package mengzuo.xin.beans;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��װ�����õ�
 * @author ����ΰ
 *
 */
public class Param {
	//��װ�ύ�Ĳ���
 private Map<String,Object> paramMap;

public Map<String, Object> getParamMap() {
	return paramMap;
}
/**
 * ��װrequst����
 */
 private HttpServletRequest requset;
 /**
  * ��װ��response
  */
 private HttpServletResponse response;

public HttpServletRequest getRequset() {
	return requset;
}
public void setRequset(HttpServletRequest requset) {
	this.requset = requset;
}
public HttpServletResponse getResponse() {
	return response;
}
public void setResponse(HttpServletResponse response) {
	this.response = response;
}

 
}
