package org.parkg.book.chap04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.parkg.book.chap03.DuplicateMemberException;
import org.parkg.book.chap03.Member;
import org.parkg.book.chap03.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * p.55 [����Ʈ 3.1] MemberRegisterService ����<br>
 * ȸ���� ����ϴ� ����
 * 
 * @author Jacob
 */
@Service
public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;

	static Logger logger = LogManager.getLogger();

	/**
	 * ȸ�� ���
	 * 
	 * @param req ����ڰ� �Է��� ȸ�� ����
	 * @throws DuplicateMemberException �̸����� �ߺ��� ��쿡 �߻�
	 */
	public void regist(RegisterRequest req) {
		logger.debug(req);
		Member member = memberDao.selectByEmail(req.getEmail());

		// ȸ���� �̹� �����ϸ� ���� �߻�
		if (member != null) {
			throw new DuplicateMemberException("�̸��� �ߺ� " + req.getEmail());
		}

		// ȸ������ ����
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName());
		memberDao.insert(newMember);
		logger.debug("ȸ�� ������ �����߽��ϴ�.");
	}
}