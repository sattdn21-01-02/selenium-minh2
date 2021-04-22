package common;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String args[]) throws IOException {
        //Create an object of File class to open xlsx file
        File file = new File("D:\\selenium_minh\\selenium_minh_project\\src\\main\\resources\\BookSelenium.xlsx");
        DataFormatter formatter = new DataFormatter(Locale.US);
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //creating a Sheet object
        Sheet sheet = wb.getSheet("sheet2");

        //get all rows in the sheet
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        //iterate over all the row to print the data present in each cell.
        for (int i = 0; i <= rowCount; i++) {

            //get cell count in a row
            int cellcount = sheet.getRow(i).getLastCellNum();

            //iterate over each cell to print its value
            System.out.println("Row" + i + " data is :");

            for (int j = 0; j < cellcount; j++) {
                String a = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                System.out.println(a);
                //System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
            }
            System.out.println();
        }
    }
}
