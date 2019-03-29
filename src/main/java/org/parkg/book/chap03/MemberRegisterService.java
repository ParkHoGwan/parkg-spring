package org.parkg.book.chap03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MemberRegisterService {

	private MemberDao memberDao;

	static Logger logger = LogManager.getLogger();
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	/**
	 * memberDao를 초기화하는 컨스트럭
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	*/
	
	/**
	 * 회원 등록
	 * 
	 * @param req 사용자가 입력한 회원 정보
	 * @throws DuplicateMemberException 이메일이 중복될 경우에 발생
	 */
	public void regist(RegisterRequest req) throws DuplicateMemberException {
		logger.debug(req);
		Member member = memberDao.selectByEmail(req.getEmail());

		// 회원이 이미 존재하면 예외 발생
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복 " + req.getEmail());
		}

		// 회원정보 저장
		Member newMember = new Member(req.getEmail(), req.getPassword(),
				req.getName());
		memberDao.insert(newMember);
		logger.debug("회원 정보를 저장했습니다.");
	}
}