package cn.zl.util;

import java.security.Key;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class WebTokenUtil {

	private static Logger log = Logger.getLogger(WebTokenUtil.class);
	
	private static Key getKeyInstance() {
		
		//生成签名密钥
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("eyJ0e");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		return signingKey;
	}
	
	/**
	 * 创建token
	 * @param claims
	 * @return
	 */
	public static String createWebToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
	}
	
	public static Map<String, Object> verifyWebToken(String jwt) {
		try{
			Map<String, Object> jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
			return jwtClaims;
		}catch(Exception e) {
			log.error("json web token verify failed");
			return null;
		}
		
	}
}
