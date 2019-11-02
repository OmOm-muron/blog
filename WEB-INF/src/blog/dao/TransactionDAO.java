package blog.dao;

import blog.dto.*;

/**
 * @author Omura
 * INSERT,UPDATE,DELETE系の処理を行うDAO
 */
public class TransactionDAO extends RootDAO {
	/**
	 * 記事を書き込む
	 * @param articleInformationDTO
	 * @return insert数
	 * @throws Exception
	 */
	public int insertArticle(ArticleInformationDTO articleInformation) throws Exception {
		String sql ="";
		return 1;
	}
}
