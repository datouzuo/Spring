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
}
