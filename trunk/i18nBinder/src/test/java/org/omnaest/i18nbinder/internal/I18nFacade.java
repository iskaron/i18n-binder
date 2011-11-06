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

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This is an automatically with i18nBinder generated facade class.<br>
 * <br>
 * To modify please adapt the underlying property files.<br>
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
       * Examples:<br>
       * <br>
       * <ul>
       * <li>en_US=value1</li>
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
       * Examples:<br>
       * <br>
       * <ul>
       * <li>en_US=value1</li>
       * </ul>
       * 
       * @see _673numericalTest
       */
      public String getMyPropertyKey1()
      {
        String key = "my.property.key1";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, this.locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Examples:<br>
       * <br>
       * <ul>
       * <li>en_US=value3</li>
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
       * Examples:<br>
       * <br>
       * <ul>
       * <li>en_US=value3</li>
       * </ul>
       * 
       * @see _673numericalTest
       */
      public String getMyPropertyKey3()
      {
        String key = "my.property.key3";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, this.locale );
        return resourceBundle.getString( key );
      }
      
    }
    
    /**
     * This is an automatically with i18nBinder generated facade class.<br>
     * <br>
     * To modify please adapt the underlying property files.<br>
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
       * Examples:<br>
       * <br>
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
       * Examples:<br>
       * <br>
       * <ul>
       * <li>de_DE=wert1</li>
       * <li>en_US=value1</li>
       * </ul>
       * 
       * @see AdminTest
       */
      public String getMyPropertyKey1()
      {
        String key = "my.property.key1";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, this.locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Examples:<br>
       * <br>
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
       * Examples:<br>
       * <br>
       * <ul>
       * <li>de_DE=wert2</li>
       * <li>en_US=value2</li>
       * </ul>
       * 
       * @see AdminTest
       */
      public String getMyPropertyKey2()
      {
        String key = "my.property.key2";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, this.locale );
        return resourceBundle.getString( key );
      }
      
    }
    
    /**
     * This is an automatically with i18nBinder generated facade class.<br>
     * <br>
     * To modify please adapt the underlying property files.<br>
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
       * Examples:<br>
       * <br>
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
       * Examples:<br>
       * <br>
       * <ul>
       * <li>=value9</li>
       * </ul>
       * 
       * @see LocalelessTest
       */
      public String getMyPropertyKey9()
      {
        String key = "my.property.key9";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, this.locale );
        return resourceBundle.getString( key );
      }
      
    }
    
    /**
     * This is an automatically with i18nBinder generated facade class.<br>
     * <br>
     * To modify please adapt the underlying property files.<br>
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
       * Examples:<br>
       * <br>
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
       * Examples:<br>
       * <br>
       * <ul>
       * <li>de_DE=wert1</li>
       * <li>en_US=value1</li>
       * </ul>
       * 
       * @see ViewTest
       */
      public String getMyPropertyKey1()
      {
        String key = "my.property.key1";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, this.locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Examples:<br>
       * <br>
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
       * Examples:<br>
       * <br>
       * <ul>
       * <li>en_US=value3</li>
       * </ul>
       * 
       * @see ViewTest
       */
      public String getMyPropertyKey3()
      {
        String key = "my.property.key3";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, this.locale );
        return resourceBundle.getString( key );
      }
      
      /**
       * Examples:<br>
       * <br>
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
       * Examples:<br>
       * <br>
       * <ul>
       * <li>de_DE=wert4</li>
       * </ul>
       * 
       * @see ViewTest
       */
      public String getMyPropertyKey4()
      {
        String key = "my.property.key4";
        ResourceBundle resourceBundle = ResourceBundle.getBundle( baseName, this.locale );
        return resourceBundle.getString( key );
      }
      
    }
    
  }
  
}
