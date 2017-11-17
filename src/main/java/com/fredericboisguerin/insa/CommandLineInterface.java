package com.fredericboisguerin.insa;

import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CommandLineInterface {


    public void main() {
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
                    creerContact(contManager);
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

    public void creerContact(ContactsManager contManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom du contact:\n");
        String nom = scanner.nextLine();

        System.out.print("email du contact:\n");
        String email = scanner.nextLine();

        System.out.print("Phone du contact:\n");
        String phone = scanner.nextLine();

        try {
            contManager.addContact(nom,email,phone);

        } catch (InvalidContactNameException e) {
            e.printStackTrace();
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        }
    }

}
