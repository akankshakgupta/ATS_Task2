package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LoginUtils {


    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    public LoginUtils(String excelPath, String sheetName) {

        try {

            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);

        }catch(Exception e) {
            e.printStackTrace();
        }

    }


    public static int getRowCount() {
        int rowCount=0;
        try {

            rowCount = sheet.getPhysicalNumberOfRows();


        }catch(Exception exp) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return rowCount;

    }

    public static int getColCount() {
        int colCount=0;
        try {

            colCount = sheet.getRow(0).getPhysicalNumberOfCells();


        }catch(Exception exp) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return colCount;

    }

    public static String getCellDataString(int rowNum, int colNum) {
        String cellData = null;


        cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

        return cellData;
    }



}


