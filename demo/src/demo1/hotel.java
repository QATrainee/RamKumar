package demo1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class hotel {
	
	static WebDriver d;
	public String workingDir;

	protected static WebElement xp(String xpath) {

		return  d.findElement(By.xpath(xpath));
	}

	protected static WebElement id(String id) {

		return  d.findElement(By.id(id));
	}
	protected static WebElement css(String cssSelector) {

		return  d.findElement(By.cssSelector(cssSelector));
	}

public static void action() throws InterruptedException
{
	
	css(".select2-chosen").click();
	
	css(".select2-input.select2-focused").sendKeys("sin");
	Thread.sleep(3000);
	
	WebElement e=xp(".//*[@id='select2-drop']/ul");
	Actions act=new Actions(d);
	act.moveToElement(e);
	
	act.click().build().perform();
	Thread.sleep(2000);

	xp(".//*[@id='dpd1']/div/input").click();
	Thread.sleep(3000);

	
	WebElement date=css(".datepicker.dropdown-menu");
	
	act.click(date).sendKeys(Keys.ENTER).build().perform();
    
	Thread.sleep(3000);
		xp(".//*[@id='dpd2']/div/input").click();
		Thread.sleep(1000);
	//xp("html/body/div[14]/div[1]/table/thead/tr[1]/th[3]").click();
	WebElement gg=xp("html/body/div[14]");
	//act.contextClick(gg);
	act.click(gg).sendKeys(Keys.ENTER).build().perform();

	Thread.sleep(2000);

    xp(".//*[@id='adults']").click();
    Thread.sleep(3000);
    WebElement d= xp(".//*[@id='adults']");
    act.moveToElement(d).click().build().perform();
    Thread.sleep(3000);

    xp(".//*[@id='HOTELS']/div/form/div[6]/div/button").click();
   
    Thread.sleep(2000);
    xp("html/body/div[5]/div[3]/div/table/tbody/tr[1]/td/div/div[2]/div/div[1]/a/button").click();
    Thread.sleep(2000);
 for(int i=0;i<=13;i++)
 {
	 Thread.sleep(2000);
    WebElement d1=css(".fotorama__img");
 
 }
 Thread.sleep(1000);
 
}
public static void close()
{
	d.close();
}

public static void main(String[] args) throws Exception
{
	
	
 

	System.setProperty("webdriver.chrome.driver","D://Ram//Drivers//chromedriver.exe");
	d=new ChromeDriver();
	d.get("http://phptravels.net");
	d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	d.manage().window().maximize();
	
	
action();
close();
}
}