package org.omnaest.i18nbinder.internal;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * This is an automatically with i18nBinder generated facade class.<br><br>
 * To modify please adapt the underlying property files.<br><br>
 * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * @see I18n
 */ 
public class I18nFacade {
  /** @see I18n */
  public final I18n I18n;

  /**
   * A {@link Translator} offers several methods to translate arbitrary keys into their i18n counterpart based on the initially
   * given {@link Locale}.
   * 
   * @see #translate(String)
   * @see #translate(String[]) 
   * @see #tryTranslate(String) 
   * @see #tryTranslate(String[]) 
   * @see #allPropertyKeys() 
   */ 
  public static class Translator {

    private final String baseName;
    private final Locale locale;

    /**
     * @see Translator
     * @param baseName
     * @param locale
     */ 
    public Translator( String baseName, Locale locale )
    {
      super();
      this.baseName = baseName;
      this.locale = locale;
    }

    private String translate(Locale locale, String key)
    {
      ResourceBundle resourceBundle = ResourceBundle.getBundle( this.baseName, locale );
      return resourceBundle.getString( key );
    }

    /**
     * Returns the translated property key for the predefined {@link Locale}
     * @see Translator
     * @see #translate(Locale, String)
     * @see #tryTranslate(String)
     * @see #translate(String[])
     */ 
    public String translate( String key )
    {
      return translate( this.locale, key );
    }

    private String tryTranslate(Locale locale, String key)
    {
      String retval = null;
      try
      {
        ResourceBundle resourceBundle = ResourceBundle.getBundle( this.baseName, locale );
        retval = resourceBundle.getString( key );
      }
      catch (MissingResourceException e) {}
      return retval;
    }

    /**
     * Returns the translated property key for the predefined {@link Locale}
     * @see Translator
     * @see #translate(String)
     * @see #tryTranslate(String[])
     */ 
    public String tryTranslate( String key )
    {
      return tryTranslate( this.locale, key );
    }

    private  Map<String, String> translate( Locale locale, String... keys )
    {
      Map<String, String> retmap = new LinkedHashMap<String, String>();
      for ( String key : keys )
      {
        retmap.put( key, translate( locale, key ) );
      }
      return retmap;
    }

    /**
     * Returns a translation {@link Map} with the given property keys and their respective values for the predefined {@link Locale}.
     * @param keys 
     * @see Translator
     * @see #allPropertyKeys()
     * @see #translate(String)
     * @see #tryTranslate(String[])
     */ 
    public Map<String, String> translate( String... keys )
    {
      return translate( this.locale, keys );
    }

    private Map<String, String> tryTranslate( Locale locale, String... keys )
    {
      Map<String, String> retmap = new LinkedHashMap<String, String>();
      for ( String key : keys )
      {
        try
        {
          retmap.put( key, translate( locale, key ) );
        }
        catch (MissingResourceException e) {}
      }
      return retmap;
    }

    /**
     * Returns a translation {@link Map} with the given property keys and their respective values for the predefined {@link Locale}.<br>
     * If a single property key cannot be resolved from the resources, it will be excluded from the translation {@link Map} but no {@link Exception} will be thrown.
     * @param keys 
     * @see Translator
     * @see #allPropertyKeys()
     * @see #translate(String)
     */ 
    public Map<String, String> tryTranslate( String... keys )
    {
      return tryTranslate( this.locale, keys );
    }

    private String[] allPropertyKeys(Locale locale)
    {
      ResourceBundle resourceBundle = ResourceBundle.getBundle( this.baseName, locale );
      return resourceBundle.keySet().toArray( new String[0] );
    }

    /**
     * Returns all available property keys for the predefined {@link Locale}. 
     * @see Translator
     * @see #translate(String[])
     * @see #tryTranslate(String[])
     */ 
    public String[] allPropertyKeys()
    {
      return allPropertyKeys( this.locale );    }

  }


