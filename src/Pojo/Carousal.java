package Pojo;

import java.util.Date;

/**
 * 轮播图实体类
 * @author Administrator
 *
 */
public class Carousal {
	private int Cid;
	private String Cpic;
	private int Corder;
	private boolean isValid;
	private Date Ctime;
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getCpic() {
		return Cpic;
	}
	public void setCpic(String cpic) {
		Cpic = cpic;
	}
	public int getCorder() {
		return Corder;
	}
	public void setCorder(int corder) {
		Corder = corder;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public Date getCtime() {
		return Ctime;
	}
	public void setCtime(Date ctime) {
		Ctime = ctime;
	}
}
