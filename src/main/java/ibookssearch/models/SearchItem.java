package ibookssearch.models;

import java.util.ArrayList;
import java.util.List;

public class SearchItem {
    private String title;
    private String artworkUrl;
    private String buyUrl;
    private String author;
    private String genre;
    private String publishDate;
    private String price;
    private String description;

    public SearchItem(ITunesSearchItem itunesItem){
        this.title = itunesItem.getTrackName();
        this.artworkUrl = itunesItem.getArtworkUrl100();
        this.buyUrl = itunesItem.getTrackViewUrl();
        this.author = itunesItem.getArtistName();
        this.genre = itunesItem.getGenres().get(0);
        this.publishDate = itunesItem.getReleaseDate();
        this.price = itunesItem.getFormattedPrice();
        this.description = itunesItem.getDescription();

        //artworkUrl = artworkUrl.substring(0, artworkUrl.lastIndexOf("/") + 1);
        //artworkUrl += "250x250bb.jpg";

    }

    public static List<SearchItem> transformFromItunes(ITunesSearchResponse searchResponse){
        ArrayList<SearchItem> searchItems = new ArrayList<>();

        for (ITunesSearchItem itunesItem : searchResponse.getResults()){
            searchItems.add(new SearchItem(itunesItem));
        }

        return searchItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public void setArtworkUrl(String imageUrl) {
        this.artworkUrl = imageUrl;
    }

    public String getBuyUrl() {
        return buyUrl;
    }

    public void setBuyUrl(String buyUrl) {
        this.buyUrl = buyUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SearchItem{" +
                "title='" + title + '\'' +
                ", artworkUrl='" + artworkUrl + '\'' +
                ", buyUrl='" + buyUrl + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
