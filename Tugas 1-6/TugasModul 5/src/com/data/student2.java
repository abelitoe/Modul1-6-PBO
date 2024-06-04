package com.data;

import com.util.iMenu;
import static com.data.student1.findStudent;

public class student2 extends user implements iMenu{
    @Override
    public void menu() {
        System.out.println("\n=============== Student Menu =================");
        System.out.print("Masukkan NIM Anda (masukkan 99 untuk kembali): ");
        String nim = scanner.next();

        if (nim.equals("99")) {
            System.out.println("Kembali ke menu utama...");
            return;
        }

        student1 student = findStudent(nim);

        if (student == null) {
            System.out.println("Mahasiswa tidak ditemukan. Kembali ke menu utama...\n");
            return;
        }

        System.out.println("1. Buku Terpinjam");
        System.out.println("2. Tampilkan dan Pinjam Buku ");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi (1-4): ");

        try{
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:

                    student.viewBorrowedBooks();
                    break;
                case 2:
                    student.choiceBook(books, scanner);
                    break;
                case 3:
                    student.returnBook(books, scanner);
                    break;
                case 4:
                    System.out.println("Keluar dari akun mahasiswa...\n");
                    return;
                default:
                     System.out.println("Input tidak valid. Silakan coba lagi.\n");
                }
            } catch (Exception e){
                System.out.println("Inputan hanya berupa angka masseh...!\n");
            }


    }
}
