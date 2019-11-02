package blog.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

/**
 * @author Omura
 * DBとのConnectionを制御する。
 */
public class RootDAO implements AutoCloseable {
    private Connection connection = null;

    public RootDAO() {
    
    }

    /**
     * DBとのConnectionを取得する。
     * 既存のConnectionがある場合にはそれを利用する。
     */
    public Connection getConnection() throws NamingException, SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                // Connectionが存在しない、または既存Connectionがclose済みの時
                InitialContext initCtx = new InitialContext();
                DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/portfolio/blog");

             // DBConnectionを取得
                connection = ds.getConnection();
            }
        } catch (NamingException | SQLException e) {
            // connection = null にする
            connection = null;
            // 例外はそのまま出力
            e.printStackTrace();
            throw e;
        }
        return connection;
    }

    /**
     * Close Connection
     */
    public void close() {
        System.out.println("-----close connection-----");

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection = null;
        }
    }

    /**
     * PreparedStatementを取得する
     */
    public PreparedStatement getPreparedStatement(String sql) throws Exception {
        return getConnection().prepareStatement(sql);
    }

    /**
     * Commit Transaction
     */
    public void commit() throws SQLException {
        connection.commit();
    }

    /**
     * Rollback Transaction
     */
    public void rollback() throws SQLException {
        connection.rollback();
    }
}
