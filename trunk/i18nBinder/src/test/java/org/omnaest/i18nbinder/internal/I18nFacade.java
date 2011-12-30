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
  /** Internally used {@link ResourceBasedTranslator}. Changing this implementation affects the behavior of the whole facade */
  protected static ResourceBasedTranslator resourceBasedTranslator = new ResourceBasedTranslator()
  {
    @Override
    public String translate( String baseName, String key, Locale locale )
    {
      ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName,locale );
      return resourceBundle.getString( key );
    }

    @Override
    public String[] resolveAllKeys( String baseName, Locale locale )
    {
      ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName,locale );
      return resourceBundle.keySet().toArray( new String[0] );
    }
  };

  /** Defines which {@link ResourceBasedTranslator} the facade should use. This affects all available instances. */
  public static void use( ResourceBasedTranslator resourceBasedTranslator )
  {
    I18nFacade.resourceBasedTranslator = resourceBasedTranslator;
  };


  /**
   * Basic interface which is used by the facade to resolve translated values for given keys<br>
   * <br>
   * Any implementation should be thread safe   */ 
  public static interface ResourceBasedTranslator {
    /**
     * Returns the translated value for the given key respecting the base name and the given {@link Locale}
     * @param baseName
     * @param key
     * @param locale
     * @return
     */ 
    public String translate( String baseName, String key, Locale locale );
    /**
     * Returns all available keys for the given {@link Locale}
     * @param baseName
     * @param locale
     * @return
     */ 
    public String[] resolveAllKeys( String baseName, Locale locale );
  }


  /**
   * A {@link Translator} offers several methods to translate arbitrary keys into their i18n counterpart based on the initially
   * given {@link Locale}.
   * 
   * @see #translate(String)
   * @see #translate(String[]) 
   * @see #allPropertyKeys() 
   */ 
  public static class Translator {

    private final String baseName;
    private final Locale locale;
    private final boolean silentlyIgnoreMissingResourceException;

    /**
     * @see Translator
     * @param baseName
     * @param locale
     */ 
    public Translator( String baseName, Locale locale )
    {
      this(baseName,locale,true);
    }

    /**
     * @see Translator
     * @param baseName
     * @param locale
     */ 
    public Translator( String baseName, Locale locale, boolean silentlyIgnoreMissingResourceException )
    {
      super();
      this.baseName = baseName;
      this.locale = locale;
      this.silentlyIgnoreMissingResourceException = silentlyIgnoreMissingResourceException;
    }

    /**
     * Returns the translated property key for the given {@link Locale}
     * @see Translator
     * @see #translate(String)
     * @see #translate(String[])
     */ 
    public String translate(Locale locale, String key)
    {
      try
      {
        return resourceBasedTranslator.translate( this.baseName, key, locale );
      }
      catch ( MissingResourceException e )
      {
        if (!this.silentlyIgnoreMissingResourceException)
        {
          throw e;
        }
        return null;
      }
    }

    /**
     * Returns the translated property key for the predefined {@link Locale}
     * @see Translator
     * @see #translate(Locale, String)
     * @see #translate(String[])
     */ 
    public String translate( String key )
    {
      return translate( this.locale, key );
    }

    /**
     * Returns a translation {@link Map} with the given property keys and their respective values for the given {@link Locale}.
     * @param keys 
     * @see Translator
     * @see #allPropertyKeys()
     * @see #translate(String)
     */ 
    public Map<String, String> translate( Locale locale, String... keys )
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
     */ 
    public Map<String, String> translate( String... keys )
    {
      return translate( this.locale, keys );
    }

    /**
     * Returns all available property keys for the given {@link Locale}. 
     * @see Translator
     * @see #allPropertyKeys()
     * @see #translate(String[])
     */ 
    public String[] allPropertyKeys(Locale locale)
    {
      return resourceBasedTranslator.resolveAllKeys( this.baseName, locale );
    }

    /**
     * Returns all available property keys for the predefined {@link Locale}. 
     * @see Translator
     * @see #allPropertyKeys(Locale)
     * @see #translate(String[])
     */ 
    public String[] allPropertyKeys()
    {
      return allPropertyKeys( this.locale );
    }

    /**
     * Returns a translation {@link Map} for the predefined {@link Locale} including all available i18n keys resolved using 
     * {@link #allPropertyKeys()} and their respective translation values resolved using {@link #translate(String...)} 
     * @see Translator
     * @see #allPropertyKeys(Locale)
     * @see #translate(String[])
     * @return {@link Map}
     */ 
    public Map<String, String> translationMap()
    {
      return this.translate( this.allPropertyKeys() );
    }

    /**
     * Similar to {@link #translationMap()} for the given {@link Locale} instead. 
     * @see Translator
     * @see #allPropertyKeys(Locale)
     * @see #translate(String[])
     * @param locale
     * @return {@link Map}
     */ 
    public Map<String, String> translationMap( Locale locale )
    {
      return this.translate( locale, this.allPropertyKeys( locale ) );
    }

  }


  /**
   * This {@link I18nFacade} constructor will create a new instance which silently ignores any {@link MissingResourceException} 
   * @see I18nFacade
   * @param locale
   */ 
  public I18nFacade( Locale locale )
  {
    this(locale,true);
  }
  

  /**
   * @see I18nFacade
   * @param locale
   * @param silentlyIgnoreMissingResourceException
   */ 
  public I18nFacade( Locale locale, boolean silentlyIgnoreMissingResourceException )
  {
    super();
    this.I18n = new I18n( locale, silentlyIgnoreMissingResourceException );
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
   * This {@link I18n} constructor will create a new instance which silently ignores any {@link MissingResourceException} 
   * @see I18n
   * @param locale
   */ 
  public I18n( Locale locale )
  {
    this(locale,true);
  }
  

  /**
   * @see I18n
   * @param locale
   * @param silentlyIgnoreMissingResourceException
   */ 
  public I18n( Locale locale, boolean silentlyIgnoreMissingResourceException )
  {
    super();
    this._673numericalTest = new _673numericalTest( locale, silentlyIgnoreMissingResourceException );
    this.AdminTest = new AdminTest( locale, silentlyIgnoreMissingResourceException );
    this.LocalelessTest = new LocalelessTest( locale, silentlyIgnoreMissingResourceException );
    this.ViewTest = new ViewTest( locale, silentlyIgnoreMissingResourceException );
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
  private final static String baseName = "i18n.673numericalTest";
  private final Locale locale;
  private final boolean silentlyIgnoreMissingResourceException;

  /**
   * This {@link _673numericalTest} constructor will create a new instance which silently ignores any {@link MissingResourceException} 
   * @see _673numericalTest
   * @param locale
   */ 
  public _673numericalTest( Locale locale )
  {
    this(locale,true);
  }
  

  /**
   * @see _673numericalTest
   * @param locale
   * @param silentlyIgnoreMissingResourceException
   */ 
  public _673numericalTest( Locale locale, boolean silentlyIgnoreMissingResourceException )
  {
    super();
    this.locale = locale;
    this.silentlyIgnoreMissingResourceException = silentlyIgnoreMissingResourceException;
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
   * @see #getMyPropertyKey1()
   * @param locale 
   */ 
  public String getMyPropertyKey1(Locale locale)
  {
    try
    {
      final String key = "my.property.key1";
      return resourceBasedTranslator.translate( baseName, key, locale );
    }
    catch ( MissingResourceException e )
    {
      if (!this.silentlyIgnoreMissingResourceException)
      {
        throw e;
      }
      return null;
    }
  }

  /**
   * Similar to {@link #getMyPropertyKey1(Locale)} for the predefined {@link Locale}.
   * @see _673numericalTest
   * @see #getMyPropertyKey1(Locale)
   */ 
  public String getMyPropertyKey1()
  {
    return getMyPropertyKey1( this.locale );
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
   * @see #getMyPropertyKey1(String[])
   * @param locale
   * @param tokens
   */ 
  public String getMyPropertyKey1( Locale locale, String... tokens )
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
   * @param tokens
   */ 
  public String getMyPropertyKey1( String... tokens )
  {
    return getMyPropertyKey1( this.locale, tokens );
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
   * @see #getMyPropertyKey3()
   * @param locale 
   */ 
  public String getMyPropertyKey3(Locale locale)
  {
    try
    {
      final String key = "my.property.key3";
      return resourceBasedTranslator.translate( baseName, key, locale );
    }
    catch ( MissingResourceException e )
    {
      if (!this.silentlyIgnoreMissingResourceException)
      {
        throw e;
      }
      return null;
    }
  }

  /**
   * Similar to {@link #getMyPropertyKey3(Locale)} for the predefined {@link Locale}.
   * @see _673numericalTest
   * @see #getMyPropertyKey3(Locale)
   */ 
  public String getMyPropertyKey3()
  {
    return getMyPropertyKey3( this.locale );
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
   * @see #getMyPropertyKey3(Map)
   * @param locale
   * @param placeholderToReplacementMap
   */ 
  public String getMyPropertyKey3( Locale locale, Map<String, String> placeholderToReplacementMap )
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
   * @param placeholderToReplacementMap
   */ 
  public String getMyPropertyKey3( Map<String, String> placeholderToReplacementMap )
  {
    return getMyPropertyKey3( this.locale, placeholderToReplacementMap );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see _673numericalTest
   * @see #translator()
   * @see #translator(Locale)
   * @return {@link Translator}   */ 
  public static Translator translator(Locale locale, boolean silentlyIgnoreMissingResourceException)
  {
    return new Translator( baseName, locale, silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see _673numericalTest
   * @see #translator()
   * @see #translator(Locale,boolean)
   * @return {@link Translator}   */ 
  public Translator translator(Locale locale)
  {
    return new Translator( baseName, locale, this.silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new {@link Translator} instance using the internal {@link Locale} and based on the {@value #baseName} i18n base
   * @see _673numericalTest
   * @see #translator(Locale)
   * @see #translator(Locale,boolean)
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
  private final static String baseName = "i18n.adminTest";
  private final Locale locale;
  private final boolean silentlyIgnoreMissingResourceException;

  /**
   * This {@link AdminTest} constructor will create a new instance which silently ignores any {@link MissingResourceException} 
   * @see AdminTest
   * @param locale
   */ 
  public AdminTest( Locale locale )
  {
    this(locale,true);
  }
  

  /**
   * @see AdminTest
   * @param locale
   * @param silentlyIgnoreMissingResourceException
   */ 
  public AdminTest( Locale locale, boolean silentlyIgnoreMissingResourceException )
  {
    super();
    this.locale = locale;
    this.silentlyIgnoreMissingResourceException = silentlyIgnoreMissingResourceException;
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
   * @see #getMyPropertyKey1()
   * @param locale 
   */ 
  public String getMyPropertyKey1(Locale locale)
  {
    try
    {
      final String key = "my.property.key1";
      return resourceBasedTranslator.translate( baseName, key, locale );
    }
    catch ( MissingResourceException e )
    {
      if (!this.silentlyIgnoreMissingResourceException)
      {
        throw e;
      }
      return null;
    }
  }

  /**
   * Similar to {@link #getMyPropertyKey1(Locale)} for the predefined {@link Locale}.
   * @see AdminTest
   * @see #getMyPropertyKey1(Locale)
   */ 
  public String getMyPropertyKey1()
  {
    return getMyPropertyKey1( this.locale );
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
   * @see #getMyPropertyKey2()
   * @param locale 
   */ 
  public String getMyPropertyKey2(Locale locale)
  {
    try
    {
      final String key = "my.property.key2";
      return resourceBasedTranslator.translate( baseName, key, locale );
    }
    catch ( MissingResourceException e )
    {
      if (!this.silentlyIgnoreMissingResourceException)
      {
        throw e;
      }
      return null;
    }
  }

  /**
   * Similar to {@link #getMyPropertyKey2(Locale)} for the predefined {@link Locale}.
   * @see AdminTest
   * @see #getMyPropertyKey2(Locale)
   */ 
  public String getMyPropertyKey2()
  {
    return getMyPropertyKey2( this.locale );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see AdminTest
   * @see #translator()
   * @see #translator(Locale)
   * @return {@link Translator}   */ 
  public static Translator translator(Locale locale, boolean silentlyIgnoreMissingResourceException)
  {
    return new Translator( baseName, locale, silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see AdminTest
   * @see #translator()
   * @see #translator(Locale,boolean)
   * @return {@link Translator}   */ 
  public Translator translator(Locale locale)
  {
    return new Translator( baseName, locale, this.silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new {@link Translator} instance using the internal {@link Locale} and based on the {@value #baseName} i18n base
   * @see AdminTest
   * @see #translator(Locale)
   * @see #translator(Locale,boolean)
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
  private final static String baseName = "i18n.localelessTest";
  private final Locale locale;
  private final boolean silentlyIgnoreMissingResourceException;

  /**
   * This {@link LocalelessTest} constructor will create a new instance which silently ignores any {@link MissingResourceException} 
   * @see LocalelessTest
   * @param locale
   */ 
  public LocalelessTest( Locale locale )
  {
    this(locale,true);
  }
  

  /**
   * @see LocalelessTest
   * @param locale
   * @param silentlyIgnoreMissingResourceException
   */ 
  public LocalelessTest( Locale locale, boolean silentlyIgnoreMissingResourceException )
  {
    super();
    this.locale = locale;
    this.silentlyIgnoreMissingResourceException = silentlyIgnoreMissingResourceException;
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
   * @see #getMyPropertyKey9()
   * @param locale 
   */ 
  public String getMyPropertyKey9(Locale locale)
  {
    try
    {
      final String key = "my.property.key9";
      return resourceBasedTranslator.translate( baseName, key, locale );
    }
    catch ( MissingResourceException e )
    {
      if (!this.silentlyIgnoreMissingResourceException)
      {
        throw e;
      }
      return null;
    }
  }

  /**
   * Similar to {@link #getMyPropertyKey9(Locale)} for the predefined {@link Locale}.
   * @see LocalelessTest
   * @see #getMyPropertyKey9(Locale)
   */ 
  public String getMyPropertyKey9()
  {
    return getMyPropertyKey9( this.locale );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see LocalelessTest
   * @see #translator()
   * @see #translator(Locale)
   * @return {@link Translator}   */ 
  public static Translator translator(Locale locale, boolean silentlyIgnoreMissingResourceException)
  {
    return new Translator( baseName, locale, silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see LocalelessTest
   * @see #translator()
   * @see #translator(Locale,boolean)
   * @return {@link Translator}   */ 
  public Translator translator(Locale locale)
  {
    return new Translator( baseName, locale, this.silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new {@link Translator} instance using the internal {@link Locale} and based on the {@value #baseName} i18n base
   * @see LocalelessTest
   * @see #translator(Locale)
   * @see #translator(Locale,boolean)
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
  private final static String baseName = "i18n.viewTest";
  private final Locale locale;
  private final boolean silentlyIgnoreMissingResourceException;

  /**
   * This {@link ViewTest} constructor will create a new instance which silently ignores any {@link MissingResourceException} 
   * @see ViewTest
   * @param locale
   */ 
  public ViewTest( Locale locale )
  {
    this(locale,true);
  }
  

  /**
   * @see ViewTest
   * @param locale
   * @param silentlyIgnoreMissingResourceException
   */ 
  public ViewTest( Locale locale, boolean silentlyIgnoreMissingResourceException )
  {
    super();
    this.locale = locale;
    this.silentlyIgnoreMissingResourceException = silentlyIgnoreMissingResourceException;
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
   * @see #getMyPropertyKey1()
   * @param locale 
   */ 
  public String getMyPropertyKey1(Locale locale)
  {
    try
    {
      final String key = "my.property.key1";
      return resourceBasedTranslator.translate( baseName, key, locale );
    }
    catch ( MissingResourceException e )
    {
      if (!this.silentlyIgnoreMissingResourceException)
      {
        throw e;
      }
      return null;
    }
  }

  /**
   * Similar to {@link #getMyPropertyKey1(Locale)} for the predefined {@link Locale}.
   * @see ViewTest
   * @see #getMyPropertyKey1(Locale)
   */ 
  public String getMyPropertyKey1()
  {
    return getMyPropertyKey1( this.locale );
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
   * @see #getMyPropertyKey3()
   * @param locale 
   */ 
  public String getMyPropertyKey3(Locale locale)
  {
    try
    {
      final String key = "my.property.key3";
      return resourceBasedTranslator.translate( baseName, key, locale );
    }
    catch ( MissingResourceException e )
    {
      if (!this.silentlyIgnoreMissingResourceException)
      {
        throw e;
      }
      return null;
    }
  }

  /**
   * Similar to {@link #getMyPropertyKey3(Locale)} for the predefined {@link Locale}.
   * @see ViewTest
   * @see #getMyPropertyKey3(Locale)
   */ 
  public String getMyPropertyKey3()
  {
    return getMyPropertyKey3( this.locale );
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
   * @see #getMyPropertyKey4()
   * @param locale 
   */ 
  public String getMyPropertyKey4(Locale locale)
  {
    try
    {
      final String key = "my.property.key4";
      return resourceBasedTranslator.translate( baseName, key, locale );
    }
    catch ( MissingResourceException e )
    {
      if (!this.silentlyIgnoreMissingResourceException)
      {
        throw e;
      }
      return null;
    }
  }

  /**
   * Similar to {@link #getMyPropertyKey4(Locale)} for the predefined {@link Locale}.
   * @see ViewTest
   * @see #getMyPropertyKey4(Locale)
   */ 
  public String getMyPropertyKey4()
  {
    return getMyPropertyKey4( this.locale );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see ViewTest
   * @see #translator()
   * @see #translator(Locale)
   * @return {@link Translator}   */ 
  public static Translator translator(Locale locale, boolean silentlyIgnoreMissingResourceException)
  {
    return new Translator( baseName, locale, silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new {@link Translator} instance using the given {@link Locale} and based on the {@value #baseName} i18n base
   * @see ViewTest
   * @see #translator()
   * @see #translator(Locale,boolean)
   * @return {@link Translator}   */ 
  public Translator translator(Locale locale)
  {
    return new Translator( baseName, locale, this.silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new {@link Translator} instance using the internal {@link Locale} and based on the {@value #baseName} i18n base
   * @see ViewTest
   * @see #translator(Locale)
   * @see #translator(Locale,boolean)
   * @return {@link Translator}   */ 
  public Translator translator()
  {
    return translator( this.locale );
  }

}

}

}


