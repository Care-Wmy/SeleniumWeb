package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.List;

public class SeleinumOne {
    WebDriver driver;
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\Study\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");

//        driver.close();
    }

    public void  GetElement(){
//        id定位
        driver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        name定位
        driver.findElement(By.name("email")).sendKeys("18410152358");
//        classname定位
        driver.findElement(By.className("js-loginPassword")).sendKeys("111111");
//        层级定位
        WebElement NodeElenet = driver.findElement(By.className("rlf-autoin"));
        NodeElenet.findElement(By.tagName("input")).click();
//        list定位
        List<WebElement> ButtonElenet = driver.findElements(By.className("rlf-group"));
//        取第四个元素
        ButtonElenet.get(4).click();
//        文本定位
        driver.findElement(By.linkText("遇到问题")).click();
//        部分文本丁文
        driver.findElement(By.partialLinkText("忘记密码")).click();
//        xpath定位
        driver.findElement(By.xpath("//*[@id=\"signin\"]/div[3]/div[2]/a[1]")).click();
//        css定位
        driver.findElement(By.cssSelector("#signup-form > div.rlf-group.pr.phoneVerityBox > p.reSend.pa.active.js-phonecode-box > span")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    public static void main(String[] args) {
        SeleinumOne seleinum_one = new SeleinumOne();
        seleinum_one.initDriver();
        seleinum_one.GetElement();

    }
}
