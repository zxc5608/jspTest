package kr.or.ddit.board.model;

public class FileVo {

	private int att_no;
	private int bor_no;
	private int post_no;
	private String user_id;
	private String file_nm;
	private String read_file_name;
	
	public FileVo(int bbsno, int postno) {
		this.bor_no = bor_no;
		this.post_no = post_no;
	}
	
	
	public FileVo() {
	
	}
	public int getAtt_no() {
		return att_no;
	}
	public void setAtt_no(int att_no) {
		this.att_no = att_no;
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
	public String getFile_nm() {
		return file_nm;
	}
	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}
	public String getRead_file_name() {
		return read_file_name;
	}
	public void setRead_file_name(String read_file_name) {
		this.read_file_name = read_file_name;
	}
	@Override
	public String toString() {
		return "FileVo [att_no=" + att_no + ", bor_no=" + bor_no + ", post_no=" + post_no + ", user_id=" + user_id
				+ ", file_nm=" + file_nm + ", read_file_name=" + read_file_name + "]";
	}
	
	
}
