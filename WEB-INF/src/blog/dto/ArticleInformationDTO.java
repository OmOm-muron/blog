package blog.dto;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Omura
 * ブログ記事情報用のDTO
 */
public class ArticleInformationDTO {
    /******************************
     * フィールド：ブログ記事の情報
     ******************************/
    // article ID
    private int articleid = -1;
    // submit date
    private Timestamp submitdate;
    // update date
    private Timestamp updatedate;
    // title
    private String title;
    // categories(ID)
    private int category1 = 0;
    private int category2 = 0;
    private int category3 = 0;
    private int category4 = 0;
    private int category5 = 0;
    // categories(Name)
    private String categoryname1;
    private String categoryname2;
    private String categoryname3;
    private String categoryname4;
    private String categoryname5;
    // article content
    private String article;
    
    /******************************
     * Getter
     ******************************/
    public int getArticleid() {
        return this.articleid;
    }
    
    public Timestamp getSubmitdate() {
        return this.submitdate;
    }
    
    public Timestamp getUpdatedate() {
        return this.updatedate;
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
    
    public String getCategoryname1() {
        return this.categoryname1;
    }
    
    public String getCategoryname2() {
        return this.categoryname2;
    }
    
    public String getCategoryname3() {
        return this.categoryname3;
    }
    
    public String getCategoryname4() {
        return this.categoryname4;
    }
    
    public String getCategoryname5() {
        return this.categoryname5;
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
    
    public void setSubmitdate(Timestamp submitdate) {
        this.submitdate = submitdate;
    }
    
    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
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
    
    public void setCategoryname1(String categoryname1) {
        this.categoryname1 = categoryname1;
    }
    
    public void setCategoryname2(String categoryname2) {
        this.categoryname2 = categoryname2;
    }
    
    public void setCategoryname3(String categoryname3) {
        this.categoryname3 = categoryname3;
    }
    
    public void setCategoryname4(String categoryname4) {
        this.categoryname4 = categoryname4;
    }
    
    public void setCategoryname5(String categoryname5) {
        this.categoryname5 = categoryname5;
    }
    
    public void setArticle(String article) {
        this.article = article;
    }
    
    /******************************
     * check this instance is valid or not
     ******************************/
    public boolean isValid() {
    	return this.articleid >= 0;
    }
}
