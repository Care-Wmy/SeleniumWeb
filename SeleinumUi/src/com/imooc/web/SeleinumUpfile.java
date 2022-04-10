package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class SeleinumUpfile {
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
    public  void DengLu(){
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
// 上传图片相关操作
    public void UpFile(){

        driver.get("https://www.imooc.com/user/setbindsns");
//        移动到头像处弹出浮窗
        WebElement HeadPng = driver.findElement(By.className("avator-mode"));
        Actions action = new Actions(driver);
        action.moveToElement(HeadPng).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        点击更换头像
        driver.findElement(By.className("js-avator-link")). click();
//        上传图片
        driver.findElement(By.id("upload")).sendKeys("C:\\Users\\Linzi\\Desktop\\456.jpg");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
    public void UpFileTwo() throws AWTException {

        driver.get("https://www.imooc.com/user/setbindsns");
//        移动到头像处弹出浮窗
        WebElement HeadPng = driver.findElement(By.className("avator-mode"));
        Actions action = new Actions(driver);
        action.moveToElement(HeadPng).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        点击更换头像
        driver.findElement(By.className("js-avator-link")). click();
        driver.findElement(By.className("avator-btn-fake")).click();
//        打开上传文件框
        StringSelection Selectjpg = new StringSelection("C:\\Users\\Linzi\\Desktop\\456.jpg");
         Clipboard Sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
         Sysc.setContents(Selectjpg,null);
//         进行ctrl+v操作 把上面文件地址粘贴到文件框地址栏
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
    public static void main(String[] args) throws AWTException {
        SeleinumUpfile seleinumUpfile = new SeleinumUpfile();
        seleinumUpfile.InitDriver();
        seleinumUpfile.DengLu();
//        seleinumUpfile.UpFile();
        seleinumUpfile.UpFileTwo();
    }

}
