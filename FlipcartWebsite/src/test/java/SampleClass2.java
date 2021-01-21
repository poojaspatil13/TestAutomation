import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleClass2
{

	WebDriver driver=null;
	@BeforeTest
	public void setUpTest()
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver.exe");
		driver=new ChromeDriver();
	}

	@Test
	public void test2() throws Exception
	{
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.name("q")).sendKeys("Dell");
	driver.findElement(By.xpath("//*[@class='L0Z3Pu']")).click();
	Thread.sleep(2000);

	}
}