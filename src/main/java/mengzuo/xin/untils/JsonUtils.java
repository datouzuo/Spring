package mengzuo.xin.untils;

import org.omg.CORBA.Object;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 对象转换为Json
 * @author 左利伟
 *
 */
public class JsonUtils {

	private static final ObjectMapper OBJECT_JSEON = new ObjectMapper();
	public static <T> String toJson(T object) {
		String json=null;
		try {
		 json= 	OBJECT_JSEON.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
}