  /**
   * @see I18nFacade
   */ 
  public I18nFacade( Locale locale )
  {
    super();
    this.I18n = new I18n( locale );
  }
  
/**
 * This is an automatically with i18nBinder generated facade class.<br><br>
 * To modify please adapt the underlying property files.<br><br>
 * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * Resource base: <b>i18n</b>
 * @see _673numericalTest
 * @see AdminTest
 * @see LocalelessTest
 * @see ViewTest
 */ 
public static class I18n {
  /** @see _673numericalTest */
  public final _673numericalTest _673numericalTest;
  /** @see AdminTest */
  public final AdminTest AdminTest;
  /** @see LocalelessTest */
  public final LocalelessTest LocalelessTest;
  /** @see ViewTest */
  public final ViewTest ViewTest;

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
 * This is an automatically with i18nBinder generated facade class.<br><br>
 * To modify please adapt the underlying property files.<br><br>
 * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * Resource base: <b>i18n.673numericalTest</b>
 * <br><br>
 * <h1>Examples:</h1>
 * <table border="1">
 * <thead>
 * <tr>
 * <th>key</th>
 * <th>examples</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td rowspan="1">my.property.key1</td>
 * <td>en_US=value {0} and {1}</td>
 * </tr>
 * <tr>
 * <td rowspan="1">my.property.key3</td>
 * <td>en_US=value3 with {arbitrary} replacement</td>
 * </tr>
 * </tbody>
 * </table><br><br>
 * @see #translator()
 * @see #translator(Locale)
 */ 
public static class _673numericalTest {
  private final Locale locale;
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
   * Returns the value of the property key <b>my.property.key1</b> for the given {@link Locale}.
   * <br><br>
   * Placeholders:
   * <ul>
   * <li><b>{0}</b></li>
   * <li><b>{1}</b></li>
   * </ul>
   * 
   * Examples:
   * <ul>
   * <li>en_US=value {0} and {1}</li>
   * </ul>
   * @see _673numericalTest
   * @see #tryGetMyPropertyKey1(Locale locale)
   * @see #getMyPropertyKey1()
   * @param locale 
   */ 
  public static String getMyPropertyKey1(Locale locale)
  {
    final String key = "my.property.key1";
    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
    return resourceBundle.getString( key );
  }

  /**
   * Similar to {@link #getMyPropertyKey1(Locale)} for the predefined {@link Locale}.
   * @see _673numericalTest
   * @see #tryGetMyPropertyKey1()
   * @see #getMyPropertyKey1(Locale)
   */ 
  public String getMyPropertyKey1()
  {
    return getMyPropertyKey1( this.locale );
  }

