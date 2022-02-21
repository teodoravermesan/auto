package com.sdl.lc.project;

import com.sdl.selenium.utils.config.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.MDC;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;

public class GlobalHooks extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(GlobalHooks.class);

    @After("@screen")
    public void screen(Scenario scenario) {
        String scenarioName = scenario.getName();
        log.warn(scenarioName + " Scenario has failed! Embed the screenshot in the report!--- ");
        byte[] screenshot = ((TakesScreenshot) WebDriverConfig.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenarioName);
    }

    @After
    public void storeStatus(Scenario scenario) {
        log.info("***** End of scenario \"" + scenario.getName() + "\". Scenario status: " + scenario.getStatus() + " *****");
        log.info("===============================================================");
    }

    @Before("@logs")
    public void logs(Scenario scenario) {
        log.info("===============================================================");
        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        log.info("***** (pid:{}) START Scenario:{} *****", pid, scenario.getName());
        MDC.put("testName", scenario.getId().split(";")[0]);
    }
}
