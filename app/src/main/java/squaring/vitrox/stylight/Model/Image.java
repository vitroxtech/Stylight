package squaring.vitrox.stylight.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

    @JsonProperty("url")
    private String url;
    @JsonProperty("primary")
    private Boolean primary;
    @JsonProperty("key")
    private String key;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("primary")
    public Boolean getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

}