  /**
   * Similar to  {@link #getMyPropertyKey1(Locale)} but does not throw any {@link MissingResourceException}.
   * @see _673numericalTest
   * @see #getMyPropertyKey1(Locale locale)
   * @see #tryGetMyPropertyKey1()
   * @param locale 
   */ 
  public static String tryGetMyPropertyKey1(Locale locale)
  {
    try
    {
      return getMyPropertyKey1( locale );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey1()} but does not throw any {@link MissingResourceException}.
   * @see _673numericalTest
   * @see #getMyPropertyKey1()
   * @see #tryGetMyPropertyKey1(Locale)
   */ 
  public String tryGetMyPropertyKey1()
  {
    return tryGetMyPropertyKey1( this.locale );
  }

  /**
   * Returns the value of the property key <b>my.property.key1</b> for the given {@link Locale} with all {0},{1},... placeholders replaced by the given tokens in their order.<br><br>
   * If there are not enough parameters existing placeholders will remain unreplaced.
   * <br><br>
   * Placeholders:
   * <ul>
   * <li><b>{0}</b></li>
   * <li><b>{1}</b></li>
   * </ul>
   * 
   * Examples:
   * <ul>
   * <li>en_US=value {0} and {1}</li>
   * </ul>
   * @see _673numericalTest
   * @see #tryGetMyPropertyKey1(Locale,String[])
   * @see #getMyPropertyKey1(String[])
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
   * Similar to  {@link #getMyPropertyKey1(Locale,String[])} using the predefined {@link Locale}.
   * @see _673numericalTest
   * @see #getMyPropertyKey1(Locale,String[])
   * @see #tryGetMyPropertyKey1(String[])
   * @param tokens
   */ 
  public String getMyPropertyKey1( String... tokens )
  {
    return getMyPropertyKey1( this.locale, tokens );
  }

  /**
   * Similar to  {@link #getMyPropertyKey1(Locale,String[])} but does not throw any {@link MissingResourceException}.
   * @see _673numericalTest
   * @see #getMyPropertyKey1(Locale,String[])
   * @see #tryGetMyPropertyKey1(String[])
   * @param locale
   * @param tokens
   */ 
  public static String tryGetMyPropertyKey1( Locale locale, String... tokens )
  {
    try
    {
      return getMyPropertyKey1( locale, tokens );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey1(String[])} but does not throw any {@link MissingResourceException}.
   * @see _673numericalTest
   * @see #getMyPropertyKey1(String[])
   * @see #tryGetMyPropertyKey1(Locale,String[])
   * @param tokens
   */ 
  public String tryGetMyPropertyKey1( String... tokens )
  {
    return tryGetMyPropertyKey1( this.locale, tokens );
  }

  /**
   * Returns the value of the property key <b>my.property.key3</b> for the given {@link Locale}.
   * <br><br>
   * Placeholders:
   * <ul>
   * <li><b>{arbitrary}</b></li>
   * </ul>
   * 
   * Examples:
   * <ul>
   * <li>en_US=value3 with {arbitrary} replacement</li>
   * </ul>
   * @see _673numericalTest
   * @see #tryGetMyPropertyKey3(Locale locale)
   * @see #getMyPropertyKey3()
   * @param locale 
   */ 
  public static String getMyPropertyKey3(Locale locale)
  {
    final String key = "my.property.key3";
    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
    return resourceBundle.getString( key );
  }

  /**
   * Similar to {@link #getMyPropertyKey3(Locale)} for the predefined {@link Locale}.
   * @see _673numericalTest
   * @see #tryGetMyPropertyKey3()
   * @see #getMyPropertyKey3(Locale)
   */ 
  public String getMyPropertyKey3()
  {
    return getMyPropertyKey3( this.locale );
  }

  /**
   * Similar to  {@link #getMyPropertyKey3(Locale)} but does not throw any {@link MissingResourceException}.
   * @see _673numericalTest
   * @see #getMyPropertyKey3(Locale locale)
   * @see #tryGetMyPropertyKey3()
   * @param locale 
   */ 
  public static String tryGetMyPropertyKey3(Locale locale)
  {
    try
    {
      return getMyPropertyKey3( locale );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey3()} but does not throw any {@link MissingResourceException}.
   * @see _673numericalTest
   * @see #getMyPropertyKey3()
   * @see #tryGetMyPropertyKey3(Locale)
   */ 
  public String tryGetMyPropertyKey3()
  {
    return tryGetMyPropertyKey3( this.locale );
  }

  /**
   * Returns the value of the property key <b>my.property.key3</b> for the given {@link Locale} with arbitrary placeholder tag like {example} replaced by the given values.<br>
   * The given placeholderToReplacementMap needs the placeholder tag name and a value. E.g. for {example} the key "example" has to be set.
   * <br><br>
   * Placeholders:
   * <ul>
   * <li><b>{arbitrary}</b></li>
   * </ul>
   * 
   * Examples:
   * <ul>
   * <li>en_US=value3 with {arbitrary} replacement</li>
   * </ul>
   * @see _673numericalTest
   * @see #tryGetMyPropertyKey3(Locale,Map)
   * @see #getMyPropertyKey3(Map)
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
   * Similar to  {@link #getMyPropertyKey3(Locale,Map)} using the predefined {@link Locale}.
   * @see _673numericalTest
   * @see #getMyPropertyKey3(Locale,Map)
   * @see #tryGetMyPropertyKey3(Map)
   * @param placeholderToReplacementMap
   */ 
  public String getMyPropertyKey3( Map<String, String> placeholderToReplacementMap )
  {
    return getMyPropertyKey3( this.locale, placeholderToReplacementMap );
  }

  /**
   * Similar to  {@link #getMyPropertyKey3(Locale,Map)} but does not throw any {@link MissingResourceException}.
   * @see _673numericalTest
   * @see #getMyPropertyKey3(Locale,Map)
   * @see #tryGetMyPropertyKey3(Map)
   * @param locale
   * @param placeholderToReplacementMap
   */ 
  public static String tryGetMyPropertyKey3( Locale locale, Map<String, String> placeholderToReplacementMap )
  {
    try
    {
      return getMyPropertyKey3( locale, placeholderToReplacementMap );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey3(Map)} but does not throw any {@link MissingResourceException}.
   * @see _673numericalTest
   * @see #getMyPropertyKey3(Locale, Map)
   * @see #tryGetMyPropertyKey3(Locale, Map)
   * @param placeholderToReplacementMap
   */ 
  public String tryGetMyPropertyKey3( Map<String, String> placeholderToReplacementMap )
  {
    return tryGetMyPropertyKey3( this.locale, placeholderToReplacementMap );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see _673numericalTest
   * @see #translator()
   * @return {@link Translator}   */ 
  public static Translator translator(Locale locale)
  {
    return new Translator( baseName, locale );
  }

  /**
   * Returns a new {@link Translator} instance using the internal {@link Locale} and based on the {@value #baseName} i18n base
   * @see _673numericalTest
   * @see #translator(Locale)
   * @return {@link Translator}   */ 
  public Translator translator()
  {
    return translator( this.locale );
  }

}

/**
 * This is an automatically with i18nBinder generated facade class.<br><br>
 * To modify please adapt the underlying property files.<br><br>
 * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * Resource base: <b>i18n.adminTest</b>
 * <br><br>
 * <h1>Examples:</h1>
 * <table border="1">
 * <thead>
 * <tr>
 * <th>key</th>
 * <th>examples</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td rowspan="2">my.property.key1</td>
 * <td>de_DE=wert1</td>
 * </tr>
 * <tr>
 * <td><small>en_US=value1</small></td>
 * </tr>
 * <tr>
 * <td rowspan="2">my.property.key2</td>
 * <td>de_DE=wert2</td>
 * </tr>
 * <tr>
 * <td><small>en_US=value2</small></td>
 * </tr>
 * </tbody>
 * </table><br><br>
 * @see #translator()
 * @see #translator(Locale)
 */ 
public static class AdminTest {
  private final Locale locale;
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
   * Returns the value of the property key <b>my.property.key1</b> for the given {@link Locale}.
   * <br><br>
   * 
   * Examples:
   * <ul>
   * <li>de_DE=wert1</li>
   * <li>en_US=value1</li>
   * </ul>
   * @see AdminTest
   * @see #tryGetMyPropertyKey1(Locale locale)
   * @see #getMyPropertyKey1()
   * @param locale 
   */ 
  public static String getMyPropertyKey1(Locale locale)
  {
    final String key = "my.property.key1";
    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
    return resourceBundle.getString( key );
  }

  /**
   * Similar to {@link #getMyPropertyKey1(Locale)} for the predefined {@link Locale}.
   * @see AdminTest
   * @see #tryGetMyPropertyKey1()
   * @see #getMyPropertyKey1(Locale)
   */ 
  public String getMyPropertyKey1()
  {
    return getMyPropertyKey1( this.locale );
  }

  /**
   * Similar to  {@link #getMyPropertyKey1(Locale)} but does not throw any {@link MissingResourceException}.
   * @see AdminTest
   * @see #getMyPropertyKey1(Locale locale)
   * @see #tryGetMyPropertyKey1()
   * @param locale 
   */ 
  public static String tryGetMyPropertyKey1(Locale locale)
  {
    try
    {
      return getMyPropertyKey1( locale );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey1()} but does not throw any {@link MissingResourceException}.
   * @see AdminTest
   * @see #getMyPropertyKey1()
   * @see #tryGetMyPropertyKey1(Locale)
   */ 
  public String tryGetMyPropertyKey1()
  {
    return tryGetMyPropertyKey1( this.locale );
  }

  /**
   * Returns the value of the property key <b>my.property.key2</b> for the given {@link Locale}.
   * <br><br>
   * 
   * Examples:
   * <ul>
   * <li>de_DE=wert2</li>
   * <li>en_US=value2</li>
   * </ul>
   * @see AdminTest
   * @see #tryGetMyPropertyKey2(Locale locale)
   * @see #getMyPropertyKey2()
   * @param locale 
   */ 
  public static String getMyPropertyKey2(Locale locale)
  {
    final String key = "my.property.key2";
    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
    return resourceBundle.getString( key );
  }

  /**
   * Similar to {@link #getMyPropertyKey2(Locale)} for the predefined {@link Locale}.
   * @see AdminTest
   * @see #tryGetMyPropertyKey2()
   * @see #getMyPropertyKey2(Locale)
   */ 
  public String getMyPropertyKey2()
  {
    return getMyPropertyKey2( this.locale );
  }

  /**
   * Similar to  {@link #getMyPropertyKey2(Locale)} but does not throw any {@link MissingResourceException}.
   * @see AdminTest
   * @see #getMyPropertyKey2(Locale locale)
   * @see #tryGetMyPropertyKey2()
   * @param locale 
   */ 
  public static String tryGetMyPropertyKey2(Locale locale)
  {
    try
    {
      return getMyPropertyKey2( locale );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey2()} but does not throw any {@link MissingResourceException}.
   * @see AdminTest
   * @see #getMyPropertyKey2()
   * @see #tryGetMyPropertyKey2(Locale)
   */ 
  public String tryGetMyPropertyKey2()
  {
    return tryGetMyPropertyKey2( this.locale );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see AdminTest
   * @see #translator()
   * @return {@link Translator}   */ 
  public static Translator translator(Locale locale)
  {
    return new Translator( baseName, locale );
  }

  /**
   * Returns a new {@link Translator} instance using the internal {@link Locale} and based on the {@value #baseName} i18n base
   * @see AdminTest
   * @see #translator(Locale)
   * @return {@link Translator}   */ 
  public Translator translator()
  {
    return translator( this.locale );
  }

}

/**
 * This is an automatically with i18nBinder generated facade class.<br><br>
 * To modify please adapt the underlying property files.<br><br>
 * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * Resource base: <b>i18n.localelessTest</b>
 * <br><br>
 * <h1>Examples:</h1>
 * <table border="1">
 * <thead>
 * <tr>
 * <th>key</th>
 * <th>examples</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td rowspan="1">my.property.key9</td>
 * <td>=value9</td>
 * </tr>
 * </tbody>
 * </table><br><br>
 * @see #translator()
 * @see #translator(Locale)
 */ 
public static class LocalelessTest {
  private final Locale locale;
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
   * Returns the value of the property key <b>my.property.key9</b> for the given {@link Locale}.
   * <br><br>
   * 
   * Examples:
   * <ul>
   * <li>=value9</li>
   * </ul>
   * @see LocalelessTest
   * @see #tryGetMyPropertyKey9(Locale locale)
   * @see #getMyPropertyKey9()
   * @param locale 
   */ 
  public static String getMyPropertyKey9(Locale locale)
  {
    final String key = "my.property.key9";
    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
    return resourceBundle.getString( key );
  }

  /**
   * Similar to {@link #getMyPropertyKey9(Locale)} for the predefined {@link Locale}.
   * @see LocalelessTest
   * @see #tryGetMyPropertyKey9()
   * @see #getMyPropertyKey9(Locale)
   */ 
  public String getMyPropertyKey9()
  {
    return getMyPropertyKey9( this.locale );
  }

  /**
   * Similar to  {@link #getMyPropertyKey9(Locale)} but does not throw any {@link MissingResourceException}.
   * @see LocalelessTest
   * @see #getMyPropertyKey9(Locale locale)
   * @see #tryGetMyPropertyKey9()
   * @param locale 
   */ 
  public static String tryGetMyPropertyKey9(Locale locale)
  {
    try
    {
      return getMyPropertyKey9( locale );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey9()} but does not throw any {@link MissingResourceException}.
   * @see LocalelessTest
   * @see #getMyPropertyKey9()
   * @see #tryGetMyPropertyKey9(Locale)
   */ 
  public String tryGetMyPropertyKey9()
  {
    return tryGetMyPropertyKey9( this.locale );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see LocalelessTest
   * @see #translator()
   * @return {@link Translator}   */ 
  public static Translator translator(Locale locale)
  {
    return new Translator( baseName, locale );
  }

  /**
   * Returns a new {@link Translator} instance using the internal {@link Locale} and based on the {@value #baseName} i18n base
   * @see LocalelessTest
   * @see #translator(Locale)
   * @return {@link Translator}   */ 
  public Translator translator()
  {
    return translator( this.locale );
  }

}

/**
 * This is an automatically with i18nBinder generated facade class.<br><br>
 * To modify please adapt the underlying property files.<br><br>
 * If the facade class is instantiated with a given {@link Locale} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * Resource base: <b>i18n.viewTest</b>
 * <br><br>
 * <h1>Examples:</h1>
 * <table border="1">
 * <thead>
 * <tr>
 * <th>key</th>
 * <th>examples</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td rowspan="2">my.property.key1</td>
 * <td>de_DE=wert1</td>
 * </tr>
 * <tr>
 * <td><small>en_US=value1</small></td>
 * </tr>
 * <tr>
 * <td rowspan="1">my.property.key3</td>
 * <td>en_US=value3</td>
 * </tr>
 * <tr>
 * <td rowspan="1">my.property.key4</td>
 * <td>de_DE=wert4</td>
 * </tr>
 * </tbody>
 * </table><br><br>
 * @see #translator()
 * @see #translator(Locale)
 */ 
public static class ViewTest {
  private final Locale locale;
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
   * Returns the value of the property key <b>my.property.key1</b> for the given {@link Locale}.
   * <br><br>
   * 
   * Examples:
   * <ul>
   * <li>de_DE=wert1</li>
   * <li>en_US=value1</li>
   * </ul>
   * @see ViewTest
   * @see #tryGetMyPropertyKey1(Locale locale)
   * @see #getMyPropertyKey1()
   * @param locale 
   */ 
  public static String getMyPropertyKey1(Locale locale)
  {
    final String key = "my.property.key1";
    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
    return resourceBundle.getString( key );
  }

  /**
   * Similar to {@link #getMyPropertyKey1(Locale)} for the predefined {@link Locale}.
   * @see ViewTest
   * @see #tryGetMyPropertyKey1()
   * @see #getMyPropertyKey1(Locale)
   */ 
  public String getMyPropertyKey1()
  {
    return getMyPropertyKey1( this.locale );
  }

  /**
   * Similar to  {@link #getMyPropertyKey1(Locale)} but does not throw any {@link MissingResourceException}.
   * @see ViewTest
   * @see #getMyPropertyKey1(Locale locale)
   * @see #tryGetMyPropertyKey1()
   * @param locale 
   */ 
  public static String tryGetMyPropertyKey1(Locale locale)
  {
    try
    {
      return getMyPropertyKey1( locale );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey1()} but does not throw any {@link MissingResourceException}.
   * @see ViewTest
   * @see #getMyPropertyKey1()
   * @see #tryGetMyPropertyKey1(Locale)
   */ 
  public String tryGetMyPropertyKey1()
  {
    return tryGetMyPropertyKey1( this.locale );
  }

  /**
   * Returns the value of the property key <b>my.property.key3</b> for the given {@link Locale}.
   * <br><br>
   * 
   * Examples:
   * <ul>
   * <li>en_US=value3</li>
   * </ul>
   * @see ViewTest
   * @see #tryGetMyPropertyKey3(Locale locale)
   * @see #getMyPropertyKey3()
   * @param locale 
   */ 
  public static String getMyPropertyKey3(Locale locale)
  {
    final String key = "my.property.key3";
    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
    return resourceBundle.getString( key );
  }

  /**
   * Similar to {@link #getMyPropertyKey3(Locale)} for the predefined {@link Locale}.
   * @see ViewTest
   * @see #tryGetMyPropertyKey3()
   * @see #getMyPropertyKey3(Locale)
   */ 
  public String getMyPropertyKey3()
  {
    return getMyPropertyKey3( this.locale );
  }

  /**
   * Similar to  {@link #getMyPropertyKey3(Locale)} but does not throw any {@link MissingResourceException}.
   * @see ViewTest
   * @see #getMyPropertyKey3(Locale locale)
   * @see #tryGetMyPropertyKey3()
   * @param locale 
   */ 
  public static String tryGetMyPropertyKey3(Locale locale)
  {
    try
    {
      return getMyPropertyKey3( locale );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey3()} but does not throw any {@link MissingResourceException}.
   * @see ViewTest
   * @see #getMyPropertyKey3()
   * @see #tryGetMyPropertyKey3(Locale)
   */ 
  public String tryGetMyPropertyKey3()
  {
    return tryGetMyPropertyKey3( this.locale );
  }

  /**
   * Returns the value of the property key <b>my.property.key4</b> for the given {@link Locale}.
   * <br><br>
   * 
   * Examples:
   * <ul>
   * <li>de_DE=wert4</li>
   * </ul>
   * @see ViewTest
   * @see #tryGetMyPropertyKey4(Locale locale)
   * @see #getMyPropertyKey4()
   * @param locale 
   */ 
  public static String getMyPropertyKey4(Locale locale)
  {
    final String key = "my.property.key4";
    ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, locale );
    return resourceBundle.getString( key );
  }

  /**
   * Similar to {@link #getMyPropertyKey4(Locale)} for the predefined {@link Locale}.
   * @see ViewTest
   * @see #tryGetMyPropertyKey4()
   * @see #getMyPropertyKey4(Locale)
   */ 
  public String getMyPropertyKey4()
  {
    return getMyPropertyKey4( this.locale );
  }

  /**
   * Similar to  {@link #getMyPropertyKey4(Locale)} but does not throw any {@link MissingResourceException}.
   * @see ViewTest
   * @see #getMyPropertyKey4(Locale locale)
   * @see #tryGetMyPropertyKey4()
   * @param locale 
   */ 
  public static String tryGetMyPropertyKey4(Locale locale)
  {
    try
    {
      return getMyPropertyKey4( locale );
    }
    catch ( MissingResourceException e )
    {
      return null;
    }
  }

  /**
   * Similar to  {@link #getMyPropertyKey4()} but does not throw any {@link MissingResourceException}.
   * @see ViewTest
   * @see #getMyPropertyKey4()
   * @see #tryGetMyPropertyKey4(Locale)
   */ 
  public String tryGetMyPropertyKey4()
  {
    return tryGetMyPropertyKey4( this.locale );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see ViewTest
   * @see #translator()
   * @return {@link Translator}   */ 
  public static Translator translator(Locale locale)
  {
    return new Translator( baseName, locale );
  }

  /**
   * Returns a new {@link Translator} instance using the internal {@link Locale} and based on the {@value #baseName} i18n base
   * @see ViewTest
   * @see #translator(Locale)
   * @return {@link Translator}   */ 
  public Translator translator()
  {
    return translator( this.locale );
  }

}

}

}


