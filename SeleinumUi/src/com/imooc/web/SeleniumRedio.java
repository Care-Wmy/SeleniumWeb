package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumRedio {
//    redio相关操作
        WebDriver driver;
    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\Study\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        打开个人中心页
        driver.get("https://www.imooc.com/user/setprofile");
    }

    public void Redio(){
//        打开个人中心页
        //driver.get("https://www.imooc.com/user/setprofile");


//        点击编辑按钮
        driver.findElement(By.className("js-edit-info")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//            拿到父级表单
        WebElement UserForm = driver.findElement(By.id("profile"));
        //        根据父级去找里面的sex
        List<WebElement> SexList = UserForm.findElements(By.name("sex"));
        //        循环列表 点击
        for(WebElement sex:SexList){
            //            判断sex是否被选中 isSelected()方法判断哪是否选中
            if (sex.isSelected()){
                break;
            }else {
                sex.click();
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        System.out.println();
    }

    public static void main(String[] args) {
        SeleniumRedio selenium_redio = new SeleniumRedio();
        selenium_redio.InitDriver();
        selenium_redio.Redio();
    }
}
