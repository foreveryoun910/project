package co.jeju.jejuProject.member.service;

import java.util.List;

import co.jeju.jejuProject.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); // 전체회원보기
	MemberVO memberSelect(MemberVO vo); // 회원조회
	MemberVO memberLogin(MemberVO vo); // 로그인
	int memberInsert(MemberVO vo); // 회원가입
	int memberUpdate(MemberVO vo); // 회원정보변경
	int memberDelete(MemberVO vo); // 회원탈퇴
}
