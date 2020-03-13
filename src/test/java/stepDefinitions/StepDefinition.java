package stepDefinitions;

import java.util.List;
import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import method.*;

public class StepDefinition {
	
	@Given("^First$")
	public void first() {
		System.out.println("prepare section");
	}
	
	@When("^Test \"([^\"]*)\"$")
	public void test(String a) {
		//new Api_Testing().Api_Testing01();
		System.out.println("test" + a);
	}
	
	@When("^Mail Send$")
	public void second() {
		//new Api_Testing().Api_Testing01();
		new Mail().Send();;
	}
	
	
	@Then("^Result$")
	public void result() {
		System.out.println("result");
	}
}
