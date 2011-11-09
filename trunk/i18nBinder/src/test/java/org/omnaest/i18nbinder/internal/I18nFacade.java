package org.omnaest.i18nbinder.internal;

import java.util.Locale;
import java.util.Map;
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
    public _673numericalTest _673numericalTest = null;
    public AdminTest         AdminTest         = null;
    public LocalelessTest    LocalelessTest    = null;
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
      
    }
    
  }
  
}
