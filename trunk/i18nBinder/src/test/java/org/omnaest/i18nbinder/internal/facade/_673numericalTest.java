package org.omnaest.i18nbinder.internal.facade;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.annotation.Generated;

/**
 * This is an automatically with i18nBinder generated facade class.<br><br>
 * To modify please adapt the underlying property files.<br><br>
 * If the facade class is instantiated with a given {@link Locale} using {@link #_673numericalTest(Locale)} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * The facade methods will silently ignore all {@link MissingResourceException}s by default. To alter this behavior see {@link #_673numericalTest(Locale, boolean)}<br><br>
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
@Generated(value = "org.omnaest.i18nbinder.I18nBinder", date = "2012-05-07T22:35:04+02:00")
public class _673numericalTest {
  private final static String baseName = "i18n.673numericalTest";
  private final Locale locale;
  private final boolean silentlyIgnoreMissingResourceException;

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
        return I18nFacade.resourceBasedTranslator.translate( this.baseName, key, locale );
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
      return I18nFacade.resourceBasedTranslator.resolveAllKeys( this.baseName, locale );
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
   * Similar to {@link #getMyPropertyKey1()} for the given {@link Locale}.
   * @see _673numericalTest
   * @see #getMyPropertyKey1()
   * @param locale 
   */ 
  protected String getMyPropertyKey1(Locale locale)
  {
    try
    {
      final String key = "my.property.key1";
      return I18nFacade.resourceBasedTranslator.translate( baseName, key, locale );
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
   * Returns the value of the property key <b>my.property.key1</b> for the predefined {@link Locale}.
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
   * @see #getMyPropertyKey1(Locale)
   */ 
  public String getMyPropertyKey1()
  {
    return getMyPropertyKey1( this.locale );
  }

  /**
   * Similar to  {@link #getMyPropertyKey1(String[])} using the given {@link Locale}.
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
   * Returns the value of the property key <b>my.property.key1</b> for the predefined {@link Locale} with all {0},{1},... placeholders replaced by the given tokens in their order.<br><br>
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
   * @see #getMyPropertyKey1(Locale,String[])
   * @param tokens
   */ 
  public String getMyPropertyKey1( String... tokens )
  {
    return getMyPropertyKey1( this.locale, tokens );
  }

  /**
   * Similar to {@link #getMyPropertyKey3()} for the given {@link Locale}.
   * @see _673numericalTest
   * @see #getMyPropertyKey3()
   * @param locale 
   */ 
  protected String getMyPropertyKey3(Locale locale)
  {
    try
    {
      final String key = "my.property.key3";
      return I18nFacade.resourceBasedTranslator.translate( baseName, key, locale );
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
   * Returns the value of the property key <b>my.property.key3</b> for the predefined {@link Locale}.
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
   * Returns a new instance of {@link _673numericalTest} which uses the given setting for the exception handling
   * @see _673numericalTest
   * @param silentlyIgnoreMissingResourceException 
   */ 
  public _673numericalTest doSilentlyIgnoreMissingResourceException( boolean silentlyIgnoreMissingResourceException )
  {
    return new _673numericalTest( this.locale, silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new instance of {@link _673numericalTest} which uses the given {@link Locale}
   * @see _673numericalTest
   * @param locale 
   */ 
  public _673numericalTest forLocale( Locale locale )
  {
    return new _673numericalTest( locale, this.silentlyIgnoreMissingResourceException );
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

