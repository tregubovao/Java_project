package lesson5;

import java.util.*;

public class HW5 {
    public static void main(String[] args) {

        taskOnePhoneBook();
//        taskTwoListOfEmployees();
    }

    private static void taskTwoListOfEmployees() {
        Map<String, String> listOfEmployees = new HashMap<>();
        listOfEmployees.put("Иванов", "Иван");
        listOfEmployees.put("Петрова", "Светлана");
        listOfEmployees.put("Белова", "Кристина");
        listOfEmployees.put("Мусина", "Анна");
        listOfEmployees.put("Крутова", "Анна");
        listOfEmployees.put("Юрин", "Иван");
        listOfEmployees.put("Лыков", "Петр");
        listOfEmployees.put("Чернышов", "Петр");
        listOfEmployees.put("Чернов", "Павел");
        listOfEmployees.put("Федорова", "Мария");
        listOfEmployees.put("Светлова", "Марина");
        listOfEmployees.put("Савина", "Мария");
        listOfEmployees.put("Рыкова", "Мария");
        listOfEmployees.put("Лугова", "Марина");
        listOfEmployees.put("Владимирова", "Анна");
        listOfEmployees.put("Мечников", "Иван");
        listOfEmployees.put("Петин", "Петр");
        listOfEmployees.put("Ежов", "Иван");

        ArrayList<String> uniqueNames = new ArrayList<>();
        Map<Integer, Set<String>> result = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, String> el: listOfEmployees.entrySet()) {
            String uName = el.getValue();
            if (!uniqueNames.contains(uName)) {
                uniqueNames.add(uName);
                int count = 0;
                for (Map.Entry<String, String> uniqueEl: listOfEmployees.entrySet()) {
                    String name = uniqueEl.getValue();
                    if (name.equalsIgnoreCase(uName)){
                        count ++;
                    }
                }
                if (count > 1) {
                    Set<String> namesToTree;
                    if (!result.containsKey(count)) {
                        namesToTree = new HashSet<>();
                    } else {
                        namesToTree = result.get(count);
                    }
                    namesToTree.add(uName);
                    result.put(count, namesToTree);
                }
            }
        }
        printOfSortedNames(result);
    }

    private static void printOfSortedNames(Map<Integer, Set<String>> result) {
        for (Map.Entry<Integer, Set<String>> el: result.entrySet()) {
            System.out.println("Имя (имена) : " + el.getValue() + "   Количество повторений: " + el.getKey());
        }
    }


    private static void taskOnePhoneBook() {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Иванов", Arrays.asList("+79219663696", "+79219555555"));
        phoneBook.put("Петров", Arrays.asList("+79219333333", "+79219222222"));
        phoneBook.put("Кузнецов", Arrays.asList("+79219666666", "+79219777788", "+79297500000"));

        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.println("Введите фамилию для поиска: ");
            String inputString = inp.nextLine();
            if (inputString.isBlank()) {
                System.out.println("Строка НЕ должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("стоп")) {
                System.out.println("До скорых встреч!");
                break;
            }
            inputString = inputString.toLowerCase();
            inputString = inputString.substring(0, 1).toUpperCase() + inputString.substring(1);

            if (phoneBook.containsKey(inputString)) {
                System.out.println("Абонент: " + inputString);
                System.out.println("Номера телефона(ов): " + phoneBook.get(inputString));
            } else {
                System.out.println("Такой абонент отсутствует. Если хотите добавить этого абонента в телефонную книгу нажмите 'да':");
                String answer = inp.nextLine();
                if (answer.equalsIgnoreCase("да")) {
                    String surname = inputString;
                    LinkedList <String> numberList = new LinkedList<>();
                    System.out.println("Укажите номер телефона для этого абонента:");
                    String number = inp.nextLine();
                    numberList.add(number);

                    while (true) {
                        System.out.println("Если хотите обавить еще один номер нажмите 'да':");
                        String answerNumberAdd = inp.nextLine();
                        if (answerNumberAdd.equalsIgnoreCase("да")) {
                            System.out.println("Укажите номер телефона для этого абонента:");
                            String anotherNumber = inp.nextLine();
                            numberList.add(anotherNumber);

                        } else {
                            break;
                        }
                    }
                    phoneBook.put(surname, numberList);
                    System.out.printf("Абонент %s добавлен в телефонную книгу.\n", surname);
                }
            }

        }
    }


}
