package org.parkg.book.chap08;

import java.util.List;

import org.parkg.book.chap03.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 인터페이스 MemberDao의 구현체. SpringJdbc를 사용해서 구현
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
	 * p.194의 memberRowMapper<br>
	 * Member 오브젝트와 member 테이블의 한 행을 매핑하는 rowMapper
	 */
	RowMapper<Member> memberRowMapper = new BeanPropertyRowMapper<>(Member.class);

	/**
	 * p.192 [리스트 8.8]의 selectByEmail() 메서드 수정
	 */
	@Override
	public Member selectByEmail(String email) {
		return jdbcTemplate.queryForObject(SELECT_BY_EMAIL, memberRowMapper, email);
	}

	/**
	 * p.201 [리스트 8.12]의 insert() 메서드 수정
	 */
	@Override
	public void insert(Member member) {
		jdbcTemplate.update(INSERT, member.getEmail(), member.getPassword(), member.getName());
	}

	/**
	 * p.198 [리스트 8.11]의 update() 메서드 수정
	 */
	@Override
	public void update(Member member) {
		jdbcTemplate.update(UPDATE, member.getEmail(), member.getPassword(), member.getName(), member.getMemberId());
	}

	/**
	 * p.195 [리스트 8.9] selectAll() 메서드 수정
	 */
	@Override
	public List<Member> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, memberRowMapper, 0, 100);
	}
}
