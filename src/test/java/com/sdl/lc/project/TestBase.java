package com.sdl.lc.project;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    public static WebDriver driver;

    static {
        if (WebDriverConfig.getDriver() == null) {
            if (driver == null) {
                LOGGER.info("=========================START======================================");
                try {
                    driver = WebDriverConfig.getWebDriver(Browser.FIREFOX);
                    FileUtils.forceMkdir(new File(WebDriverConfig.getDownloadPath()));
                } catch (IOException e) {
                    LOGGER.error("{}", e.getMessage());
                }
            }
        }
    }
}