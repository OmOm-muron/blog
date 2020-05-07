package blog.dto;

import java.sql.Timestamp;

/**
 * @author Omura
 * コメント情報用のDTO
 */
public class CommentDTO {
    /******************************
     * フィールド：コメントの情報
     ******************************/
    // comment ID
    private int commentid = -1;
    // article ID
    private int articleid;
    // comment submit date
    private Timestamp commentdate;
    // comment update date
    private Timestamp updatedate;
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
    
    public Timestamp getCommentdate() {
        return this.commentdate;
    }
    
    public Timestamp getUpdatedate() {
        return this.updatedate;
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
    
    public void setCommentdate(Timestamp commentdate) {
        this.commentdate = commentdate;
    }
    
    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }
    
    public void setComment(String title) {
        this.comment = title;
    }
    
    /******************************
     * check this instance is valid or not
     ******************************/
    public boolean isValid() {
    	return this.commentid >= 0;
    }
}
