package tallerminireto1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TallerMiniReto1 {

    static ArrayList<String> numberListString = new ArrayList<>();

    public static void main(String[] args) {
        Scanner textEntry = new Scanner(System.in);
        System.out.println("Part One: 10 Digit Random Number Generator ");
        System.out.println("\nWrite how many numbers do you want to generate?: ");
        try {
            int quantity = textEntry.nextInt();
            Long numberList[] = new Long[quantity];
            for (int i = 0; i < quantity; i++) {
                System.out.println("\nWrite the input value: (TipoA or TipoB) ");
                String input = textEntry.next();
                randomGenerator(input);
            }
            System.out.println("\nPart Two: Sorting algorithms for a number list");
            System.out.println("The following lists contains the numbers generated at the part one:");
            for (int j = 0; j < numberListString.size(); j++) {
                String value = numberListString.get(j);
                System.out.println(value);
                numberList[j] = (Long.parseLong(value));
            }
            System.out.println("\nPlease write the sort order: (Asc or Desc)");
            String sortOrder = textEntry.next();
            if (sortOrder.equals("Asc")) {
                ascendingSort(numberList);
            } else if (sortOrder.equals("Desc")) {
                descendingSort(numberList);
            }
            textEntry.close();
        } catch (Exception e) {
            System.out.println("The input value is not allowed");
        }
    }

    static public void randomGenerator(String input) {
        String start = "";
        if (input.equals("TipoA")) {
            start = "54";
            validInput(start);
        } else if (input.equals("TipoB")) {
            start = "08";
            validInput(start);
        } else {
            System.out.println("The input value is not valid");
        }

    }

    static public void validInput(String start) {
        Random random = new Random();
        String middle = "";
        String end = "";
        int number = random.nextInt(99999999 - 10000000 + 1) + 10000000;
        middle = String.valueOf(number);
        end = start.concat(middle);
        numberListString.add(end);
        System.out.println(end);
    }

    static void ascendingSort(Long[] numberList) {
        System.out.println("\nYou choosed ascending sort");
        Long orderArray;
        for (int j = 0; j < (numberList.length - 1); j++) {
            for (int i = 0; i < (numberList.length - 1); i++) {
                if (numberList[i] > numberList[i + 1]) {
                    orderArray = numberList[i];
                    numberList[i] = numberList[i + 1];
                    numberList[i + 1] = orderArray;
                }
            }
        }
        System.out.println("The ascending sorted matrix is");
        for (Long matrixValue : numberList) {
            System.out.println(matrixValue);
        }
    }

    

    static void descendingSort(Long[] numberList) {
        System.out.println("\nYou choosed descending sort");
        Long orderArray;
        for (int j = 0; j < (numberList.length - 1); j++) {
            for (int i = 0; i < (numberList.length - 1); i++) {
                if (numberList[i] < numberList[i + 1]) {
                    orderArray = numberList[i];
                    numberList[i] = numberList[i + 1];
                    numberList[i + 1] = orderArray;
                }
            }
        }
        System.out.println("The descending sorted matrix is");
        for (Long matrixValue : numberList) {
            System.out.println(matrixValue);
        }
    }
}
