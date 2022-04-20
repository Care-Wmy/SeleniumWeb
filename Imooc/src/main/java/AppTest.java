import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AppTest {
    WebDriver driver;
    public void InitDriver(){

        System.setProperty("webdriver.chrome.driver","D:\\Study\\chromdriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");
    }

    public void  UserLogin(){

        WebElement EmeailElement = driver.findElement(By.name("email"));

        WebElement PassWordElement = driver.findElement(By.name("password"));

        WebElement LoginClick = driver.findElement(By.className("moco-btn-red"));

        EmeailElement.sendKeys("18410152358");
        PassWordElement.sendKeys("lin18410152358");
        LoginClick.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            WebElement UserPng = driver.findElement(By.className("js-header-avator"));
            Actions actions = new Actions(driver);
//            鼠标悬停
            actions.moveToElement(UserPng).perform();
            String UserName = driver.findElement(By.className("text-ellipsis")).getText();
            if (UserName.equals("稳妥_1")){
                System.out.println("登录成功" + UserName);
            }else {
                System.out.println("用户信息不匹配" + UserName);
            }
        } catch (Exception e){
            System.out.println("登录失败");
        }

        driver.close();
    }

    public static void main(String[] args) {
        AppTest  appte =  new AppTest();
        appte.InitDriver();
        appte.UserLogin();
    }
}
