package kr.or.ddit.board.model;

import java.util.Date;

public class ComVo {

	private int com_no;
	private String com_user_id;
	private Date com_date;
	private String com_con;
	private int com_del;
	private int bor_no;
	private int post_no;
	private String user_id;
	
	public ComVo() {
		
	}

	
	public int getCom_no() {
		return com_no;
	}
	public void setCom_no(int com_no) {
		this.com_no = com_no;
	}
	public String getCom_user_id() {
		return com_user_id;
	}
	public void setCom_user_id(String com_user_id) {
		this.com_user_id = com_user_id;
	}
	public Date getCom_date() {
		return com_date;
	}
	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}
	public String getCom_con() {
		return com_con;
	}
	public void setCom_con(String com_con) {
		this.com_con = com_con;
	}
	public int getCom_del() {
		return com_del;
	}
	public void setCom_del(int com_del) {
		this.com_del = com_del;
	}
	public int getBor_no() {
		return bor_no;
	}
	public void setBor_no(int bor_no) {
		this.bor_no = bor_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "ComVo [com_no=" + com_no + ", com_user_id=" + com_user_id + ", com_date=" + com_date + ", com_con="
				+ com_con + ", com_del=" + com_del + ", bor_no=" + bor_no + ", post_no=" + post_no + ", user_id="
				+ user_id + "]";
	}
	
	
	
}
