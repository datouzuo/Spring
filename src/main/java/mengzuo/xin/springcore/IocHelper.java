package mengzuo.xin.springcore;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import mengzuo.xin.beans.DI;
import mengzuo.xin.untils.ArrayUtil;
import mengzuo.xin.untils.EntityUtil;
/**
 * 通过检测DI.class
 * 完成注入，暂时不能面向接口编程，
 * 后期进行改进
 * @author 左利伟
 *
 */
public class IocHelper {

	private static final Map<Class<?>, Object> MAP;
	static {
		MAP = BeanHelper.getBeanMap();
		Set<Entry<Class<?>, Object>> clsSet = MAP.entrySet();
		if (clsSet != null) {
			for (Entry<Class<?>, Object> entry : clsSet) {
				Class<?> cls = entry.getKey();
				Object clsBean = entry.getValue();

				Field[] fields = cls.getFields();
				if (ArrayUtil.isNotEmpty(fields)) {
					for (Field field : fields) {
						if (field.isAnnotationPresent(DI.class)) {
							Class<?> type = field.getType();
							Object fieldbean = BeanHelper.getBean(type);
							if (fieldbean != null) {
								EntityUtil.setFiled(field, clsBean, fieldbean);
							}
						}
					}
				}
			}
		}
	}

}
