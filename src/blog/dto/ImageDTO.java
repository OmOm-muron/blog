package blog.dto;

/**
 * @author Omura
 * 添付画像用のDTO
 */
public class ImageDTO {
    /******************************
     * フィールド：画像の情報
     ******************************/
    // image ID
    private int imageid;
    // article ID
    private int articleid;
    // image path
    private String imagepath;
    
    /******************************
     * Getter
     ******************************/
    public int getImageid() {
        return this.imageid;
    }
    
    public int getArticleid() {
        return this.articleid;
    }
    
    public String getImagepath() {
        return this.imagepath;
    }
    
    /******************************
     * Setter
     ******************************/
    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
    
    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }
    
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
}
