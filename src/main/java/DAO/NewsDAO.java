package DAO;

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
    private final String INSERT_NEWS = "INSERT INTO news (id_category, tile_news, content , date_news,id_user, status_news, img) VALUES (?, ?, ?, ?, ?, ? ,?);";
    private final String SELECT_BY_ID = "select * from news where id_news = ?  ";
    private final String UPDATE_BY_ID = "update news set tile_news = ? , content = ? where id_news = ?;";
    private final String DELETE_BY_ID = "updte news set status_news = 0 where id_news = ? ";


    public NewsDAO(){
        connection = getConnection();
    }
    public List<News> selectAllNews() {
        List<News> news = new ArrayList<>();
        //sử dụng để thực thi các truy vấn được tham số hóa.
        String sql = "select * from user";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idNews = rs.getInt("id_news");
                int idCategory = rs.getInt("id_category");
                String tileNews = rs.getString("tile_news");
                String content = rs.getString("content");
                Date dateNews = rs.getDate("date_news");
                int idUser = rs.getInt("id_user");
                int statusNews = rs.getInt("status_news");
                news.add(new News(idNews, idCategory, tileNews, content, dateNews, idUser, statusNews));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return news;
    }
    public News selectNews(int idNews) {
        News news = null;
        return news;
    }
    public void insertNews(News news) throws SQLException {

    }
    public void updateNews(News news) throws SQLException {


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
