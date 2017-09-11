package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Pojo.News;
import Util.ConnectionPool;

public class NewsDao {
	private static ConnectionPool cp=ConnectionPool.getInstance();//创建连接池对象
	private static Connection conn=cp.getConnection();//获得数据库连接
	/**
	 * 查询新闻
	 * @return 新闻集合
	 */
	public static List<News> find(){
		List<News> newslist=new ArrayList<News>();
		String sql="select *from new limit 0,5";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				News news=new News();
				news.setNid(Integer.parseInt(rs.getString("Nid")));
				news.setNtitle(rs.getString("Ntitle"));
				news.setNcontent(rs.getString("Ncontent"));
				news.setNtime(rs.getDate("Ntime"));
				news.setNorder(Integer.parseInt(rs.getString("Norder")));
				newslist.add(news);//添加到集合里
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("新闻查询出错");
			e.printStackTrace();
		}finally{
			cp.release(conn);//连接池回收连接对象
		}
		return newslist;
	}
	/**
	 * 新增新闻
	 */
	public static boolean add(News news){
		String sql="insert into new(Ntitle,Ncontent,Ntime,Norder) values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, news.getNtitle());
			pstmt.setObject(2, news.getNcontent());
			pstmt.setObject(3, news.getNtime());
			pstmt.setObject(4, news.getNorder());
			int rs=pstmt.executeUpdate();
			if(rs!=0){
				System.out.println("插入成功！");
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("插入失败");
		}finally{
			cp.release(conn);//连接池回收连接对象
		}
		return false;
	}
	
	public static boolean edit(News news){
		String sql="update new SET Ntitle=?, Ncontent=?, Ntime=?, Norder=? WHERE Nid=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, news.getNtitle());
			pstmt.setObject(2, news.getNcontent());
			pstmt.setObject(3, news.getNtime());
			pstmt.setObject(4, news.getNorder());
			pstmt.setObject(5, news.getNid());
			int rs=pstmt.executeUpdate();
			if(rs!=0){
				System.out.println("新闻更新成功");
			}else{
				System.out.println("更新失败");
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cp.release(conn);
		}
		return false;
	}
	
	public static boolean delete(News news){
		String sql="delete from new WHERE Nid=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, news.getNid());
			int rs=pstmt.executeUpdate();
			if(rs!=0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cp.release(conn);
		}
		
		return false;
	}
}
