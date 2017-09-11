package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;



/**
 * 数据库连接
 */
public class ConnectionPool {
	private Vector<Connection> pool;
	private String url;
	private String username;
	private String password;
	private String driverClassName;
	private int poolSize=1;
	private static ConnectionPool instance=null;
	
	//私有构造方法，禁止外部创建本类对象，要想获得本类对象，通过<code>getInstance</code>方法
	private ConnectionPool(){
		//System.out.println("构造函数");
		init();
	}
	
	//连接池初始化方法，读取文件属性文件的内容，建立连接池中的初始连接
	private void init(){
		readConfig();
		pool=new Vector<Connection>(poolSize);
		addConnection();
	}
	//返回到连接池中，回收数据库连接
	public synchronized void release(Connection conn){
		pool.add(conn);
	}
	//关闭连接池中的所有数据库连接
	public synchronized void closePool(){
		for(int i=0;i<pool.size();i++){
			try {
				((Connection)pool.get(i)).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pool.remove(i);
		}
	}
	//返回当前连接池的一个对象
	public static ConnectionPool getInstance(){
		if(instance==null){
			instance=new ConnectionPool();
		}
		return instance;
	}
	//获取当前连接池的一个数据库连接
	public synchronized Connection getConnection(){
		if(pool.size()>0){
			Connection conn=pool.get(0);
			pool.remove(conn);
			return conn;
		}else{
			return null;
		}
	}
	//在连接池中创建初始设置的数据库连接
	private void addConnection(){
		Connection conn=null;
		for(int i=0;i<poolSize;i++){
			try {
				Class.forName(driverClassName);
				conn=java.sql.DriverManager.getConnection(url,username,password);
				pool.add(conn);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}catch(SQLException e){
					e.printStackTrace();
			}		
		}
	}
	//读取设置连接池的属性文件
	private void readConfig(){
		
		try {
			String path=System.getProperty("user.dir")+"\\dbpool.properties";
			System.out.println(path);
			//String path=System.getProperty("user.dir")+"\\src\\dbpool.properties";//System.getProperty("user.dir")当前工程路径
			FileInputStream is;
			is = new FileInputStream(path);
			Properties props=new Properties();
			props.load(is);
			this.driverClassName=props.getProperty("driverClassName");
			//System.out.println(this.driverClassName);
			this.username=props.getProperty("username");
			this.password=props.getProperty("password");
			this.url=props.getProperty("url");
			this.poolSize=Integer.parseInt(props.getProperty("poolSize"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库配置文件找不到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取配置文件出错");
		}		
	}
	
}
