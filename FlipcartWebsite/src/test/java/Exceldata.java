
public class Exceldata {

	public static void main(String[] args) 
	{
		String projectPath=System.getProperty("user.dir");
		ExcelUtilis excel=new ExcelUtilis(projectPath+"/Excel/Data.xlsx","Sheet1");
		excel.getRowCount();
		excel.getCellDataString(1,1);
	}

}
