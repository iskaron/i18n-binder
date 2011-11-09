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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.omnaest.i18nbinder.internal.I18nFacade.I18n._673numericalTest;

public class I18nFacadeTest
{
  @Test
  public void testInstantiation()
  {
    Locale locale = Locale.US;
    I18nFacade i18nFacade = new I18nFacade( locale );
    assertEquals( "value {0} and {1}", i18nFacade.I18n._673numericalTest.getMyPropertyKey1() );
    assertEquals( "value3 with {arbitrary} replacement", i18nFacade.I18n._673numericalTest.getMyPropertyKey3() );
    assertEquals( "value2", i18nFacade.I18n.AdminTest.getMyPropertyKey2() );
    
    //
    assertEquals( "value a and b", i18nFacade.I18n._673numericalTest.getMyPropertyKey1( "a", "b" ) );
    
    //
    Map<String, String> placeholderToReplacementMap = new HashMap<String, String>();
    placeholderToReplacementMap.put( "arbitrary", "another" );
    assertEquals( "value3 with another replacement",
                  i18nFacade.I18n._673numericalTest.getMyPropertyKey3( placeholderToReplacementMap ) );
    
    //
    assertEquals( "value {0} and {1}", i18nFacade.I18n._673numericalTest.translate( "my.property.key1" ) );
    
    //
    String[] keys = _673numericalTest.allPropertyKeys();
    Map<String, String> map = i18nFacade.I18n._673numericalTest.translate( keys );
    assertEquals( Arrays.asList( "my.property.key1", "my.property.key3" ), new ArrayList<String>( map.keySet() ) );
    assertEquals( Arrays.asList( "value {0} and {1}", "value3 with {arbitrary} replacement" ),
                  new ArrayList<String>( map.values() ) );
  }
}
