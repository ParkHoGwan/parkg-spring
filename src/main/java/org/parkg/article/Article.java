package org.parkg.article;

/**
 * Article 도메인 오브젝트.<br>
 * 데이터베이스의 article 테이블에 매핑한다.
 * 
 * @author Jacob
 */
public class Article {
	// 글번호
	String articleId;

	// 제목
	String title;

	// 내용
	String content;

	// 작성자 아이디
	String userId;

	// 작성자 이름
	String name;

	// 등록일시
	String cdate;

	/*
	 * Getter and Setter methods
	 */
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", name=" + name + ", cdate=" + cdate + "]";
	}
}