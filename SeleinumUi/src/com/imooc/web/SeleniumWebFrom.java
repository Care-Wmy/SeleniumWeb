package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumWebFrom {
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

    public void WebForm(){
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

    public void SelectOption(){
//        打开个人中心页
         driver.get("https://www.imooc.com/user/setprofile");

//        点击编辑按钮
        driver.findElement(By.className("js-edit-info")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//            拿到父级表单
        WebElement UserForm = driver.findElement(By.id("profile"));
//        拿到下拉框
        UserForm.findElement(By.id("job")).click();
//        定位标签,取集合中的第五个
        UserForm.findElements(By.tagName("option")).get(5).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    public static void main(String[] args) {
        SeleniumWebFrom seleniumWebFrom = new SeleniumWebFrom();
        seleniumWebFrom.InitDriver();
        seleniumWebFrom.WebForm();
        seleniumWebFrom.SelectOption();
    }
}

