package examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Gmail {
	
	
	public static void main (String [] args) throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "C:/Wiki/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");
		
		// Login to Gmail
		
		WebElement nextbtn = driver.findElement(By.xpath("//*[@id='next']"));
		nextbtn.click();
		String errorMessageText = driver.findElement(By.xpath("//*[@id='errormsg_0_Email']")).getText();
		String errorMessageColor = driver.findElement(By.xpath("//*[@id='errormsg_0_Email']")).getCssValue("color");
		System.out.println("Error Message text: "+errorMessageText);
		System.out.println("Error Message text color: "+errorMessageColor);
		
		String userID = "deepthi.kesa@gmail.com";
		String password = "pass123";
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(userID);
		System.out.println("Location of Element -"+"Next is" + nextbtn.getLocation());
		nextbtn.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(password);
		WebElement passwordbtn = driver.findElement(By.xpath("//*[@id='signIn']"));
		System.out.println("Location of Element -"+"Password is" + passwordbtn.getLocation());
		passwordbtn.click();
		Thread.sleep(30000);
	
		
		// Compose Email & Send
		//driver.findElement(By.xpath("//*[@id=':iz']/div/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=':15k']")).sendKeys("a@a.com");
		String subject = "CASE STUDY AUTOMATION ENGINEERING & QA";
		driver.findElement(By.xpath("//*[@id=':os']")).sendKeys(subject);
		driver.findElement(By.xpath("//*[@id=':px']")).sendKeys("Submitting My Case Study");
		driver.findElement(By.xpath("//*[@id=':oi']")).click();
		Thread.sleep(7000);
		
		// Check Send Email 
		driver.findElement(By.xpath("//*[@id=':jb']/div/div[1]/span/a")).click();
		Thread.sleep(10000);
		String sendMailText = driver.findElement(By.xpath("//*[@id=':p5']")).getText();
		if (sendMailText.equalsIgnoreCase(subject))
		{
			System.out.println("Mail send successfully");
		}
		else
		{
			System.out.println("Unable to find the send mail.");
		}
		
				// Compose Email & Send
				driver.findElement(By.xpath("//div[2]/div/div/div/div[2]/div/div/div/div/div")).click();
				driver.findElement(By.xpath("//*[@id=':p8']")).sendKeys("a@a.com");
				String subject2 = "CASE STUDY AUTOMATION ENGINEERING & QA";
				driver.findElement(By.xpath("//div[3]/input")).sendKeys(subject2);
				driver.findElement(By.xpath("//td[2]/div[2]/div/div")).sendKeys("Submitting My Case Study");
				driver.findElement(By.xpath("//td/div/div/div[4]/table/tbody/tr/td/div/div[2]")).click();
				Thread.sleep(2000);
				
				// Check Send Email 
				driver.findElement(By.xpath("//div[4]/div/div/div/span/a")).click();
				Thread.sleep(2000);
				String sendMailText2 = driver.findElement(By.xpath("//td[6]/div/div/div[2]/span")).getText();
				if (sendMailText2.equalsIgnoreCase(subject2))
				{
					System.out.println("Mail send successfully");
				}
				else
				{
					System.out.println("Unable to find the send mail.");
				}
		
		
	}
	

}
