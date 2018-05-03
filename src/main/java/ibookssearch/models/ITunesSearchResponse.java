package ibookssearch.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ITunesSearchResponse {

    private static final String ENDPOINT_TEMPLATE = "http://itunes.apple.com/search?term=%s&country=ca&media=ebook";

    public ITunesSearchResponse(){
        //for json
    }

    private int resultCount;

    private List<ITunesSearchItem> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<ITunesSearchItem> getResults() {
        return results;
    }

    public void setItems(List<ITunesSearchItem> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ITunesSearchResponse{" +
                "resultCount=" + resultCount +
                ", results=" + results +
                '}';
    }

    public static ITunesSearchResponse getResponse(String searchTerm, RestTemplate restTemplate){
        String completeEndpoint = String.format(ENDPOINT_TEMPLATE, searchTerm);

        return restTemplate.getForObject(completeEndpoint, ITunesSearchResponse.class);
    }
}
