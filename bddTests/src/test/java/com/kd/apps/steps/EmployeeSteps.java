package com.kd.apps.steps;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.kd.apps.stepsImpl.EmployeeStepsImpl;
import com.kd.apps.util.TestProp;
/**
 * 
 * @author Pallavi Varne
 *
 */
public class EmployeeSteps {

	String url;
	Long count;
	String xauthtoken;
	
	@Steps
	EmployeeStepsImpl employeeApiTestSteps;
	
	@Given("RestFul api url for employee '$apiURL'")
	public void given(String apiUrl) {
		TestProp.initTestProp();
		TestProp.setBaseUrl();
		TestProp.setApiUrl(apiUrl);
		this.url = TestProp.getBaseUrl() + TestProp.getApiUrl();
	}
	
	@When("POST request is sent for create Employee")
	public void whenCreate() {
		employeeApiTestSteps.create(this.url);
	}
	
	@Then("Employee should be created")
	public void thenCreate() {
		employeeApiTestSteps.testCreate();
	}
	
	@Then("Status code should be 200")
	public void thenTestSatusCode() {
		employeeApiTestSteps.testStatus();
	}
	
	@Given("RestFul api url for employee")
	public void given() {
		TestProp.setBaseUrl();
		this.url = TestProp.getBaseUrl() + TestProp.getApiUrl();
	}
	
	@When("GET request is sent with unique employee id")
	public void whenReadOne() {
		employeeApiTestSteps.readOne(this.url);
	}
	
	@Then("Employee record with given id should be fetched")
	public void thenReadOne() {
		employeeApiTestSteps.testEntity();
	}
	
	@When("GET all request is sent for Employee")
	public void whenReadAll() {
		employeeApiTestSteps.readAll(this.url);
	}
	
	@Then("All Employee records should be fetched")
	public void thenReadAll() {
		employeeApiTestSteps.testCount();
	}
	
	@When("PUT request is sent with unique employee id")
	public void whenUpdate() {
		employeeApiTestSteps.update(this.url);
	}
	
	@Then("Employee record should be updated")
	public void thenUpdate() {
		employeeApiTestSteps.testUpdate();
	}
	
	@When("DELETE request is sent with unique employee id")
	public void whenDelete() {
		employeeApiTestSteps.delete(this.url);
	}

	@Then("Employee record with given id should be deleted")
	public void thenDelete() {
		employeeApiTestSteps.testNullEntity();
	}
}
