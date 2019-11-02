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
    private int co_commentid;
    // article ID
    private int co_articleid;
    // comment submit date
    private Date co_commentdate;
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
    
    public void setComment(String ex_title) {
        this.co_comment = ex_title;
    }
}
