package org.experis.wishlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // genero una lista vuota per inserire lista desideri
        List<Gift> giftsList = new ArrayList<>();

        // apro un ciclo while per chiedere all utente di aggiungere alla lista regali
        boolean exit = false;

        while (!exit){
            System.out.println("Number of items in the list: " + giftsList.size());
            System.out.println("Do you want add new item at the wishlist? y/n");
            String choice = scan.nextLine().toLowerCase();
            switch (choice){
                case "y":
                    // aggiungo alal lista elemento
                    System.out.print("What you want add?: ");
                    String gift = scan.nextLine();
                    giftsList.add((new Gift(gift)));
                    break;

                    case "n":
                        // termino il ciclo
                        exit = true;
                    break;

                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }

        System.out.println(giftsList);
        // ordino la lista dei regali

        Collections.sort(giftsList);

        System.out.println(giftsList);



        scan.close();
    }
}
