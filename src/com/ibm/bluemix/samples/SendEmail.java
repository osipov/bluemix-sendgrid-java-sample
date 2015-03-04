/*
* Copyright IBM Corp. 2014
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.ibm.bluemix.samples;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/email")
public class SendEmail {

	private static final String USERNAME = VCAP_SERVICES.get("sendgrid", "0", "credentials", "username");
	private static final String PASSWORD = VCAP_SERVICES.get("sendgrid", "0", "credentials", "password");
	private static final String FROM = System.getenv("FROM_EMAIL");
	private static final String TO = System.getenv("TO_EMAIL");

	@GET
	public String send() throws SendGridException {

		SendGrid sendgrid = new SendGrid(USERNAME, PASSWORD);
		SendGrid.Email email = new SendGrid.Email();
		email.addTo(TO);
		email.setFrom(FROM);
		email.setSubject("Greetings");
		email.setHtml("<strong>Hello from SendGrid!</strong>");
		SendGrid.Response response = sendgrid.send(email);
		return response.getMessage();

	}
}