package Package1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchHandler implements ActionListener {

    private SearchService _searchService;

    public SearchHandler(SearchService searchService) {
        this._searchService = searchService;
    }

    public void actionPerformed(ActionEvent event) {
        String searchTerm = event.getActionCommand();
        _searchService.findBooks(searchTerm);

    }
}