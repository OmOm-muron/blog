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
    private int categoryid = -1;
    // category name
    private String categoryname;
    
    /******************************
     * Getter
     ******************************/
    public int getCategoryid() {
        return this.categoryid;
    }
    
    public String getCategoryname() {
        return this.categoryname;
    }
    
    /******************************
     * Setter
     ******************************/
    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
    
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
    
    /******************************
     * check this instance is valid or not
     ******************************/
    public boolean isValid() {
    	return this.categoryid >= 0;
    }
}
