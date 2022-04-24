package com.gzl.Imooc;

import com.gzl.Imooc.AppTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginImooc {
    WebDriver driver;
    public void InitDriver(){

        System.setProperty("webdriver.chrome.driver","D:\\Study\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");
    }

    public void  UserLogin(){
        String UserElement = "email";
        String GetByName = "name";

        String PassElement = "password";
        String GetByPassWord = "name";

        String LoginElement = "moco-btn-red";
        String GetByLoginElement = "className";

        String GetByUserPng = "className";
        String UserPng = "js-header-avator";

        String GetByUserNames = "className";
        String UserNames = "text-ellipsis";

        String UserName = "18410152358";
        String PassWord = "lin18410152358";
//        定位账号输入框
        WebElement EmeailElement = GetElenent(GetByName,UserElement);
//        定位密码输入框
        WebElement PassWordElement = GetElenent(GetByPassWord,PassElement);
//        定位登录按钮
        WebElement LoginClick = GetElenent(GetByLoginElement,LoginElement);
//         输入账号
        EmeailElement.sendKeys(UserName);
//         输入密码
        PassWordElement.sendKeys(PassWord);
//        点击登录
        LoginClick.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
//            定位头像框元素
            WebElement UserPngs = GetElenent(GetByUserPng,UserPng);
            Actions actions = new Actions(driver);
//            鼠标悬停
            actions.moveToElement(UserPngs).perform();
//            获取用户名
            String UserNameInfo = GetElenent(GetByUserNames,UserNames).getText();
//            判断用户名是否匹配
            if (UserNameInfo.equals("稳妥_1")){
                System.out.println("登录成功" + UserNameInfo);
            }else {
                System.out.println("用户信息不匹配" + UserNameInfo);
            }
        } catch (Exception e){
            System.out.println("登录失败");
        }

        driver.close();
    }

    public By GetByLocal(String getby, String getValue){
        if (getby.equals("id")){
            return By.id(getValue);
        }else if (getby.equals("name")){
            return By.name(getValue);
        }else if (getby.equals("className")){
            return By.className(getValue);
        }else{
            return By.xpath(getValue);
        }
    }

    public WebElement GetElenent(String getby, String getValue){
        WebElement Element =  driver.findElement(this.GetByLocal(getby,getValue));
        return Element;
    }

    public static void main(String[] args) {
        AppTest appte =  new AppTest();
        appte.InitDriver();
        appte.UserLogin();
    }
}
