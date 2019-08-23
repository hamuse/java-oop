package com.bitcamp.services;

import com.bitcamp.domains.MemberBean; //어디서 받아와서 쓸것인지. 불러오는것

/**
 * 요구사항(기능정의)
 * <사용자기능>
 *  1. 회원가입 
 *  2. 마이페이지 :정보보기 
 *  3. 비번 수정
 *   4. 탈퇴  
 *   5. 아이디 존재체크
 *   6. 로그인
 * ******************
 * <관리자기능>
 * 5. 회원목록
 * 6. 아이디 검색 
 * 7. 이름 검색
 * 8. 전체 회원수 구하기
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
	 * 3. 비번수정 로그인한 상태( id ,옛날비번 , 신규비번 을 입력 받아서 옛날비번을 체크후 일치하면 신규 비번으로 변경)
	 *  비번 변경 후 로그인을 실행해서 새로 바뀐 비번이 로그인 성공이고 옛날 비번은 로그인 실패가 떠야한다. 
	 *  
	 */

	public String changePassword(MemberBean param) {
		String msg = "비밀번호 번경";
		String id = param.getId();
		String pw = param.getPw();
		String[] pws = pw.split(",");
		String oldPw = pws[0];
		String newPw = pws[1];
		
		for(int i = 0; i< count ; i++) {
			if(param.getId().equals(members[i].getId()) && param.getPw().equals(members[i].getPw())) {
				members[i].setPw(newPw);
				break;
				
			}
		}
		
	
		return msg;
	}

	public String withdrawal(MemberBean param) {
		String msg = "회원탈퇴";
		return msg;
	}
	public String existId(String id) {
		//이미가입한 아이디입니다 .
		String msg = "가입가능한 아이디입니다 .";	
		for(int i = 0; i<count ; i ++) {
			if(id.equals(this.members[i].getId())) {
				msg = "이미 존재하는 아이디입니다 .";	
			break;
			}
		}
		return msg;
		
	}
	/**
	 *  6. 로그인(파라미터로 ID, PW만 입력받은 상태.
	 * */
	public String login(MemberBean param) {
		String msg = "로그인 실패";
		
	    for(int i =0 ;i< count ; i++) {
	    	if(param.getId().equals(members[i].getId()) && param.getPw().equals(members[i].getPw()) ) {
	    			msg = "로그인 성공";
	    			break;
	    	}
	    	
	    }
		
		return msg;
	}
	/************************************************************************************************************************
	 * 관리자 기능 
	 **********************************************************************************************************************/
	/**
	 *  5.회원목록(관리자)
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
				break;
			}
		}
		return member;
	}
	//이름 검색
	public MemberBean[] findName (String name ) { //1.  결과값이 복수라서 배열이 들어간다.  
     int j = 0;
		for(int i = 0 ; i <count ; i++) {	
    	  if(name.equals(this.members[i].getName())) {
    		j++;
    	  }
	    }
		MemberBean[] members = new MemberBean[j]; //2.
		 j = 0;
      for (int i =0; i<count; i++) {
    	  if(name.equals(this.members[i].getName())) {
    		 members[j] = this.members[i];
    		  j++;
    		  if(members.length == j) {
    			  break;
    		  }
    		 
    	  }
		  members[i] = this.members[i]; //= 표시는 담는다는 의미 
	  }
  
	    return members;
	    		}
	 public String countAll() {
		 
		 return "총회원수 : "+count;
	 }


}
