package mengzuo.xin.springcore;

import mengzuo.xin.untils.ClassUntil;
import mengzuo.xin.untils.EntityUtil;

public class HelperLoder {

	public static void loder() {
		Class<?>[] clsArra = {
				ConfigHepler.class,
				ClassHelper.class,
				BeanHelper.class,
				IocHelper.class
		};
		for(Class<?> cls : clsArra) {
			ClassUntil.loadClass(cls.getName());
		}
	}
	
}
