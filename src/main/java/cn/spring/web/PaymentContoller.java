package cn.spring.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentContoller {

	@RequestMapping("/payType.html")
	public String payment(Model model) throws IOException {
	/*
	 * 获取jar包中的图片展现在页面上
	 * 
	 */
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-alipay-imgs-api.xml");
		AlipyImages alipy = (AlipyImages) ctx.getBean("alipay");

		//获取图片输入流
		InputStream in = alipy.getImgs().getInputStream();
		//InputStream转化为byte[]数组
		String apBase64Encoded = encode(in);
		
		model.addAttribute("alipayimges", apBase64Encoded);
		return "pay/payType";
	}

	private String encode(InputStream in) throws IOException, UnsupportedEncodingException {
		///读取输入流内容的字节到字节数组中
		byte[] data = IOUtils.toByteArray(in);
		byte[] encodeBase64 = Base64.encodeBase64(data);
		String base64Encoded = new String(encodeBase64, "UTF-8");
		return base64Encoded;
	}

}
