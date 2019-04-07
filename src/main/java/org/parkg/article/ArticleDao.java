package org.parkg.article;

import java.util.List;

/**
 * Data Access Object.<br>
 * �����ͺ��̽��� �����ؼ� �����͸� �����ϴ� �������̽�.
 * 
 * @author Jacob
 */
public interface ArticleDao {

	/**
	 * ���
	 */
	List<Article> listArticles();

	/**
	 * ��ȸ
	 */
	Article getArticle(String articleId);

	/**
	 * ���
	 * 
	 * @return �߰��� ���� ����
	 */
	int addArticle(Article article);

	/**
	 * ����
	 * 
	 * @return ������ ���� ����
	 */
	int updateArticle(Article article);

	/**
	 * ����
	 * 
	 * @return ������ ���� ����
	 */
	int deleteArticle(String articleId);
}