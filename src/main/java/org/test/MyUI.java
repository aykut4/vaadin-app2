package org.test;

import javax.servlet.annotation.WebServlet;

import com.vaadin.data.util.BeanItemContainer;
import org.test.*;
import com.vaadin.server.FontAwesome;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.util.List;

/**
 *
 */
@Theme("mytheme")
@Widgetset("org.test.MyAppWidgetset")
public class MyUI extends UI {

    final VerticalLayout layout = new VerticalLayout();
    private Grid grid =  new Grid();
    private BookForm bookForm = new BookForm(this, layout);

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        this.grid.setColumns("name", "author", "isbn");
        layout.addComponent(grid);

        HorizontalLayout main = new HorizontalLayout(grid, bookForm);
        main.setSpacing(true);
        main.setSizeFull();
        grid.setSizeFull();
        main.setExpandRatio(grid, 1);
        layout.addComponent(main);
        //Database db = bookForm.getDatabase();

        //HorizontalLayout main = new HorizontalLayout(grid);
        //main.setSizeFull();

        //HorizontalLayout form = new HorizontalLayout(bookForm);
        //form.setSizeFull();

        //this.grid.setSizeFull();

        //main.setExpandRatio(grid, 1);
        updateList();
        layout.setMargin(true);
        //layout.addComponents(main, form);
        //List<Book> list = db.getBooks();
        //BeanItemContainer<Book> mybooks = new BeanItemContainer<Book>(Book.class, list);
        //if(!db.getBooks().isEmpty()) grid.setContainerDataSource(mybooks);
        setContent(layout);
    }
    public void updateList () {
        List<Book> list = bookForm.getDatabase().getBooks();
        grid.setContainerDataSource(new BeanItemContainer<>(Book.class, list
        ));
    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
