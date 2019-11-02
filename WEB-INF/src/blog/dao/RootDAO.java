package blog.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

/**
 * @author Omura
 * DBとのConnectionを制御する。
 */
public class RootDAO implements AutoCloseable {
    private Connection co_connection = null;

    public RootDAO() {
    
    }

    /**
     * DBとのConnectionを取得する。
     * 既存のConnectionがある場合にはそれを利用する。
     */
    public Connection getConnection() throws NamingException, SQLException {
        try {
            if (co_connection == null || co_connection.isClosed()) {
                // Connectionが存在しない、または既存Connectionがclose済みの時
                InitialContext in_initCtx = new InitialContext();
                DataSource in_ds = (DataSource) in_initCtx.lookup("java:comp/env/jdbc/portfolio/blog");

             // DBConnectionを取得
                co_connection = in_ds.getConnection();
            }
        } catch (NamingException | SQLException e) {
            // connection = null にする
            co_connection = null;
            // 例外はそのまま出力
            e.printStackTrace();
            throw e;
        }
        return co_connection;
    }

    /**
     * Close Connection
     */
    public void close() {
        System.out.println("-----close connection-----");

        try {
            co_connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            co_connection = null;
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
        co_connection.commit();
    }

    /**
     * Rollback Transaction
     */
    public void rollback() throws SQLException {
        co_connection.rollback();
    }
}
