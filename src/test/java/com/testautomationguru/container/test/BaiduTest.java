package com.testautomationguru.container.test;

import com.testautomationguru.container.pages.BaiduPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaiduTest {

    private WebDriver driver;
    private BaiduPage baidu;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://172.16.10.47:4444/wd/hub"), dc);
        baidu = new BaiduPage(driver);
    }

    @Test
    public void googleTest() throws InterruptedException {
        baidu.goTo();
        baidu.searchFor("automation");
        Assert.assertTrue(baidu.getResults().size() >= 10);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

}
