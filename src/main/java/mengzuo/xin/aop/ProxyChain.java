package mengzuo.xin.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 代理链
 * @author 左利伟
 *
 */
public class ProxyChain {

	public ProxyChain(Class<?> targetClass, Object object, Method method, Object[] params, List proxyList) {
		super();
		this.targetClass = targetClass;
		this.object = object;
		this.method = method;
		this.params = params;
		this.proxyList = proxyList;
		
	}
//目标字节码
	private final Class<?> targetClass;
	//目标对象
	private final Object object;
	//目标方法
	private final Method method;
	//方法参数
	private final Object[] params;
	//代理链
	private List<Proxy> proxyList = new ArrayList<Proxy>();
    
	public Class<?> getTargetClass() {
		return targetClass;
	}

	public Object getObject() {
		return object;
	}

	public Method getMethod() {
		return method;
	}

	public Object[] getParams() {
		return params;
	}
	private int proxyIndex = 0;
	
	public Object doProxyChain() throws Exception {
		Object methodResult;
		if(proxyIndex<proxyList.size()) {
			methodResult= proxyList.get(proxyIndex++).doProxy(this);
		}
		else {
		 methodResult =	method.invoke(object, params);
		}
		return methodResult;
	}
	
}
