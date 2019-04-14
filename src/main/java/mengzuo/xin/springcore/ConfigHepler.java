package mengzuo.xin.springcore;

import java.util.Properties;

import mengzuo.xin.untils.ConfigConstant;
import mengzuo.xin.untils.ProperUntil;
/**
 * 配置工具类
 * @author 左利伟
 *
 */
public final class ConfigHepler {
 
	private static final Properties CINFIGFIFE = 
			ProperUntil.loadProper(ConfigConstant.CONFIG_FIFE);
//获取需要扫描的包
	public static String getScanPackage() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.SCAN_PACKAGE);
		
	}
	//获取数据库驱动
	public static String getJDBCDriver() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.JDBC_DRIVER);
	}
	//获取数据库地址
	public static String getJDBCUrl() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.JDBC_URL);
	}
	//获取数据库的用户名
	public static String getJDBCUsername() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.JDBC_USERNAME);
	}
	//获取数据库的密码
	public static String getJDBCPassword() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.JDBC_PASSWORD);
	}
}
