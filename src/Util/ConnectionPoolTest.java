package Util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class ConnectionPoolTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("测试结束");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("测试前的初始化");
	}
	
	@Test
	public void test() throws SQLException {
		String sql="select *from user";
		ConnectionPool pool=null;
		pool= ConnectionPool.getInstance();
		for(int i=0;i<10;i++){		
			Connection conn=pool.getConnection();
			System.out.println(1);
			PreparedStatement stmt=conn.prepareStatement(sql);
		
			ResultSet rs= stmt.executeQuery();
			
			while(rs.next()){			
				System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
			}
			rs.close();
			stmt.close();
			pool.release(conn);//将数据库连接放回连接池
		}
		pool.closePool();	
	}
	@Test
	public void mp(){
		int[] A={3,2,1,4,5};
		for(int i=0;i<A.length;i++){
			System.out.println("i:"+i);
            for(int k=i;k<A.length;k++){
                if(A[i]>A[k]){
                    int temp=A[k];
                    A[k]=A[i];
                    A[i]=temp;
                }
                for(int c:A)
                	System.out.print(c);
                System.out.println();
            }           
        }
	}
}
