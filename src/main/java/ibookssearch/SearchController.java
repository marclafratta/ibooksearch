package ibookssearch;


import java.util.Date;
import java.util.Map;

import ibookssearch.models.ITunesSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class SearchController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/searchpage")
    public String welcome(Map<String, Object> model) {

        Quote quote = restTemplate.getForObject(
        "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

        ITunesSearchResponse searchResponse = restTemplate.getForObject("http://itunes.apple.com/search?term=Aubrey+Marcus&country=ca&media=ebook",
                ITunesSearchResponse.class);

        System.out.println(quote);

        System.out.println(searchResponse);

        model.put("quote", quote.getValue().getQuote());
        //model.put("quote", "testquote");
        model.put("time", new Date());
        model.put("message", this.message);

        model.put("searchResponse", searchResponse);

        return "hello";
    }

}
