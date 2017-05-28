package utils;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.StaticBucketMap;

public class MyStringUtlis {
	public static String  toUTFString(HttpServletRequest request,String str) throws UnsupportedEncodingException {
		//String utf = new String(request.getParameter(str).getBytes("ISO8859-1"),"UTF-8");
		String utf = request.getParameter(str);
		return utf;
	}

}
