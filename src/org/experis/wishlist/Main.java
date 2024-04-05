package org.experis.wishlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // genero una lista vuota per inserire lista desideri
        List<Gift> giftsList = new ArrayList<>();


        // path file
        String pathFile = "./resources/wish-list.txt";
        // creo spazio percorso file
        File file = new File(pathFile);

        // se esiste lista txt recupero i dati al suo interno
        if(file.exists()){
            try {
                Scanner fileScanner = new Scanner(file);

                // prendo ogni riga del file txt e lo metto dentro alla mia lista
                while (fileScanner.hasNextLine()) {
                    giftsList.add(new Gift(fileScanner.nextLine()));
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }

        // apro un ciclo while per chiedere all utente di aggiungere alla lista regali
        boolean exit = false;

        while (!exit){
            System.out.println("Number of items in the list: " + giftsList.size());
            System.out.println("Do you want add new item at the wishlist? y/n");
            String choice = scan.nextLine().toLowerCase();
            switch (choice){
                case "y":
                    // aggiungo alla lista elemento
                    System.out.print("What you want add?: ");
                    String gift = scan.nextLine();
                    // controllo se il regalo è presente nella lista
                    if(giftsList.contains((new Gift(gift)))){
                        System.out.println("Gift already inside!");
                    }else {
                     giftsList.add((new Gift(gift)));
                    }
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

        // ordino la lista dei regali
        Collections.sort(giftsList);

        System.out.println(giftsList);

        // scrivo su file la lista desideri
        try (FileWriter fileWriter = new FileWriter(new File("./resources/wish-list.txt"))) {
            for (Gift gift : giftsList) {
                fileWriter.write(gift.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scan.close();
    }
}
