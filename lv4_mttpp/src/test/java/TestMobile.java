import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestMobile{
    AndroidDriver driver ;

    @BeforeClass()
    public void setUp() throws MalformedURLException{
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability( "app" , "D:\\Faks\\Diplomski\\1.semestar\\MiTTPP\\ApiDemos-debug.apk" );
        capabilities.setCapability( "VERSION" , "9.0" );
        capabilities.setCapability( "deviceName" , "emulator" );
        capabilities.setCapability( "platformName" , "Android" );
        driver = new AndroidDriver(new URL( "http://127.0.0.1:4723/wd/hub" ), capabilities);
        driver .manage().timeouts().implicitlyWait( 10 , TimeUnit. SECONDS );
    }

    @Test
    public void testCal() throws Exception {
        MobileElement e11= (MobileElement)
                driver .findElement(By. xpath ( "//android.widget.TextView[@content-desc=\"Text\"]" ));
        e11.click();
        MobileElement e12= (MobileElement)
                driver .findElement(By. xpath ( "//android.widget.TextView[@content-desc=\"LogTextBox\"]"));
        e12.click();
        MobileElement e13=(MobileElement)
                driver .findElement(By. xpath ( "//android.widget.Button[@content-desc=\"Add\"]"));
        e13.click();
        driver .navigate().back();
        driver .navigate().back();
        driver .navigate().back();
    }
    public void teardown(){
        driver .quit();
    }}