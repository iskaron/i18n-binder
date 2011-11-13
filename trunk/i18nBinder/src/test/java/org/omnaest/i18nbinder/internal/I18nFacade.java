package org.omnaest.i18nbinder.internal;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * This is an automatically with i18nBinder generated facade class.<br>
 * <br>
 * To modify please adapt the underlying property files.<br>
 * <br>
 * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined {@link Locale}
 * when invoked.<br>
 * <br>
 * 
 * @see I18n
 */
public class I18nFacade
{
  /** @see I18n */
  public I18n I18n = null;
  
  /**
   * @see I18nFacade
   */
  public I18nFacade( Locale locale )
  {
    super();
    this.I18n = new I18n( locale );
  }
  
  /**
   * This is an automatically with i18nBinder generated facade class.<br>
   * <br>
   * To modify please adapt the underlying property files.<br>
   * <br>
   * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined
   * {@link Locale} when invoked.<br>
   * <br>
   * Resource base: <b>i18n</b>
   * 
   * @see _673numericalTest
   * @see AdminTest
   * @see LocalelessTest
   * @see ViewTest
   */
  public static class I18n
  {
    /** @see _673numericalTest */
    public _673numericalTest _673numericalTest = null;
    /** @see AdminTest */
    public AdminTest         AdminTest         = null;
    /** @see LocalelessTest */
    public LocalelessTest    LocalelessTest    = null;
    /** @see ViewTest */
    public ViewTest          ViewTest          = null;
    
    /**
     * @see I18n
     */
    public I18n( Locale locale )
    {
      super();
      this._673numericalTest = new _673numericalTest( locale );
      this.AdminTest = new AdminTest( locale );
      this.LocalelessTest = new LocalelessTest( locale );
      this.ViewTest = new ViewTest( locale );
    }
    
    /**
     * This is an automatically with i18nBinder generated facade class.<br>
     * <br>
     * To modify please adapt the underlying property files.<br>
     * <br>
     * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined
     * {@link Locale} when invoked.<br>
     * <br>
     * Resource base: <b>i18n.673numericalTest</b>
     * 
     * @see #allPropertyKeys()
     * @see #allPropertyKeys(Locale)
     * @see #translate(String)
     * @see #translate(Locale, String)
     * @see #translate(String[])
     * @see #translate(Locale, String[])
     * @see #tryTranslate(String)
     * @see #tryTranslate(Locale, String)
     * @see #tryTranslate(String[])
     * @see #tryTranslate(Locale, String[])
     */
    public static class _673numericalTest
    {
      private final Locale        locale;
      private final static String baseName = "i18n.673numericalTest";
      
      /**
       * @see _673numericalTest
       */
      public _673numericalTest( Locale locale )
      {
        super();
        this.locale = locale;
        
      }
      
