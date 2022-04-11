package com.imooc.web;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

//鼠标相关操作
public class SeleniumActions {
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

    //鼠标相关操作
    public void Actions(){
/**        鼠标左击
        Actions actions = new Actions(driver);
        actions.click().perform();
//        鼠标右击
        actions.contextClick().perform();
//        鼠标双击
        actions.doubleClick().perform();
//        鼠标悬停
        actions.moveToElement(元素).perform();
**/

//        WebElement Login = driver.findElement(By.id("js-signin-btn"));
        Actions actions = new Actions(driver);
//        点击登录
//        actions.click(Login).perform();
//          拿到整个列表
        List<WebElement> ItemList = driver.findElements(By.className("item"));
//        获取第一个
        WebElement Mobile = ItemList.get(1);
//        鼠标悬停
        actions.moveToElement(Mobile).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        点击小程序跳转
        driver.findElement(By.linkText("爬虫")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }

    public static void main(String[] args) {
          SeleniumActions seleniumActions =  new SeleniumActions();
          seleniumActions.InitDriver();
          seleniumActions.Actions();
    }
}
