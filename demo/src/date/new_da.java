package date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public abstract class new_da {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver d;
		System.setProperty("webdriver.chrome.driver","D://Ram//Drivers//chromedriver.exe");
		d=new ChromeDriver();
		d.get("http://demo.automationtesting.in/Datepicker.html");
	
		WebElement e=d.findElement(By.xpath(".//*[@id='ui-datepicker-div']"));
	    Actions ac=new Actions(d);
	    d.findElement(By.xpath(".//*[@id='datepicker1']")).click();
	    Thread.sleep(2000);
	    ac.click().sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(2000);
	
	}
}
