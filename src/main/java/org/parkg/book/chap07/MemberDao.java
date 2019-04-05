package org.parkg.book.chap07;

import java.util.List;

import org.parkg.book.chap03.Member;


public interface MemberDao {

	/**
	 * �̸��Ϸ� ȸ�� ���� ������
	 */
	Member selectByEmail(String email);

	/**
	 * ȸ������ ����
	 */
	void insert(Member member);

	/**
	 * ȸ������ ����
	 */
	void update(Member member);

	/**
	 * ȸ�� ���
	 */
	List<Member> selectAll(int offset, int count);
}
