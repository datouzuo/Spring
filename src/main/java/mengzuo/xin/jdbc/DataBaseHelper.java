package mengzuo.xin.jdbc;

import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mysql.jdbc.Connection;

import mengzuo.xin.springcore.ConfigHepler;
import mengzuo.xin.springcore.ControllerHelper;
import mengzuo.xin.untils.ConfigConstant;
import net.sf.cglib.core.Local;

/**
 * 连接池
 * @author 左利伟
 *
 */
public class DataBaseHelper {

	private static final DruidDataSource dataSource;
	
	//加载线程池
	static {
	 dataSource = new DruidDataSource();
		dataSource.setDriverClassName(ConfigHepler.getJDBCDriver());
		dataSource.setUrl(ConfigHepler.getJDBCUrl());
		dataSource.setUsername(ConfigHepler.getJDBCUsername());
		dataSource.setPassword(ConfigHepler.getJDBCPassword());
		
	}
	
	private static final ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	//开启事务
	public static void beginTransaction () {
	Connection connection =null;
			try {
				connection= (Connection) dataSource.getConnection();
				if(connection!=null) {
				connection.setAutoCommit(false);
				}
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				local.set( connection);
			}
			
			
		
		
	}
	//提交事务
public static void commitTransaction() {
	Connection connection = local.get();
	if(connection!=null) {
		try {
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			local.remove();
		}
	}
	
}
//事务回滚
public static void rollbackTransaction() {
	
	Connection connection = local.get();
	if(connection!=null) {
		try {
			connection.rollback();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			local.remove();
		}
	}
	
}
	
}
