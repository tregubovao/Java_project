package lesson1;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        arrayB();
//        test();
//        inNameAndSay();

        minAndMax();
//        moveToTheBack();
//        inpNameTimesOfDay();

//        System.out.println("Hello, world");
    }

    private static void inpNameTimesOfDay() {
//        System.out.println(LocalTime.now());
        Scanner inp = new Scanner(System.in);
        System.out.printf("Введите Ваше имя: ");
        String name = inp.nextLine();
        inp.close();
        LocalTime now = LocalTime.now();
        System.out.println(now);
        if (now.getHour() >= 5 && now.getHour() < 12) {
            System.out.println("Доброе утро, " + name + "!");
        } else if (now.getHour() >= 12 && now.getHour() < 18) {
            System.out.println("Добрый день, " + name + "!");
        } else if (now.getHour() >= 18 && now.getHour() < 23) {
            System.out.println("Доброе вечер, " + name + "!");
        } else {
            System.out.println("Доброй ночи, " + name + "!");
        }
    }

    private static void inNameAndSay() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите Ваше имя: ");
        String name = in.nextLine();
        System.out.printf("Привет, " + name + "!");
        in.close();
    }

    private static void minAndMax() {
        int[] arr = {1, -14, 5, 6, 3, 9, -6, 25, 8};
        int minn = arr[0];
        int maxx = arr[0];
        for (int el: arr) {
            if (el < minn) {
                minn = el;
            }
            if (el > maxx) {
                maxx = el;
            }
        }
        System.out.println("Минимальный элемент: " + minn);
        System.out.println("Максимальный элемент: " + maxx);
    }

    static void test() {

        System.out.printf("Hello, world!");
    }

    private static void arrayB() {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1};
        int count = 0;
        int maxx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count += 1;
//                System.out.println("count" + count);

            } else {
                if (count > maxx) {
                    maxx = count;
                }
                count = 0;
            }

            /*if (arr[i] == 1) count += 1;
            if (count > maxx) maxx = count;
            if (arr[i] != 1) count = 0;*/
        }
        if (count > maxx) {
            maxx = count;
        }
        System.out.println("MAX кол-во 1: " + maxx);
    }

    private static void moveToTheBack() {
        int[] arr1 = {3, 3, 2, 2, 2, 3, 3, 3, 2};
        int[] arr2 = new int[arr1.length];
        int val = 3;
        int count3 = 0;
        int count2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == val) {
                arr2[arr2.length - count3 - 1] = arr1[i];
                count3++;
            } else {
                arr2[count2] = arr1[i];
                count2++;
            }
        }
        for (int item1 : arr1)
            System.out.print(item1 + " ");
        System.out.println();
        for (int item2 : arr2)
            System.out.print(item2 + " ");
    }


}


