package com.sumerge.utilities;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ReadFromExcel {

    public static Object[][] getExcelData(String fileName) throws IOException {
        FileInputStream file = new FileInputStream(
                new File(System.getProperty("user.dir") + "\\src\\main\\resources\\"+fileName+".xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowsNo = sheet.getLastRowNum();
        int colsNo = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rowsNo][colsNo];
        for (int i = 0; i < rowsNo; i++) {
            for (int j = 0; j < colsNo; j++) {

                XSSFRow row = sheet.getRow(i + 1);
                Cell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        int number = (int) cell.getNumericCellValue();
                        String S = Integer.toString(number);
                        data[i][j] = S;
                        break;
                }

            }
        }
        file.close();
        return (data);
    }

    public static Object[][] getCols(String fileName, int startCol, int endCol) throws IOException {
        Object data[][] = getExcelData(fileName);
        String[][] requiredData = new String[data.length][endCol - startCol];
        int rows = data.length;
        int cols = endCol - startCol;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                requiredData[i][j] = data[i][startCol + j].toString();
            }
        }
        return (requiredData);
    }

    public static void  main (String args[]) throws IOException {
        System.out.println(getExcelData("CreateAccountTestData").length);

    }
}
