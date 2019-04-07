package org.parkg.book.chap04;

import java.util.HashMap;
import java.util.Map;

import org.parkg.book.chap03.Member;
import org.springframework.stereotype.Repository;

/**
 * p.62 [����Ʈ 3.5] MemberDao ����<br>
 * ȸ�� ���̺��� �����ϴ� Data Access Object
 * 
 * @author Jacob
 */
@Repository
public class MemberDao {

	/**
	 * ȸ������ �� (ȸ�� ���̺�)
	 */
	Map<String, Member> map = new HashMap<>();

	/**
	 * �̸��Ϸ� ȸ�� ���� ������
	 */
	public Member selectByEmail(String email) {
		return map.get(email);
	}

	/**
	 * ȸ������ ����
	 */
	public void insert(Member member) {
		map.put(member.getEmail(), member);
	}
}
