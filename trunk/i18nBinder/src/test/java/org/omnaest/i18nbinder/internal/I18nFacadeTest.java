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

import java.util.Locale;

import org.junit.Test;

public class I18nFacadeTest
{
  @Test
  public void testInstantiation()
  {
    Locale locale = Locale.US;
    I18nFacade i18nFacade = new I18nFacade( locale );
    assertEquals( "value1", i18nFacade.I18n._673numericalTest.getMyPropertyKey1() );
    assertEquals( "value2", i18nFacade.I18n.AdminTest.getMyPropertyKey2() );
  }
}
