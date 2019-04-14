package mengzuo.xin.springcore;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mengzuo.xin.untils.EntityUtil;

/**
 * bean助手类
 * @author 左利伟
 *
 */
public final class BeanHelper {
  

	private static final Logger LOGGER =
			LoggerFactory.getLogger(EntityUtil.class);
	private static final Map<Class<?>,Object> MAP = new HashMap<Class<?>,Object>();
	static {
		Set<Class<?>> beanClass = ClassHelper.getBeanClass();
		for(Class<?> cls : beanClass) {
			MAP.put(cls, EntityUtil.newInstance(cls));
		}
		
	}
	/**
	 * 获取Map
	 * key:类的类
	 * Object 对应的对象
	 * @return
	 */
	public static Map<Class<?>,Object> getBeanMap(){
		return MAP;
	} 
	/**
	 * 获得对应类的对象
	 * @param cls
	 * @return
	 */
	 public static Object getBean(Class<?> cls) {
		 if(!MAP.containsKey(cls)) {
			LOGGER.error("没有找到对应的bean"); 
		 }
		 else 
			 return MAP.get(cls);
		 return null;
	 }
	public static void setBean(Class<?> cls,Object obj) {
		
		MAP.put(cls, obj);
	}
}
