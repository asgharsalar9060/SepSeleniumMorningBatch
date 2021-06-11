package ExcelLibUtil;

public class Xls_ReaderTest {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader("./src/main/java/ExcelLibUtil/Book.xlsx");
		
		String sheetName = "login";
		
		System.out.println(reader.getCellData(sheetName, "Username", 3));
		String data = reader.getCellData(sheetName, 0, 2);
		System.out.println(data);
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: " + rowCount);
		
//		reader.addColumn(sheetName, "Status");
		
//		reader.addSheet("registration");
		
		
//		if(! reader.isSheetExist("registration")) {
//			reader.addSheet("registration");
//		}
		
//		reader.setCellData(sheetName, "Status", 2, "PASS");
		reader.setCellData(sheetName, "Status", 3, "FAIL");
		
		int colCount = reader.getColumnCount(sheetName);
		System.out.println("total columns: " + colCount);
		
//		reader.removeColumn("registration", 0);
		
		System.out.println(reader.getCellData("registration", "Phonenumber", 2));
		System.out.println(reader.getCellData("registration", "Age", 2));
		
		System.out.println(reader.getCellData("registration", "Phonenumber", 3));
		System.out.println(reader.getCellData("registration", "Age", 3));
		
		
	}

}
