package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCheckBox {

    WebDriver driver;
    public void InitDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");

    }

    public void CheckBox(){
        WebElement Box = driver.findElement(By.id("auto-signin"));
//        isEnabled()判断元素是否可用
        System.out.println(Box.isEnabled());
        //       isSelected()判断元素是否被选中
        System.out.println(Box.isSelected());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Box.click();
        driver.close();

    }

    public static void main(String[] args) {
        SeleniumCheckBox selenium_checkbox = new SeleniumCheckBox();
        selenium_checkbox.InitDriver();
        selenium_checkbox.CheckBox();
    }

    }
