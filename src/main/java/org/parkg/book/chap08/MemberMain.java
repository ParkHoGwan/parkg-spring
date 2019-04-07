package org.parkg.book.chap08;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * p.204 [����Ʈ 8.13]�� Main�� Service�� �и��� Main �κ�<br>
 * Spring���� bean�� �������� ����
 * 
 * @author Jacob
 */
public class MemberMain {
	public static void main(String[] args) throws Exception {
		new MemberMain().go();
	}

	public void go() throws Exception {
		Properties props = new Properties();

		// Ŭ�����н��� �ִ� db.properties ���Ͽ��� ������Ƽ�� �д´�.
		InputStream in = getClass().getClassLoader().getResourceAsStream("db.properties");
		props.load(in);

		// db.url ������Ƽ ������ �����ͼҽ� �ʱ�ȭ
		DataSource dataSource = new MariaDbDataSource(props.getProperty("db.url"));

		// dataSource�� jdbcTemplate�� �ִ´�. (Injection)
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		// jdbcTemplate�� memberDao�� �ִ´�. (Injection)
		MemberDaoImplUsingSpringJdbc memberDao = new MemberDaoImplUsingSpringJdbc();
		memberDao.setJdbcTemplate(jdbcTemplate);

		// memberDao�� memberService�� �ִ´�. (Injection)
		MemberService memberService = new MemberService();
		memberService.setMemberDao(memberDao);

		// ����Ͻ� �޼��� ����
		memberService.insertMember();
		memberService.selectAll();
	}
}
