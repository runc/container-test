package com.testautomationguru.container.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class HtmlUnitTest {

    public static void main(String[] args) throws Exception {

        test();

        WebDriver driver = new RemoteWebDriver(new URL("http://172.16.10.47:4444/wd/hub"),
                DesiredCapabilities.htmlUnit());

        driver.get("http://baidu.com");

        System.out.println("标题:" + driver.getTitle());

    }

    public static void test(){

        System.setProperty ( "webdriver.chrome.driver" , "/Users/dtstack/webdriver/bin/chromedriver" );

        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://baidu.com");

        System.out.println("标题:" + driver.getTitle());

    }

}
