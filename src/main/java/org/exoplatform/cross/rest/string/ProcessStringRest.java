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


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang.StringUtils;
import org.exoplatform.services.rest.resource.ResourceContainer;

/**
 * Created by The eXo Platform SAS
 * Author : Canh Pham Van
 *          canhpv@exoplatform.com
 * Sep 24, 2012  
 */
@Path("/rest/")
public class ProcessStringRest implements ResourceContainer{

//http://localhost:8080/ecmdemo/rest-ecmdemo/rest/reverse/ab/
@GET
@Path("/reverse/{a}")
@Produces("text/plain")
public String reverseString(@PathParam("a") String a){
  String reverseString = "";
  if (!StringUtils.isEmpty(a)){
    char[] stringArray = a.toCharArray();
    char[] tempArray = new char[stringArray.length];
    int j = 0;
    for (int i = stringArray.length-1;i>=0;i--){
      tempArray[j] = stringArray[i];
      j++;
    }
    reverseString = new String(tempArray);
  }

  return reverseString;
}

//http://localhost:8080/ecmdemo/rest-ecmdemo/rest/mix/ab/cd/
@GET
@Path("/mix/{a}/{b}")
@Produces("text/plain")
public String mixString(@PathParam("a") String a, @PathParam("b") String b){
  
  StringBuffer bufStr = new StringBuffer();
  if (!StringUtils.isEmpty(a) && !StringUtils.isEmpty(b)){    
      
    if (a.length()>=b.length()){
      for (int i=0;i<b.length();i++){
        bufStr.append(a.charAt(i));
        bufStr.append(b.charAt(i));
      }
      bufStr.append(a.substring(b.length()));
    }else {
      for (int i=0;i<a.length();i++){
        bufStr.append(a.charAt(i));
        bufStr.append(b.charAt(i));
      }
      bufStr.append(b.substring(a.length()));      
    }
  }
  return bufStr.toString();
}

}
