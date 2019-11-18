package com.spring.handler;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.pojo.User;
import com.spring.service.UserServiceInterface;
import com.spring.utils.HttpRequest;





@Controller
@RequestMapping("/")
public class UserHandler {

	@Autowired
	private UserServiceInterface userServiceInterface;

	@RequestMapping("/index")
	public Object index() {
		return "regist";
	}

	@RequestMapping("/regist")
	public String regist(@Valid @ModelAttribute("user") User user, BindingResult br) {
//		System.out.println("name="+user.getName());
//		System.out.println("password="+user.getPassword());
		if (br.hasErrors()) {
			return "regist";
		} else {
			userServiceInterface.addUser(user);
			return "welcome";
		}
	}

	// 小程序数据测试

	@RequestMapping("/getUserInfo")
	@ResponseBody
	public Object getUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		/* 设置响应头允许ajax跨域访问 */
		response.setHeader("Access-Control-Allow-Origin", "*");

		/* 星号表示所有的异域请求都可以接受， */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		// 获取微信小程序get的参数值并打印
		String appID = "wxbc1b046294b9950a";
		String SecretID = "62e89a424e02f44ed37d7cbb7190ea6a";
		String code = request.getParameter("code");
		String grantType = "authorization_code";

		String params = "appid=" + appID + "&secret=" + SecretID + "&js_code=" + code + "&grant_type=" + grantType;
		String str = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
		return str;

	}
	
}
