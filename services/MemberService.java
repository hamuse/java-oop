package com.bitcamp.services;

import com.bitcamp.domains.MemberBean; //어디서 받아와서 쓸것인지. 불러오는것

/**
 * 요구사항(기능정의)
 * <사용자기능>
 *  1. 회원가입 2. 마이페이지 :정보보기 3. 비번 수정 4. 탈퇴 
 * ******************
 * <관리자기능>
 * 5. 회원목록
 * 6. 아이디 검색 
 */
public class MemberService { // 기능적인일 //MemberService -> 서버에 저장 .. 멤버의 정보를 갖는다 .멤버빈을 벡터화 시킨것 . 멤버빈이 2개이상되는것.
	private MemberBean[] members; // 객체 배열 count 의미다 뒷숫자. 백터화 된것. //계속 값이 유지되어 있어야해서 . //멤버변수는 초기화하지않는다.
	private int count;

	public MemberService() {
		members = new MemberBean[3];
		count = 0;
	}

	/**
	 * 1. 회원가입
	 */
	public String join(MemberBean param) {
		String msg = "회원가입 성공";
       members[count] = param; //회원가입 정보 입력받은 곳 
       count++; 
		return msg;
	}

	/**
	 * 2. 마이페이지
	 */
	public String getMyPage(MemberBean param) {
		return param.toString();
	}

	/**
	 * 3. 비번수정
	 */

	public String changePassword(MemberBean param) {
		String msg = "비밀번호 번경";
		return msg;
	}

	public String withdrawal(MemberBean param) {
		String msg = "회원탈퇴";
		return msg;
	}
	/**
	 *  5.회원목록
	 */
	public String list( ) {
		String msg = "";
		for(int i = 0 ; i<count;  i++) {
			msg += members[i].toString()+",\n";
		}
		
		return msg;
	}
	/**
	 *  6. 아이디검색
	 */
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		
		for(int i =0 ; i < count ; i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];
			}
		}
		return member;
	}

}
