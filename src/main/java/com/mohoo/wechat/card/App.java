package com.mohoo.wechat.card;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.mohoo.wechat.card.config.BaseConfig;
import com.mohoo.wechat.card.entity.CardInfo;
import com.mohoo.wechat.card.entity.card.Card;
import com.mohoo.wechat.card.service.WxBaseService;
import com.mohoo.wechat.card.service.WxConsumeService;
import com.mohoo.wechat.card.service.WxCreateService;
import com.mohoo.wechat.card.service.WxPushService;
import com.mohoo.wechat.card.util.PropertiesUtil;

import javafx.scene.layout.Background;

/**
 * baseMain 类描述
 * <p>
 * 创建日期：2016年6月30日<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * 
 * @author Administrator
 * @version 1.0
 */
public class App {
	public static void main(String[] args) {

		//获取accesstoken
//		BaseConfig baseConfig = new BaseConfig();
//		baseConfig.setAppid("wx68061bcd4be1047f");
//		baseConfig.setSecret("d4624c36b6795d1d99dcf0547af5443d");
//		baseConfig.setAccessTokenUrl(PropertiesUtil.getPropertyPath("weixin.get_access_token"));
////		System.out.println(baseConfig);
//		
//		WxBaseService wxBaseService = new WxBaseService(baseConfig);
//		String accessToken = wxBaseService.getAccessToken();
////		System.out.println(accessToken);
	
		//写死accesstoken和at_et
		BaseConfig baseConfig = new BaseConfig();
		baseConfig.setAppid("wx68061bcd4be1047f");
		baseConfig.setSecret("d4624c36b6795d1d99dcf0547af5443d");
		baseConfig.setAccessToken("5_ucreQmw_CLKhu2Wj9n2itULLzkeeTKO_8FG7xim9pdLBnkPEmcrcqdVRbCw0v_xmRN63eTVBZ3AYjidzEg4JPk7KXiv991HrVG8ywK0uvPjwBJohNFFNgA8EP6S0e_8WOMVWOGtYr9XNQcjuJYZcAJAWLM");
		baseConfig.setAccessTokenExpiresTime(1514285706000l);
		
		//上传图片
//		WxCreateService wxCreateService = new WxCreateService(baseConfig);
//		File file =new File("2.jpg");
//		try {
//			Map<String, Object> map = wxCreateService.uploadImg(file);
//			System.out.println(map);
//			String url=(String) map.get("url");
//			System.out.println(url);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("end");
		/* 得到的返回值
		http://mmbiz.qpic.cn/mmbiz_png/eoYrXPETzey7liamUIicrAEsGNrUdukspyAibNxX8AQGrQuxCz1qkWzpwjvVaTIHajERKXgo1acIOMOPwELIgG6ibQ/0
		*/
		
		//创建卡劵
//		WxCreateService wxCreateService = new WxCreateService(baseConfig);
//		try {
//			Map<String, Object> createCard = wxCreateService.createCard("{ \"card\": { \"card_type\": \"GROUPON\", \"groupon\": { \"base_info\": { \"logo_url\": \""
//					+ "http://mmbiz.qpic.cn/mmbiz_png/eoYrXPETzey7liamUIicrAEsGNrUdukspyAibNxX8AQGrQuxCz1qkWzpwjvVaTIHajERKXgo1acIOMOPwELIgG6ibQ/0"
//					+ "\", \"brand_name\":\"微信餐厅\", \"code_type\":\"CODE_TYPE_TEXT\", \"title\": \"132元双人火锅套餐\", \"sub_title\": \"周末狂欢必备\", \"color\": \"Color010\", \"notice\": \"使用时向服务员出示此券\", \"service_phone\": \"020-88888888\", \"description\": \"不可与其他优惠同享\n如需团购券发票，请在消费时向商户提出\n店内均可使用，仅限堂食\", \"date_info\": { \"type\": \"DATE_TYPE_FIX_TERM\", \"fixed_term\": 15 , \"fixed_begin_term\": 0 }, \"sku\": { \"quantity\": 500000 }, \"get_limit\": 3, \"use_custom_code\": false, \"bind_openid\": false, \"can_share\": true, \"can_give_friend\": true, \"location_id_list\" : [123, 12321, 345345], \"custom_url_name\": \"立即使用\", \"custom_url\": \"http://www.qq.com\", \"custom_url_sub_title\": \"6个汉字tips\", \"promotion_url_name\": \"更多优惠\", \"promotion_url\": \"http://www.qq.com\" }, \"deal_detail\": \"以下锅底2选1（有菌王锅、麻辣锅、大骨锅、番茄锅、清补凉锅、酸 菜鱼锅可选）：\n大锅1份 12元\n小锅2份 16元 \"} }}");
//			System.out.println(createCard);
//			System.out.println(createCard.get("card_id"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("end");
		/*得到的返回值 car_id:
		 * prGfcvsGwNzNhEvQG0nzDJUqiOFQ
		 * */

		//创建二维码
//		WxPushService wxPushService = new WxPushService(baseConfig);
//		try {
//			Map<String, Object> createQrcode = wxPushService.createQrcode("{\"action_name\": \"QR_CARD\", \"action_info\": { \"card\": { \"card_id\": \"prGfcvsGwNzNhEvQG0nzDJUqiOFQ\"} } }");
//			System.out.println(createQrcode);
//			System.out.println(createQrcode.get("show_qrcode_url"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("end");
		//使用微信扫一扫上面得到的show_qrcode_url的二维码，领到钱包里
		

		//核销卡券
//		WxConsumeService wxConsumeService = new WxConsumeService(baseConfig);
//		try {
//			Map<String, Object> consumeCode = wxConsumeService.consumeCode("{ \"code\":\"368412175022\" }");
//			System.out.println(consumeCode);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("end");
		//核销后，客户的券就使用掉了




	}
}
