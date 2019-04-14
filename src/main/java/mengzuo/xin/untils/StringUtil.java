package mengzuo.xin.untils;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
 
	public static boolean isNotEmpty(String s) {
		if(s!=null) {
			s.trim();
		}
		return StringUtils.isNotEmpty(s);
	}
}
