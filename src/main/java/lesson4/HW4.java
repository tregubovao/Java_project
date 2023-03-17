package lesson4;

import java.util.*;

public class HW4 {
    public static void main(String[] args) {
        taskOne();  //  1. Реализовать консольное приложение, которое:
                    // Принимает от пользователя и “запоминает” строки.
                    // Если введено print, выводит строки так, чтобы последняя введенная
                    // была первой в списке, а первая - последней.
                    // Если введено revert, удаляет предыдущую введенную строку из памяти.
//        taskTwo();   // 2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

    }

    private static void taskTwo() {
        LinkedList<String> numbers = new LinkedList<>();
        Collections.addAll(numbers, "1", "2", "3", "4", "5", "6");
        System.out.println(numbers);

        numbers = toReverseLinkedList(numbers);
        System.out.println(numbers);
    }

    private static LinkedList<String> toReverseLinkedList(LinkedList<String> num) {
        LinkedList<String> reversedNumbers = new LinkedList<>();
        Iterator<String> iterator = num.descendingIterator();
        while (iterator.hasNext()) {
            reversedNumbers.add(iterator.next());
        }
        return reversedNumbers;
    }

    private static void taskOne() {
        Scanner inp = new Scanner(System.in);
        LinkedList<String> fruitsAndVegetables = new LinkedList<>();
        Collections.addAll(fruitsAndVegetables, "apple", "orange", "banana", "tomato", "strawberry", "melon");

        while (true) {
            System.out.println();
            System.out.print("Введите (добавьте) строку: ");
            String inputString = inp.nextLine();
            if (inputString.isBlank()) {
                System.out.println("Строка НЕ должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("stop")) {
                System.out.println("До скорых встреч!");
                break;
            }
            if (inputString.equalsIgnoreCase("print")) {
                printReversedValues(fruitsAndVegetables);
                continue;
            }
            if (inputString.equalsIgnoreCase("revert")) {
                if (fruitsAndVegetables.size() > 0) {
                    String toRemove = fruitsAndVegetables.getLast();
                    fruitsAndVegetables.removeLast();
                    System.out.printf("Слово %s удалено с последней позиции (позиция № %d)%n", toRemove, fruitsAndVegetables.size() + 1);
                } else {
                    System.out.println("Список пуст");
                }
                continue;
            }
            fruitsAndVegetables.addLast(inputString);
            System.out.printf("Слово %s добавлено на позицию № %d%n", inputString, fruitsAndVegetables.size());
        }
    }

    private static void printReversedValues(LinkedList<String> list) {
        System.out.printf("%d) %s%n", 1, list.getLast());
        for (int i = 1; i < list.size() - 1; i++) {
            System.out.printf("%d) %s%n", i + 1, list.get(i));
        }
        System.out.printf("%d) %s%n", list.size(), list.getFirst());
    }
}
