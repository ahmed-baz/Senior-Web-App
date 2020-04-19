/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.web.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import javax.enterprise.context.BusyConversationException;
import javax.jws.WebParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import net.seniorsteps.bll.SeniorBLGateway;
import net.seniorsteps.senior.common.bean.CityBean;

/**
 * REST Web Service
 *
 * @author Senior Steps
 */
@Path("firstRest")
public class FirstRest {

	private SeniorBLGateway SeniorBLGateway;

	@Context
	private UriInfo context;

	/**
	 * Creates a new instance of FirstRest
	 */
	public FirstRest() {
	}

	/**
	 * Retrieves representation of an instance of
	 * net.seniorsteps.senior.web.rest.FirstRest
	 *
	 * @return an instance of java.lang.String
	 */
	@GET
	@Produces("application/json")
	public String getJson() {
		//TODO return proper representation object
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.setDateFormat("yyyy-MM-dd");
		Gson gson = gsonBuilder.create();
//		Gson gson =  new Gson();

		CityBean cityBean = new CityBean("Cairo Ar", "Cairo En");
		cityBean.setTempDate(new Date());
		cityBean.setId(12);
		String jsonObject = gson.toJson(cityBean);
		return jsonObject;
	}

	/**
	 * PUT method for updating or creating an instance of FirstRest
	 *
	 * @param content representation for the resource
	 * @return an HTTP response with content of the updated or created resource.
	 */
	@PUT
	@Consumes("application/json")
	public void putJson(String content) {
	}

	@PUT
	@Path("findCity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String findCity(@WebParam(name = "city") String cityString) {
		Gson gson = new Gson();
		CityBean cityBean = gson.fromJson(cityString, CityBean.class);
		System.out.println(cityBean.getNameAr());
		return null;
	}
}
