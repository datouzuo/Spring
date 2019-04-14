package mengzuo.xin.untils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ���乤����
 * @author ����ΰ
 *
 */
public class EntityUtil {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(EntityUtil.class);
	/**
	 * ���ֽ���ת���ɶ���
	 * @param cls
	 * @return
	 */
	public static Object newInstance(Class<?> cls) {
		Object instance = null;
		try {
			 instance = cls.newInstance();
		} catch (Exception e) {
			LOGGER.error("ת��ʧ��",e);
			e.printStackTrace();
		}
		return instance;
	}
	/**
	 * ���з���
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
		   LOGGER.error("����ʧ��",e);
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * ���ֶν��и�ֵ
	 * @param field
	 * @param obj
	 * @param value
	 */
	public static void setFiled(Field field,Object obj,Object value ) {
		try {
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			LOGGER.error("��ֵʧ��",e);
			e.printStackTrace();
		}
	}
}
