package com.enbaev;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    final public String pathToJDDBC = "jdbc:postgresql://localhost:5432/postgres";

    public void addBook(Book exampleBook) {
        String execute = "insert into BookBase (id,title,authorId,pagesCount) VALUES (" + "'" + exampleBook.id + "'"
                + "," + "'" + exampleBook.title + "'" + "," +
                "" + "'" + exampleBook.authorId + "'" + ","
                + exampleBook.pagesCount + ")";
        try (Connection connection = DriverManager.getConnection(pathToJDDBC);
             PreparedStatement statement = connection.prepareStatement(execute)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addAuthor(Author exampleAuthor) {
        String execute = "insert into AuthorBase (id, firstName,lastName) VALUES (" +
                "'" + exampleAuthor.id + "'" +
                "," + "'" + exampleAuthor.firstName + "'" + "," +
                "'" + exampleAuthor.lastName + "'" + ")";
        try (Connection connection = DriverManager.getConnection(pathToJDDBC);
             PreparedStatement statement = connection.prepareStatement(execute)) {
            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void printAuthor() {
        try (Connection connection = DriverManager.getConnection(pathToJDDBC);
             PreparedStatement statement = connection.prepareStatement("select *from AuthorBase");
             ResultSet resultOfAuthor = statement.executeQuery()) {
            while (resultOfAuthor.next()) {
                String id = resultOfAuthor.getString(1);
                String firstName = resultOfAuthor.getString(2);
                String lastName = resultOfAuthor.getString(3);
                System.out.println(id + " " + firstName + " " + lastName);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public List<Book> getBooksByAuthor(String firstName, String lastname) {
        try (Connection connection = DriverManager.getConnection(pathToJDDBC);
             PreparedStatement statement = connection.prepareStatement("SELECT * from BookBase JOIN AuthorBase " +
                     "ON AuthorBase.id=BookBase.authorId WHERE firstName=" +
                     "'" + firstName + "'" + " and  lastName=" + "'" + lastname + "'");
             ResultSet resultSet = statement.executeQuery()) {
            List<Book> resultOfFind = new ArrayList<>();
            while (resultSet.next()) {
                String idBook = resultSet.getString(1);
                String titleBook = resultSet.getString(2);
                String authorIdBook = resultSet.getString(3);
                int pagesBook = resultSet.getInt(4);
                resultOfFind.add(new Book(idBook, titleBook, authorIdBook, pagesBook));
            }
            return resultOfFind;
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            return null;
        }
    }
}
