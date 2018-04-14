package com.testautomationguru.container.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * <p>
 *     本地驱动
 * </p>
 */
public class Selenium2Example {

    public static void main(String[] args) {
        // 创建了一个 Firefox driver 的实例
        // 注意，其余的代码依赖于接口而非实例

        System.setProperty ( "webdriver.chrome.driver" , "/Users/dtstack/webdriver/bin/chromedriver" );

        WebDriver driver = new ChromeDriver();

        new Thread(new Runnable() {
            @Override
            public void run() {
                driver.get("http://www.google.com");
            }
        }).start();
        // 使用它访问 Google

        new Thread(new Runnable() {
            @Override
            public void run() {
                driver.get("http://www.baidu.com");
            }
        });


        // 同样的事情也可以通过以下代码完成
        // driver.navigate().to("http://www.google.com");

        // 找到搜索输入框
        WebElement element = driver.findElement(By.name("q"));

        // 输入要查找的词
        element.sendKeys("Cheese!");

        // 提交表单
        element.submit();

        // 检查页面标题
        System.out.println("Page title is: " + driver.getTitle());

        // Google 搜索结果由 JavaScript 动态渲染
        // 等待页面加载完毕，超时时间设为10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        //应该能看到: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //关闭浏览器
        driver.quit();
    }

}
