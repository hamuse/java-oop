package com.bitcamp.controllers;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;
import javax.swing.JOptionPane;
public class MemberController {

	public static void main(String[] args) { //입력받고 출력하고 //클라이언트 
		MemberService memberService = new MemberService(); //초기화 선언 생성  ----> 생성했다.  // 멤버 변수가없다.//정보가 한군대 모여있어야해서 한번만 생성한다. 
		//클레스         인스턴스           연산자  생성자 
		MemberBean member = null; //객체에 초기화  MemberBean member; 공간만있어서 선언(실체가 없어도된다.) 이름부여  선언 디클리레이션. ->추상
		               //멤버변수가 있다.                     //땅이있으면 디파인? 
		//기능은 복사하지않고 인스턴스는 복사한다. 
		
		
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료 \n"
					+ "1. 회원가입 \n"
					+ "2. 마이페이지 \n"
					+ "3. 비번수정 \n"
					+ "4. 회원탈퇴"
					+ "5. 회원 목록"
					+ "6. 아이디검색")) {
			case "0": 
				
				JOptionPane.showMessageDialog(null, "종료");
				
				return;
			
			case "1":
				String spec = JOptionPane.showInputDialog("이름, 아이디, 비번, 주민번호, 혈액형,키,몸무게");
				member = new MemberBean();//인스턴스를 생성하다. new 메모리를 만드는 키워드 진짜 공간을 갖게된다.  ->이니셜라이즈 객체생성 . 
                //여러 공간을 만들기 위해서 1케이스 안에 넣으면 실행할떄마다 공간(주소를 만들어줌). 내용물은 같은데 공간이 다른것 . ? 주소값? 0
				String[] arr = spec.split(","); 
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPw(arr[2]);
				member.setSSn(arr[3]);
				member.setBlood(arr[4]);
				member.setHeight(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));
				
			//	String msg = memberService.join(member);
				JOptionPane.showMessageDialog(null, memberService.join(member));
				
				
				
				break;
			case "2":
				JOptionPane.showMessageDialog(null, memberService.getMyPage(member));

				break;
			case "3":

				break;
			case "4":

				break;
			case "5" :
				JOptionPane.showMessageDialog(null, memberService.list());
				break;
			case "6" :
				String searchId =JOptionPane.showInputDialog("검색아이디");
				member = memberService.findById(searchId);
				JOptionPane.showMessageDialog(null, member);
				
				break;
			default:
				break;
			}
		}

	}

}
