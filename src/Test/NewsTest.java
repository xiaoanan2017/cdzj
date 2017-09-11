package Test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Action.NewsAction;
import Dao.NewsDao;
import Pojo.News;

public class NewsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("测试开始");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("测试结束");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("测试中");
	}

	@Test
	public void findtest() {//新闻查询测试		
		Iterator<News> it=(NewsDao.find()).iterator();
		while(it.hasNext()){
			//System.out.println(it.next().getNtime());
			System.out.println(it.next().getNtitle());
		}
	}
	
	@Test
	public void addtest() {//新闻新增测试
		News news=new News();
		news.setNcontent("测试内容5555");
		news.setNorder(4);
		news.setNtime(new Date());
		news.setNtitle("新闻标题4");
		NewsDao.add(news);
	}
	@Test
	public void edittest(){
		News news=new News();
		news.setNcontent("aaaaa");
		news.setNorder(4);
		news.setNtime(new Date());
		news.setNtitle("更新内容..........");
		news.setNid(6);
		NewsDao.edit(news);
	}
	@Test
	public void deleteTest(){
		News news=new News();
		news.setNid(1);
		NewsDao.delete(news);
	}
}
