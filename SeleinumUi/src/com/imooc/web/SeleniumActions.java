package com.imooc.web;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

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
            Thread.sleep(3000);
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
//        driver.close();

    }

    //  多窗口切换
    public void WinHandle(){
        //        拿到当前所有窗口
        Set<String> Handels = driver.getWindowHandles();
//        拿到当前的页面
        String Cur = driver.getWindowHandle();
//        循环页面
        for (String s:Handels){
//            判断循环到的页面是不是当前页面
            if(s.equals(Cur)){
//                不是，继续循环
                continue;
            }else {
//                是当前页面就停止
                driver.switchTo().window(s);
            }
        }
        driver.findElement(By.className("ellipsis2")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
    public void AlertWIin(){
        driver.get("地址");
//        只有确认类型弹窗
//        点击弹出弹窗
        driver.findElement(By.id("")).click();
//        处理弹窗
        driver.switchTo().alert();

//        有确认取消类型弹窗
//        取消弹窗dismiss
        driver.switchTo().alert().dismiss();
//        确认accept
        driver.switchTo().alert().accept();

//        有需要输入信息弹窗处理
//        输入信息
        driver.switchTo().alert().sendKeys("123456");
//        点击确认
        driver.switchTo().alert().accept();

//        页面刷新使用方法
        driver.navigate().refresh();
    }

    public static void main(String[] args) {
          SeleniumActions seleniumActions =  new SeleniumActions();
          seleniumActions.InitDriver();
          seleniumActions.Actions();
          seleniumActions.WinHandle();
    }
}
