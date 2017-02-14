package squaring.vitrox.stylight.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty("available")
    private Boolean available;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("date")
    private String date;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("masterProductId")
    private Integer masterProductId;
    @JsonProperty("hasUnits")
    private Boolean hasUnits;
    @JsonProperty("url")
    private String url;
    @JsonProperty("shopLink")
    private String shopLink;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("savings")
    private Double savings;
    @JsonProperty("images")
    private List<Image> images = null;
    @JsonProperty("sale")
    private Boolean sale;
    @JsonProperty("shippingCost")
    private Integer shippingCost;
    @JsonProperty("checkoutId")
    private String checkoutId;
    @JsonProperty("vertical")
    private String vertical;

    @JsonProperty("available")
    public Boolean getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @JsonProperty("currency")
    public Currency getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("masterProductId")
    public Integer getMasterProductId() {
        return masterProductId;
    }

    @JsonProperty("masterProductId")
    public void setMasterProductId(Integer masterProductId) {
        this.masterProductId = masterProductId;
    }

    @JsonProperty("hasUnits")
    public Boolean getHasUnits() {
        return hasUnits;
    }

    @JsonProperty("hasUnits")
    public void setHasUnits(Boolean hasUnits) {
        this.hasUnits = hasUnits;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("shopLink")
    public String getShopLink() {
        return shopLink;
    }

    @JsonProperty("shopLink")
    public void setShopLink(String shopLink) {
        this.shopLink = shopLink;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("savings")
    public Double getSavings() {
        return savings;
    }

    @JsonProperty("savings")
    public void setSavings(Double savings) {
        this.savings = savings;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("sale")
    public Boolean getSale() {
        return sale;
    }

    @JsonProperty("sale")
    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    @JsonProperty("shippingCost")
    public Integer getShippingCost() {
        return shippingCost;
    }

    @JsonProperty("shippingCost")
    public void setShippingCost(Integer shippingCost) {
        this.shippingCost = shippingCost;
    }

    @JsonProperty("checkoutId")
    public String getCheckoutId() {
        return checkoutId;
    }

    @JsonProperty("checkoutId")
    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    @JsonProperty("vertical")
    public String getVertical() {
        return vertical;
    }

    @JsonProperty("vertical")
    public void setVertical(String vertical) {
        this.vertical = vertical;
    }


 public class Currency {

     @JsonProperty("id")
     private Integer id;
     @JsonProperty("name")
     private String name;
     @JsonProperty("symbol")
     private String symbol;

     @JsonProperty("id")
     public Integer getId() {
         return id;
     }

     @JsonProperty("id")
     public void setId(Integer id) {
         this.id = id;
     }

     @JsonProperty("name")
     public String getName() {
         return name;
     }

     @JsonProperty("name")
     public void setName(String name) {
         this.name = name;
     }

     @JsonProperty("symbol")
     public String getSymbol() {
         return symbol;
     }

     @JsonProperty("symbol")
     public void setSymbol(String symbol) {
         this.symbol = symbol;
     }
 }

}