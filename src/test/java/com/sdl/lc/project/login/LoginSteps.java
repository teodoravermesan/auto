package com.sdl.lc.project.login;

import com.sdl.lc.pages.LoginView;
import com.sdl.lc.project.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps extends TestBase {
	private final LoginView loginView = new LoginView();
	WebDriverWait wait = new WebDriverWait(driver, 120);

	@Then("I logout from LC")
	public void logout() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	@Given("I open url {string}")
	public void iOpenUrl(String url) {
		 driver.get(url);
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@And("I stop the test")
	public void iStopTheTest() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@When("I login with {string} and {string}")
	public void iLoginWithAnd(String email, String password) {
		wait.until(ExpectedConditions.elementToBeClickable((By.name(loginView.getEmail()))));
		driver.findElement(By.name(loginView.getEmail())).sendKeys(email);
		driver.findElement(By.name(loginView.getPassword())).sendKeys(password);
		driver.findElement(By.name(loginView.getLogIn())).click();
	}
}
