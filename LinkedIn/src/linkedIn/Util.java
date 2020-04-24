package linkedIn;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Util {
public static  WebDriver driver;


	public static WebDriver getFirefoxDriver()
	{
		System.setProperty("webdriver.gecko.driver", "D:geckodriver.exe");
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	WebDriver driver = new FirefoxDriver();
	return driver;
		
	}

	public static WebDriver getChromeDriver(){

	System.setProperty("webdriver.chrome.driver", "//E:JAVA//chromedriver_win32//chromedriver.exe");
	  driver = new ChromeDriver();	
	return driver;

	}


	public static void applywait(long millisec)
	{
		try {
			Thread.sleep(millisec);
		} catch (Exception e) {
		}
	}
	
	public static long findscrolllength(){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	long scroll = (long) js.executeScript("return document.body.scrollHeight");
    	return scroll;
	}
	
	 public static void killProcess(){
	    	//https://superuser.com/questions/877346/how-to-kill-a-specific-java-process-by-application-name
	    	String windowsCommand = "taskkill /F /FI chromedriver.exe /T";
	    	Runtime rt = Runtime.getRuntime();
	    	  if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
				try {
					rt.exec(windowsCommand);
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	   //else
	    	     //rt.exec("kill -9 " +....);
	    }
}
