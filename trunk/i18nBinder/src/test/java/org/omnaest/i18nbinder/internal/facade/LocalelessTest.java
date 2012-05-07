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
 * If the facade class is instantiated with a given {@link Locale} using {@link #LocalelessTest(Locale)} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * The facade methods will silently ignore all {@link MissingResourceException}s by default. To alter this behavior see {@link #LocalelessTest(Locale, boolean)}<br><br>
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
@Generated(value = "org.omnaest.i18nbinder.I18nBinder", date = "2012-05-07T22:35:04+02:00")
public class LocalelessTest {
  private final static String baseName = "i18n.localelessTest";
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
   * Similar to {@link #getMyPropertyKey9()} for the given {@link Locale}.
   * @see LocalelessTest
   * @see #getMyPropertyKey9()
   * @param locale 
   */ 
  protected String getMyPropertyKey9(Locale locale)
  {
    try
    {
      final String key = "my.property.key9";
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
   * Returns the value of the property key <b>my.property.key9</b> for the predefined {@link Locale}.
   * <br><br>
   * 
   * Examples:
   * <ul>
   * <li>=value9</li>
   * </ul>
   * @see LocalelessTest
   * @see #getMyPropertyKey9(Locale)
   */ 
  public String getMyPropertyKey9()
  {
    return getMyPropertyKey9( this.locale );
  }

  /**
   * Returns a new instance of {@link LocalelessTest} which uses the given setting for the exception handling
   * @see LocalelessTest
   * @param silentlyIgnoreMissingResourceException 
   */ 
  public LocalelessTest doSilentlyIgnoreMissingResourceException( boolean silentlyIgnoreMissingResourceException )
  {
    return new LocalelessTest( this.locale, silentlyIgnoreMissingResourceException );
  }

  /**
   * Returns a new instance of {@link LocalelessTest} which uses the given {@link Locale}
   * @see LocalelessTest
   * @param locale 
   */ 
  public LocalelessTest forLocale( Locale locale )
  {
    return new LocalelessTest( locale, this.silentlyIgnoreMissingResourceException );
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

