package mengzuo.xin.untils;



/**
 * 类型转换
 * @author 左利伟
 *
 */
public final class CastUtil {

	
	public static String castString(Object object) {
		return castString(object,"");
	}
	/**
	 * 类型转换，并加入默认值
	 * @param object
	 * @param defauleValue
	 * @return
	 */
	public static String castString(Object object,String defauleValue) {
	return object!=null?String.valueOf(object):defauleValue;
			
	}
	/**
	 * object转换int
	 * @param object
	 * @return
	 */
	public static int castInt(Object object) {
		return castInt(object,0);
		
	}
	public static int castInt(Object object,int defaultValue) {
		int value = defaultValue;
		try {
			if(object!=null) {
				String obj = castString(object);
				if(StringUtil.isNotEmpty(obj))
				value = Integer.parseInt(obj);
			}
		} catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}
	/**
	 * object转换double
	 * @param object
	 * @return
	 */
	public static double castDouble(Object object) {
		return castDouble(object,0);
		
	}
	public static double castDouble(Object object,int defaultValue) {
		double value = defaultValue;
		try {
			if(object!=null) {
				String obj = castString(object);
				if(StringUtil.isNotEmpty(obj))
				value = Double.parseDouble(obj);
			}
		} catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}
	/**
	 * 转换为Long型
	 * @param object
	 * @return
	 */
	public static long castLong(Object object) {
		return castLong(object,0);
		
	}
	public static long castLong(Object object,int defaultValue) {
		long value = defaultValue;
		try {
			if(object!=null) {
				String obj = castString(object);
				if(StringUtil.isNotEmpty(obj))
				value = Long.parseLong(obj);
			}
		} catch (Exception e) {
			value = defaultValue;
		}
		return value;
	}
	/**
	 * 转换为boolean型
	 * @param object
	 * @return
	 */
	public static boolean castBoolean(Object object) {
		return castBoolean(object,false);
	}
	public static boolean castBoolean(Object object,boolean deflutvalue) {
		boolean value = deflutvalue;
		if(object!=null) {
			try {
				
				String obj = castString(object);
				value = Boolean.parseBoolean(obj);
			} catch (Exception e) {
				value = deflutvalue;
			}
		}
		return value;
	}
   	
}
