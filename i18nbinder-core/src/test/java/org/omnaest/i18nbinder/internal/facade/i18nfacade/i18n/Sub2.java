package org.omnaest.i18nbinder.internal.facade.i18nfacade.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import javax.annotation.Generated;
import org.omnaest.i18nbinder.internal.facade.i18nfacade.i18n.sub2.Shared;

/**
 * This is an automatically with i18nBinder generated facade class.<br><br>
 * To modify please adapt the underlying property files.<br><br>
 * If the facade class is instantiated with a given {@link Locale} using {@link #Sub2(Locale)} all non static methods will use this predefined {@link Locale} when invoked.<br><br>
 * The facade methods will silently ignore all {@link MissingResourceException}s by default. To alter this behavior see {@link #Sub2(Locale, boolean)}<br><br>
 * Resource base: <b>i18n.sub2</b>
 * @see Shared
 */ 
@Generated(value = "http://code.google.com/p/i18n-binder/", date = "2016-03-22T12:08:39+01:00")
public class Sub2 {
  /** @see Shared */
  public final Shared Shared;

  /**
   * This {@link Sub2} constructor will create a new instance which silently ignores any {@link MissingResourceException} 
   * @see Sub2
   * @param locale
   */ 
  public Sub2( Locale locale )
  {
    this(locale,true);
  }
  

  /**
   * @see Sub2
   * @param locale
   * @param silentlyIgnoreMissingResourceException
   */ 
  public Sub2( Locale locale, boolean silentlyIgnoreMissingResourceException )
  {
    super();
    this.Shared = new Shared( locale, silentlyIgnoreMissingResourceException );
  }
  
}

