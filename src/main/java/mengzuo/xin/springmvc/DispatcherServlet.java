package mengzuo.xin.springmvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.Enumeration;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mengzuo.xin.beans.Controller;
import mengzuo.xin.beans.Hander;
import mengzuo.xin.beans.Param;
import mengzuo.xin.beans.Requst;
import mengzuo.xin.springcore.BeanHelper;
import mengzuo.xin.springcore.ControllerHelper;
import mengzuo.xin.springcore.HelperLoder;
import mengzuo.xin.untils.ArrayUtil;
import mengzuo.xin.untils.EntityUtil;
import mengzuo.xin.untils.JsonUtils;

/**
 * ǰ�˿��ƿ�����
 * @author ����ΰ
 *
 */
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		//�õ�·���ͷ���
		String requsetPath = req.getPathInfo();
		String requstMethod = req.getMethod().toLowerCase();
		//�õ�������
		Hander hander = ControllerHelper.getHander(requstMethod, requsetPath);
	     if(hander!=null) {
	    	 Class<?> cls = hander.getControllerClass();
	    	 Method method = hander.getActionMethod();    
	    		 req.setCharacterEncoding("UTF-8");
	    		 Map parameterMap = req.getParameterMap();
	    		 Param param = new Param();
	    		 //�õ�����
	    		param.getParamMap().putAll(parameterMap);
	   
	    		Object obj = BeanHelper.getBean(cls);
	    		//��ò�������
	    		 Object object =null;
	    		 Type[] genericParameterTypes = method.getGenericParameterTypes();
	    		if(!ArrayUtil.isNotEmpty(genericParameterTypes)) {
	    			 object = EntityUtil.invoke(method, obj);
	    			
	    		}else {
	    		 //TODO��Ϊ��װ����
	    	     
	    		param.setRequset(req);
	    		param.setResponse(resp);  	    
	    		
	    	   object = EntityUtil.invoke(method, obj, param);
	    		}
	    	   String reult =null;
	    	   if(object instanceof String) {
	    		   reult = String.valueOf(object);
	    	   }
	    	   else {
	    		   reult = JsonUtils.toJson(object);
	    	   }
	    	   //����Jsonֵ
	    	   resp.setContentType("application/json");
	    	   resp.setCharacterEncoding("UTF-8");
	    	   PrintWriter writer = resp.getWriter();
	    	   writer.write(reult);
	    	   writer.flush();
	    	   writer.close();
	     }
	               
	}
/**
 * ����ʱ���г�ʼ��
 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		HelperLoder.init();
	}
	

}

