
import net.seniorsteps.senior.web.soap.FirstWebService_Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Senior Steps
 */
public class SeniorSOAPClientGateway {

	public static String hello(String name) {
		try { // Call Web Service Operation
			net.seniorsteps.senior.web.soap.FirstWebService_Service service = new net.seniorsteps.senior.web.soap.FirstWebService_Service();
			net.seniorsteps.senior.web.soap.FirstWebService port = service.getFirstWebServicePort();
			// TODO initialize WS operation arguments here
			java.lang.String result = port.hello(name);
			return result;
		} catch (Exception ex) {
			throw ex;
		}

	}

	public static void main(String[] args) {
		System.out.println(hello("Ahmed"));
	}
}
