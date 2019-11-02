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
    private int commentid;
    // article ID
    private int articleid;
    // comment submit date
    private Date commentdate;
    // comment content
    private String comment;
    
    /******************************
     * Getter
     ******************************/
    public int getCommentid() {
        return this.commentid;
    }
    
    public int getArticleid() {
        return this.articleid;
    }
    
    public Date getCommentdate() {
        return this.commentdate;
    }
    
    public String getComment() {
        return this.comment;
    }
    
    /******************************
     * Setter
     ******************************/
    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }
    
    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }
    
    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }
    
    public void setComment(String title) {
        this.comment = title;
    }
}
