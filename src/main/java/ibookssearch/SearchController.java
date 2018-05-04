package ibookssearch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Controller
public class SearchController {

    @GetMapping("/")
    public String searchPage(Map<String, Object> model) {
        return "search";
    }

}
