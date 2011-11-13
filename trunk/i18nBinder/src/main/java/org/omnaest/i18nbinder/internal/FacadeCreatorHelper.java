/*******************************************************************************
 * Copyright 2011 Danny Kunz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.omnaest.i18nbinder.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.omnaest.i18nbinder.grouping.FileGroup;
import org.omnaest.i18nbinder.grouping.FileGroupToPropertiesAdapter;
import org.omnaest.i18nbinder.grouping.FileGrouper;
import org.omnaest.utils.structure.collection.ListUtils;
import org.omnaest.utils.structure.collection.ListUtils.ElementFilter;
import org.omnaest.utils.structure.element.converter.ElementConverterElementToMapEntry;
import org.omnaest.utils.structure.hierarchy.TokenMonoHierarchy;
import org.omnaest.utils.structure.hierarchy.TokenMonoHierarchy.TokenElementPath;
import org.omnaest.utils.structure.map.SimpleEntry;

/**
 * Helper to create a i18n facade Java source code file based on property files
 * 
 * @author Omnaest
 */
public class FacadeCreatorHelper
{
  /* ********************************************** Constants ********************************************** */
  public static final String DEFAULT_JAVA_FACADE_FILENAME_I18N_FACADE = "I18nFacade";
  public static final String LINE_SEPARATOR                           = System.getProperty( "line.separator" );
  
  /* ********************************************** Methods ********************************************** */
  
