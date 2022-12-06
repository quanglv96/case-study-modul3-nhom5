package DAO;


import Model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final Connection connection;
    private final String SELECT_ALL_CATEGORY = "select * from category;";
    private final String SELECT_CATEGORY_BY_ID = "select * from category where id_category = ?;";
    private final String SELECT_COUNT_CATEGORY="select n.id_category,c.name_category,count(n.id_category) as count from news n, category c where n.id_category=c.id_category group by id_category;";
    public CategoryDAO() {
        connection = MyConnection.getConnection();
    }
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_category");
                String name = resultSet.getString("name_category");
                categories.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
    public Category findCategoryById(int id) {
        Category category = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name_category");
                System.out.println(name);
                category= new Category(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
    public List<Category> categoryCount(){
        List<Category> listCategory=new ArrayList();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNT_CATEGORY)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_category");
                String category = resultSet.getString("name_category");
                int count = resultSet.getInt("count");
                listCategory.add(new Category(id,category,count));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCategory;
    }

}
