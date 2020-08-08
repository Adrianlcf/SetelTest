package SetelMobileAutomation.SetelMobileAutomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class Todoist {
	
	public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    
    @Before
    public void setup() throws MalformedURLException {
    	
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_2_API_28");
        caps.setCapability("udid", "emulator-5554"); 
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.todoist");
        caps.setCapability("appActivity","com.todoist.activity.HomeActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }
    
    @Test
    public void TestTodoist() throws InterruptedException {
       
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/btn_welcome_continue_with_email"))).click();
 
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/email_exists_input"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/email_exists_input"))).sendKeys("adrianlcf@hotmail.com");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/btn_continue_with_email"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/log_in_password"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/log_in_password"))).sendKeys("Setel@todoist");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/btn_log_in"))).click();
    	
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/fab"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("android:id/message"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("android:id/message"))).sendKeys("Task 1 - Setel Assessment.");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//android.widget.ImageView[@content-desc=\"Add\"]"))).click();
    	
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/content_toolbar_container"))).click();
      
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/root"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/item_checkmark"))).click();
        Thread.sleep(3000);
        String txt = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.todoist:id/snackbar_text"))).getText();
        System.out.println("The task is: " + txt);
        }  
      
    @After
    public void teardown(){
        driver.quit();
    }

}
