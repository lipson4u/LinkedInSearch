package linkedIn;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.stream.events.Characters;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Exit;

public class Navigate extends Util {
	static WebDriverWait wait = new WebDriverWait(driver,200);

	public static void LoadLinkedin() throws Exception{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		String url="https://www.linkedin.com/uas/login?trk=guest_homepage-basic_nav-header-signin";
		driver.get(url);
		
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
	    driver.findElement(By.id("username")).sendKeys("email@gmail.com");
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
	    driver.findElement(By.id("password")).sendKeys("12345");

	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	  //  Util.applywait(5000);
	}
    public static void Searchfriends(){
	    Util.applywait(3000);

    	 driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("Technical HR Germany");
    	    Util.applywait(3000);
    	    driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
    	    Util.applywait(3000);
    	    driver.findElement(By.xpath("//button[@aria-label='View only People results']")).click();
    	    Util.applywait(3000);

	    	
	
    }
    
    public static void Nextpage(){
	    Util.applywait(3000);

    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='artdeco-pagination__button artdeco-pagination__button--next artdeco-button artdeco-button--muted artdeco-button--icon-right artdeco-button--1 artdeco-button--tertiary ember-view']")));
		 driver.findElement(By.xpath("//button[@class='artdeco-pagination__button artdeco-pagination__button--next artdeco-button artdeco-button--muted artdeco-button--icon-right artdeco-button--1 artdeco-button--tertiary ember-view']")).click();
		
    }
    
    public static String connectmessage()
    {
     String Str = "I am a QA Engineer having 4 years of experience in software testing and looking for jobs across Germany.I am familiar with automation(Selenium, Jmeter) and manual testing. I have A2 level German.Please let me know is there any opportunities for me in your organisation";
     return Str;
    }
    
    public static void findtotal(){
    	WebElement count= driver.findElement(By.xpath("//h3[@class='search-results__total pt4 pb0 t-14 t-black--light t-normal pl5  clear-both']"));
    	
    	String results = count.getText();
    			
    	 results = results.replaceAll("\\D+","");
    	System.out.println(results);
    	int result = Integer.parseInt(results);			

    	for(int k = 1;k<result;k++)
    	{
    		findconnections();	
    		System.out.println("Adding connections from " + (k+1) + " Page");
    	}
    	
    }
    
    public static void findconnections(){
    	{
    	    long scroll = findscrolllength();	
	    	System.out.println("scroll length is " + scroll );
	    	int len;
	    	for (len= 0;len< scroll; len++){
	    		len = len+ 500;
	    		 try {
	     	    	 driver.findElement(By.xpath("//button[starts-with(@aria-label,'Connect with')]")).isDisplayed();
	         	    List<WebElement> Connections33 =  driver.findElements(By.xpath("//button[starts-with(@aria-label,'Connect with')]"));
	       	       // System.out.println("size of connect buttons is :  " + Connections33.size());
	       	        
	       	     for(int i= 0; Connections33.size()> i;i++)
	    			{
	   			    	Util.applywait(3000);
	    				Connections33.get(i).click();
	    			    Util.applywait(3000);
	    			    driver.findElement(By.xpath("//button[@class ='artdeco-button artdeco-button--secondary artdeco-button--3 mr1']")).click();
	    			    if( driver.findElements(By.id("email")).size()!=0)
	    			    		{
	    			      	driver.findElement(By.id("email")).sendKeys("josephchithira@gmail.com");	
	    			    }
	    			    
	    		        driver.findElement(By.name("message")).sendKeys(connectmessage());
	    		        driver.findElement(By.xpath("//button[@class='artdeco-button artdeco-button--3 ml1']")).click();
	    			    
	    			}
	    	    }
	   	     	     catch (Exception e) {
	     	    	JavascriptExecutor js1 = ((JavascriptExecutor) driver);
	     	    	System.out.println(len);
	 				if (len> scroll){
	 				Nextpage();  
    			    Util.applywait(3000);

	 				}
	 				else{
		 				js1.executeScript("window.scrollTo(0, "+len+");");
	 				}
	   	     	     }

			}
	        Util.applywait(3000);
		}
    }
    } 
