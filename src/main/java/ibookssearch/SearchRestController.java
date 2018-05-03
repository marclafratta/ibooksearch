package ibookssearch;

import ibookssearch.models.ITunesSearchItem;
import ibookssearch.models.ITunesSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchRestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/search/{searchTerm}", method = RequestMethod.GET)
    ITunesSearchResponse searchItunes(@PathVariable String searchTerm){
        System.out.println(searchTerm);
        String searchUrl = String.format("http://itunes.apple.com/search?term=%s&country=ca&media=ebook", searchTerm);
        System.out.println(searchUrl);
        return restTemplate.getForObject(searchUrl, ITunesSearchResponse.class);
    }
}
