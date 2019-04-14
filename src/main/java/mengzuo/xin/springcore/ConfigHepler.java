package mengzuo.xin.springcore;

import java.util.Properties;

import mengzuo.xin.untils.ConfigConstant;
import mengzuo.xin.untils.ProperUntil;
/**
 * ���ù�����
 * @author ����ΰ
 *
 */
public final class ConfigHepler {
 
	private static final Properties CINFIGFIFE = 
			ProperUntil.loadProper(ConfigConstant.CONFIG_FIFE);
//��ȡ��Ҫɨ��İ�
	public static String getScanPackage() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.SCAN_PACKAGE);
		
	}
	//��ȡ���ݿ�����
	public static String getJDBCDriver() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.JDBC_DRIVER);
	}
	//��ȡ���ݿ��ַ
	public static String getJDBCUrl() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.JDBC_URL);
	}
	//��ȡ���ݿ���û���
	public static String getJDBCUsername() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.JDBC_USERNAME);
	}
	//��ȡ���ݿ������
	public static String getJDBCPassword() {
		return ProperUntil.getString(CINFIGFIFE, ConfigConstant.JDBC_PASSWORD);
	}
}
