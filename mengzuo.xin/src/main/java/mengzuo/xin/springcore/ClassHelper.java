package mengzuo.xin.springcore;

import java.util.HashSet;
import java.util.Set;

import mengzuo.xin.beans.Controller;
import mengzuo.xin.beans.Dao;
import mengzuo.xin.beans.MyService;
import mengzuo.xin.untils.ClassUntil;

/**
 * �õ���ͬ��ע���ֽ���
 * @author ����ΰ
 *
 */
public final class ClassHelper {

	private static final Set<Class<?>> classset;
	
	static {
		String path = ConfigHepler.getScanPackage();
		classset=ClassUntil.getAllClass(path);
		
	}
	/**
	 * �õ�controllerע����
	 * @return
	 */
	public static Set<Class<?>> getControllerClass(){
	Set<Class<?>> ctc = new HashSet<Class<?>>();
	for(Class<?> cls : classset) {
		if(cls.isAnnotationPresent(Controller.class)) {
			ctc.add(cls);
		}
		
	}
	return ctc;
	}
	/**
	 * �õ�MySeviceע�����
	 * @return
	 */
	public static Set<Class<?>> getMyServiceClass(){
		Set<Class<?>> ctc = new HashSet<Class<?>>();
		for(Class<?> cls : classset) {
			if(cls.isAnnotationPresent(MyService.class)) {
				ctc.add(cls);
			}
			
		}
		return ctc;
 	}
	/**
	 * �õ�Daoע�����
	 * @return
	 */
	public static Set<Class<?>> getDaoClass(){
		Set<Class<?>> ctc = new HashSet<Class<?>>();
		for(Class<?> cls : classset) {
			if(cls.isAnnotationPresent(Dao.class)) {
				ctc.add(cls);
			}
			
		}
		return ctc;
 	}
	/**
	 * �õ���ע�����
	 * @return
	 */
	public static Set<Class<?>> getBeanClass(){
		Set<Class<?>> ctc = new HashSet<Class<?>>();
		ctc.addAll(getControllerClass());
		ctc.addAll(getDaoClass());
		ctc.addAll(getMyServiceClass());
		return ctc;
 	}
	
	/**
	 * �õ��������е���
	 * @return
	 */
	public static Set<Class<?>> getAllClass(){
		return classset;
 	}	
}
