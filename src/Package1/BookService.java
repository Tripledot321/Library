package Package1;

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
        database.selectUsers(searchTerm);

        return new ArrayList<String>();
    }




}
