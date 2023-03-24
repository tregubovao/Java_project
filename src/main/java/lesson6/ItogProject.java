package lesson6;


import java.util.List;
import java.util.Scanner;

public class ItogProject {
    public static void main(String[] args) {
        noteBooks();
    }
    private static void noteBooks() {
        Notebook nb1 = new Notebook("Honor", "HYM-W56", 13.3, "2560x1600 пикс.",
                512, 8, 3200, 6, 30066661);
        nb1.setPrice(59999);
        nb1.quantity = 3;

        Notebook nb2 = new Notebook("HP", "13-be0069ur", 16.1, "1920x1080 пикс.",
                512, 16, 4200, 6, 30061882);
        nb2.setPrice(63995);
        nb2.quantity = 2;

        Notebook nb3 = new Notebook("HUAWEY", "53013PLV", 15.6, "1920x1080 пикс.",
                256, 8, 3200, 2, 30066689);
        nb3.setPrice(39999);
        nb3.quantity = 10;

        Notebook nb4 = new Notebook("Asus", "F15 FX506HCB-US51", 15.6, "1920x1080 пикс.",
                512, 8, 3200, 6, 30065394);
        nb4.setPrice(79999);
        nb4.quantity = 13;

        Notebook nb5 = new Notebook("Lenovo", "5 15ITL05 82FG0165US", 15.6, "1920x1080 пикс.",
                256, 8, 3200, 4, 30065399);
        nb5.setPrice(59999);
        nb5.quantity = 6;

        Notebook nb6 = new Notebook("Honor", "HYM-W56", 13.3, "2560x1600 пикс.",
                512, 8, 3200, 6, 30066661);
        nb6.setPrice(59999);
        nb6.quantity = 5;

        Notebook nb7 = new Notebook("Acer", "SP114-31", 14, "1920x1080 пикс.",
                128, 4, 2933, 2, 30062291);
        nb7.setPrice(59999);
        nb7.quantity = 20;


        System.out.println(nb4);
        nb2.printInfo();
        System.out.println(nb6.equals(nb1));
        System.out.println(nb5.hashCode());
        System.out.println();

        List<Notebook> arrayList = List.of(nb1, nb2, nb3, nb4, nb5, nb6, nb7);

        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.println("Введите минимальный объем SSD или 'стоп' для прекращения поиска: ");
            String inputString = inp.nextLine();
            if (inputString.isBlank()) {
                System.out.println("Строка НЕ должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("Стоп")) {
                System.out.println("До скорых встреч!");
                break;
            }
            for (Notebook el: arrayList ) {
                if (el.ssdVolume >= Integer.parseInt(inputString)) {
                    el.printInfo();
                }
            }
        }

    }

}
