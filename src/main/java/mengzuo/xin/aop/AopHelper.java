package mengzuo.xin.aop;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import mengzuo.xin.beans.Aop;
import mengzuo.xin.beans.Transaction;
import mengzuo.xin.jdbc.TransactionProxy;
import mengzuo.xin.springcore.BeanHelper;
import mengzuo.xin.springcore.ClassHelper;
import mengzuo.xin.untils.ClassUntil;

/**
 * aop������
 * @author ����ΰ
 *
 */
public final class AopHelper {
//���ɴ����ಢ�滻ԭ������
	static {
		try {
		Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
			Map<Class<?>, List<Aspect>> creatTarget = creatTarget(proxyMap);
		 Set<Entry<Class<?>,List<Aspect>>> entrySet = creatTarget.entrySet();
		for(Entry<Class<?>,List<Aspect>> entry : entrySet) {
			Class<?> key = entry.getKey();
			List<Aspect> list = entry.getValue();
			Object object = ProxyManager.creatProxy(key, list);
		   BeanHelper.setBean(key, object);
		}
		} catch (Exception e) {
			
		
		}
		
		
		
	}
	
	
	
	
	/**
	 * �õ�Aopע����value��Ӧ��ֵ
	 * @param aop
	 * @return
	 */
	public static Set<Class<?>> creatTargetClassSet(Aop aop){
			Set<Class<?>> clsSet = new HashSet<Class<?>>();
			Class<? extends Annotation> value = aop.value();
			if(value!=null) {
				clsSet = ClassHelper.getClassAnnotation(value);
			}
			return clsSet;
	}
	/**
	 * �õ�Map��keyΪ����value������ĵ���
	 * @return
	 */
	public static Map<Class<?>,Set<Class<?>>> createProxyMap(){
		HashMap<Class<?>,Set<Class<?>>> map = new HashMap<Class<?>,Set<Class<?>>>();
		Set<Class<?>> classSuper = ClassHelper.getClassSuper(Aspect.class);
		map.putAll(addTransaction());
		if(classSuper!=null) {
			for(Class cls:classSuper) {
				if(cls.isAnnotationPresent(Aop.class)) {
				 Aop aop = (Aop) cls.getAnnotation(Aop.class);
				 Set<Class<?>> targetClassSet = creatTargetClassSet(aop);
				 map.put(cls, targetClassSet);
				}
			}
		}
		return map;
	}
	//����������
	private static  Map<Class<?>,Set<Class<?>>> addTransaction(){
		Map<Class<?>,Set<Class<?>>> hashMap = new HashMap<Class<?>,Set<Class<?>>>();
		Set<Class<?>> annotation = ClassHelper.getClassAnnotation(Transaction.class);
		if(annotation!=null) {
			hashMap.put(TransactionProxy.class, annotation);
		}
		
		return hashMap;
	}
	/**
	 * �õ���Ӧ���������
	 * @param map
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static Map<Class<?>,List<Aspect>> creatTarget(Map<Class<?>,Set<Class<?>>> map) throws InstantiationException, IllegalAccessException{
		
		Map<Class<?>, List<Aspect>> targetMap = new HashMap<Class<?>,List<Aspect>>();
		Set<Entry<Class<?>,Set<Class<?>>>> entrySet = map.entrySet();
		for(Entry<Class<?>,Set<Class<?>>> entry : entrySet) {
			Class<?> aspectClass = entry.getKey();
			Set<Class<?>> value = entry.getValue();
			Aspect aspect = (Aspect) aspectClass.newInstance();
			for(Class<?> cls : value) {
			 List<Aspect> list = targetMap.get(cls);
			 if(list!=null) {
				 list.add(aspect);
			 }else {
				 List<Aspect> aspectList = new ArrayList<Aspect>();
				 aspectList.add(aspect);
				 targetMap.put(cls, aspectList);
			 }
				
				
			}
		}
		return targetMap;
	}
}
