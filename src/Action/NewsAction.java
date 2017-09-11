package Action;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import Dao.NewsDao;
import Pojo.News;

public class NewsAction extends ActionSupport {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private News news=new News();//创建要使用的对象实例	

	public String execute() throws Exception{
		System.out.println("新闻管理");
		return "NewsManager";
	}

public String doFind(){//查询新闻
	System.out.println("查询新闻");
	ActionContext context=ActionContext.getContext();
	List<News> newslist=new ArrayList<News>();
	newslist=NewsDao.find();//获得新闻对象集合
	context.put("newslist", newslist);//将新闻集合放到request中
	Iterator<News> it=newslist.iterator();
	while(it.hasNext()){
		System.out.println(it.next().getNtitle());
	}
	
	List<String> test=new ArrayList<String>();
	test.add("a11");
	test.add("b11");
	context.put("test", test);
	
//	List<News> newslist=new ArrayList<News>();
//	News new1=new News();
//	new1.setNcontent("1111111");
//	new1.setNid(100);
//	new1.setNorder(10);
//	new1.setNtime(new Date());
//	new1.setNtitle("111111");
//	newslist.add(new1);
	context.put("newslist", newslist);
	return "NewsManager";
}
public String doAdd(){//增加新闻
	ActionContext context=ActionContext.getContext();
	boolean flag=NewsDao.add(news);
	if(flag){
		context.put("addMessage", "收到数据库回传，添加成功");
	}else{
		context.put("addMessage", "收到数据库回传，添加失败");
	}
	return "news";
}
public String doEdit(){//修改新闻
	return null;
}
public String doDelete(){//删除新闻
	return null;
}
}
