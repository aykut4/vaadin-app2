package org.test;


import java.util.*;

public class Database {

    private List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public boolean addBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isEqual(book)) {
                return false;
            }
        }
        books.add(book);
        return true;
    }

    public boolean removeBook (Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isEqual(book)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
}
