package com.cyj.spring.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyj.spring.common.utils.comment.HttpUtil;


/**
 * Created by cyj
 * on 2018/8/14.
 */
public class JudeMobileAttribution {
    /**
     * 精确到省
     *
     * @param phoneNum 手机号码
     * @return 浙江
     */
    public static String getMobileAddress(String phoneNum) {
        if (phoneNum.isEmpty()) {
            return "手机号为空";
        } else {
            String result = HttpUtil.sendGet("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?" + "tel=" + phoneNum);
            System.out.println(result);
            String json = result.replace("__GetZoneResult_ = ", "");
            JSONObject jobj = JSON.parseObject(json);
            String data1 = jobj.get("province").toString();
            return data1;
        }
    }

    /**
     * 精确到市
     *
     * @param phoneNum 手机号码
     * @return 浙江杭州移动
     */
    public static String getMobileAddressByBaiDu(String phoneNum) {
        if (phoneNum.isEmpty()) {
            return "手机号为空";
        } else {
            String result = HttpUtil.sendGet("http://mobsec-dianhua.baidu.com/dianhua_api/open/location?" + "tel=" + phoneNum);
            System.out.println(result);
            JSONObject json = JSON.parseObject(result);
            String response = json.get("response").toString();
            JSONObject detail = JSON.parseObject(response);
            if (detail.containsKey(phoneNum)) {
                return JSON.parseObject(detail.get(phoneNum).toString()).get("location").toString();
            } else {
                return "手机号查询失败";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(JudeMobileAttribution.getMobileAddressByBaiDu(""));
    }
}
