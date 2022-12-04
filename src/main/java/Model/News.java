package Model;


import java.util.Date;

public class News {
    protected int idNews;
    protected Category category;   // khóa phụ
    protected String tileNews;
    protected String content;
    protected Date dateNews;
    protected User user;    // khóa phụ
    protected int statusNews = 1;
    protected String img;

    public News(int idNews, Category category, String tileNews, String content, Date dateNews, User user, int statusNews) {
        this.idNews = idNews;
        this.category = category;
        this.tileNews = tileNews;
        this.content = content;
        this.dateNews = dateNews;
        this.user = user;
        this.statusNews = statusNews;
    }

    public News(Category category, String tileNews, String content, Date dateNews, User user, int statusNews, String img) {
        this.category = category;
        this.tileNews = tileNews;
        this.content = content;
        this.dateNews = dateNews;
        this.user = user;
        this.statusNews = statusNews;
        this.img = img;
    }

    public News(int idNews, Category category, String tileNews, String content, Date dateNews, User user, int statusNews, String img) {
        this.idNews = idNews;
        this.category = category;
        this.tileNews = tileNews;
        this.content = content;
        this.dateNews = dateNews;
        this.user = user;
        this.statusNews = statusNews;
        this.img = img;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTileNews() {
        return tileNews;
    }

    public void setTileNews(String tileNews) {
        this.tileNews = tileNews;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateNews() {
        return dateNews;
    }

    public void setDateNews(Date dateNews) {
        this.dateNews = dateNews;
    }

    public User getUser() {
        return user;
    }

    public void setIdUser(User user) {
        this.user = user;
    }

    public int getStatusNews() {
        return statusNews;
    }

    public void setStatusNews(int statusNews) {
        this.statusNews = statusNews;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
