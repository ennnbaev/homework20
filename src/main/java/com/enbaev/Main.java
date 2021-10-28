package com.enbaev;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookService user = new BookService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию : 1 - добавить автора; 2 - добавить книгу; 3 - найти книгу по автору ; " +
                    "4 - просмотреть авторов 5 - выход");
            int chose = scanner.nextInt();
            switch (chose) {
                case 1 -> {
                    System.out.print("Для добавления автора напишите имя и фамилию : ");
                    String firstname = scanner.next();
                    String lastname = scanner.next();
                    Author author = new Author(firstname, lastname);
                    user.addAuthor(author);
                }
                case 2 -> {
                    System.out.println("Для добавления книги напишите название книги, айди автора и количество страниц : ");
                    String title = scanner.next();
                    String authorId = scanner.next();
                    int pages = scanner.nextInt();
                    Book book = new Book(title, authorId, pages);
                    user.addBook(book);
                }
                case 3 -> {
                    System.out.println("Для поиска книги напишите имя и фамилию автора");
                    String firstnameAuthor = scanner.next();
                    String lastnameAuthor = scanner.next();
                    System.out.println(user.getBooksByAuthor(firstnameAuthor, lastnameAuthor));
                }
                case 4 -> user.printAuthor();

                case 5 -> {
                    return;
                }
                default -> System.out.println("Выбрана неправильная команда");
            }
        }
    }

}

