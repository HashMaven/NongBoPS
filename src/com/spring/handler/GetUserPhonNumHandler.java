package com.spring.handler;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class GetUserPhonNumHandler {
	@RequestMapping("/getUserPhoneNumbers")
	@ResponseBody
	public Object getUserPhoneNumber(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		/* 设置响应头允许ajax跨域访问 */
		response.setHeader("Access-Control-Allow-Origin", "*");

		/* 星号表示所有的异域请求都可以接受， */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		// 获取微信小程序get的参数值并打印
		
		String encryptedData = request.getParameter("encryptedData");
		String session_key = request.getParameter("sessionKey");
		String iv = request.getParameter("iv");
		String result = wxDecrypt(encryptedData, session_key, iv);
		return result;
	}

	// 算法名
		  public static final String KEY_NAME = "AES";
		  // 加解密算法/模式/填充方式
		  // ECB模式只用密钥即可对数据进行加密解密，CBC模式需要添加一个iv
//		  public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";
		  public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";
		  
		  public static String wxDecrypt(String encrypted, String session_key, String iv) {
			    String json = null;
			    byte[] encrypted64 = Base64.decodeBase64(encrypted);
			    byte[] key64 = Base64.decodeBase64(session_key);
			    byte[] iv64 = Base64.decodeBase64(iv);
			    try {
			      init();
			      json = new String(decrypt(encrypted64, key64, generateIV(iv64)));
			    } catch (Exception e) {
			      e.printStackTrace();
			    }
			    return json;
			  }
		  /**
		   * 初始化密钥
		   */
		  public static void init() throws Exception {

				  if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null){
				  System.out.println("security provider BC not found");
				  Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
				  }
		    
		    KeyGenerator.getInstance(KEY_NAME).init(128);
		  }
		 
		  /**
		   * 生成iv
		   */
		  public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
		    // iv 为一个 16 字节的数组，这里采用和 iOS 端一样的构造方法，数据全为0
		    // Arrays.fill(iv, (byte) 0x00);
		    AlgorithmParameters params = AlgorithmParameters.getInstance(KEY_NAME);
		    params.init(new IvParameterSpec(iv));
		    return params;
		  }
		 
		  /**
		   * 生成解密
		   */
		  public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes, AlgorithmParameters iv)
		      throws Exception {
		    Key key = new SecretKeySpec(keyBytes, KEY_NAME);
		    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		    // 设置为解密模式
		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
		    System.out.println(cipher.doFinal(encryptedData));
		    return cipher.doFinal(encryptedData);
		  }
}
