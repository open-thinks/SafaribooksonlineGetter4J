/**   
 *  Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
* @Title: HtmlBinaryResourceAgent.java 
* @Package openthinks.others.safaribook.agent 
* @Description: TODO
* @author dailey.yet@outlook.com  
* @date Aug 11, 2015
* @version V1.0   
*/
package openthinks.others.safaribook.agent;

import java.io.IOException;

import openthinks.others.safaribook.keeper.HtmlResourceKeeper;
import openthinks.others.safaribook.util.ResourceType;

import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

/**
 * The binary resource agent for HTML page
 * @author dailey.yet@outlook.com
 * @see HtmlImageResourceAgent
 */
public class HtmlBinaryResourceAgent extends HtmlResourceAgent {

	public HtmlBinaryResourceAgent(HtmlResourceKeeper<?> keeper) {
		super(keeper);
	}

	@Override
	public void makeKeepToLocal(HtmlElement element) throws IOException {
		WebResponse wrp = this.keeper.loadWebResponse(this.keeper.getResourceURL());
		storeBinaryResource(wrp.getContentAsStream());
	}

	@Override
	public ResourceType getResourceType() {
		return ResourceType.APPLICATION;
	}

}
