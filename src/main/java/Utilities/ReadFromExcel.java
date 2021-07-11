package Utilities;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


public class ReadFromExcel {

    public static Object[][] getExcelData() throws IOException {
        FileInputStream file = new FileInputStream(
                new File(System.getProperty("user.dir") + "\\resources\\Book1.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowsNo = sheet.getLastRowNum();
        int colsNo = sheet.getRow(0).getLastCellNum();
        //System.out.println(colsNo);
        String[][] data = new String[rowsNo][colsNo];
        for (int i = 0; i < rowsNo; i++) {
            for (int j = 0; j < colsNo; j++) {

                XSSFRow row = sheet.getRow(i + 1);
                Cell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        //System.out.println(cell.getStringCellValue());
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        int number = (int) cell.getNumericCellValue();
                        String S = Integer.toString(number);
                        data[i][j] = S;
                        //System.out.println(S);
                        break;
                }


            }
        }
        file.close();
        return (data);
    }

    public static String[][] getCertainData(int startRow,int endRow, int startCol,int endCol) throws IOException {
        Object data[][] = getExcelData();
        String[][] requiredData = new String[endRow-startRow][endCol-startCol];
        //System.out.println(endRow-startRow);
        int rows =endRow-startRow;
        int cols =endCol-startCol;
        //System.out.println(rows);
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j <cols; j++) {
                requiredData[i][j] = data[startRow+i][startCol+j].toString();
            }
        }
        return (requiredData);
    }

    public static void main(String args[]) throws IOException {
        int startRow=2;
        int startCol=0;
        int endRow = 3;
        int endCol = 2;
        int rows =endRow-startRow;
        int cols =endCol-startCol;
        System.out.println(rows);
        String[][] data =getCertainData(startRow,endRow,startCol,endCol);
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < cols; j++) {
                //System.out.println("in");
                System.out.println(data[i][j]);
            }
        }
    }
}