      /**
       * Returns the value of the property key <b>my.property.key1</b> for the given {@link Locale}. <br>
       * <br>
       * Placeholders:
       * <ul>
       * <li><b>{0}</b></li>
       * <li><b>{1}</b></li>
       * </ul>
       * Examples:
       * <ul>
       * <li>en_US=value {0} and {1}</li>
       * </ul>
       * 
       * @param locale
       * @see _673numericalTest
       */
      public static String getMyPropertyKey1( Locale locale )
      {
        String key = "my.property.key1";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key1</b> for the predefined {@link Locale}. <br>
       * <br>
       * Placeholders:
       * <ul>
       * <li><b>{0}</b></li>
       * <li><b>{1}</b></li>
       * </ul>
       * Examples:
       * <ul>
       * <li>en_US=value {0} and {1}</li>
       * </ul>
       * 
       * @see _673numericalTest
       */
      public String getMyPropertyKey1()
      {
        return getMyPropertyKey1( this.locale );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key1</b> for the given {@link Locale} with all {0},{1},...
       * placeholders replaced by the given tokens in their order.<br>
       * <br>
       * If there are not enough parameters existing placeholders will remain unreplaced. <br>
       * <br>
       * Placeholders:
       * <ul>
       * <li><b>{0}</b></li>
       * <li><b>{1}</b></li>
       * </ul>
       * Examples:
       * <ul>
       * <li>en_US=value {0} and {1}</li>
       * </ul>
       * 
       * @see _673numericalTest
       * @param locale
       * @param tokens
       */
      public static String getMyPropertyKey1( Locale locale, String... tokens )
      {
        String retval = getMyPropertyKey1( locale );
        for ( int ii = 0; ii < tokens.length; ii++ )
        {
          String token = tokens[ii];
          if ( token != null )
          {
            retval = retval.replaceAll( "\\{" + ii + "\\}", token );
          }
        }
        return retval;
      }
      
      /**
       * Returns the value of the property key <b>my.property.key1</b> for the predefined {@link Locale} with all {0},{1},...
       * placeholders replaced by the given tokens in their order. If there are not enough parameters existing placeholders will
       * remain unreplaced. <br>
       * <br>
       * Placeholders:
       * <ul>
       * <li><b>{0}</b></li>
       * <li><b>{1}</b></li>
       * </ul>
       * Examples:
       * <ul>
       * <li>en_US=value {0} and {1}</li>
       * </ul>
       * 
       * @see _673numericalTest
       * @param tokens
       */
      public String getMyPropertyKey1( String... tokens )
      {
        return getMyPropertyKey1( this.locale, tokens );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key3</b> for the given {@link Locale}. <br>
       * <br>
       * Placeholders:
       * <ul>
       * <li><b>{arbitrary}</b></li>
       * </ul>
       * Examples:
       * <ul>
       * <li>en_US=value3 with {arbitrary} replacement</li>
       * </ul>
       * 
       * @param locale
       * @see _673numericalTest
       */
      public static String getMyPropertyKey3( Locale locale )
      {
        String key = "my.property.key3";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key3</b> for the predefined {@link Locale}. <br>
       * <br>
       * Placeholders:
       * <ul>
       * <li><b>{arbitrary}</b></li>
       * </ul>
       * Examples:
       * <ul>
       * <li>en_US=value3 with {arbitrary} replacement</li>
       * </ul>
       * 
       * @see _673numericalTest
       */
      public String getMyPropertyKey3()
      {
        return getMyPropertyKey3( this.locale );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key3</b> for the given {@link Locale} with arbitrary placeholder tag
       * like {example} replaced by the given values.<br>
       * The given placeholderToReplacementMap needs the placeholder tag name and a value. E.g. for {example} the key "example"
       * has to be set. <br>
       * <br>
       * Placeholders:
       * <ul>
       * <li><b>{arbitrary}</b></li>
       * </ul>
       * Examples:
       * <ul>
       * <li>en_US=value3 with {arbitrary} replacement</li>
       * </ul>
       * 
       * @see _673numericalTest
       * @param locale
       * @param placeholderToReplacementMap
       */
      public static String getMyPropertyKey3( Locale locale, Map<String, String> placeholderToReplacementMap )
      {
        String retval = getMyPropertyKey3( locale );
        if ( placeholderToReplacementMap != null )
        {
          for ( String placeholder : placeholderToReplacementMap.keySet() )
          {
            if ( placeholder != null )
            {
              String token = placeholderToReplacementMap.get( placeholder );
              retval = retval.replaceAll( "\\{" + placeholder + "\\}", token );
            }
          }
        }
        return retval;
      }
      
      /**
       * Returns the value of the property key <b>my.property.key3</b> for the predefined {@link Locale} with arbitrary
       * placeholder tag like {example} replaced by the given values. The given placeholderToReplacementMap needs the placeholder
       * tag name and a value. E.g. for {example} the key "example" has to be set. <br>
       * <br>
       * Placeholders:
       * <ul>
       * <li><b>{arbitrary}</b></li>
       * </ul>
       * Examples:
       * <ul>
       * <li>en_US=value3 with {arbitrary} replacement</li>
       * </ul>
       * 
       * @see _673numericalTest
       * @param placeholderToReplacementMap
       */
      public String getMyPropertyKey3( Map<String, String> placeholderToReplacementMap )
      {
        return getMyPropertyKey3( this.locale, placeholderToReplacementMap );
      }
      
      /**
       * Returns the translated property key for the given {@link Locale}.
       * 
       * @param locale
       * @param key
       * @see _673numericalTest
       * @see #translate(String)
       * @see #tryTranslate(Locale, String)
       * @see #translate(Locale, String[])
       */
      public static String translate( Locale locale, String key )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the translated property key for the predefined {@link Locale}
       * 
       * @see _673numericalTest
       * @see #translate(Locale, String)
       * @see #tryTranslate(String)
       * @see #translate(Locale, String)
       * @see #translate(String[])
       */
      public String translate( String key )
      {
        return translate( this.locale, key );
      }
      
      /**
       * Returns the translated property key for the given {@link Locale}.
       * 
       * @param locale
       * @param key
       * @see _673numericalTest
       * @see #tryTranslate(String)
       * @see #translate(Locale, String[])
       */
      public static String tryTranslate( Locale locale, String key )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        String retval = null;
        try
        {
          retval = resourceBundle.getString( key );
        }
        catch ( MissingResourceException e )
        {
        }
        return retval;
      }
      
      /**
       * Returns the translated property key for the predefined {@link Locale}
       * 
       * @see _673numericalTest
       * @see #translate(Locale, String)
       * @see #tryTranslate(String[])
       */
      public String tryTranslate( String key )
      {
        return tryTranslate( this.locale, key );
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.
       * 
       * @param locale
       * @param keys
       * @see _673numericalTest
       * @see #allPropertyKeys()
       * @see #translate(String[])
       * @see #translate(Locale, String)
       * @see #tryTranslate(Locale, String[])
       */
      public static Map<String, String> translate( Locale locale, String... keys )
      {
        Map<String, String> retmap = new LinkedHashMap<String, String>();
        for ( String key : keys )
        {
          retmap.put( key, translate( locale, key ) );
        }
        return retmap;
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the predefined
       * {@link Locale}.
       * 
       * @param keys
       * @see _673numericalTest
       * @see #allPropertyKeys()
       * @see #translate(String)
       * @see #translate(Locale, String[])
       * @see #tryTranslate(Locale, String[])
       * @see #tryTranslate(String[])
       */
      public Map<String, String> translate( String... keys )
      {
        return translate( this.locale, keys );
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.<br>
       * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but
       * no {@link Exception} will be thrown.
       * 
       * @param locale
       * @param keys
       * @see _673numericalTest
       * @see #allPropertyKeys()
       * @see #translate(Locale, String[])
       * @see #translate(String[])
       * @see #translate(Locale, String)
       */
      public static Map<String, String> tryTranslate( Locale locale, String... keys )
      {
        Map<String, String> retmap = new LinkedHashMap<String, String>();
        for ( String key : keys )
        {
          try
          {
            retmap.put( key, translate( locale, key ) );
          }
          catch ( MissingResourceException e )
          {
          }
        }
        return retmap;
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the predefined
       * {@link Locale}.<br>
       * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but
       * no {@link Exception} will be thrown.
       * 
       * @param keys
       * @see _673numericalTest
       * @see #allPropertyKeys()
       * @see #translate(String)
       * @see #tryTranslate(Locale, String[])
       */
      public Map<String, String> tryTranslate( String... keys )
      {
        return tryTranslate( this.locale, keys );
      }
      
      /**
       * Returns all available property keys for the predefined {@link Locale}.
       * 
       * @see _673numericalTest
       * @see #allPropertyKeys(Locale)
       * @see #translate(String[])
       * @see #translate(Locale, String[])
       */
      public String[] allPropertyKeys()
      {
        return allPropertyKeys( this.locale );
      }
      
      /**
       * Returns all available property keys for the given {@link Locale}.
       * 
       * @param locale
       * @see _673numericalTest
       * @see #allPropertyKeys()
       * @see #translate(String[])
       * @see #translate(Locale, String[])
       */
      public static String[] allPropertyKeys( Locale locale )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.keySet().toArray( new String[0] );
      }
      
    }
    
    /**
     * This is an automatically with i18nBinder generated facade class.<br>
     * <br>
     * To modify please adapt the underlying property files.<br>
     * <br>
     * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined
     * {@link Locale} when invoked.<br>
     * <br>
     * Resource base: <b>i18n.adminTest</b>
     * 
     * @see #allPropertyKeys()
     * @see #allPropertyKeys(Locale)
     * @see #translate(String)
     * @see #translate(Locale, String)
     * @see #translate(String[])
     * @see #translate(Locale, String[])
     * @see #tryTranslate(String)
     * @see #tryTranslate(Locale, String)
     * @see #tryTranslate(String[])
     * @see #tryTranslate(Locale, String[])
     */
    public static class AdminTest
    {
      private final Locale        locale;
      private final static String baseName = "i18n.adminTest";
      
      /**
       * @see AdminTest
       */
      public AdminTest( Locale locale )
      {
        super();
        this.locale = locale;
        
      }
      
      /**
       * Returns the value of the property key <b>my.property.key1</b> for the given {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>de_DE=wert1</li>
       * <li>en_US=value1</li>
       * </ul>
       * 
       * @param locale
       * @see AdminTest
       */
      public static String getMyPropertyKey1( Locale locale )
      {
        String key = "my.property.key1";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key1</b> for the predefined {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>de_DE=wert1</li>
       * <li>en_US=value1</li>
       * </ul>
       * 
       * @see AdminTest
       */
      public String getMyPropertyKey1()
      {
        return getMyPropertyKey1( this.locale );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key2</b> for the given {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>de_DE=wert2</li>
       * <li>en_US=value2</li>
       * </ul>
       * 
       * @param locale
       * @see AdminTest
       */
      public static String getMyPropertyKey2( Locale locale )
      {
        String key = "my.property.key2";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key2</b> for the predefined {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>de_DE=wert2</li>
       * <li>en_US=value2</li>
       * </ul>
       * 
       * @see AdminTest
       */
      public String getMyPropertyKey2()
      {
        return getMyPropertyKey2( this.locale );
      }
      
      /**
       * Returns the translated property key for the given {@link Locale}.
       * 
       * @param locale
       * @param key
       * @see AdminTest
       * @see #translate(String)
       * @see #tryTranslate(Locale, String)
       * @see #translate(Locale, String[])
       */
      public static String translate( Locale locale, String key )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the translated property key for the predefined {@link Locale}
       * 
       * @see AdminTest
       * @see #translate(Locale, String)
       * @see #tryTranslate(String)
       * @see #translate(Locale, String)
       * @see #translate(String[])
       */
      public String translate( String key )
      {
        return translate( this.locale, key );
      }
      
      /**
       * Returns the translated property key for the given {@link Locale}.
       * 
       * @param locale
       * @param key
       * @see AdminTest
       * @see #tryTranslate(String)
       * @see #translate(Locale, String[])
       */
      public static String tryTranslate( Locale locale, String key )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        String retval = null;
        try
        {
          retval = resourceBundle.getString( key );
        }
        catch ( MissingResourceException e )
        {
        }
        return retval;
      }
      
      /**
       * Returns the translated property key for the predefined {@link Locale}
       * 
       * @see AdminTest
       * @see #translate(Locale, String)
       * @see #tryTranslate(String[])
       */
      public String tryTranslate( String key )
      {
        return tryTranslate( this.locale, key );
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.
       * 
       * @param locale
       * @param keys
       * @see AdminTest
       * @see #allPropertyKeys()
       * @see #translate(String[])
       * @see #translate(Locale, String)
       * @see #tryTranslate(Locale, String[])
       */
      public static Map<String, String> translate( Locale locale, String... keys )
      {
        Map<String, String> retmap = new LinkedHashMap<String, String>();
        for ( String key : keys )
        {
          retmap.put( key, translate( locale, key ) );
        }
        return retmap;
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the predefined
       * {@link Locale}.
       * 
       * @param keys
       * @see AdminTest
       * @see #allPropertyKeys()
       * @see #translate(String)
       * @see #translate(Locale, String[])
       * @see #tryTranslate(Locale, String[])
       * @see #tryTranslate(String[])
       */
      public Map<String, String> translate( String... keys )
      {
        return translate( this.locale, keys );
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.<br>
       * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but
       * no {@link Exception} will be thrown.
       * 
       * @param locale
       * @param keys
       * @see AdminTest
       * @see #allPropertyKeys()
       * @see #translate(Locale, String[])
       * @see #translate(String[])
       * @see #translate(Locale, String)
       */
      public static Map<String, String> tryTranslate( Locale locale, String... keys )
      {
        Map<String, String> retmap = new LinkedHashMap<String, String>();
        for ( String key : keys )
        {
          try
          {
            retmap.put( key, translate( locale, key ) );
          }
          catch ( MissingResourceException e )
          {
          }
        }
        return retmap;
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the predefined
       * {@link Locale}.<br>
       * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but
       * no {@link Exception} will be thrown.
       * 
       * @param keys
       * @see AdminTest
       * @see #allPropertyKeys()
       * @see #translate(String)
       * @see #tryTranslate(Locale, String[])
       */
      public Map<String, String> tryTranslate( String... keys )
      {
        return tryTranslate( this.locale, keys );
      }
      
      /**
       * Returns all available property keys for the predefined {@link Locale}.
       * 
       * @see AdminTest
       * @see #allPropertyKeys(Locale)
       * @see #translate(String[])
       * @see #translate(Locale, String[])
       */
      public String[] allPropertyKeys()
      {
        return allPropertyKeys( this.locale );
      }
      
      /**
       * Returns all available property keys for the given {@link Locale}.
       * 
       * @param locale
       * @see AdminTest
       * @see #allPropertyKeys()
       * @see #translate(String[])
       * @see #translate(Locale, String[])
       */
      public static String[] allPropertyKeys( Locale locale )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.keySet().toArray( new String[0] );
      }
      
    }
    
    /**
     * This is an automatically with i18nBinder generated facade class.<br>
     * <br>
     * To modify please adapt the underlying property files.<br>
     * <br>
     * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined
     * {@link Locale} when invoked.<br>
     * <br>
     * Resource base: <b>i18n.localelessTest</b>
     * 
     * @see #allPropertyKeys()
     * @see #allPropertyKeys(Locale)
     * @see #translate(String)
     * @see #translate(Locale, String)
     * @see #translate(String[])
     * @see #translate(Locale, String[])
     * @see #tryTranslate(String)
     * @see #tryTranslate(Locale, String)
     * @see #tryTranslate(String[])
     * @see #tryTranslate(Locale, String[])
     */
    public static class LocalelessTest
    {
      private final Locale        locale;
      private final static String baseName = "i18n.localelessTest";
      
      /**
       * @see LocalelessTest
       */
      public LocalelessTest( Locale locale )
      {
        super();
        this.locale = locale;
        
      }
      
      /**
       * Returns the value of the property key <b>my.property.key9</b> for the given {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>=value9</li>
       * </ul>
       * 
       * @param locale
       * @see LocalelessTest
       */
      public static String getMyPropertyKey9( Locale locale )
      {
        String key = "my.property.key9";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key9</b> for the predefined {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>=value9</li>
       * </ul>
       * 
       * @see LocalelessTest
       */
      public String getMyPropertyKey9()
      {
        return getMyPropertyKey9( this.locale );
      }
      
      /**
       * Returns the translated property key for the given {@link Locale}.
       * 
       * @param locale
       * @param key
       * @see LocalelessTest
       * @see #translate(String)
       * @see #tryTranslate(Locale, String)
       * @see #translate(Locale, String[])
       */
      public static String translate( Locale locale, String key )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the translated property key for the predefined {@link Locale}
       * 
       * @see LocalelessTest
       * @see #translate(Locale, String)
       * @see #tryTranslate(String)
       * @see #translate(Locale, String)
       * @see #translate(String[])
       */
      public String translate( String key )
      {
        return translate( this.locale, key );
      }
      
      /**
       * Returns the translated property key for the given {@link Locale}.
       * 
       * @param locale
       * @param key
       * @see LocalelessTest
       * @see #tryTranslate(String)
       * @see #translate(Locale, String[])
       */
      public static String tryTranslate( Locale locale, String key )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        String retval = null;
        try
        {
          retval = resourceBundle.getString( key );
        }
        catch ( MissingResourceException e )
        {
        }
        return retval;
      }
      
      /**
       * Returns the translated property key for the predefined {@link Locale}
       * 
       * @see LocalelessTest
       * @see #translate(Locale, String)
       * @see #tryTranslate(String[])
       */
      public String tryTranslate( String key )
      {
        return tryTranslate( this.locale, key );
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.
       * 
       * @param locale
       * @param keys
       * @see LocalelessTest
       * @see #allPropertyKeys()
       * @see #translate(String[])
       * @see #translate(Locale, String)
       * @see #tryTranslate(Locale, String[])
       */
      public static Map<String, String> translate( Locale locale, String... keys )
      {
        Map<String, String> retmap = new LinkedHashMap<String, String>();
        for ( String key : keys )
        {
          retmap.put( key, translate( locale, key ) );
        }
        return retmap;
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the predefined
       * {@link Locale}.
       * 
       * @param keys
       * @see LocalelessTest
       * @see #allPropertyKeys()
       * @see #translate(String)
       * @see #translate(Locale, String[])
       * @see #tryTranslate(Locale, String[])
       * @see #tryTranslate(String[])
       */
      public Map<String, String> translate( String... keys )
      {
        return translate( this.locale, keys );
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.<br>
       * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but
       * no {@link Exception} will be thrown.
       * 
       * @param locale
       * @param keys
       * @see LocalelessTest
       * @see #allPropertyKeys()
       * @see #translate(Locale, String[])
       * @see #translate(String[])
       * @see #translate(Locale, String)
       */
      public static Map<String, String> tryTranslate( Locale locale, String... keys )
      {
        Map<String, String> retmap = new LinkedHashMap<String, String>();
        for ( String key : keys )
        {
          try
          {
            retmap.put( key, translate( locale, key ) );
          }
          catch ( MissingResourceException e )
          {
          }
        }
        return retmap;
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the predefined
       * {@link Locale}.<br>
       * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but
       * no {@link Exception} will be thrown.
       * 
       * @param keys
       * @see LocalelessTest
       * @see #allPropertyKeys()
       * @see #translate(String)
       * @see #tryTranslate(Locale, String[])
       */
      public Map<String, String> tryTranslate( String... keys )
      {
        return tryTranslate( this.locale, keys );
      }
      
      /**
       * Returns all available property keys for the predefined {@link Locale}.
       * 
       * @see LocalelessTest
       * @see #allPropertyKeys(Locale)
       * @see #translate(String[])
       * @see #translate(Locale, String[])
       */
      public String[] allPropertyKeys()
      {
        return allPropertyKeys( this.locale );
      }
      
      /**
       * Returns all available property keys for the given {@link Locale}.
       * 
       * @param locale
       * @see LocalelessTest
       * @see #allPropertyKeys()
       * @see #translate(String[])
       * @see #translate(Locale, String[])
       */
      public static String[] allPropertyKeys( Locale locale )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.keySet().toArray( new String[0] );
      }
      
    }
    
    /**
     * This is an automatically with i18nBinder generated facade class.<br>
     * <br>
     * To modify please adapt the underlying property files.<br>
     * <br>
     * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined
     * {@link Locale} when invoked.<br>
     * <br>
     * Resource base: <b>i18n.viewTest</b>
     * 
     * @see #allPropertyKeys()
     * @see #allPropertyKeys(Locale)
     * @see #translate(String)
     * @see #translate(Locale, String)
     * @see #translate(String[])
     * @see #translate(Locale, String[])
     * @see #tryTranslate(String)
     * @see #tryTranslate(Locale, String)
     * @see #tryTranslate(String[])
     * @see #tryTranslate(Locale, String[])
     */
    public static class ViewTest
    {
      private final Locale        locale;
      private final static String baseName = "i18n.viewTest";
      
      /**
       * @see ViewTest
       */
      public ViewTest( Locale locale )
      {
        super();
        this.locale = locale;
        
      }
      
      /**
       * Returns the value of the property key <b>my.property.key1</b> for the given {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>de_DE=wert1</li>
       * <li>en_US=value1</li>
       * </ul>
       * 
       * @param locale
       * @see ViewTest
       */
      public static String getMyPropertyKey1( Locale locale )
      {
        String key = "my.property.key1";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key1</b> for the predefined {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>de_DE=wert1</li>
       * <li>en_US=value1</li>
       * </ul>
       * 
       * @see ViewTest
       */
      public String getMyPropertyKey1()
      {
        return getMyPropertyKey1( this.locale );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key3</b> for the given {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>en_US=value3</li>
       * </ul>
       * 
       * @param locale
       * @see ViewTest
       */
      public static String getMyPropertyKey3( Locale locale )
      {
        String key = "my.property.key3";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key3</b> for the predefined {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>en_US=value3</li>
       * </ul>
       * 
       * @see ViewTest
       */
      public String getMyPropertyKey3()
      {
        return getMyPropertyKey3( this.locale );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key4</b> for the given {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>de_DE=wert4</li>
       * </ul>
       * 
       * @param locale
       * @see ViewTest
       */
      public static String getMyPropertyKey4( Locale locale )
      {
        String key = "my.property.key4";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the value of the property key <b>my.property.key4</b> for the predefined {@link Locale}. <br>
       * <br>
       * Examples:
       * <ul>
       * <li>de_DE=wert4</li>
       * </ul>
       * 
       * @see ViewTest
       */
      public String getMyPropertyKey4()
      {
        return getMyPropertyKey4( this.locale );
      }
      
      /**
       * Returns the translated property key for the given {@link Locale}.
       * 
       * @param locale
       * @param key
       * @see ViewTest
       * @see #translate(String)
       * @see #tryTranslate(Locale, String)
       * @see #translate(Locale, String[])
       */
      public static String translate( Locale locale, String key )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Returns the translated property key for the predefined {@link Locale}
       * 
       * @see ViewTest
       * @see #translate(Locale, String)
       * @see #tryTranslate(String)
       * @see #translate(Locale, String)
       * @see #translate(String[])
       */
      public String translate( String key )
      {
        return translate( this.locale, key );
      }
      
      /**
       * Returns the translated property key for the given {@link Locale}.
       * 
       * @param locale
       * @param key
       * @see ViewTest
       * @see #tryTranslate(String)
       * @see #translate(Locale, String[])
       */
      public static String tryTranslate( Locale locale, String key )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        String retval = null;
        try
        {
          retval = resourceBundle.getString( key );
        }
        catch ( MissingResourceException e )
        {
        }
        return retval;
      }
      
      /**
       * Returns the translated property key for the predefined {@link Locale}
       * 
       * @see ViewTest
       * @see #translate(Locale, String)
       * @see #tryTranslate(String[])
       */
      public String tryTranslate( String key )
      {
        return tryTranslate( this.locale, key );
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.
       * 
       * @param locale
       * @param keys
       * @see ViewTest
       * @see #allPropertyKeys()
       * @see #translate(String[])
       * @see #translate(Locale, String)
       * @see #tryTranslate(Locale, String[])
       */
      public static Map<String, String> translate( Locale locale, String... keys )
      {
        Map<String, String> retmap = new LinkedHashMap<String, String>();
        for ( String key : keys )
        {
          retmap.put( key, translate( locale, key ) );
        }
        return retmap;
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the predefined
       * {@link Locale}.
       * 
       * @param keys
       * @see ViewTest
       * @see #allPropertyKeys()
       * @see #translate(String)
       * @see #translate(Locale, String[])
       * @see #tryTranslate(Locale, String[])
       * @see #tryTranslate(String[])
       */
      public Map<String, String> translate( String... keys )
      {
        return translate( this.locale, keys );
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.<br>
       * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but
       * no {@link Exception} will be thrown.
       * 
       * @param locale
       * @param keys
       * @see ViewTest
       * @see #allPropertyKeys()
       * @see #translate(Locale, String[])
       * @see #translate(String[])
       * @see #translate(Locale, String)
       */
      public static Map<String, String> tryTranslate( Locale locale, String... keys )
      {
        Map<String, String> retmap = new LinkedHashMap<String, String>();
        for ( String key : keys )
        {
          try
          {
            retmap.put( key, translate( locale, key ) );
          }
          catch ( MissingResourceException e )
          {
          }
        }
        return retmap;
      }
      
      /**
       * Returns a translation {@link Map} with the given property keys and their respective values for the predefined
       * {@link Locale}.<br>
       * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but
       * no {@link Exception} will be thrown.
       * 
       * @param keys
       * @see ViewTest
       * @see #allPropertyKeys()
       * @see #translate(String)
       * @see #tryTranslate(Locale, String[])
       */
      public Map<String, String> tryTranslate( String... keys )
      {
        return tryTranslate( this.locale, keys );
      }
      
      /**
       * Returns all available property keys for the predefined {@link Locale}.
       * 
       * @see ViewTest
       * @see #allPropertyKeys(Locale)
       * @see #translate(String[])
       * @see #translate(Locale, String[])
       */
      public String[] allPropertyKeys()
      {
        return allPropertyKeys( this.locale );
      }
      
      /**
       * Returns all available property keys for the given {@link Locale}.
       * 
       * @param locale
       * @see ViewTest
       * @see #allPropertyKeys()
       * @see #translate(String[])
       * @see #translate(Locale, String[])
       */
      public static String[] allPropertyKeys( Locale locale )
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
        return resourceBundle.keySet().toArray( new String[0] );
      }
      
    }
    
  }
  
}
