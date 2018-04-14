package com.testautomationguru.container.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaiduPage {

    private final WebDriver driver;

    private final WebDriverWait wait;

    public BaiduPage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    @FindBy(name = "wd")
    private WebElement searchBox;

    @FindBy(css = "input.s_btn")
    private WebElement searchButton;

    @FindBy(className = "result c-container ")
    private List<WebElement> searchResults;

    public void goTo(){
        this.driver.get("http://www.baidu.com/");
    }

    public void searchFor(String text) throws InterruptedException{
        this.searchBox.sendKeys(text);

        System.out.println(driver.getTitle());

        wait.until(ExpectedConditions.elementToBeClickable(this.searchButton));
        this.searchButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("rc")));

    }

    public List<WebElement> getResults() {
        return this.searchResults;
    }

}
