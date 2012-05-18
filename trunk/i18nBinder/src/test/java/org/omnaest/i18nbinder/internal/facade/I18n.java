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
 * If the facade class is instantiated with a given {@link Locale} using {@link #I18n(Locale)} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * The facade methods will silently ignore all {@link MissingResourceException}s by default. To alter this behavior see {@link #I18n(Locale, boolean)}<br><br>
 * Resource base: <b>i18n</b>
 * @see _673numericalTest
 * @see AdminTest
 * @see LocalelessTest
 * @see ViewTest
 */ 
@Generated(value = "org.omnaest.i18nbinder.I18nBinder", date = "2012-05-18T11:34:07+02:00")
public class I18n {
  /** @see _673numericalTest */
  public final _673numericalTest _673numericalTest;
  /** @see AdminTest */
  public final AdminTest AdminTest;
  /** @see LocalelessTest */
  public final LocalelessTest LocalelessTest;
  /** @see ViewTest */
  public final ViewTest ViewTest;

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
  
}

