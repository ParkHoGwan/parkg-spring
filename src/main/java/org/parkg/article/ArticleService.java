package org.parkg.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * articleDao�� ����ؼ� �� ���, ��ȸ, �߰�, ����, ������ �Ѵ�.
 * 
 * @author Jacob
 */
@Service	
public class ArticleService {
	@Autowired	
	ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	/**
	 * �� ���
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * �� ��ȸ
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	/**
	 * �� ���
	 */
	public void addArticle() {
		Article article = new Article();
		article.setTitle("���ǽ� 879ȭ �ִ� ���������� ����!��¤������ �Ϳ��");
		article.setContent("�� ������ �����̴� ��Ȳ��, �� ���� �������� ���ϴ� ��¤���� ģ������ ���⿡ ���ſ� ���ǿ� �Բ� ������ �ϰ� �߰ſ� �ͼ��� ���� �ں� ��Ÿ����.");
		article.setUserId("7"); 
		article.setName("��ȣ��");
		if (articleDao.addArticle(article) > 0)
			System.out.println("���� �߰��߽��ϴ�.");
		else
			System.out.println("���� �߰����� ���߽��ϴ�.");
	}

	/**
	 * �� ����
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("���� �����߽��ϴ�.");
		else
			System.out.println("���� �������� ���߽��ϴ�.");
	}

	/**
	 * �� ����
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("���� �����߽��ϴ�.");
		else
			System.out.println("���� �������� ���߽��ϴ�.");
	}
}