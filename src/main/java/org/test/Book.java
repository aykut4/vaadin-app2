package org.test;

import java.io.Serializable;

public class Book implements Serializable {

    private String name;
    private String author;
    private String isbn;


    public Book (String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public String getName() {return name;}
    public String getAuthor() {return author;}
    public String  getIsbn() {return isbn;}

    public void setName(String name) {this.name = name;}
    public void setAuthor(String author) {this.author = author;}
    public void setIsbn(String isbn) {this.isbn = isbn;}

    public boolean isEqual (Book book) {
        if (this.isbn.equals(book.isbn)) return true;
        else return false;
    }
}
