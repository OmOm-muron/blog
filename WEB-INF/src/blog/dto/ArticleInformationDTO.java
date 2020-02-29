package blog.dto;

import java.sql.Date;

/**
 * @author Omura
 * ブログ記事情報用のDTO
 */
public class ArticleInformationDTO {
    /******************************
     * フィールド：ブログ記事の情報
     ******************************/
    // article ID
    private int co_articleid = -1;
    // submit date
    private Date co_submitdate;
    // update date
    private Date co_updatedate;
    // title
    private String co_title;
    // categories
    private int co_category1 = 0;
    private int co_category2 = 0;
    private int co_category3 = 0;
    private int co_category4 = 0;
    private int co_category5 = 0;
    // article content
    private String co_article;
    
    /******************************
     * Getter
     ******************************/
    public int getArticleid() {
        return this.co_articleid;
    }
    
    public Date getSubmitdate() {
        return this.co_submitdate;
    }
    
    public Date getUpdatedate() {
        return this.co_updatedate;
    }
    
    public String getTitle() {
        return this.co_title;
    }
    
    public int getCategory1() {
        return this.co_category1;
    }
    
    public int getCategory2() {
        return this.co_category2;
    }
    
    public int getCategory3() {
        return this.co_category3;
    }
    
    public int getCategory4() {
        return this.co_category4;
    }
    
    public int getCategory5() {
        return this.co_category5;
    }
    
    public String getArticle() {
        return this.co_article;
    }
    
    /******************************
     * Setter
     ******************************/
    public void setArticleid(int ex_articleid) {
        this.co_articleid = ex_articleid;
    }
    
    public void setSubmitdate(Date ex_submitdate) {
        this.co_submitdate = ex_submitdate;
    }
    
    public void setUpdatedate(Date ex_updatedate) {
        this.co_updatedate = ex_updatedate;
    }
    
    public void setTitle(String ex_title) {
        this.co_title = ex_title;
    }
    
    public void setCategory1(int ex_category1) {
        this.co_category1 = ex_category1;
    }
    
    public void setCategory2(int ex_category2) {
        this.co_category2 = ex_category2;
    }
    
    public void setCategory3(int ex_category3) {
        this.co_category3 = ex_category3;
    }
    
    public void setCategory4(int ex_category4) {
        this.co_category4 = ex_category4;
    }
    
    public void setCategory5(int ex_category5) {
        this.co_category5 = ex_category5;
    }
    
    public void setArticle(String ex_article) {
        this.co_article = ex_article;
    }
    
    /******************************
     * check this instance is valid or not
     ******************************/
    public boolean isValid() {
    	return this.co_articleid >= 0;
    }
}
