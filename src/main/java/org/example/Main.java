package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    public static void main(String[] args) {
        //путь до тестовых файлов
        String fileName = "C:/Users/Deserag/IdeaProjects/prakticks/testing/Test1.xlsx";
        String listName = "Лист1";

        //создаем переменные, в которых будут храниться данные из файла
        String[] days = new String[100]; // массив с датами
        String[] rabota = new String[100]; //массив работы
        String[] otvetstvenost = new String[100]; //массив отвественных

        // Создаем файл и поток для чтения
        File file = new File(fileName);
        FileInputStream inputStream = null;
        Workbook workbook = null;

        try {
            inputStream = new FileInputStream(file);

            // Открываем книгу Excel
            workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(listName);

            // Получаем строки и выводим содержимое каждой из них
            for (Row row : sheet) {
                int rowNumber = row.getRowNum();
                int stolb = rowNumber;
                if (rowNumber == 0) {
                    int i = 0;// номер первой строки с датами
                    int j = 0;// номер столбцов, из которых будет браться информация
                    int day = 0;//
                    for (Cell cell : row) {
                        /*
                        * нахождение даты которая указана для работы и занесение ее в массив
                        * для определения правильности позициизадействованны дополнительные переменные, которые служат обозначениями для ячейки, в которой распологается запись*/
                        int columnNumber = cell.getColumnIndex();
                        if (columnNumber == j){
                            days[day] = cell.toString();
                            System.out.print("Дата: " + days[day] + "столбец:" + rowNumber + "строка: " + columnNumber +  "\n"); //проверка на занесение даты в массив
                            day += 1;
                            j += 2;
                        }
                    }
                }
            }


            /*
            * здесь находится второй парсер, который необходим для получения рабоыт и отвественного
            * также для упрощения работы созданы новые переменные, которые нужны как в цикле, так и для массивов*/
            int stolb = 0;
            int stolb_rabota = 0;
            int stolb_otvetst = 1;
            int day = 0;
            for (Row row : sheet) {
                int rowNumber = row.getRowNum();
                if ( rowNumber <= 1){}
                else{
                    int a = 0;
                    for (Cell cell : row) {
                        if (a % 2 == 0){
                            //System.out.println("Работа:" +cell.toString()+ "\n") ; проверка нахождения работы
                        rabota[day] = cell.toString();
                        System.out.println("Работа: " + rabota[day] + "\n");
                        a += 1;
                        }
                        else {
                            //System.out.println("должность:" +cell.toString()+ "\n"); проверка нахождения работника
                            otvetstvenost[day] = cell.toString();
                            System.out.println("должность: " +otvetstvenost[day]+ "\n");
                            day += 1;
                            a += 1;
                        }
                    }
                    }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                // Закрываем поток и книгу Excel
                if (inputStream != null) {
                    inputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}