package models;

import java.util.List;
import java.util.Map;


public class Show {
    private List<String> available_markets;
    private List<String> copyrights;
    private String description;
    private String html_description;
    private boolean explicit;
    private Map<String, String> external_urls;
    private String href;
    private String id;
    private List<Image> images;
    private boolean is_externally_hosted;
    private List<String> languages;
    private String media_type;
    private String name;
    private String publisher;
    private String type;
    private String uri;
    private int total_episodes;

    // Getters and Setters
    public List<String> getAvailable_markets() {
        return available_markets;
    }

    public void setAvailable_markets(List<String> available_markets) {
        this.available_markets = available_markets;
    }

    public List<String> getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(List<String> copyrights) {
        this.copyrights = copyrights;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtml_description() {
        return html_description;
    }

    public void setHtml_description(String html_description) {
        this.html_description = html_description;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public Map<String, String> getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(Map<String, String> external_urls) {
        this.external_urls = external_urls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public boolean isIs_externally_hosted() {
        return is_externally_hosted;
    }

    public void setIs_externally_hosted(boolean is_externally_hosted) {
        this.is_externally_hosted = is_externally_hosted;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getTotal_episodes() {
        return total_episodes;
    }

    public void setTotal_episodes(int total_episodes) {
        this.total_episodes = total_episodes;
    }
}
