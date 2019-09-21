
package login.dao;

import java.sql.*;

/**
 * @author Omura
 * ���[�U�[���擾�p��DTO
 */
public class UserInformationDAO extends RootDAO {
    /**
     * ���[�U�[�����݂��邩�ǂ����𔻒肷��B
     */
    public boolean existsUser(String userid, String password) throws Exception {
        // SQL��錾
        String sql = "SELECT users.userid\n"
                + "FROM users\n"
                + "INNER JOIN role ON users.roleid = role.roleid\n"
                + "WHERE users.userid = ?\n"
                + "AND users.password = ?\n"
                ;

        // PreparedStatement���擾�A���sSQL��n���B
        PreparedStatement statement = getPreparedStatement(sql);

        // �v���[�X�z���_�\���ɒl������
        statement.setString(1, userid);
        statement.setString(2, password);

        // SQL�����s���Č��ʂ��擾����B
        ResultSet rs = statement.executeQuery();

        // �������ʂ����݂����true��Ԃ��B
        return rs.next();
    }
}