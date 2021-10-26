package com.enbaev;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    public void addBook(Book exampleBook) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
        Statement statement = connection.createStatement();
        String execute = "insert into BookBase (id,title,authorId,pagesCount) VALUES (" + "'" + exampleBook.id + "'"
                + "," + "'" + exampleBook.title + "'" + "," +
                "" + "'" + exampleBook.authorId + "'" + ","
                + exampleBook.pagesCount + ")";
        statement.execute(execute);
    }

    public void addAuthor(Author exampleAuthor) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
        Statement statement = connection.createStatement();
        String execute = "insert into AuthorBase (id, firstName,lastName) VALUES (" +
                "'" + exampleAuthor.id + "'" +
                "," + "'" + exampleAuthor.firstName + "'" + "," +
                "'" + exampleAuthor.lastName + "'" + ")";
        statement.execute(execute);
    }

    public static List<String> getBooksByAuthor(String firstName, String lastname) throws SQLException {
        List<String> resultOfFind = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from BookBase JOIN AuthorBase ON AuthorBase.id=BookBase.authorId WHERE firstName=" +
                "'" + firstName + "'" + " and  lastName=" + "'" + lastname + "'");
        while (resultSet.next()) {
            resultOfFind.add(resultSet.getString(2) + " pages : " + resultSet.getInt(4));
        }
        return resultOfFind;
    }
}
