package Package1;

import javax.swing.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private DatabaseConn database;
    public BookService(DatabaseConn database){
        this.database = database;
    }

    public List<String> findBooks(String searchTerm){

        System.out.println("Search service was requested to find books with search term '"+searchTerm+"'");

        database.getBooks(searchTerm);
        List<String> searchResults = database.selectBooks(searchTerm);

        return searchResults;

    }

    public void updateBook(String isbn, String bookPublisher, String bookCategory, String title, String yearOfPublication, String classification, String removeBook, String editBook){

        System.out.println("Book update service was requested");

        //testa ifall checkboxen "remove user" är ikryssad
        if(removeBook.equalsIgnoreCase("remove")){
            database.removeBook(isbn);
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Item "+isbn+" was deleted from database");
        }
        else if(editBook.equalsIgnoreCase("edit")){
            database.updateBook(isbn, bookPublisher, bookCategory, title, yearOfPublication, classification);
            JFrame f3 = new JFrame();
            JOptionPane.showMessageDialog(f3, "Item "+isbn+" was UPDATED in the database");
        }
        else {
            database.addBook(isbn, bookPublisher, bookCategory, title, yearOfPublication, classification);
            JFrame f2 = new JFrame();
            JOptionPane.showMessageDialog(f2, "Item was added to database");
        }
    }


}
