
package login.dto;

/**
 * ユーザー情報のDTO
 */
public class UserInformationDTO {
    // Fields
    private String co_userid;
    private String co_username;
    private int co_roleid;
    private String co_rolename;
    private String co_password;

    // Getter
    public String getUserid() {
        return this.co_userid;
    }
    
    public String getUsername() {
        return this.co_username;
    }
    
    public int getRoleid() {
        return this.co_roleid;
    }
    
    public String getRolename() {
        return this.co_rolename;
    }
    
    public String getPassword() {
        return this.co_password;
    }

    //Setter
    public void setUserid(String ex_userid) {
        this.co_userid = ex_userid;
    }
    
    public void setUsername(String ex_username) {
        this.co_username = ex_username;
    }
    
    public void setRoleid(int ex_roleid) {
        this.co_roleid = ex_roleid;
    }
    
    public void setRolename(String ex_rolename) {
        this.co_rolename = ex_rolename;
    }
    
    public void setPassword(String ex_password) {
        this.co_password = ex_password;
    }
}