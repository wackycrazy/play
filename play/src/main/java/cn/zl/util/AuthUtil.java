package cn.zl.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class AuthUtil {

	private static Map<String, Object> getClientLoginInfo(HttpServletRequest request) throws Exception {
		Map<String, Object> decode = new HashMap<String, Object>();
		String sessionId = request.getHeader("sessionId");
		if(sessionId != null) {
			decode = decodeSession(sessionId);
			return decode;
		}
		throw new Exception("session 解析错误");
	}
	
	public static Long getUserId(HttpServletRequest request) throws Exception {
		return Long.valueOf((Integer)getClientLoginInfo(request).get("userId"));
	}
	
	/**
	 * session解密
	 * @param sessionId
	 * @return
	 */
	public static Map<String, Object> decodeSession(String sessionId) {
		try{
			return WebTokenUtil.verifyWebToken(sessionId);
		}catch(Exception e) {
			System.err.println("json web token verify failed");
			return null;
		}
	}
}
