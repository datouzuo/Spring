package mengzuo.xin.untils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射工具类
 * @author 左利伟
 *
 */
public class EntityUtil {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(EntityUtil.class);
	/**
	 * 将字节码转换成对象
	 * @param cls
	 * @return
	 */
	public static Object newInstance(Class<?> cls) {
		Object instance = null;
		try {
			 instance = cls.newInstance();
		} catch (Exception e) {
			LOGGER.error("转换失败",e);
			e.printStackTrace();
		}
		return instance;
	}
	/**
	 * 运行方法
	 * @param method
	 * @param obj
	 * @param args
	 * @return
	 */
	public static Object invoke(Method method,Object obj,Object ...args) {
		Object result = null;
		try {
			method.setAccessible(true);
			result = method.invoke(obj, args);
		} catch (Exception e) {
		   LOGGER.error("运行失败",e);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 对字段进行赋值
	 * @param field
	 * @param obj
	 * @param value
	 */
	public static void setFiled(Field field,Object obj,Object value ) {
		try {
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			LOGGER.error("赋值失败",e);
			e.printStackTrace();
		}
	}
}
