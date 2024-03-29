package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
//  下拉框相关操作
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
//    下拉框相关操作2
    public void SelectOptionTwo(){
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
        WebElement JobList = UserForm.findElement(By.id("job"));
//     运用select方法操作下拉框
      Select DowenList = new Select(JobList);
//      DowenList.selectByIndex(8);
//        运用selectByValue定位下拉框里的值
      DowenList.selectByValue("8");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        运用selectByVisibleText定位下拉框里的值
        DowenList.selectByVisibleText("交互设计师");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        开头为de的方法支持多选
//        DowenList.deselectByVisibleText("交互设计师");
        List<WebElement> SelectOption = DowenList.getAllSelectedOptions();
        for (WebElement option:SelectOption){
            System.out.println(option.getText());
        }
        driver.close();
    }

    public static void main(String[] args) {
        SeleniumWebFrom seleniumWebFrom = new SeleniumWebFrom();
        seleniumWebFrom.InitDriver();
        seleniumWebFrom.WebForm();
 //       seleniumWebFrom.SelectOption();
        seleniumWebFrom.SelectOptionTwo();
    }
}

