package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVo {
	private String userid;
	private String usernm;
	private String pass;
	private Date reg_dt;
	private String alias;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String filename;
	private String realfilename;
	
	//getter setter toString
	
	//대다수의 framework는 기본생성자를 필요로 한다.
	public UserVo() {}
	
	public UserVo(String userid, String usernm, String pass, Date reg_dt, String alias, String addr1,
			String addr2, String zipcode) {
		this.userid=userid;
		this.usernm=usernm;
		this.pass=pass;
		this.reg_dt= reg_dt;
		this.alias=alias;
		this.addr1=addr1;
		this.addr2=addr2;
		this.zipcode=zipcode;
		// TODO Auto-generated constructor stub
	}

	public String getAddr1() {
		return addr1 == null? "":addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2 == null? "":addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcode() {
		return zipcode == null?"":zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getFilename() {
		return filename == null?"":filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRealfilename() {
		return realfilename == null?"":realfilename;
	}

	public void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getReg_dt_fmt() {
		//reg_dt 필드가 null이면 ""문자열 반환
		//reg_dt필드가 null이 아니면 SimpleDateFormat을
		//생성하여 yyyy.MM.dd 포맷의 문자열로 변환하여 리턴
		if(this.reg_dt== null) {
			return "";
			
		}else {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy.MM.dd");
			return sdf.format(this.reg_dt);
			
		}
	}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", usernm=" + usernm + ", pass=" + pass + ", reg_dt=" + reg_dt + ", alias="
				+ alias + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", filename=" + filename
				+ ", realfilename=" + realfilename + "]";
	}

	
	
}
