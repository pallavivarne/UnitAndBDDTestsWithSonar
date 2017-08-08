package com.kd.apps.stepsImpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;
import org.seleniumhq.jetty9.http.HttpStatus;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.kd.apps.util.TestProp;

/**
 * 
 * @author Pallavi Varne
 *
 */
public class EmployeeStepsImpl extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	
	long count;
	Date updateDate;
	
	@Step
	public void create(String url) {
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/json");
		
		Map<String,Object> object = new HashMap<String, Object>();
		object.put("name", "Suhas");
		object.put("deptId", "1001");
		object.put("address", "Kolhapur");
		object.put("salary", "29000");
		
		Response res = SerenityRest.given().headers(requestHeaders)
	        	.contentType(ContentType.JSON)
	        	.body(object)
	        	.when().post(url).thenReturn();
		
		String resBody = res.getBody().asString();
		JsonObject resBodyJson = new JsonParser().parse(resBody).getAsJsonObject();
		TestProp.writeProp("api.id",resBodyJson.get("id").toString());
	}
	
	@Step
	public void testCreate() {
		Assert.assertTrue(TestProp.readProp("api.id") != null);
	}
	
	@Step
	public void testStatus() {
		assertThat("Response status code", SerenityRest.then().extract().statusCode() ,equalTo(HttpStatus.OK_200));
	}
	
	@Step
	public void readOne(String url) {
		url = url +"/"+ TestProp.readProp("api.id");
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/json");
		SerenityRest.given().headers(requestHeaders)
	        	.contentType(ContentType.JSON)
	        	.when().get(url);
	}
	
	@Step
	public void testEntity() {
		assertThat(SerenityRest.then().extract().body().jsonPath().get("id").toString(), equalTo(TestProp.readProp("api.id").toString()));
	}
	
	@Step
	public void readAll(String url) {
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/json");
		SerenityRest.given().headers(requestHeaders)
	        	.contentType(ContentType.JSON)
	        	.when().get(url);
	}
	
	@Step
	public void testCount() {
		List<Object> list = SerenityRest.then().extract().body().jsonPath().get("id");
		Assert.assertTrue(list.size() > 0);
	}
	
	@Step
	public void update(String url) {
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/json");
		
		Map<String,Object> object = new HashMap<String, Object>();
		object.put("name", "Pallavi1");
		
		url = url + "/" + TestProp.readProp("api.id");
		SerenityRest.given().headers(requestHeaders)
	        	.contentType(ContentType.JSON)
	        	.body(object)
	        	.when().put(url);
	}
	
	@Step
	public void testUpdate() {
		Assert.assertTrue(SerenityRest.then().extract().body().jsonPath().get("name").equals("Pallavi1"));
	}
	
	@Step
	public void delete(String url) {
		url = url + "/" + TestProp.readProp("api.id");
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Content-Type", "application/json");
		
		SerenityRest.given().headers(requestHeaders)
		.contentType(ContentType.JSON)
		.when().delete(url);
	}
	
	@Step
	public void testNullEntity() {
		Assert.assertTrue(true);
	}
	
}