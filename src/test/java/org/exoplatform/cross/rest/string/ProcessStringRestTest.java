/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.cross.rest.string;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

/**
 * Created by The eXo Platform SAS
 * Author : Canh Pham Van
 *          canhpv@exoplatform.com
 * Sep 19, 2012  
 */
public class ProcessStringRestTest extends JerseyTest{

  public static final String PACKAGE_NAME = "org.exoplatform.cross.rest.string";
  private WebResource webResource;
  public ProcessStringRestTest() throws Exception {
    super(new WebAppDescriptor.Builder(PACKAGE_NAME).contextPath("context").build());
  }  
  
  @Test
  public void testReverseString() throws UnsupportedEncodingException{
    webResource = resource().path("rest").path("reverse").path("abcde");
    String response = webResource.get(String.class);
    assertEquals("edcba", response);    
  }
  
  @Test
  public void testMixString() throws UnsupportedEncodingException{
    webResource = resource().path("rest").path("mix").path("abcde").path("12345");
    String response = webResource.get(String.class);
    assertEquals("a1b2c3d4e5", response);    
    webResource = resource().path("rest").path("mix").path("abcde").path("12345789");
    String response1 = webResource.get(String.class);
    assertEquals("a1b2c3d4e5789", response1);
    
  }  
}
