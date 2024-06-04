package com.data;

import com.util.iMenu;
import java.util.Scanner;

public class admin extends user implements iMenu{

    @Override
    public void menu(){
        System.out.println("======== Admin Menu ========");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tampilkan Mahasiswa Terdaftar");
        System.out.println("3. Tambahkan Buku");
        System.out.println("4. Tampilkan buku yang tersedia");

        System.out.println("5. Keluar");
        System.out.print("Pilih opsi (1-5): ");
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                admin.addStudent();
                break;
            case 2:
                admin.displayRegisteredStudents();
                break;
            case 3:
                user.addBook();
                break;
            case 4:
                user.booksList();
                break;
            case 5:
                System.out.println("Keluar");
                break;
            default:
                System.out.println("Input tidak valid. Silakan coba lagi.");
        }
    }

    static String ADMIN_USERNAME = "admin";
    static String ADMIN_PASSWORD = "admin";

    public static void loginAsAdmin(Scanner scanner) {
        System.out.println();
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password : ");
        String password = scanner.next();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Succesfull Login as Admin\n");
            admin adm = new admin();
            adm.menu();
        } else {
            System.out.println("Admin User Not Found");
        }
        System.out.println();
    }

    public static void addStudent() {
        System.out.println();
        System.out.print("Masukkan nama mahasiswa: ");
        String name = scanner.next();
        System.out.print("Masukkan fakultas mahasiswa: ");
        String faculty = scanner.next();
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.next();
        System.out.print("Masukkan program studi mahasiswa: ");
        String program = scanner.next();

        student1.students.add(new student1(name, faculty, nim, program));
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    public static void displayRegisteredStudents() {
        System.out.println();
        System.out.println("============================ Mahasiswa Terdaftar =============================");
        System.out.printf("%-20s %-20s %-25s %-30s\n", "Nama", "Fakultas", "NIM", "Program Studi");
        for (student1 student : student1.students) {
            System.out.printf("%-20s %-20s %-25s %-30s\n", student.getName(), student.getFaculty(), student.getNim(), student.getProgram());
            System.out.println("\n");
        }
    }
}


