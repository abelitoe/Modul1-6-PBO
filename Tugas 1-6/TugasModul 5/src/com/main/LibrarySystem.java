package com.main;

import com.data.*;
import exception.custom.illegalAdminAcces;
import java.util.Scanner;

public class LibrarySystem {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws illegalAdminAcces {
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login sebagai Student");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    student2 std = new student2();
                    std.menu();
                    break;
                case 2:
                    try{
                        admin.isAdmin(scanner);
                    } catch (illegalAdminAcces e){
                        System.out.println("Error : " + e.getMessage() + "\n");
                    }
                    break;
                case 3:
                    System.out.println("Adios!.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Input tidak valid \n");
            }
        }
    }
}
