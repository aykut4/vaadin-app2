package org.test;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.*;
import com.vaadin.ui.declarative.FieldBinder;
import org.test.*;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.data.util.*;
import com.vaadin.*;

import java.util.List;

public class BookForm  extends FormLayout {

    private TextField name = new TextField("Name");
    private TextField author = new TextField("Author");
    private TextField isbn = new TextField("ISBN");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Database database = new Database();
    private FieldGroup binder = new FieldGroup();
    private Book book;
    private MyUI myUI;


    public BookForm (MyUI myUI, VerticalLayout layout) {

        this.myUI = myUI;

        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        layout.addComponents(name, author, isbn, buttons);

        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(KeyCode.ENTER);

        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());
    }

    Database getDatabase() {
        return database;
    }

    private void delete () {
        Book book = new Book(name.getValue(), author.getValue(), isbn.getValue());
        database.removeBook(book);
        //List<Book> list = database.getBooks();
        //BeanItemContainer<Book> mybooks = new BeanItemContainer<Book>(Book.class, list);
        myUI.updateList();
    }
    private void save () {
        Book book = new Book(name.getValue(), author.getValue(), isbn.getValue());
        database.addBook(book);
        //List<Book> list = database.getBooks();
        //BeanItemContainer<Book> mybooks = new BeanItemContainer<Book>(Book.class, list);
        myUI.updateList();
    }
}
