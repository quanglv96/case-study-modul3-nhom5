package Model;


import java.util.Date;

public class News {
    protected int idNews;
    protected int idCategory;   // khóa phụ
    protected String tileNews;
    protected String content;
    protected Date dateNews;
    protected int idUser;    // khóa phụ
    protected int statusNews = 0;
    protected String img;

    public News(int idNews, int idCategory, String tileNews, String content, Date dateNews, int idUser, int statusNews) {
        this.idNews = idNews;
        this.idCategory = idCategory;
        this.tileNews = tileNews;
        this.content = content;
        this.dateNews = dateNews;
        this.idUser = idUser;
        this.statusNews = statusNews;
        this.img = img;
    }

    public News(int idCategory, String tileNews, String content, Date dateNews, int idUser, int statusNews, String img) {
        this.idCategory = idCategory;
        this.tileNews = tileNews;
        this.content = content;
        this.dateNews = dateNews;
        this.idUser = idUser;
        this.statusNews = statusNews;
        this.img = img;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
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

    public void getDateNews() {
        return dateNews;
    }

    public void setDateNews(Date dateNews) {
        this.dateNews = dateNews;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
