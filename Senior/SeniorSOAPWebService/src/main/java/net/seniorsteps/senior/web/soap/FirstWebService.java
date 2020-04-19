/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.web.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Senior Steps
 */
@WebService(serviceName = "FirstWebService")
public class FirstWebService {

	public FirstWebService() {
	}

	/**
	 * This is a sample web service operation
	 */
	@WebMethod(operationName = "hello")
	public String hello(@WebParam(name = "name") String txt) {

		return "Hello " + txt + " !";
	}

	@WebMethod(operationName = "test")
	public String test(@WebParam(name = "id") Integer id) {
		// call blGatway
		// return name 
		return "ID is " + id;
	}

}
