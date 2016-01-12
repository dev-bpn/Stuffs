package mobotech.stuffs.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by prashantwosti on 2/20/2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Banner {

    @JsonProperty("title")
    private String bannerTitle;

    @JsonProperty("link")
    private String bannerUrl;

    public Banner(String bannerTitle , String bannerUrl) {
        this.bannerTitle = bannerTitle;
        this.bannerUrl = bannerUrl;
    }

    public Banner() {

    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

}
