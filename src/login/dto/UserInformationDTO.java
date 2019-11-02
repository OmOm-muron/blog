
package login.dto;

/**
 * @author Omura
 * ユーザー情報のDTO
 */
public class UserInformationDTO {
    // フィールド
    private String userid;
    private String username;
    private int roleid;
    private String rolename;
    private String password;

    // Getter
    public String getUserid() {
        return this.userid;
    }
    public String getUsername() {
        return this.username;
    }
    public int getRoleid() {
        return this.roleid;
    }
    public String getRolename() {
        return this.rolename;
    }
    public String getPassword() {
        return this.password;
    }

    //Setter
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}