package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int secim = -1;

        while (secim != 0) {
            System.out.println("0 (Çıkış), 1 (Ekleme), 2 (Çıkarma)");
            System.out.print("Seçiminiz: ");

            secim = Integer.parseInt(scanner.nextLine());

            if (secim == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                addItems(input);
            } else if (secim == 2) {
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                removeItems(input);
            } else if (secim != 0) {
                System.out.println("Geçersiz Seçim");
            }
            printSorted();
        }
        scanner.close();
    }

    public static void printSorted() {
        if (groceryList.isEmpty()) {
            System.out.println("[Liste şu an boş]");
        } else {
            for (String item : groceryList) {
                System.out.println(item);
            }
        }
    }


    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            } else if (checkItemIsInList(trimmedItem)) {
                System.out.println("Uyarı: " + trimmedItem + " zaten listede mevcut.");
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            } else {
                System.out.println("Hata: " + trimmedItem + " listede bulunamadı.");
            }
            Collections.sort(groceryList);
        }

    }
}