  /**
   * @param propertyFileSet
   * @param localeFilter
   * @param fileNameLocaleGroupPattern
   * @param groupingPatternGroupingGroupIndexList
   * @param javaFacadeFileName
   * @return
   */
  public static String createI18nInterfaceFacadeFromPropertyFiles( Set<File> propertyFileSet,
                                                                   LocaleFilter localeFilter,
                                                                   String fileNameLocaleGroupPattern,
                                                                   List<Integer> groupingPatternGroupingGroupIndexList,
                                                                   String baseNameInTargetPlattform,
                                                                   String baseFolderIgnoredPath,
                                                                   String packageName,
                                                                   String javaFacadeFileName )
  {
    //
    String retval = null;
    
    //
    if ( propertyFileSet != null )
    {
      //
      Map<String, FileGroup> fileGroupIdentifierToFileGroupMap;
      {
        FileGrouper fileGrouper = new FileGrouper();
        try
        {
          if ( fileNameLocaleGroupPattern != null )
          {
            fileGrouper.setGroupingPatternString( fileNameLocaleGroupPattern );
          }
          if ( groupingPatternGroupingGroupIndexList != null )
          {
            fileGrouper.setGroupingPatternGroupingGroupIndexList( groupingPatternGroupingGroupIndexList );
          }
        }
        catch ( Exception e )
        {
          ModifierHelper.logger.info( e.getMessage() );
        }
        fileGrouper.setGroupingPatternReplacementToken( "" );
        fileGrouper.addAllFiles( propertyFileSet );
        fileGroupIdentifierToFileGroupMap = fileGrouper.determineFileGroupIdentifierToFileGroupMap();
      }
      
      //
      List<FileGroupToPropertiesAdapter> fileGroupToPropertiesAdapterList = new ArrayList<FileGroupToPropertiesAdapter>();
      {
        //
        for ( String fileGroupIdentifier : fileGroupIdentifierToFileGroupMap.keySet() )
        {
          //
          FileGroup fileGroup = fileGroupIdentifierToFileGroupMap.get( fileGroupIdentifier );
          
          //
          FileGroupToPropertiesAdapter fileGroupToPropertiesAdapter = new FileGroupToPropertiesAdapter( fileGroup );
          
          //
          fileGroupToPropertiesAdapterList.add( fileGroupToPropertiesAdapter );
        }
        
        //
        Collections.sort( fileGroupToPropertiesAdapterList, new Comparator<FileGroupToPropertiesAdapter>()
        {
          @Override
          public int compare( FileGroupToPropertiesAdapter fileGroupToPropertiesAdapter1,
                              FileGroupToPropertiesAdapter fileGroupToPropertiesAdapter2 )
          {
            //
            String fileGroupIdentifier1 = fileGroupToPropertiesAdapter1.getFileGroup().getFileGroupIdentifier();
            String fileGroupIdentifier2 = fileGroupToPropertiesAdapter2.getFileGroup().getFileGroupIdentifier();
            
            //
            return fileGroupIdentifier1.compareTo( fileGroupIdentifier2 );
          }
        } );
      }
      
      //determine all locales but fix the order
      List<String> localeList = new ArrayList<String>();
      {
        //
        Set<String> localeSet = new HashSet<String>();
        for ( FileGroupToPropertiesAdapter fileGroupToPropertiesAdapter : fileGroupToPropertiesAdapterList )
        {
          localeSet.addAll( fileGroupToPropertiesAdapter.determineGroupTokenList() );
        }
        localeList.addAll( localeSet );
        
        //
        for ( String locale : localeSet )
        {
          if ( !localeFilter.isLocaleAccepted( locale ) )
          {
            localeList.remove( locale );
          }
        }
        
        //
        Collections.sort( localeList );
      }
      
      //facade source code
      {
        //
        TokenMonoHierarchy<String, PropertyKeyAndValues> TokenMonoHierarchy = new TokenMonoHierarchy<String, PropertyKeyAndValues>();
        
        //
        for ( FileGroupToPropertiesAdapter fileGroupToPropertiesAdapter : fileGroupToPropertiesAdapterList )
        {
          //
          String fileGroupIdentifier = fileGroupToPropertiesAdapter.getFileGroup().getFileGroupIdentifier();
          
          //
          List<String> tokenPathElementList = new ArrayList<String>();
          {
            //
            final String pathDelimiter = "[\\\\/]";
            
            //
            if ( StringUtils.isNotBlank( baseNameInTargetPlattform ) )
            {
              //
              String[] baseNameTokens = baseNameInTargetPlattform.split( pathDelimiter );
              
              //              
              tokenPathElementList.addAll( Arrays.asList( baseNameTokens ) );
            }
            
            //
            String[] fileGroupIdentifierTokens = fileGroupIdentifier.replaceFirst( Pattern.quote( baseFolderIgnoredPath ), "" )
                                                                    .split( pathDelimiter );
            if ( fileGroupIdentifierTokens.length > 0 )
            {
              //
              String lastToken = fileGroupIdentifierTokens[fileGroupIdentifierTokens.length - 1];
              lastToken = lastToken.replaceAll( "\\.properties$", "" ).replaceAll( "_", "" );
              fileGroupIdentifierTokens[fileGroupIdentifierTokens.length - 1] = lastToken;
              
              //
              tokenPathElementList.addAll( Arrays.asList( fileGroupIdentifierTokens ) );
            }
            
            //
            ElementFilter<String> elementFilter = new ElementFilter<String>()
            {
              @Override
              public boolean filter( String element )
              {
                // 
                return !StringUtils.isNotBlank( element );
              }
            };
            tokenPathElementList = ListUtils.filter( tokenPathElementList, elementFilter );
            
          }
          
          //
          ModifierHelper.logger.info( "Processing: " + fileGroupIdentifier );
          
          //
          List<String> propertyKeyList = new ArrayList<String>( fileGroupToPropertiesAdapter.determinePropertyKeySet() );
          Collections.sort( propertyKeyList );
          for ( String propertyKey : propertyKeyList )
          {
            if ( propertyKey != null )
            {
              //
              PropertyKeyAndValues propertyKeyAndValues = new PropertyKeyAndValues();
              {
                //
                propertyKeyAndValues.propertyKey = propertyKey;
                
                //
                for ( String locale : localeList )
                {
                  //
                  String value = fileGroupToPropertiesAdapter.resolvePropertyValue( propertyKey, locale );
                  value = StringUtils.defaultString( value );
                  if ( StringUtils.isNotBlank( value ) )
                  {
                    propertyKeyAndValues.valueList.add( locale + "=" + value );
                  }
                }
              }
              
              //                 
              TokenElementPath<String> tokenElementPath = new TokenElementPath<String>( tokenPathElementList );
              TokenMonoHierarchy.addTokenElementPathWithValues( tokenElementPath, propertyKeyAndValues );
            }
          }
        }
        
        //
        retval = buildFacadeSource( TokenMonoHierarchy, packageName, javaFacadeFileName );
      }
    }
    
    //
    return retval;
  }
  
