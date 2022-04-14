package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWin {
    WebDriver driver;
    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\Study\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void Login(){
//        输入账号
        driver.findElement(By.name("email")).sendKeys("18410152358");
//        输入密码
        driver.findElement(By.name("password")).sendKeys("lin18410152358");

//        点击登录
        driver.findElement(By.className("moco-btn-red")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void SeleniumWin(){
        driver.get("https://www.imooc.com/article/publish#");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement IfameEment = driver.findElement(By.id("ueditor_0"));
//        忘了多看看
        driver.switchTo().frame(IfameEment);
//        定位标签
        WebElement Clla = driver.findElement(By.tagName("p"));
//        点击一下不然没有焦点下面输入会报错
        Clla.click();
//        输入信息
        Clla.sendKeys("this is test");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }

    public static void main(String[] args) {
      SeleniumWin seleniumWin =  new SeleniumWin();
      seleniumWin.InitDriver();
      seleniumWin.Login();
      seleniumWin.SeleniumWin();
    }
}
