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
    private int co_imageid;
    // article ID
    private int co_articleid;
    // image path
    private String co_imagepath;
    
    /******************************
     * Getter
     ******************************/
    public int getImageid() {
        return this.co_imageid;
    }
    
    public int getArticleid() {
        return this.co_articleid;
    }
    
    public String getImagepath() {
        return this.co_imagepath;
    }
    
    /******************************
     * Setter
     ******************************/
    public void setImageid(int ex_imageid) {
        this.co_imageid = ex_imageid;
    }
    
    public void setArticleid(int ex_articleid) {
        this.co_articleid = ex_articleid;
    }
    
    public void setImagepath(String ex_imagepath) {
        this.co_imagepath = ex_imagepath;
    }
}