  protected static class PropertyKeyAndValues
  {
    public String       propertyKey = null;
    public List<String> valueList   = new ArrayList<String>();
  }
  
  private static String buildFacadeSource( TokenMonoHierarchy<String, PropertyKeyAndValues> TokenMonoHierarchy,
                                           String packageName,
                                           String javaFacadeFileName )
  {
    //
    StringBuilder retval = new StringBuilder();
    
    //
    TokenMonoHierarchy<String, PropertyKeyAndValues>.Navigator navigator = TokenMonoHierarchy.getNavigator();
    
    //
    retval.append( StringUtils.isNotBlank( packageName ) ? "package " + packageName + ";\n\n" : "" );
    retval.append( "import java.util.LinkedHashMap;\n" );
    retval.append( "import java.util.Locale;\n" );
    retval.append( "import java.util.Map;\n" );
    retval.append( "import java.util.MissingResourceException;\n" );
    retval.append( "import java.util.ResourceBundle;\n\n" );
    
    //
    String className = StringUtils.isNotBlank( javaFacadeFileName ) ? javaFacadeFileName
                                                                   : DEFAULT_JAVA_FACADE_FILENAME_I18N_FACADE;
    boolean staticModifier = false;
    buildFacadeSource( retval, className, staticModifier, navigator );
    
    return retval.toString().replaceAll( "\n", LINE_SEPARATOR );
  }
  
