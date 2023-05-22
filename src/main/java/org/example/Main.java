package org.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        // Specify the path of the Excel file
        String excelFilePath = "C:/Users/Deserag/IdeaProjects/prakticka/testing/Test1.xlsx";

        // Create an input stream for reading Excel file
        try (InputStream inputStream = new FileInputStream(excelFilePath)) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.getStringCellValue() + "\t");
                }
                System.out.println();
            }
            workbook.close();

        } catch (IOException ex) {
            System.err.println("Failed to parse Excel file: " + ex.getMessage());
        }
    }
}