package Action;

import com.opensymphony.xwork2.ActionSupport;

import Pojo.News;

public class CarousalAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	News news=new News();
	public String execute() throws Exception{
		System.out.println("轮播图");
		return SUCCESS;
	}
}
