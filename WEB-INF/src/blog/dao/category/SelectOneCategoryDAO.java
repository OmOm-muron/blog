package blog.dao.category;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

import blog.dao.RootDAO;
import blog.dto.ArticleInformationDTO;
import blog.dto.CategoryDTO;
import blog.dto.CommentDTO;

/**
 * @author Omura
 * 一件のデータを取得するDAO
 */
public class SelectOneCategoryDAO extends RootDAO {
	
	/*****************************************************************
	 * 記事関係のクエリ
	 *****************************************************************/
	public ArticleInformationDTO selectArticle(int ex_articleid) throws Exception {
		// initialize return value
		ArticleInformationDTO in_dto = new ArticleInformationDTO();
		
		// declare base SQL
		String in_sql = "SELECT "
				+ "articleid, submitdate, title, "
				+ "category1, category2, category3, category4, category5"
				+ "article, updatedate\n"
				+ "FROM article\n"
				+ "WHERE articleid = ?";
		
		try {
			// get prepared statement and execute query
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setInt(1, ex_articleid);
			ResultSet in_resultSet = in_statement.executeQuery();
			
			if (in_resultSet.next()) {
				// set SQL Result to return value
				in_dto.setArticleid(in_resultSet.getInt("articleid"));
				in_dto.setSubmitdate(in_resultSet.getDate("submitdate"));
				in_dto.setTitle(in_resultSet.getString("title"));
				in_dto.setCategory1(in_resultSet.getInt("category1"));
				in_dto.setCategory2(in_resultSet.getInt("category2"));
				in_dto.setCategory3(in_resultSet.getInt("category3"));
				in_dto.setCategory4(in_resultSet.getInt("category4"));
				in_dto.setCategory5(in_resultSet.getInt("category5"));
				in_dto.setArticle(in_resultSet.getString("article"));
				in_dto.setUpdatedate(in_resultSet.getDate("updatedate"));
			}
			
			if (!in_dto.isValid()) {
				// when invalid article information
				throw new Exception("Article Information is invalid.\n");
			}
			return in_dto;
		} catch (Exception e) {
			throw e;
		} finally {
			super.close();
		}
	}
	
	/*****************************************************************
	 * コメント関係のクエリ
	 *****************************************************************/
	public CommentDTO selectComment(int ex_commentid) throws Exception {
		// initialize return value
		CommentDTO in_dto = new CommentDTO();
		
		// declare base SQL
		String in_sql = "SELECT "
				+ "commentid, articleid, commentdate, "
				+ "comment, updatedate\n"
				+ "FROM comment\n"
				+ "WHERE commentid = ?";
		
		try {
			// get prepared statement and execute query
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setInt(1, ex_commentid);
			ResultSet in_resultSet = in_statement.executeQuery();
			
			if (in_resultSet.next()) {
				// set SQL Result to return value
				in_dto.setCommentid(in_resultSet.getInt("commentid"));
				in_dto.setArticleid(in_resultSet.getInt("articleid"));
				in_dto.setCommentdate(in_resultSet.getDate("commentdate"));
				in_dto.setComment(in_resultSet.getString("comment"));
				in_dto.setUpdatedate(in_resultSet.getDate("updatedate"));
			}
			
			if (!in_dto.isValid()) {
				// when invalid comment information
				throw new Exception("Comment Information is invalid.\n");
			}
			return in_dto;
		} catch (Exception e) {
			throw e;
		} finally {
			super.close();
		}
	}
	
	/*****************************************************************
	 * カテゴリ関係のクエリ
	 *****************************************************************/
	public CategoryDTO selectCategory(int ex_categoryid) throws Exception {
		// initialize return value
		CategoryDTO in_dto = new CategoryDTO();
		
		// declare base SQL
		String in_sql = "SELECT "
				+ "categoryid, categoryname\n"
				+ "FROM category\n"
				+ "WHERE categoryid = ?";
		
		try {
			// get prepared statement and execute query
			PreparedStatement in_statement = getPreparedStatement(in_sql);
			in_statement.setInt(1, ex_categoryid);
			ResultSet in_resultSet = in_statement.executeQuery();
			
			if (in_resultSet.next()) {
				// set SQL Result to return value
				in_dto.setCategoryid(in_resultSet.getInt("categoryid"));
				in_dto.setCategoryname(in_resultSet.getString("categoryname"));
			}
			
			if (!in_dto.isValid()) {
				// when invalid category information
				throw new Exception("Category Information is invalid.\n");
			}
			return in_dto;
		} catch (Exception e) {
			throw e;
		} finally {
			super.close();
		}
	}
}
