package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAction {
    WebDriver driver;
    public void InitDriver(){

        System.setProperty("webdriver.chrome.driver","D:\\Study\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");
    }
//    input输入元素操作
    public void  InputElement(){
//        用name定位input框
        WebElement EmeailElement = driver.findElement(By.name("email"));
        //        取出placeholder元素的内容
//        定义一个对象
        String UserInfo = EmeailElement.getAttribute("placeholder");
//        输入账号
        EmeailElement.sendKeys("18410152358");
//        等待三秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        清除输入框的内容
//        EmeailElement.clear();

//        打印出来上方placeholder元素的内容
        System.out.println(UserInfo);
//      取出input输入框的内容
        String Mobel = EmeailElement.getAttribute("value");
//        打印输入框出输入框的内容
        System.out.println(Mobel);
//        isEnabled()方法判断输入框是否可以输入
        boolean info = EmeailElement.isEnabled();
//        打印状态
        System.out.println(info);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        关闭浏览器
        driver.close();

    }

    public static void main(String[] args) {
        SeleniumAction  seleniumaction = new SeleniumAction();
        seleniumaction.InitDriver();
        seleniumaction.InputElement();
    }
}
