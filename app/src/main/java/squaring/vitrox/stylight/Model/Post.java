package squaring.vitrox.stylight.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Post implements RecyclerObject{

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("teaserImage")
    private String teaserImage;

    public String getTeaserImage() {
        return teaserImage;
    }

    public void setTeaserImage(String teaserImage) {
        this.teaserImage = teaserImage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public class Category {

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("color")
        private String color;
        @JsonProperty("slug")
        private String slug;
        @JsonProperty("description")
        private String description;

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

        @JsonProperty("color")
        public String getColor() {
            return color;
        }

        @JsonProperty("color")
        public void setColor(String color) {
            this.color = color;
        }

        @JsonProperty("slug")
        public String getSlug() {
            return slug;
        }

        @JsonProperty("slug")
        public void setSlug(String slug) {
            this.slug = slug;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

    }
}
