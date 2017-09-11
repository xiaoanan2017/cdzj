package Pojo;

import java.util.Date;

/**
 * 新闻实体类
 * @author Administrator
 *序号、标题、内容、发布时间、排序
 */
public class News {
	private int Nid;
	private String Ntitle;
	private String Ncontent;
	private Date Ntime;
	private int Norder;
	
	/**
	 * 
	 */
	public int getNid() {
		return Nid;
	}
	public void setNid(int nid) {
		Nid = nid;
	}
	public String getNtitle() {
		return Ntitle;
	}
	public void setNtitle(String ntitle) {
		Ntitle = ntitle;
	}
	public String getNcontent() {
		return Ncontent;
	}
	public void setNcontent(String ncontent) {
		Ncontent = ncontent;
	}
	public Date getNtime() {
		return Ntime;
	}
	public void setNtime(Date ntime) {
		Ntime = ntime;
	}
	public int getNorder() {
		return Norder;
	}
	public void setNorder(int norder) {
		Norder = norder;
	}
	
}
