package lesson2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;
import java.io.File;

public class HW2 {
    static Logger logger = Logger.getLogger("Task3");

    public static void main(String[] args) {
//        taskOnePalindrom();
//        taskTwoTestToText();
        taskThreeExtension("C:\\Users\\Александр\\IdeaProjects\\Java_project");

    }

    private static void taskOnePalindrom() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Введите строку символов: ");
        String str = inp.nextLine();
        inp.close();
        char[] array = str.toCharArray();
        char[] array2 = new char[array.length];
        for (int i = 0; i < str.length(); i++) {
            array2[i] = array[array.length - 1 - i];
        }
        String str2 = "";
        for (char el : array2) {
            str2 += String.valueOf(el);
        }
        System.out.println(str);
        System.out.println(str2);
        boolean compare = str.equals(str2);
        System.out.println(compare);
//        if (str.equals(str2)) {
//            System.out.println("Это палиндром!");
//        } else {
//            System.out.println("Это НЕ палиндром!");
//        }
    }

    private static void taskTwoTestToText() {
        try (PrintWriter pw = new PrintWriter("src/main/resources/HW2_task2.txt")) {
            pw.print(stringMaking());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        /*PrintWriter pw = null;
        try {
            pw = new PrintWriter("src/main/resources/HW2_task2.txt");
            pw.print(stringMaking());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            pw.close();
        }*/
    }
    private static String stringMaking() {
        String test = "TEST";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(test);
        }
        return sb.toString();

    }

    private static void taskThreeExtension(String pathDir) {
        String[] fileNamesFromDir = new String[0];
        try {
            fileNamesFromDir = convertPathToNamesArr(pathDir);
        } catch (directoriIsNotFoundException e) {
            logger.severe(e.getMessage());
            System.exit(1);
        }

        StringBuilder sbExtension = new StringBuilder();
        int count = 1;
        for (String el : fileNamesFromDir) {
            if (el.contains(".")) {
                String[] ext = el.split("\\.");
                System.out.println(count + ". Расширение файла: " + ext[1]);
            } else {
                System.out.println(count + ". Расширение файла: " + "отсутствует");
            }
            count++;
        }
    }
    private static String[] convertPathToNamesArr(String path) {
        File dir = new File(path);
        if (!dir.isDirectory()) {
            throw new directoriIsNotFoundException("По указанному пути не было найдено директории:" + path);
        }
        return dir.list();
    }
}
