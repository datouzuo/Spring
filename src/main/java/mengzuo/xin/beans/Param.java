package mengzuo.xin.beans;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 封装参数用的
 * @author 左利伟
 *
 */
public class Param {
	//封装提交的参数
 private Map<String,Object> paramMap;

public Map<String, Object> getParamMap() {
	return paramMap;
}
/**
 * 封装requst对象
 */
 private HttpServletRequest requset;
 /**
  * 封装的response
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
