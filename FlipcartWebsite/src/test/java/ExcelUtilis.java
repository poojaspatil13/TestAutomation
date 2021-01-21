import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilis 
{
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtilis(String excelPath , String sheetName)
	{
		try
		{
		//projectPath = System.getProperty("user.dir");
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String arg[])
	{
		//getRowCount();
		getCellDataString(0,0);
		//getCellDataNumber();
	}

	public static int getRowCount()
	{
		int rowCount=0;
		try
		{
			//projectPath = System.getProperty("user.dir");
			//workbook = new XSSFWorkbook(projectPath+"/Excel/Data.xlsx");
			//sheet = workbook.getSheet("Sheet1");
			rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println("Number of row count:"+rowCount);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}
	public static String getCellDataString(int rownum, int colnum)
	{
		String cellData=null;
		try
		{
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath+"/Excel/Data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
			//System.out.println(cellData);
		}
		catch(Exception exp)
		{

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}
	
	public static int getColCount()
	{
		int colCount=0;
		try
		{
			//projectPath = System.getProperty("user.dir");
			//workbook = new XSSFWorkbook(projectPath+"/Excel/Data.xlsx");
			//sheet = workbook.getSheet("Sheet1");
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			//System.out.println("Number of col:"+colCount);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}

}
