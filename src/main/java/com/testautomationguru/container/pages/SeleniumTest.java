package com.testautomationguru.container.pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * <p>
 *     远程驱动
 * </p>
 */
public class SeleniumTest {

    private static WebDriver driver;
    private BaiduPage baidu;

    public static void main(String[] args) throws Exception {

        SeleniumTest ST = new SeleniumTest();
        ST.setUp();

        //ST.googleTest();

        long startTime = System.currentTimeMillis();
        for(int cc = 0; cc < 5; cc++){
            driver.get("http://baidu.com");


            System.out.println(driver.getTitle());
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime + ",耗时");


        ST.tearDown();


    }




    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://172.16.10.47:4444/wd/hub"), dc);
        //baidu = new BaiduPage(driver);
    }

    public void googleTest() throws InterruptedException {
        baidu.goTo();
        baidu.searchFor("automation");
        Assert.assertTrue(baidu.getResults().size() >= 10);
    }

    public void tearDown() throws InterruptedException {
        driver.quit();
    }

}
