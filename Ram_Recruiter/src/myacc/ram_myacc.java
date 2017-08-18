package myacc;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

public class ram_myacc {

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

	public void browserOpen() throws InterruptedException {
		workingDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome"
				+ ".driver",workingDir+ "\\source\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}

	public void logIn() throws Exception {
		File file = new File(workingDir + "\\source\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.get(prop.getProperty("URL"));
	
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		xp(prop.getProperty("recruiterlogin")).click();
		
		Thread.sleep(1000);
		xp(prop.getProperty("loginbutton")).click();
	
		d.switchTo().defaultContent();
		d.switchTo().frame("empcontentframe");

		xp(prop.getProperty("mailid")).sendKeys(prop.getProperty("username"));
		Thread.sleep(3000);

		xp(prop.getProperty("password1")).sendKeys(prop.getProperty("password"));
	
		Thread.sleep(2000);
		xp(prop.getProperty("submitbutton")).click();
		
		Thread.sleep(1000);

	}
	public void function() throws Exception
	{
		xp(".//*[@id='LeftMenu6']/div/div").click();
		Thread.sleep(1000);
	
		d.switchTo().frame("Iframe2");
		xp(".//*[@id='txtemailid']").clear();
		xp(".//*[@id='txtemailid']").sendKeys("trainee3@tiliconveli.com");
		Thread.sleep(1000);
		xp(".//*[@id='txtFName']").clear();
		xp(".//*[@id='txtFName']").sendKeys("Trainee");
		Thread.sleep(1000);
		xp(".//*[@id='txtLName']").clear();
		xp(".//*[@id='txtLName']").sendKeys("Three");
		Thread.sleep(1000);
		xp(".//*[@id='txtComname']").clear();
		xp(".//*[@id='txtComname']").sendKeys("Techpark");;
		Thread.sleep(1000);
		xp(".//*[@id='ddsCountry']").sendKeys("India");
		Thread.sleep(1000);
		xp(".//*[@id='txtCity']").clear();
		xp(".//*[@id='txtCity']").sendKeys("Mumbai, Maharashtra");
		Thread.sleep(1000);
		xp(".//*[@id='txtPersonalEmailID']").clear();
		xp(".//*[@id='txtPersonalEmailID']").sendKeys("qatraining1@tiliconveli.com");
		Thread.sleep(1000);
	
		xp(".//*[@id='txtPhoneArea']").sendKeys("+91");
		Thread.sleep(1000);
		xp(".//*[@id='txtPhone']").clear();
		xp(".//*[@id='txtPhone']").sendKeys("9487525100");
		Thread.sleep(1000);
		xp(".//*[@id='btnUpdate']").click();
		Thread.sleep(5000);
		
		
		String winHandleBefore = d.getWindowHandle();
		for(String winHandle : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle);
		
		
		css("#PasswordHL").click();  
	
		d.switchTo().frame("Iframe3");
		xp(".//*[@id='txtResetPwd']").sendKeys("TV@345");
		Thread.sleep(2000);
		xp(".//*[@id='txtConPwd']").sendKeys("TV@345");
		Thread.sleep(2000);
		xp(".//*[@id='btnResetPwd']").click();
		Thread.sleep(5000);
	
		}
		String winHandleBefore1 = d.getWindowHandle();
		for(String winHandle : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle);
		
		
		css("#PreferencesHL").click();
		d.switchTo().frame("Iframe3");
		Thread.sleep(2000);
		css("#LIShare>table>tbody>tr>td>a>img").click();
		Thread.sleep(2000);
	
		css("#FBShare>table>tbody>tr>td>a>img").click();
		Thread.sleep(2000);
	
		xp(".//*[@id='radioHotResumes_1']").click();
		Thread.sleep(2000);
		xp(".//*[@id='radioHotResumes_0']").click();
		Thread.sleep(2000);
		xp(".//*[@id='radioHotRequirement_1']").click();
		Thread.sleep(2000);
		xp(".//*[@id='radioHotRequirement_0']").click();
		Thread.sleep(2000);
		xp(".//*[@id='radioIM_1']").click();
		Thread.sleep(2000);
		xp(".//*[@id='radioIM_0']").click();
		Thread.sleep(2000);
		xp(".//*[@id='btnUpdate']").click();
		}
		}
	

	public void logOut() throws Exception {

		d.switchTo().defaultContent();

		Thread.sleep(10000);
		File file = new File(workingDir+"\\source\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		xp(prop.getProperty("usersetting")).click();
	
		Thread.sleep(10000);
		xp(prop.getProperty("logoutbutton")).click();
	
		Thread.sleep(10000);
	}

	void browserClose() {
		d.quit();
	}

}

