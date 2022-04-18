package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumWait {
    WebDriver driver;
    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\Study\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //三种等待方式
    public void WaitThree(){
//        隐式等待
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        显示等待
       WebDriverWait wait = new WebDriverWait(driver,10);
//       查看这个元素是否存在
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));
    }

    public static void main(String[] args) {

    }
}
