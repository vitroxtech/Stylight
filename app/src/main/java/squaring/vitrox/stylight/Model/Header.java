package squaring.vitrox.stylight.Model;

public class Header implements RecyclerObject {

    private String Title;
    private String SubTitle;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Header(String title, String subtitle) {
        Title = title;
        SubTitle = subtitle;
    }

    public String getSubTitle() {
        return SubTitle;
    }

    public void setSubTitle(String subTitle) {
        SubTitle = subTitle;
    }
}
