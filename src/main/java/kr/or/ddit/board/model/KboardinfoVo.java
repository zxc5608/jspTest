package kr.or.ddit.board.model;

public class KboardinfoVo {

private int bor_no;
private int bor_act;
private String bor_name;


public KboardinfoVo(int bor_no, int bor_act, String bor_name) {
	this.bor_no= bor_no;
	this.bor_act =bor_act;
	this.bor_name= bor_name;
}
public int getBor_no() {
	return bor_no;
}
public void setBor_no(int bor_no) {
	this.bor_no = bor_no;
}
public int getBor_act() {
	return bor_act;
}
public void setBor_act(int bor_act) {
	this.bor_act = bor_act;
}
public String getBor_name() {
	return bor_name;
}
public void setBor_name(String bor_name) {
	this.bor_name = bor_name;
}

@Override
public String toString() {
	return "KboardinfoVo [bor_no=" + bor_no + ", bor_act=" + bor_act + ", bor_name=" + bor_name + "]";
}




	
	
}
