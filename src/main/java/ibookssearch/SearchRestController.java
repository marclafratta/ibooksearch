package ibookssearch;

import ibookssearch.models.ITunesSearchResponse;
import ibookssearch.models.SearchItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class SearchRestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/search/{searchTerm}", method = RequestMethod.GET)
    List<SearchItem> searchItunes(@PathVariable String searchTerm){
        ITunesSearchResponse iTunesResponse = ITunesSearchResponse.getResponse(searchTerm, restTemplate);
        return SearchItem.transformFromItunes(iTunesResponse);
    }
}