  private static void buildFacadeSource( StringBuilder stringBuilder,
                                         String className,
                                         boolean staticModifier,
                                         TokenMonoHierarchy<String, PropertyKeyAndValues>.Navigator navigator )
  {
    //
    Map<String, String> subClassNameToTokenElementMap = new LinkedHashMap<String, String>();
    Map<String, List<String>> propertyNameToExampleValueListMap = new LinkedHashMap<String, List<String>>();
    Map<String, String> propertyNameToPropertyKeyMap = new HashMap<String, String>();
    String baseName = StringUtils.join( navigator.determineTokenPathElementList(), "." );
    
    //
    {
      //
      List<String> tokenElementOfChildrenList = navigator.getTokenElementOfChildrenList();
      
      subClassNameToTokenElementMap.putAll( ListUtils.asMap( tokenElementOfChildrenList,
                                                             new CamelCaseTokenElementToMapEntryConverter( className ) ) );
      
    }
    {
      //
      if ( navigator.hasValues() )
      {
        //
        List<PropertyKeyAndValues> propertyKeyAndValuesList = navigator.getValues();
        for ( PropertyKeyAndValues propertyKeyAndValues : propertyKeyAndValuesList )
        {
          //
          String propertyKey = propertyKeyAndValues.propertyKey;
          
          //
          String propertyName = "";
          {
            //
            {
              //
              String[] tokens = propertyKey.split( "[^a-zA-Z0-9]" );
              for ( String token : tokens )
              {
                propertyName += StringUtils.capitalize( token );
              }
            }
          }
          
          //
          {
            //
            String key = propertyName;
            List<String> value = propertyKeyAndValues.valueList;
            propertyNameToExampleValueListMap.put( key, value );
          }
          
          //
          {
            //
            propertyNameToPropertyKeyMap.put( propertyName, propertyKey );
          }
        }
      }
    }
    
    //
    boolean hasBaseName = StringUtils.isNotBlank( baseName );
    boolean hasProperties = !propertyNameToExampleValueListMap.keySet().isEmpty();
    
    //  
    //documentation
    stringBuilder.append( "/**\n" );
    stringBuilder.append( " * This is an automatically with i18nBinder generated facade class.<br><br>\n" );
    stringBuilder.append( " * To modify please adapt the underlying property files.<br><br>\n" );
    stringBuilder.append( " * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined {@link Locale} when invoked.<br><br>\n" );
    stringBuilder.append( hasBaseName ? " * Resource base: <b>" + baseName + "</b>\n" : "" );
    
    for ( String subClassName : subClassNameToTokenElementMap.keySet() )
    {
      stringBuilder.append( " * @see " + subClassName + "\n" );
    }
    
    if ( hasProperties )
    {
      stringBuilder.append( " * @see #allPropertyKeys()\n" );
      stringBuilder.append( " * @see #allPropertyKeys(Locale)\n" );
      stringBuilder.append( " * @see #translate(String)\n" );
      stringBuilder.append( " * @see #translate(Locale, String)\n" );
      stringBuilder.append( " * @see #translate(String[])\n" );
      stringBuilder.append( " * @see #translate(Locale, String[])\n" );
      stringBuilder.append( " * @see #tryTranslate(String)\n" );
      stringBuilder.append( " * @see #tryTranslate(Locale, String)\n" );
      stringBuilder.append( " * @see #tryTranslate(String[])\n" );
      stringBuilder.append( " * @see #tryTranslate(Locale, String[])\n" );
    }
    stringBuilder.append( " */ \n" );
    
    //class
    stringBuilder.append( "public " + ( staticModifier ? "static " : "" ) + "class " + className + " {\n" );
    {
      //vars
      {
        //
        if ( !propertyNameToExampleValueListMap.isEmpty() )
        {
          //
          stringBuilder.append( "  private final Locale locale;\n" );
          
          //
          stringBuilder.append( "    private final static String baseName = \"" + baseName + "\";\n" );
        }
        
        //
        for ( String subClassName : subClassNameToTokenElementMap.keySet() )
        {
          stringBuilder.append( "  /** @see " + subClassName + " */\n" );
          stringBuilder.append( "  public " + subClassName + " " + subClassName + " = null;\n" );
        }
      }
      
      //constructor
      {
        //
        stringBuilder.append( "\n" );
        stringBuilder.append( "  /**\n" );
        stringBuilder.append( "   * @see " + className + "\n" );
        stringBuilder.append( "   */ \n" );
        stringBuilder.append( "  public " + className + "( Locale locale )\n" );
        stringBuilder.append( "  {\n" );
        {
          stringBuilder.append( "    super();\n" );
          if ( !propertyNameToExampleValueListMap.isEmpty() )
          {
            stringBuilder.append( "    this.locale = locale;\n\n" );
          }
          
          //
          for ( String subClassName : subClassNameToTokenElementMap.keySet() )
          {
            stringBuilder.append( "    this." + subClassName + " = new " + subClassName + "( locale );\n" );
          }
          
        }
        stringBuilder.append( "  }\n" );
        stringBuilder.append( "  \n" );
      }
      
      //static sublcasses
      {
        //
        for ( String subClassName : subClassNameToTokenElementMap.keySet() )
        {
          boolean subClassStaticModifier = true;
          buildFacadeSource( stringBuilder, subClassName, subClassStaticModifier,
                             navigator.newNavigatorFork().navigateToChild( subClassNameToTokenElementMap.get( subClassName ) ) );
        }
      }
      
      //methods based on properties
      if ( hasProperties )
      {
        //
        for ( String propertyName : propertyNameToExampleValueListMap.keySet() )
        {
          //
          String propertyKey = propertyNameToPropertyKeyMap.get( propertyName );
          List<String> exampleValueList = propertyNameToExampleValueListMap.get( propertyName );
          
          //
          List<String> replacementTokensForExampleValuesNumericPlaceholders = determineReplacementTokensForExampleValues( exampleValueList,
                                                                                                                          "\\{\\d+\\}" );
          List<String> replacementTokensForExampleValuesArbitraryPlaceholders = determineReplacementTokensForExampleValues( exampleValueList,
                                                                                                                            "\\{\\w+\\}" );
          
          boolean containsNumericalReplacementToken = replacementTokensForExampleValuesNumericPlaceholders.size() > 0;
          boolean containsArbitraryReplacementToken = !containsNumericalReplacementToken
                                                      && replacementTokensForExampleValuesArbitraryPlaceholders.size() > 0;
          
          //
          {
            //
            stringBuilder.append( "  /**\n" );
            stringBuilder.append( "   * Returns the value of the property key <b>" + propertyKey
                                  + "</b> for the given {@link Locale}.\n" );
            printJavaDocPlaceholders( stringBuilder, replacementTokensForExampleValuesArbitraryPlaceholders );
            printJavaDocValueExamples( stringBuilder, exampleValueList );
            stringBuilder.append( "   * @param locale \n" );
            stringBuilder.append( "   * @see " + className + "\n" );
            stringBuilder.append( "   */ \n" );
            stringBuilder.append( "  public static String get" + propertyName + "(Locale locale)\n" );
            stringBuilder.append( "  {\n" );
            stringBuilder.append( "    String key = \"" + propertyKey + "\";\n" );
            stringBuilder.append( "    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );\n" );
            stringBuilder.append( "    return resourceBundle.getString( key );\n" );
            stringBuilder.append( "  }\n\n" );
            
            //
            stringBuilder.append( "  /**\n" );
            stringBuilder.append( "   * Returns the value of the property key <b>" + propertyKey
                                  + "</b> for the predefined {@link Locale}.\n" );
            printJavaDocPlaceholders( stringBuilder, replacementTokensForExampleValuesArbitraryPlaceholders );
            printJavaDocValueExamples( stringBuilder, exampleValueList );
            stringBuilder.append( "   * @see " + className + "\n" );
            stringBuilder.append( "   */ \n" );
            stringBuilder.append( "  public String get" + propertyName + "()\n" );
            stringBuilder.append( "  {\n" );
            stringBuilder.append( "    return get" + propertyName + "( this.locale );\n" );
            stringBuilder.append( "  }\n\n" );
          }
          
          //
          if ( containsNumericalReplacementToken )
          {
            //
            stringBuilder.append( "  /**\n" );
            stringBuilder.append( "   * Returns the value of the property key <b>"
                                  + propertyKey
                                  + "</b> for the given {@link Locale} with all {0},{1},... placeholders replaced by the given tokens in their order.<br><br>\n" );
            stringBuilder.append( "   * If there are not enough parameters existing placeholders will remain unreplaced.\n" );
            printJavaDocPlaceholders( stringBuilder, replacementTokensForExampleValuesNumericPlaceholders );
            printJavaDocValueExamples( stringBuilder, exampleValueList );
            stringBuilder.append( "   * @see " + className + "\n" );
            stringBuilder.append( "   * @param locale\n" );
            stringBuilder.append( "   * @param tokens\n" );
            stringBuilder.append( "   */ \n" );
            stringBuilder.append( "  public static String get" + propertyName + "( Locale locale, String... tokens )\n" );
            stringBuilder.append( "  {\n" );
            stringBuilder.append( "    String retval = get" + propertyName + "( locale );\n" );
            stringBuilder.append( "    for ( int ii = 0; ii < tokens.length; ii++ )\n" );
            stringBuilder.append( "    {\n" );
            stringBuilder.append( "      String token = tokens[ii];\n" );
            stringBuilder.append( "      if ( token != null )\n" );
            stringBuilder.append( "      {\n" );
            stringBuilder.append( "        retval = retval.replaceAll( \"\\\\{\" + ii + \"\\\\}\", token );\n" );
            stringBuilder.append( "      }\n" );
            stringBuilder.append( "    }\n" );
            stringBuilder.append( "    return retval;\n" );
            stringBuilder.append( "  }\n\n" );
            
            //
            stringBuilder.append( "  /**\n" );
            stringBuilder.append( "   * Returns the value of the property key <b>"
                                  + propertyKey
                                  + "</b> for the predefined {@link Locale} with all {0},{1},... placeholders replaced by the given tokens in their order.\n" );
            stringBuilder.append( "   * If there are not enough parameters existing placeholders will remain unreplaced.\n" );
            printJavaDocPlaceholders( stringBuilder, replacementTokensForExampleValuesNumericPlaceholders );
            printJavaDocValueExamples( stringBuilder, exampleValueList );
            stringBuilder.append( "   * @see " + className + "\n" );
            stringBuilder.append( "   * @param tokens\n" );
            stringBuilder.append( "   */ \n" );
            stringBuilder.append( "  public String get" + propertyName + "( String... tokens )\n" );
            stringBuilder.append( "  {\n" );
            stringBuilder.append( "    return get" + propertyName + "( this.locale, tokens );\n" );
            stringBuilder.append( "  }\n\n" );
          }
          
          //
          if ( containsArbitraryReplacementToken )
          {
            //
            stringBuilder.append( "  /**\n" );
            stringBuilder.append( "   * Returns the value of the property key <b>"
                                  + propertyKey
                                  + "</b> for the given {@link Locale} with arbitrary placeholder tag like {example} replaced by the given values.<br>\n" );
            stringBuilder.append( "   * The given placeholderToReplacementMap needs the placeholder tag name and a value. E.g. for {example} the key \"example\" has to be set.\n" );
            printJavaDocPlaceholders( stringBuilder, replacementTokensForExampleValuesArbitraryPlaceholders );
            printJavaDocValueExamples( stringBuilder, exampleValueList );
            stringBuilder.append( "   * @see " + className + "\n" );
            stringBuilder.append( "   * @param locale\n" );
            stringBuilder.append( "   * @param placeholderToReplacementMap\n" );
            stringBuilder.append( "   */ \n" );
            stringBuilder.append( "  public static String get" + propertyName
                                  + "( Locale locale, Map<String, String> placeholderToReplacementMap )\n" );
            stringBuilder.append( "  {\n" );
            stringBuilder.append( "    String retval = get" + propertyName + "( locale );\n" );
            stringBuilder.append( "    if ( placeholderToReplacementMap != null )\n" );
            stringBuilder.append( "    {\n" );
            stringBuilder.append( "      for ( String placeholder : placeholderToReplacementMap.keySet() )\n" );
            stringBuilder.append( "      {\n" );
            stringBuilder.append( "        if ( placeholder != null )\n" );
            stringBuilder.append( "        {\n" );
            stringBuilder.append( "          String token = placeholderToReplacementMap.get( placeholder );\n" );
            stringBuilder.append( "          retval = retval.replaceAll( \"\\\\{\" + placeholder + \"\\\\}\", token );\n" );
            stringBuilder.append( "        }\n" );
            stringBuilder.append( "      }\n" );
            stringBuilder.append( "    }\n" );
            stringBuilder.append( "    return retval;\n" );
            stringBuilder.append( "  }\n\n" );
            
            //
            stringBuilder.append( "  /**\n" );
            stringBuilder.append( "   * Returns the value of the property key <b>"
                                  + propertyKey
                                  + "</b> for the predefined {@link Locale} with arbitrary placeholder tag like {example} replaced by the given values.\n" );
            stringBuilder.append( "   * The given placeholderToReplacementMap needs the placeholder tag name and a value. E.g. for {example} the key \"example\" has to be set.\n" );
            printJavaDocPlaceholders( stringBuilder, replacementTokensForExampleValuesArbitraryPlaceholders );
            printJavaDocValueExamples( stringBuilder, exampleValueList );
            stringBuilder.append( "   * @see " + className + "\n" );
            stringBuilder.append( "   * @param placeholderToReplacementMap\n" );
            stringBuilder.append( "   */ \n" );
            stringBuilder.append( "  public String get" + propertyName + "( Map<String, String> placeholderToReplacementMap )\n" );
            stringBuilder.append( "  {\n" );
            stringBuilder.append( "    return get" + propertyName + "( this.locale, placeholderToReplacementMap );\n" );
            stringBuilder.append( "  }\n\n" );
          }
        }
        
        //translation map methods
        {
          //
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns the translated property key for the given {@link Locale}.\n" );
          stringBuilder.append( "   * @param locale \n" );
          stringBuilder.append( "   * @param key \n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #translate(String)\n" );
          stringBuilder.append( "   * @see #tryTranslate(Locale, String)\n" );
          stringBuilder.append( "   * @see #translate(Locale, String[])\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public static String translate(Locale locale, String key)\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );\n" );
          stringBuilder.append( "    return resourceBundle.getString( key );\n" );
          stringBuilder.append( "  }\n\n" );
          
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns the translated property key for the predefined {@link Locale}\n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #translate(Locale, String)\n" );
          stringBuilder.append( "   * @see #tryTranslate(String)\n" );
          stringBuilder.append( "   * @see #translate(Locale, String)\n" );
          stringBuilder.append( "   * @see #translate(String[])\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public String translate( String key )\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    return translate( this.locale, key );\n" );
          stringBuilder.append( "  }\n\n" );
          
          //
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns the translated property key for the given {@link Locale}.\n" );
          stringBuilder.append( "   * @param locale \n" );
          stringBuilder.append( "   * @param key \n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #tryTranslate(String)\n" );
          stringBuilder.append( "   * @see #translate(Locale, String[])\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public static String tryTranslate(Locale locale, String key)\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );\n" );
          stringBuilder.append( "    String retval = null;\n" );
          stringBuilder.append( "    try\n" );
          stringBuilder.append( "    {\n" );
          stringBuilder.append( "      retval = resourceBundle.getString( key );\n" );
          stringBuilder.append( "    }\n" );
          stringBuilder.append( "    catch (MissingResourceException e) {}\n" );
          stringBuilder.append( "    return retval;\n" );
          stringBuilder.append( "  }\n\n" );
          
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns the translated property key for the predefined {@link Locale}\n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #translate(Locale, String)\n" );
          stringBuilder.append( "   * @see #tryTranslate(String[])\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public String tryTranslate( String key )\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    return tryTranslate( this.locale, key );\n" );
          stringBuilder.append( "  }\n\n" );
          
          //
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.\n" );
          stringBuilder.append( "   * @param locale \n" );
          stringBuilder.append( "   * @param keys \n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #allPropertyKeys()\n" );
          stringBuilder.append( "   * @see #translate(String[])\n" );
          stringBuilder.append( "   * @see #translate(Locale, String)\n" );
          stringBuilder.append( "   * @see #tryTranslate(Locale, String[])\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public static Map<String, String> translate( Locale locale, String... keys )\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    Map<String, String> retmap = new LinkedHashMap<String, String>();\n" );
          stringBuilder.append( "    for ( String key : keys )\n" );
          stringBuilder.append( "    {\n" );
          stringBuilder.append( "      retmap.put( key, translate( locale, key ) );\n" );
          stringBuilder.append( "    }\n" );
          stringBuilder.append( "    return retmap;\n" );
          stringBuilder.append( "  }\n\n" );
          
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns a translation {@link Map} with the given property keys and their respective values for the predefined {@link Locale}.\n" );
          stringBuilder.append( "   * @param keys \n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #allPropertyKeys()\n" );
          stringBuilder.append( "   * @see #translate(String)\n" );
          stringBuilder.append( "   * @see #translate(Locale, String[])\n" );
          stringBuilder.append( "   * @see #tryTranslate(Locale, String[])\n" );
          stringBuilder.append( "   * @see #tryTranslate(String[])\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public Map<String, String> translate( String... keys )\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    return translate( this.locale, keys );\n" );
          stringBuilder.append( "  }\n\n" );
          
          //
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.<br>\n" );
          stringBuilder.append( "   * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but no {@link Exception} will be thrown.\n" );
          stringBuilder.append( "   * @param locale \n" );
          stringBuilder.append( "   * @param keys \n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #allPropertyKeys()\n" );
          stringBuilder.append( "   * @see #translate(Locale, String[])\n" );
          stringBuilder.append( "   * @see #translate(String[])\n" );
          stringBuilder.append( "   * @see #translate(Locale, String)\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public static Map<String, String> tryTranslate( Locale locale, String... keys )\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    Map<String, String> retmap = new LinkedHashMap<String, String>();\n" );
          stringBuilder.append( "    for ( String key : keys )\n" );
          stringBuilder.append( "    {\n" );
          stringBuilder.append( "      try\n" );
          stringBuilder.append( "      {\n" );
          stringBuilder.append( "        retmap.put( key, translate( locale, key ) );\n" );
          stringBuilder.append( "      }\n" );
          stringBuilder.append( "      catch (MissingResourceException e) {}\n" );
          stringBuilder.append( "    }\n" );
          stringBuilder.append( "    return retmap;\n" );
          stringBuilder.append( "  }\n\n" );
          
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns a translation {@link Map} with the given property keys and their respective values for the predefined {@link Locale}.<br>\n" );
          stringBuilder.append( "   * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but no {@link Exception} will be thrown.\n" );
          stringBuilder.append( "   * @param keys \n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #allPropertyKeys()\n" );
          stringBuilder.append( "   * @see #translate(String)\n" );
          stringBuilder.append( "   * @see #tryTranslate(Locale, String[])\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public Map<String, String> tryTranslate( String... keys )\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    return tryTranslate( this.locale, keys );\n" );
          stringBuilder.append( "  }\n\n" );
          
          //          
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns all available property keys for the predefined {@link Locale}. \n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #allPropertyKeys(Locale)\n" );
          stringBuilder.append( "   * @see #translate(String[])\n" );
          stringBuilder.append( "   * @see #translate(Locale, String[])\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public String[] allPropertyKeys()\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    return allPropertyKeys( this.locale );" );
          stringBuilder.append( "  }\n\n" );
          
          //          
          stringBuilder.append( "  /**\n" );
          stringBuilder.append( "   * Returns all available property keys for the given {@link Locale}. \n" );
          stringBuilder.append( "   * @param locale \n" );
          stringBuilder.append( "   * @see " + className + "\n" );
          stringBuilder.append( "   * @see #allPropertyKeys()\n" );
          stringBuilder.append( "   * @see #translate(String[])\n" );
          stringBuilder.append( "   * @see #translate(Locale, String[])\n" );
          stringBuilder.append( "   */ \n" );
          stringBuilder.append( "  public static String[] allPropertyKeys(Locale locale)\n" );
          stringBuilder.append( "  {\n" );
          stringBuilder.append( "    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );\n" );
          stringBuilder.append( "    return resourceBundle.keySet().toArray( new String[0] );\n" );
          stringBuilder.append( "  }\n\n" );
          
        }
      }
    }
    
    //
    stringBuilder.append( "}\n\n" );
  }
  
