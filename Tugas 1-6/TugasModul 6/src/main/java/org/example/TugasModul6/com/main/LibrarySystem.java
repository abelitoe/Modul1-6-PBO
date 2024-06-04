package org.example.TugasModul6.com.main;

import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.TugasModul6.books.*;
import org.example.TugasModul6.data.Admin;
import org.example.TugasModul6.data.Student;

import java.util.ArrayList;

public class LibrarySystem {
    public static ArrayList<Book> daftarBuku = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static void startLibrarySystem(Stage stage) {
        daftarBuku.add(new StoryBook("1111", "Tsunami Trophy", 17, "Story", "Ten Hag"));
        daftarBuku.add(new HistoryBook("2222", "Mizone", 2, "History", "Brando"));
        daftarBuku.add(new TextBook("3333", "Kucing Hitam", 4, "Text", "Sang Hitam"));

        studentList.add(new Student("202310370311111", "Zhongli", "Teknik", "Roamer"));
        studentList.add(new Student("202310370322222", "Zilong", "Teknik", "Gold Lane"));
        studentList.add(new Student("202310370333333", "Zoy boy", "Teknik", "Hyper"));


        VBox root = new VBox(10);
        root.setStyle("-fx-background-color:#CCFFCC");
        Scene scene = new Scene(root, 400, 300);

        scene.setFill(Color.GRAY);

        Label label = new Label("===== Library System =====");

        root.setAlignment(Pos.CENTER);
        Button exitButton = new Button("Keluar");
        exitButton.setPrefWidth(200);
        exitButton.setPrefHeight(20);

        Button adminLoginButton = new Button("Login sebagai Admin");
        adminLoginButton.setPrefHeight(20);
        adminLoginButton.setPrefWidth(200);

        Button studentLoginButton = new Button("Login sebagai Mahasiswa");
        studentLoginButton.setPrefHeight(20);
        studentLoginButton.setPrefWidth(200);



        studentLoginButton.setOnAction(event -> studentLogin(stage));
        adminLoginButton.setOnAction(event -> {
            try {
                new Admin().login(stage);
            } catch (Exception e) {
                showErrorDialog("Error", e.getMessage());
            }
        });
        exitButton.setOnAction(event -> stage.close());

        root.getChildren().addAll(label, exitButton, studentLoginButton, adminLoginButton);

        stage.setScene(scene);
        stage.setTitle("Library System");
        stage.show();
    }

    private static void studentLogin(Stage stage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 400, 300);


        Label label = new Label("Masukkan NIM : ");
        TextField nimField = new TextField();
        Button loginButton = new Button("Login");
        Button backButton = new Button("Kembali");

        loginButton.setOnAction(event -> {
            String nimStudent = nimField.getText();
            if (nimStudent.length() == 15 && checkNim(nimStudent)) {
                Student student = new Student(nimStudent);
                student.login(stage);
            } else {
                showErrorDialog("Error", "Nim tidak terdaftar atau tidak valid!");
            }
        });

        backButton.setOnAction(event -> startLibrarySystem(stage));

        root.getChildren().addAll(label, nimField, loginButton, backButton);

        stage.setScene(scene);
    }

    private static void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
