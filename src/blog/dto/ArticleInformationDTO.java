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
    private int articleid;
    // submit date
    private Date submitdate;
    // title
    private String title;
    // categories
    private int category1;
    private int category2;
    private int category3;
    private int category4;
    private int category5;
    // article content
    private String article;
    
    /******************************
     * Getter
     ******************************/
    public int getArticleid() {
        return this.articleid;
    }
    
    public Date getSubmitdate() {
        return this.submitdate;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public int getCategory1() {
        return this.category1;
    }
    
    public int getCategory2() {
        return this.category2;
    }
    
    public int getCategory3() {
        return this.category3;
    }
    
    public int getCategory4() {
        return this.category4;
    }
    
    public int getCategory5() {
        return this.category5;
    }
    
    public String getArticle() {
        return this.article;
    }
    
    /******************************
     * Setter
     ******************************/
    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }
    
    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setCategory1(int category1) {
        this.category1 = category1;
    }
    
    public void setCategory2(int category2) {
        this.category2 = category2;
    }
    
    public void setCategory3(int category3) {
        this.category3 = category3;
    }
    
    public void setCategory4(int category4) {
        this.category4 = category4;
    }
    
    public void setCategory5(int category5) {
        this.category5 = category5;
    }
    
    public void setArticle(String article) {
        this.article = article;
    }
}
