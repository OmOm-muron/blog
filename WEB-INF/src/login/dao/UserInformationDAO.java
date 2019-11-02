
package login.dao;

import java.sql.*;

/**
 *ユーザー情報取得用DTO
 */
public class UserInformationDAO extends RootDAO {
    /**
     * ユーザーが存在するかどうかを判定する。
     */
    public boolean existsUser(String ex_userid, String ex_password) throws Exception {
        // SQLを宣言
        String sql = "SELECT users.userid\n"
                + "FROM users\n"
                + "INNER JOIN role ON users.roleid = role.roleid\n"
                + "WHERE users.userid = ?\n"
                + "AND users.password = ?\n"
                ;

        // PreparedStatementを取得、実行SQLを渡す。
        PreparedStatement in_statement = getPreparedStatement(sql);

        // iプレースホルダ―に値を入れる。
        in_statement.setString(1, ex_userid);
        in_statement.setString(2, ex_password);

        // SQLを実行して結果を取得する。
        ResultSet in_rs = in_statement.executeQuery();

        // i検索結果が存在すればtrueを返す。
        return in_rs.next();
    }
}