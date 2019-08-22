package com.bitcamp.domains;

public class MemberBean { //속성
 private String id, name, pw, blood, ssn;
 private double height, weight;
 private int salary;
 
public String getId() {
	return this.id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return this.name;
}
public void setName(String name) {
	this.name = name;
}
public String getPw() {
	return this.pw;
}
public void setPw(String pw) {
	this.pw = pw;
}
public String getBlood() {
	return this.blood;
}
public void setBlood(String blood) {
	this.blood = blood;
}
public double getHeight() {
	return this.height;
}
public void setHeight(double height) {
	this.height = height;
}
public double getWeight() {
	return this.weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public void setSSn(String ssn) {
	this.ssn = ssn;
}
public String getSSn() {
	return this.ssn;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public int getSalary() {
	return this.salary;
}
@Override
	public String toString() {
	// 이름, 아이디, 비번, 주민번호, 혈액형,키,몸무게
		return String.format("[회원정보 : \n"
				+ "아이디 : %s \n"
				+ "이름 : %s \n"
				+ "비번 : %s \n"
				+ "주민번호: %s \n"
				+ "혈액형 : %s \n"
				+ "키: %s \n"
				+ "몸무게 : %s \n]"
				, id, name, pw, blood, ssn,height, weight);
	}

}


 


