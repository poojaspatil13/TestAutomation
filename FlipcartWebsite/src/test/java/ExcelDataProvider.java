import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelDataProvider 
{
	
	WebDriver driver=null;
	@BeforeTest
	public void setUpTest()
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	
	
	@Test(dataProvider="test1data")
	public void test1(String email,String password) throws Exception
	{
		System.out.println(email+"     "+password);
		driver.get("https://affiliate.flipkart.com/login");
		driver.findElement(By.id("inputEmail")).sendKeys(email);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();
		Thread.sleep(2000);
	}
	
	
	@DataProvider(name="test1data")
	public Object[][] getData()
	{
		String excelPath= "E://Eclipse//AmazonWebsite//Excel//Data.xlsx";
		Object data[][]= testData(excelPath,"Sheet1");
		return data;
	}
	
	public static Object[][] testData(String excelPath, String sheetName)
	{
		ExcelUtilis excel = new ExcelUtilis(excelPath,sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][]=new Object[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData+"  ");
				data[i-1][j]=cellData;
			
			}
			System.out.println();
		}
		return data;
		
	}
	
}
