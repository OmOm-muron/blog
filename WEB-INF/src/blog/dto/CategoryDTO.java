package blog.dto;

/**
 * @author Omura
 * カテゴリ用のDTO
 */
public class CategoryDTO {
    /******************************
     * フィールド：カテゴリの情報
     ******************************/
    // category ID
    private int co_categoryid;
    // category name
    private String co_categoryname;
    
    /******************************
     * Getter
     ******************************/
    public int getCategoryid() {
        return this.co_categoryid;
    }
    
    public String getCategoryname() {
        return this.co_categoryname;
    }
    
    /******************************
     * Setter
     ******************************/
    public void setCategoryid(int ex_categoryid) {
        this.co_categoryid = ex_categoryid;
    }
    
    public void setCategoryname(String ex_categoryname) {
        this.co_categoryname = ex_categoryname;
    }
}
