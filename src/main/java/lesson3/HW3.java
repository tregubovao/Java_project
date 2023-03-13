
package lesson3;
import java.util.*;

public class HW3 {
    public static void main(String[] args) {
        taskOne();      // 1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)
//        taskTwo();      // 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
//        taskThree();    // 3. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа.
    }

    private static void taskOne() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            arrayList.add(rand.nextInt(30));
        }
        System.out.println(arrayList);

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(arrayList);
    }

    private static void taskTwo() {
        ArrayList<Integer> arrayList= new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            arrayList.add(rand.nextInt(30));
        }
        System.out.println(arrayList);

        double summ = 0;
        for (int el: arrayList) {
            summ+=el;
        }
        double average = summ/arrayList.size();
        System.out.println("Максимальный элемент: " + Collections.max(arrayList));
        System.out.println("Минимальный элемент: " + Collections.min(arrayList));
        System.out.println("Среднее арифметическое: " + average);

    }


    private static void taskThree() {
        ArrayList<String> superList = new ArrayList<>();
        Collections.addAll(superList, "1", "2", "File", "32.25", "true", "555", "63.555", "26", "false", "61", "Hello", "123", "Hi!");
        for (int i = 0; i < superList.size(); i++) {
            try {
                int n = Integer.parseInt(superList.get(i));
                superList.remove(i);
                i--;
            } catch (NumberFormatException e) {
                System.out.println(superList.get(i) + " - НЕ целое число");
            }
        }

        System.out.println("Результат: " + superList);

    }
}
