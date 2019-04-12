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
}
