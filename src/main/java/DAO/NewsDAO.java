package DAO;

import Model.Category;
import Model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static DAO.MyConnection.getConnection;

public class NewsDAO {
    private final Connection connection;
    private final String SELECT_ALL_NEWS = "select * from news;";
    private final String INSERT_NEWS = "INSERT INTO news (id_category, tile_news, content , date_news ,id_user, status_news, img) VALUES (?, ?, ?, ?, ?, ? ,?);";
    private final String SELECT_BY_ID = "select * from news where id_news = ?  ";
    private final String UPDATE_BY_ID = "update news set tile_news = ? , content = ?, date_news = ?, img = ? where id_news = ?;";
    private final String DELETE_BY_ID = "updte news set status_news = 0 where id_news = ? ";
    private Category category;
    private News news;



    public NewsDAO() {
        NewsDAO newsDAO = new NewsDAO();
        connection = getConnection();
    }

    private UserDAO userDAO;
    private CategoryDAO categoryDAO;


    public NewsDAO() {
        connection = MyConnection.getConnection();
        category=new Category();
        userDAO=new UserDAO();
        categoryDAO=new CategoryDAO();

    }

    public List<News> selectAllNews() {
        List<News> news = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NEWS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idNews = rs.getInt("id_news");
                int idCategory = rs.getInt("id_category");
                String tileNews = rs.getString("tile_news");
                String content = rs.getString("content");
                Date dateNews = rs.getDate("date_news");
                int idUser = rs.getInt("id_user");
                int statusNews = rs.getInt("status_news");
                String img = rs.getString("img");
                news.add(new News(idNews, idCategory, tileNews, content, dateNews, idUser, statusNews, img));
                news.add(new News(idNews, categoryDAO.findCategoryById(idCategory), tileNews, content, dateNews, userDAO.findUserById(idUser), statusNews,img));

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return news;
    }

    public News selectNews(int idNews) {
        News news = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, idNews);
            ResultSet rs = preparedStatement.executeQuery();
            // duyệt bản ghi result
            while (rs.next()) {
                int idCategory = rs.getInt("id_category");
                String tileNews = rs.getString("tile_news");
                String content = rs.getString("content");
                Date dateNews = rs.getDate("date_news");
                int idUser = rs.getInt("id_user");
                int statusNews = rs.getInt("status_news");
                String img = rs.getString("img");
                news = new News(idCategory, tileNews, content, dateNews, idUser, statusNews, img);
                news = new News(categoryDAO.findCategoryById(idCategory), tileNews, content, dateNews, userDAO.findUserById(idUser), statusNews,img );

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return news;
    }

    public void insertNews(News news) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEWS)) {
            preparedStatement.setInt(1, news.getCategory().getIdCategory());
            preparedStatement.setString(2, news.getTileNews());
            preparedStatement.setString(3, news.getContent());
            preparedStatement.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.setInt(5, news.getUser().getIdUser());
            preparedStatement.setInt(6, news.getStatusNews());
            preparedStatement.setString(7, news.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    //
    public void updateNews(News news) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID);) {
            statement.setString(1, news.getTileNews());
            statement.setString(2, news.getContent());
            statement.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            statement.setString(4, news.getImg());
            statement.setInt(5, news.getIdNews());
            statement.executeUpdate();
        }
    }

    public void deleteNews(int idNews) throws SQLException {

    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
