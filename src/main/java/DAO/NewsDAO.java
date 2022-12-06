package DAO;

import Model.Category;
import Model.News;

import javax.servlet.ServletException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static DAO.MyConnection.getConnection;

public class NewsDAO {
    private final Connection connection;
    private final String SELECT_ALL_NEWS = "select * from news where status_news=1 order by id_news;";
    private final String INSERT_NEWS = "INSERT INTO news (id_category, tile_news, content , date_news ,id_user, status_news, img) VALUES (?, ?, ?, ?, ?, ? ,?);";
    private final String SELECT_BY_ID = "select * from news where id_news = ? and status_news=1 order by id_news";
    private final String UPDATE_BY_ID = "update news set tile_news = ? , content = ?, date_news = ?, img = ? where id_news = ?;";
    private final String SELECT_BY_CATEGORY = "select * from news where id_category in (select id_category from category where name_category=?);";
    private final String DELETE_BY_ID = "update news set status_news = 0 where id_news = ? ";
    private final String SELECT_BY_USERS = "select * from news where status_news= 1 and id_user=?;";
    private final String SELECT_BY_LIKE="select *from news where tile_news like ?;";

    private Category category;
    private News news;
    private UserDAO userDAO;
    private CategoryDAO categoryDAO;

    public NewsDAO() {
        connection = MyConnection.getConnection();
        category = new Category();
        userDAO = new UserDAO();
        categoryDAO = new CategoryDAO();
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
               LocalDate dateNews = rs.getDate("date_news").toLocalDate();
                int idUser = rs.getInt("id_user");
                int statusNews = rs.getInt("status_news");
                String img = rs.getString("img");
                Category category1 = categoryDAO.findCategoryById(idCategory);
                System.out.println(category1.getNameCategory());
                news.add(new News(idNews, categoryDAO.findCategoryById(idCategory), tileNews, content, dateNews, userDAO.findUserById(idUser), statusNews, img));
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
            while (rs.next()) {
                int idCategory = rs.getInt("id_category");
                String tileNews = rs.getString("tile_news");
                String content = rs.getString("content");
                LocalDate dateNews = rs.getDate("date_news").toLocalDate();
                int idUser = rs.getInt("id_user");
                int statusNews = rs.getInt("status_news");
                String img = rs.getString("img");
                news = new News(categoryDAO.findCategoryById(idCategory), tileNews, content, dateNews, userDAO.findUserById(idUser), statusNews, img);
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
            preparedStatement.setDate(4, Date.valueOf(news.getDateNews()));
            preparedStatement.setInt(5, news.getUser().getIdUser());
            preparedStatement.setInt(6, news.getStatusNews());
            preparedStatement.setString(7, news.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void updateNews(News news) throws SQLException, ServletException {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID);) {
            statement.setString(1, news.getTileNews());
            statement.setString(2, news.getContent());
            statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            System.out.println(java.sql.Date.valueOf(LocalDate.now()));
            statement.setString(4, news.getImg());
            statement.setInt(5, news.getIdNews());
            statement.executeUpdate();
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public boolean deleteNews(int idNews) throws SQLException {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, idNews);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    public List<News> selectNewsByCategory(String category) {
        List<News> listNews = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CATEGORY)) {
            preparedStatement.setString(1, category);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idNews = rs.getInt("id_news");
                int idCategory = rs.getInt("id_category");
                String tileNews = rs.getString("tile_news");
                String content = rs.getString("content");
                LocalDate dateNews = rs.getDate("date_news").toLocalDate();
                int idUser = rs.getInt("id_user");
                int statusNews = rs.getInt("status_news");
                String img = rs.getString("img");
                Category category1 = categoryDAO.findCategoryById(idCategory);
                System.out.println(category1.getNameCategory());
                listNews.add(new News(idNews, categoryDAO.findCategoryById(idCategory), tileNews, content, dateNews, userDAO.findUserById(idUser), statusNews, img));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listNews;
    }
    public List<News> selectNewsByIdUser(int id) {
        List<News> listNews = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USERS) ){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idNews = rs.getInt("id_news");
                int idCategory = rs.getInt("id_category");
                String tileNews = rs.getString("tile_news");
                String content = rs.getString("content");
                LocalDate dateNews = rs.getDate("date_news").toLocalDate();
                int idUser = rs.getInt("id_user");
                int statusNews = rs.getInt("status_news");
                String img = rs.getString("img");
                Category category1 = categoryDAO.findCategoryById(idCategory);
                System.out.println(category1.getNameCategory());
                listNews.add(new News(idNews, categoryDAO.findCategoryById(idCategory), tileNews, content, dateNews, userDAO.findUserById(idUser), statusNews, img));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listNews;
    }
    public List<News> selectNewsTiles(String text) {
        List<News> listNews = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_LIKE) ){
            preparedStatement.setString(1, text);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idNews = rs.getInt("id_news");
                int idCategory = rs.getInt("id_category");
                String tileNews = rs.getString("tile_news");
                String content = rs.getString("content");
                LocalDate dateNews = rs.getDate("date_news").toLocalDate();
                int idUser = rs.getInt("id_user");
                int statusNews = rs.getInt("status_news");
                String img = rs.getString("img");
                Category category1 = categoryDAO.findCategoryById(idCategory);
                System.out.println(category1.getNameCategory());
                listNews.add(new News(idNews, categoryDAO.findCategoryById(idCategory), tileNews, content, dateNews, userDAO.findUserById(idUser), statusNews, img));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listNews;
    }
}