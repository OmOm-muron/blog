
package login.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

/**
 * @author Omura
 * DB�Ƃ�Connection�𐧌䂷��B
 */
public class RootDAO implements AutoCloseable {
    private Connection connection = null;

    public RootDAO() {

    }

    /**
     * DB�Ƃ�Connection���擾����B
     * ����Connection������ꍇ�ɂ͂���𗘗p����B
     */
    public Connection getConnection() throws NamingException, SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                // Connection�����݂��Ȃ��A�܂��͊���Connection��close�ς݂̎�
                InitialContext initCtx = new InitialContext();
                DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/portfolio/common");

                // DBConnection���擾
                connection = ds.getConnection();
            }
        } catch (NamingException | SQLException e) {
            // connection = null �ɂ���
            connection = null;
            // ��O�͂��̂܂܏o��
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
     * PreparedStatement���擾����B
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