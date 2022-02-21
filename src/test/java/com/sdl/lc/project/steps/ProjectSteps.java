package com.sdl.lc.project.steps;

import com.sdl.lc.pages.NewProject;
import com.sdl.lc.pages.ProjectsView;
import com.sdl.lc.project.TestBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectSteps extends TestBase {
	private final ProjectsView projectsView = new ProjectsView();
	private final NewProject newProject = new NewProject();
	WebDriverWait wait = new WebDriverWait(driver, 200);

	@Then("I open Projects page")
	public void iOpenProjectsPage() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(projectsView.getProjects())));
		driver.findElement(By.xpath(projectsView.getProjects())).click();
	}

	@And("I click on 'New Project' button")
	public void iClickOnNewProjectButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(projectsView.getNewProject())));
		driver.findElement(By.xpath(projectsView.getNewProject())).click();
	}

	@And("I type {string} name")
	public void iTypeProjectName(String projectName) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(newProject.getName())));
		driver.findElement(By.name(newProject.getName())).sendKeys(projectName);
	}

	@And("I type {string} location")
	public void iTypeLocation(String location) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(newProject.getLocation())));
		driver.findElement(By.name(newProject.getLocation())).sendKeys(location);
		driver.findElement(By.name(newProject.getLocation())).sendKeys(Keys.ENTER);
	}

	@And("I type {string} Source Language")
	public void iTypeSourceLanguage(String sourceLanguage) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(newProject.getSourceLanguage())));
		driver.findElement(By.name(newProject.getSourceLanguage())).sendKeys(sourceLanguage);
		driver.findElement(By.name(newProject.getSourceLanguage())).sendKeys(Keys.ENTER);
	}

	@And("I type {string} Target Language")
	public void iTypeTargetLanguage(String targetLanguage) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(newProject.getTargetLanguage())));
		driver.findElement(By.name(newProject.getTargetLanguage())).sendKeys(targetLanguage);
		driver.findElement(By.name(newProject.getTargetLanguage())).sendKeys(Keys.ENTER);
	}

	@And("I type {string} File Type Configuration")
	public void iTypeFileTypeConfiguration(String fileTypeConfiguration) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(newProject.getFileTypeConfiguration())));
		driver.findElement(By.name(newProject.getFileTypeConfiguration())).sendKeys(fileTypeConfiguration);
		driver.findElement(By.name(newProject.getFileTypeConfiguration())).sendKeys(Keys.ENTER);
	}

	@And("I upload a file {string}")
	public void iUploadFile(String file) {
		File path = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + file);
		StringSelection ss = new StringSelection(path.getPath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(newProject.getBrowse())));
		driver.findElement(By.xpath(newProject.getBrowse())).click();

		try {
			Robot robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(file + ".txt",
				driver.findElement(By.cssSelector(newProject.getFile())).getAttribute("data-qtip"));
	}

	@Then("I click on the Next button")
	public void iClickOnNextButton() {
		driver.findElement(By.xpath(newProject.getNext())).click();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}

	@And("I type {string} Translation Engine")
	public void iTypeTranslationEngine(String translationEngine) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newProject.getTranslationEngine())));
		driver.findElement(By.xpath(newProject.getTranslationEngine())).sendKeys(translationEngine);
		driver.findElement(By.xpath(newProject.getTranslationEngine())).sendKeys(Keys.ENTER);
	}

	@And("I type {string} Pricing Model")
	public void iTypePricingModel(String pricingModel) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(newProject.getPricingModel())));
		driver.findElement(By.name(newProject.getPricingModel())).sendKeys(pricingModel);
		driver.findElement(By.name(newProject.getPricingModel())).sendKeys(Keys.ENTER);
	}

	@And("I type {string} Workflow")
	public void iTypeWorkfLow(String workflow) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name(newProject.getWorkflow())));
		driver.findElement(By.name(newProject.getWorkflow())).sendKeys(workflow);
		driver.findElement(By.name(newProject.getWorkflow())).sendKeys(Keys.ENTER);
	}

	@And("I click on the Create & Start button")
	public void iClickOnCreateAndStartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(newProject.getCreateAndStart())));
		driver.findElement(By.xpath(newProject.getCreateAndStart())).click();
	}

	@Then("{string} and {string} notifications are displayed")
	public void iWaitForNotifications(String createdNotification, String startedNotification) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(projectsView.getCreatedNotification())));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(projectsView.getStartedNotification())));
		Assert.assertTrue(driver.findElement(By.xpath(projectsView.getCreatedNotification())).getText()
				.contains(createdNotification));
		Assert.assertEquals(startedNotification,
				driver.findElement(By.xpath(projectsView.getStartedNotification())).getText());
	}

	@And("{string} project is displayed in the list")
	public void newProjectCreated(String projectName) {
		Assert.assertEquals(projectName, driver.findElement(By.cssSelector(projectsView.getProject())).getText());
	}
}
