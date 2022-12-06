package Model;

public class Category {
    protected int idCategory;
    protected String nameCategory;
    protected int countCategory;

    public Category(int idCategory, String nameCategory, int countCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.countCategory = countCategory;
    }

    public int getCountCategory() {
        return countCategory;
    }

    public void setCountCategory(int countCategory) {
        this.countCategory = countCategory;
    }

    public Category(int idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Category() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
