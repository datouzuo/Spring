package mengzuo.xin.untils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public final class ProperUntil {

	private final static Logger LOGGER =
			LoggerFactory.getLogger(ProperUntil.class);
   public static Properties loadProper(String path) {
	   URL pa = Thread.currentThread().getContextClassLoader().getResource(path);
	   InputStream stream=null;
	   Properties pp =null;
	   try {
        	stream = new FileInputStream(new File(pa.toString()));
        	pp.load(stream);
        	
		} catch (IOException e) {
			LOGGER.error("�ļ�������",e);
			e.printStackTrace();
		}finally {
			if(stream!=null)
				try {
					stream.close();
				} catch (IOException e) {
					LOGGER.error("�ر���ʧ��",e);
					e.printStackTrace();
				}
		}
	    
       
        return pp;
   }
	public static String getString(Properties proper,String key) {
		
		
	return getString( proper, key,"");
	
	}
	/**���ļ��еõ��ַ���
     * ����ʱ����Ĭ��ֵ
     * @param proper
     * @param key
     * @param defaultValue
     * @return 
     */
	public static String getString(Properties proper,String key,String defaultValue) {
	 String value = defaultValue;
		if(proper.containsKey(key))
		value= proper.getProperty(key);
		 
		return value;
		
	} 
	/**
	 * ���ļ��еõ�intֵ
	 * @param proper
	 * @param key
	 * @return
	 */
	public static int getInt(Properties proper,String key) {
		return getInt(proper,key, 0);
	}
	public static int getInt(Properties proper,String key,int defaultvalue) {
		int value = defaultvalue;
		if(proper.containsKey(value)) {
			String obj = proper.getProperty(key);
			value = CastUtil.castInt(obj);
		}
		return value;
	}
	/**
	 * ���ļ��еõ�boolean��ֵ
	 * @param peroper
	 * @param key
	 * @return
	 */
	public static boolean getBoolean(Properties peroper,String key) {
		return getBoolean(peroper,key,false);
	}
	public static boolean getBoolean(Properties proper,String key,boolean defaultvalue) {
		boolean value = defaultvalue;
		if(proper.containsKey(key)) {
			String obj  = proper.getProperty(key);
			value = CastUtil.castBoolean(obj);
		}
		return value;
	}
}
