package demo1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


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
	xp("html/body/div[13]/div[1]/table/tbody/tr[3]/td[5]").click();
	Thread.sleep(3000);
	for(int j=0;j<7;j++)
	{
		Thread.sleep(2000);
	xp("html/body/div[14]/div[1]/table/thead/tr[1]/th[3]").click();
	}
	Thread.sleep(2000);
	xp("html/body/div[14]/div[1]/table/tbody/tr[3]/td[5]").click();
	Thread.sleep(2000);
    xp(".//*[@id='adults']").click();
    Thread.sleep(3000);
    WebElement d= xp(".//*[@id='adults']");
    act.moveToElement(d).click().build().perform();
    Thread.sleep(3000);

    xp(".//*[@id='HOTELS']/div/form/div[6]/div/button").click();
   
    Thread.sleep(2000);
    xp("html/body/div[5]/div[3]/div/table/tbody/tr/td/div/div[2]/div/div[1]/a/button").click();
    Thread.sleep(2000);
 for(int i=0;i<13;i++)
 {
	 Thread.sleep(2000);
    xp(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]").click();
    Thread.sleep(1000);
 }
}

public static void main(String[] args) throws Exception
{
	System.setProperty("webdriver.chrome.driver","D://Ram//Drivers//chromedriver.exe");
	d=new ChromeDriver();
	d.get("http://phptravels.net");
	d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	d.manage().window().maximize();
action();

}
}