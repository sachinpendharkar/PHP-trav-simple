package D1;

import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Docker_p {
	
	WebDriver driver;
	//String url="http://sparshv2/Pages/Home.aspx";
	//String url="http://10.67.89.41/Automation/HMS/LoginPage.aspx ";
	String url ="https://www.phptravels.net/login";
	//String url="https://www.google.co.in/";
	@Before
	public void setUp() throws Exception {
		
		/*DesiredCapabilities dcp = new DesiredCapabilities();
		dcp.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		dcp.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		dcp.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		dcp.setCapability("name", "PHP");
		dcp.setCapability("idleTimeout", 150);
		driver = new RemoteWebDriver(new URL("http://35.193.7.170:4444/wd/hub"),dcp);*/
	
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		/*System.setProperty("webdriver.ie.driver","D:\\drivers\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(); 
		driver.manage().window().maximize();
		*/
		driver.get(url);
		
	}

	
	@Test
	public void test() throws Exception {
		//Thread.sleep(1000);
		
		System.out.println("Title:-"+driver.getTitle());
		//Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		System.out.println("username entered");
		
		driver.findElement(By.name("password")).sendKeys("demouser");
		System.out.println("pass entered");
		driver.findElement(By.xpath("//*[@id='loginfrm']/div[1]/div[5]/button")).click();
		System.out.println("loggedin");
		driver.findElement(By.linkText("Bookings")).click();
		System.out.println("clicked on booking");
		String x=driver.findElement(By.xpath("//*[@id='body-section']/div/div[1]/div/div[1]/h3")).getText();
				if(x.equals("Hi, DVhbCERv IlqEZZxz")){
					System.out.println("testcase1 passed-entered main page");
				}
				else{
					System.out.println("testcase1 failed");
				}
				driver.findElement(By.linkText("Invoice")).click();
				
				/*String  handle= driver.getWindowHandle();
				 driver.switchTo().window("http://www.phptravels.net/invoice?id=73&sessid=6897");*/
				 
				 Set<String> windows=driver.getWindowHandles();
				 System.out.println(windows.size());
					Iterator<String> it=windows.iterator();
					String parent=it.next();
					String child=it.next();
					driver.switchTo().window(child); 
				
		//driver.navigate().to("http://www.phptravels.net/invoice?id=73&sessid=6897");
		String b=driver.findElement(By.xpath("//*[@id='invoiceTable']/tbody/tr[4]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[5]/td[1]/strong")).getText();
		System.out.println(b);
				 if(b.equalsIgnoreCase("Check out")){
					 System.out.println("testcase passed");
					 
				 }
				 else{
					 System.out.println("testcase failed");
				 }
				
		        driver.findElement(By.xpath("//*[@id='btn']")).click();
	
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	

}