
package login.dao;

import java.sql.*;

/**
 * @author Omura
 * ユーザー情報取得用のDTO
 */
public class UserInformationDAO extends RootDAO {
    /**
     * ユーザーが存在するかどうかを判定する。
     */
    public boolean existsUser(String userid, String password) throws Exception {
        // SQLを宣言
        String sql = "SELECT users.userid\n"
                + "FROM users\n"
                + "INNER JOIN role ON users.roleid = role.roleid\n"
                + "WHERE users.userid = ?\n"
                + "AND users.password = ?\n"
                ;

        // PreparedStatementを取得、実行SQLを渡す。
        PreparedStatement statement = getPreparedStatement(sql);

        // プレースホルダ―をに値を入れる
        statement.setString(1, userid);
        statement.setString(2, password);

        // SQLを実行して結果を取得する。
        ResultSet rs = statement.executeQuery();

        // 検索結果が存在すればtrueを返す。
        return rs.next();
    }
}