package org.parkg.book.chap03;

public class MemberMain {
	
	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		MemberRegisterService regService = new MemberRegisterService();
		regService.setMemberDao(memberDao);
		
		// registerRequest �ʱ�ȭ
		RegisterRequest req = new RegisterRequest();
		req.setEmail("jacob@irafe.com");
		req.setPassword("xxxx");
		req.setName("Jacob");

		// ȸ�� ���
		regService.regist(req);
	}
}