package com.gzl.Imooc;

import com.gzl.Imooc.util.ProUtil;
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
/*        String UserElement = "email";
        String GetByName = "name";

        String PassElement = "password";
        String GetByPassWord = "name";

        String LoginElement = "moco-btn-red";
        String GetByLoginElement = "className";

        String GetByUserPng = "className";
        String UserPng = "js-header-avator";

        String GetByUserNames = "className";
        String UserNames = "text-ellipsis";*/
        String UserName = "18410152358";
        String PassWord = "lin18410152358";
//        定位账号输入框
        WebElement EmeailElement = GetElenent("username");
//        定位密码输入框
        WebElement PassWordElement = GetElenent("password");
//        定位登录按钮
        WebElement LoginClick = GetElenent("loginbutton");
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
            WebElement UserPngs = GetElenent("headpng");
            Actions actions = new Actions(driver);
//            鼠标悬停
            actions.moveToElement(UserPngs).perform();
//            获取用户名
            String UserNameInfo = GetElenent("userinfo").getText();
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

    public By GetByLocal(String key){
        ProUtil proUtil = new ProUtil("D:\\Study\\JavaUi\\SeleniumWeb\\Imooc\\element.properties");
        String Locator = proUtil.GetPorperties(key);//key等于配置文件中的username=name>email
//        取第一个值，用">"分割
        String LocatorBy = Locator.split(">")[0];
//        //        取第二个值
        String LocatorValue = Locator.split(">")[1];

        if (LocatorBy.equals("id")){
            return By.id(LocatorValue);
        }else if (LocatorBy.equals("name")){
            return By.name(LocatorValue);
        }else if (LocatorBy.equals("className")){
            return By.className(LocatorValue);
        }else{
            return By.xpath(LocatorValue);
        }
    }

    public WebElement GetElenent(String key){
        WebElement Element =  driver.findElement(this.GetByLocal(key));
        return Element;
    }

    public static void main(String[] args) {
        LoginImooc loginImooc =  new LoginImooc();
        loginImooc.InitDriver();
        loginImooc.UserLogin();
    }
}