  private static void printJavaDocPlaceholders( StringBuilder stringBuilder,
                                                List<String> replacementTokensForExampleValuesPlaceholders )
  {
    stringBuilder.append( "   * <br><br>\n" );
    if ( !replacementTokensForExampleValuesPlaceholders.isEmpty() )
    {
      stringBuilder.append( "   * Placeholders:\n" );
      stringBuilder.append( "   * <ul>\n" );
      for ( String replacementToken : replacementTokensForExampleValuesPlaceholders )
      {
        stringBuilder.append( "   * <li><b>" + replacementToken + "</b></li>\n" );
      }
      stringBuilder.append( "   * </ul>\n" );
    }
  }
  
  /**
   * @param stringBuilder
   * @param exampleValueList
   */
  private static void printJavaDocValueExamples( StringBuilder stringBuilder, List<String> exampleValueList )
  {
    stringBuilder.append( "   * \n" );
    stringBuilder.append( "   * Examples:\n" );
    stringBuilder.append( "   * <ul>\n" );
    for ( String exampleValue : exampleValueList )
    {
      stringBuilder.append( "   * <li>" + exampleValue + "</li>\n" );
    }
    stringBuilder.append( "   * </ul>\n" );
  }
  
  /**
   * @param exampleValueList
   * @param regexTokenPattern
   * @return
   */
  private static List<String> determineReplacementTokensForExampleValues( List<String> exampleValueList, String regexTokenPattern )
  {
    //
    Set<String> retset = new LinkedHashSet<String>();
    
    //
    final Pattern pattern = Pattern.compile( regexTokenPattern );
    for ( String exampleValue : exampleValueList )
    {
      Matcher matcher = pattern.matcher( exampleValue );
      while ( matcher.find() )
      {
        retset.add( matcher.group() );
      }
    }
    
    //
    return new ArrayList<String>( retset );
  }
  
  protected static class CamelCaseTokenElementToMapEntryConverter implements
                                                                 ElementConverterElementToMapEntry<String, String, String>
  {
    /* ********************************************** Variables ********************************************** */
    public String excludedkey = null;
    
    /* ********************************************** Methods ********************************************** */
    public CamelCaseTokenElementToMapEntryConverter( String excludedkey )
    {
      super();
      this.excludedkey = excludedkey;
    }
    
    @Override
    public Entry<String, String> convert( String element )
    {
      //
      String key = "";
      String value = "";
      
      //
      if ( element != null )
      {
        //
        String[] tokens = element.split( "[^a-zA-Z0-9]" );
        for ( String token : tokens )
        {
          key += StringUtils.capitalize( token );
        }
        
        //
        key = StringUtils.isBlank( key ) ? "Root" : key;
        key = key.matches( "\\d+.*" ) ? "_" + key : key;
        key = StringUtils.equals( key, this.excludedkey ) ? key + "_" : key;
        
        //
        value = element;
      }
      
      // 
      return new SimpleEntry<String, String>( key, value );
    }
    
  }
}
