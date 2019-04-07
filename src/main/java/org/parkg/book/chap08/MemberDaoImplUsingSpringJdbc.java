package org.parkg.book.chap08;

import java.util.List;

import org.parkg.book.chap03.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * �������̽� MemberDao�� ����ü. SpringJdbc�� ����ؼ� ����
 * 
 * @author Jacob
 */
public class MemberDaoImplUsingSpringJdbc implements MemberDao {

	static final String SELECT_BY_EMAIL = "SELECT memberId, email, name FROM member WHERE email=?";

	static final String INSERT = "INSERT member(email, password, name) VALUES(?, sha2(?,256), ?)";

	static final String UPDATE = "UPDATE member SET email=?, password=sha2(?,256), name=? WHERE memberId=?";

	static final String SELECT_ALL = "SELECT memberId, email, name FROM member ORDER BY memberId desc LIMIT ?,?";

	JdbcTemplate jdbcTemplate;

	/**
	 * jdbcTemplate setter for injection
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * p.194�� memberRowMapper<br>
	 * Member ������Ʈ�� member ���̺��� �� ���� �����ϴ� rowMapper
	 */
	RowMapper<Member> memberRowMapper = new BeanPropertyRowMapper<>(Member.class);

	/**
	 * p.192 [����Ʈ 8.8]�� selectByEmail() �޼��� ����
	 */
	@Override
	public Member selectByEmail(String email) {
		return jdbcTemplate.queryForObject(SELECT_BY_EMAIL, memberRowMapper, email);
	}

	/**
	 * p.201 [����Ʈ 8.12]�� insert() �޼��� ����
	 */
	@Override
	public void insert(Member member) {
		jdbcTemplate.update(INSERT, member.getEmail(), member.getPassword(), member.getName());
	}

	/**
	 * p.198 [����Ʈ 8.11]�� update() �޼��� ����
	 */
	@Override
	public void update(Member member) {
		jdbcTemplate.update(UPDATE, member.getEmail(), member.getPassword(), member.getName(), member.getMemberId());
	}

	/**
	 * p.195 [����Ʈ 8.9] selectAll() �޼��� ����
	 */
	@Override
	public List<Member> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, memberRowMapper, 0, 100);
	}
}
