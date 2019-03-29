package org.parkg.book.chap03;

public class Member {
	String memberId; // ���̵�
	String email; // �̸���
	String password; // ��й�ȣ
	String name; // �̸�
	String registerDate; // ����Ͻ�

	/**
	 * Default Constructor
	 */
	public Member() {
	}

	/**
	 * email, password, name ���� �ʱ�ȭ�ϴ� ����Ʈ����
	 * 
	 * @param email �̸���
	 * @param password ��й�ȣ
	 * @param name �̸�
	 */
	public Member(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", email=" + email
				+ ", password=" + password + ", name=" + name
				+ ", registerDate=" + registerDate + "]";
	}
}
