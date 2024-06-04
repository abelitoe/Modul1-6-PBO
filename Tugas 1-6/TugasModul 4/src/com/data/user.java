package com.data;

import com.book.Book;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class user {

    public static Scanner scanner = new Scanner (System.in);
    public static ArrayList<Book> books = new ArrayList<>();
    static {
        books.add(new Book("111", "Pluto Projector", "ROC", "History", 3));
        books.add(new Book("222", "Manchaster United", "TenHag", "Story", 2));
        books.add(new Book("333", "Sympson", "Todi", "Text", 3));
    }

    public static ArrayList<Book> booksList(){
        student1.setBooks(books);
        System.out.println();
        System.out.println("======================= Daftar Buku di Perpustakaan =====================");
        System.out.printf("%-10s %-20s %-20s %-15s %-10s\n", "ID", "Judul", "Penulis", "Kategori", "Stok");
        for (Book book : books) {
            System.out.printf("%-10s %-20s %-20s %-15s %-10d\n", book.getId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getStock());
        }
        System.out.println();

        return books;
    }

    public static void addBook() {
        System.out.println();
        System.out.println("===== Tambah Buku Baru =====");
        System.out.print("Masukkan ID buku: ");
        String id = scanner.next();
        scanner.nextLine();
        System.out.print("Masukkan judul buku: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan nama penulis: ");
        String author = scanner.nextLine();
        System.out.print("Masukkan kategori buku: ");
        String category = scanner.nextLine();
        System.out.print("Masukkan stok buku: ");
        int stock = scanner.nextInt();

        Book newBook = new Book(id, title, author, category, stock);
        user.books.add(newBook);
        System.out.println("Buku berhasil ditambahkan!");
    }


}
