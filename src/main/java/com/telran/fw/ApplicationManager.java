package com.telran.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    AppiumDriver<MobileElement> driver;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    DesiredCapabilities capabilities;
    RecyclerHelper recycler;


    public void start() throws IOException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "MyNex");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "com.h6ah4i.android.example.advrecyclerview");

//        capabilities.setCapability("appActivity", ".launcher.MainActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app",
                "/Users/tayahatum/QAAppium/apk/AdvancedRecyclerView.apk");

//            capabilities.setCapability("noReset","false");
//            capabilities.setCapability("fullReset", "true");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumListener());
        logger.info("App is started");
        recycler = new RecyclerHelper(driver);

    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public RecyclerHelper recycler() {
        return recycler;
    }

    public void stop() {
        driver.quit();
    }


}


