package blog.dto;

import java.sql.Date;

/**
 * @author Omura
 * コメント情報用のDTO
 */
public class CommentDTO {
    /******************************
     * フィールド：コメントの情報
     ******************************/
    // comment ID
    private int co_commentid = -1;
    // article ID
    private int co_articleid;
    // comment submit date
    private Date co_commentdate;
    // comment update date
    private Date co_updatedate;
    // comment content
    private String co_comment;
    
    /******************************
     * Getter
     ******************************/
    public int getCommentid() {
        return this.co_commentid;
    }
    
    public int getArticleid() {
        return this.co_articleid;
    }
    
    public Date getCommentdate() {
        return this.co_commentdate;
    }
    
    public Date getUpdatedate() {
        return this.co_updatedate;
    }
    
    public String getComment() {
        return this.co_comment;
    }
    
    /******************************
     * Setter
     ******************************/
    public void setCommentid(int ex_commentid) {
        this.co_commentid = ex_commentid;
    }
    
    public void setArticleid(int ex_articleid) {
        this.co_articleid = ex_articleid;
    }
    
    public void setCommentdate(Date ex_commentdate) {
        this.co_commentdate = ex_commentdate;
    }
    
    public void setUpdatedate(Date ex_updatedate) {
        this.co_updatedate = ex_updatedate;
    }
    
    public void setComment(String ex_title) {
        this.co_comment = ex_title;
    }
    
    /******************************
     * check this instance is valid or not
     ******************************/
    public boolean isValid() {
    	return this.co_commentid >= 0;
    }
}
