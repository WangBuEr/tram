package me.king.admin.util;

import java.util.HashMap;
import java.util.Map;

import me.king.util.http.HttpClientUtil;

public class SmsUtil {
	
	public static void main(String[] args) throws Exception {
//		Client client =  new Client("9SDK-EMY-0999-JDVRT", "430863");
//		int a= client.sendSMS(new String[] {"18651807631"}, "hello world", 3);
//		System.out.println("短信发送结果:"+a);
		Map<String, String> params = new HashMap<>();
		params.put("cdkey", "9SDK-EMY-0999-JDVRT");
		params.put("password", "430863");
		params.put("phone", "13360502171");
		params.put("message", "【某某公司】您好，回复TD退订");
		params.put("addserial", "");
		params.put("seqid", System.currentTimeMillis() + "");
		params.put("smspriority", "1");
		String result = HttpClientUtil.getServiceResponseAsString("http://sdk999in.eucp.b2m.cn:8080/sdkproxy/sendsms.action", params);
		System.out.println(result);

	}
}
