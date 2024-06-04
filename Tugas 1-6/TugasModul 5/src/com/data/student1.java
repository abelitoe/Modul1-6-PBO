package com.data;

import com.book.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class student1 extends user{

    public static ArrayList<student1> students = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    private String name;
    private String faculty;
    private String nim;
    private String program;

    public student1(String name, String faculty, String nim, String program) {
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }


    public static void setBooks(ArrayList<Book> booksList) {
        books = booksList;
    }

    public static void setStudents(ArrayList<student1> studentsList) {
        students = studentsList;
    }

    public static student1 findStudent(String nim) {
        for (student1 s : students) {
            if (s.getNim().equals(nim)) {
                return s;
            }
        }
        return null;
    }

    public void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println();
            System.out.println("Anda belum meminjam buku apapun.");
            return;
        }
        System.out.println();
        System.out.println("=========================== Buku Terpinjam =============================");
        System.out.printf("%-10s %-20s %-20s %-10s %-10s\n", "ID", "Judul", "Penulis", "Stok", "Durasi");
        for (Book book : borrowedBooks) {
            System.out.printf("%-10s %-20s %-20s %-10d %-10s\n", book.getId(), book.getTitle(), book.getAuthor(), book.getStock(), book.getDuration());
        }
        System.out.println();
    }

    public void choiceBook(ArrayList<Book> books, Scanner scanner) {
        user.booksList();
        System.out.print("Masukkan ID buku yang ingin dipinjam: ");
        String id = scanner.next();

        if (id.isEmpty()) {
            System.out.println("ID buku tidak boleh kosong. Kembali ke menu mahasiswa...");
            return;
        }

        Book book = null;
        for (Book b : books) {
            if (b.getId().equals(id)) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Buku tidak ditemukan. Kembali ke menu mahasiswa...");
            return;
        }

        if (book.getStock() > 0) {
            System.out.print("Masukkan durasi peminjaman (maksimal 14 hari): ");
            int duration = scanner.nextInt();

            if (duration <= 0 || duration > 14) {
                System.out.println("Durasi peminjaman tidak valid. Kembali ke menu mahasiswa...");
            }

            book.setDuration(duration);

            borrowedBooks.add(book);
            book.setStock(book.getStock() - 1);
            System.out.println("Buku berhasil dipinjam!\n");
        } else {
            System.out.println("Maaf, stok buku habis.\n");
        }
    }
    public void returnBook(ArrayList<Book> books, Scanner scanner) {
        if (borrowedBooks.isEmpty()) {
            System.out.println("Anda belum meminjam buku apapun untuk dikembalikan.");
            return;
        }

        viewBorrowedBooks();

        System.out.print("Masukkan ID buku yang ingin dikembalikan: ");
        String id = scanner.next();

        Book bookToReturn = null;
        for (Book book : borrowedBooks) {
            if (book.getId().equals(id)) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("Buku dengan ID tersebut tidak ditemukan di daftar peminjaman Anda.");
            return;
        }

        for (Book book : user.books) {
            if (book.getId().equals(bookToReturn.getId())) {
                book.setStock(book.getStock() + 1);
                break;
            }
        }

        borrowedBooks.remove(bookToReturn);
        System.out.println("Buku berhasil dikembalikan. Terima kasih!");
    }

}

