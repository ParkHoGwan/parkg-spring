package org.parkg.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Spring JDBC�� ����ؼ� ArticleDao�� ����
 * 
 * @author Jacob
 */

	

@Repository("articleDao")	
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	/**
	 * ��� �������� sql
	 */
	static final String LIST_ARTICLES = "SELECT articleId, title, name, cdate FROM article LIMIT 20";

	/**
	 * �� 1�� �������� sql
	 */
	static final String GET_ARTICLE = "SELECT articleId, title, content, name, cdate FROM article WHERE articleId=?";

	/**
	 * �� ����ϴ� sql
	 */
	static final String ADD_ARTICLE = "INSERT INTO article(title, content, userId, name) VALUES (?,?,?,?)";

	/**
	 * �� �����ϴ� sql
	 */
	static final String UPDATE_ARTICLE = "UPDATE article SET title=?, content=? WHERE articleId=?";

	/**
	 * �� �����ϴ� sql
	 */
	static final String DELETE_ARTICLE = "DELETE FROM article WHERE articleId=?";
	
	@Autowired					
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * �� ���
	 */
	@Override
	public List<Article> listArticles() {
		return jdbcTemplate.query(LIST_ARTICLES, new BeanPropertyRowMapper<>(Article.class));
	}

	/**
	 * �� ��
	 */
	@Override
	public Article getArticle(String articleId) {
		return jdbcTemplate.queryForObject(GET_ARTICLE, new BeanPropertyRowMapper<>(Article.class), articleId);
	}

	/**
	 * �� ���
	 */
	@Override
	public int addArticle(Article article) {
		return jdbcTemplate.update(ADD_ARTICLE, article.getTitle(), article.getContent(), article.getUserId(),
				article.getName());
	}

	/**
	 * �� ����
	 */
	@Override
	public int updateArticle(Article article) {
		return jdbcTemplate.update(UPDATE_ARTICLE, article.getTitle(), article.getContent(), article.getArticleId());
	}

	/**
	 * �� ����
	 */
	@Override
	public int deleteArticle(String articleId) {
		return jdbcTemplate.update(DELETE_ARTICLE, articleId);
	}
}