package com.fredericboisguerin.insa;

import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";


    public static void main(String[] args) {
        ContactsManager contManager = new ContactsManager();

        String fileName = "/home/mendesfe/contacts-manager/Contacts.csv";

        while (true) {
            Scanner sc1 = new Scanner(System.in);
            System.out.print("Options:\n");
            System.out.print("1 - Créer un contact;\n");
            System.out.print("2 - Modifier un contact;\n");
            System.out.print("3 - Supprimer un contact;\n");
            System.out.print("4 - Afficher list;\n");
            while (!sc1.hasNextInt()) {
                System.out.println("That's not a number!");
                sc1.next();
            }

            int option = sc1.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Créer un contact\n");
                    creerContact(contManager, fileName);
                    break;
                case 2:
                    System.out.print("Modifier un contact\n");
                    modifierContact(contManager, fileName);
                    break;
                case 3:
                    System.out.print("Supprimer un contact\n");
                    supprimerContact(contManager, fileName);
                    break;
                case 4:
                    System.out.print("Afficher list\n");
                    afficherList(contManager);
                    break;
                default:
                    System.out.print("Option invalide");
            }
        }
    }

    private static void afficherList(ContactsManager contManager) {
        contManager.printAllContacts();
    }

    private static void supprimerContact(ContactsManager contManager, String fileName) {
        Scanner sc1 = new Scanner(System.in);

        System.out.print("Nom du contact:\n");
        while (!sc1.hasNext()) {
            System.out.print("Inserer un nom!\n");
            sc1.next();
        }
        String nom = sc1.next();

        contManager.deleteContactByName(nom);
    }

    private static void modifierContact(ContactsManager contManager, String fileName) {
        Scanner sc1 = new Scanner(System.in);

        System.out.print("Nom du contact:\n");
        while (!sc1.hasNext()) {
            System.out.print("Inserer un nom!\n");
            sc1.next();
        }
        String nom = sc1.next();

        Contact cont = contManager.getContactByName(nom);

        System.out.print("Options:\n");
        System.out.print("1 - Modifier nom;\n");
        System.out.print("2 - Modifier email;\n");
        System.out.print("3 - Modifier phone;\n");
        while (!sc1.hasNextInt()) {
            System.out.println("That's not a number!");
            sc1.next();
        }

        int option = sc1.nextInt();

        switch (option) {
            case 1:
                System.out.print("Nouveau nom:\n");
                while (!sc1.hasNext()) {
                    System.out.print("Inserer un nom!\n");
                    sc1.next();
                }
                String nouveauNom = sc1.next();
                cont.setName(nouveauNom);
                break;
            case 2:
                System.out.print("Nouvel email:\n");
                while (!sc1.hasNext()) {
                    System.out.print("Inserer un email!\n");
                    sc1.next();
                }
                String nouvelEmail= sc1.next();
                cont.setMail(nouvelEmail);
                break;
            case 3:
                System.out.print("Nouveau phone:\n");
                while (!sc1.hasNext()) {
                    System.out.print("Inserer un phone!\n");
                    sc1.next();
                }
                String nouveauPhone= sc1.next();
                cont.setPhone(nouveauPhone);
                break;
            default:
                System.out.print("Option invalide.\n");
        }
    }

    private static void creerContact(ContactsManager contManager, String fileName) {
        Scanner sc1 = new Scanner(System.in);

        System.out.print("Nom du contact:\n");
        while (!sc1.hasNext()) {
            System.out.print("Inserer un nom!\n");
            sc1.next();
        }
        String nom = sc1.next();

        System.out.print("email du contact:\n");
        while (!sc1.hasNext()) {
            System.out.print("Inserer un email!\n");
            sc1.next();
        }
        String email = sc1.next();

        System.out.print("Phone du contact:\n");
        while (!sc1.hasNext()) {
            System.out.print("Inserer un phone!\n");
            sc1.next();
        }
        String phone = sc1.next();

        try {
            contManager.addContact(nom,email,phone);
            FileWriter fileWriter = null;

            try {
                fileWriter = new FileWriter(fileName);

                fileWriter.append(nom);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(email);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phone);
                fileWriter.append(NEW_LINE_SEPARATOR);

            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
            } finally {

                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
                }

            }

        } catch (InvalidContactNameException e) {
            e.printStackTrace();
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        }
    }

}
