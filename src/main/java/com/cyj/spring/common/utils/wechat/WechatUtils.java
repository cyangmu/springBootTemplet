package com.cyj.spring.common.utils.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyj.spring.common.utils.comment.HttpUtil;
import com.cyj.spring.system.model.wechat.AccessToken;
import com.cyj.spring.system.model.wechat.WxinfoEnum;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author cyj
 * @date 2017/11/5
 */
//微信工具类
public class WechatUtils {

    /**
     * 获取凭证
     *
     * @return
     */
    public static AccessToken getAccessToken() {
        AccessToken accessToken = null;
        // 获取access_token的接口地址（GET） 限200（次/天）
        String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String requestUrl = access_token_url.replace("APPID", String.valueOf(WxinfoEnum.APPID)).replace("APPSECRET", String.valueOf(WxinfoEnum.SECRET));
        String result = HttpUtil.sendGet(requestUrl);
        JSONObject json = JSON.parseObject(result);
        System.out.println("开始请求");
        // 如果请求成功
        if (null != json) {
            try {
                accessToken = new AccessToken();
                accessToken.setToken(json.getString("access_token"));
                accessToken.setExpiresIn(json.getInteger("expires_in"));
                System.out.println("请求成功");
            } catch (Exception e) {
                accessToken = null;
                // 获取token失败
                System.out.println("获取token失败 errcode:" + json.getInteger("errcode") + " errmsg:"
                        + json.getString("errmsg"));
            }
        }
        return accessToken;
    }

    /**
     * @param @param  code appId secret
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Title: getOpenId
     * @Description: 根据网页授权获取用户openid
     */
    public static String getOpenId(String code, String appId, String secret) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appId + "&secret=" + secret + "&code="
                + code + "&grant_type=authorization_code";
        String openId = "";
        try {
            URL getUrl = new URL(url);
            HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] b = new byte[size];
            is.read(b);
            String message = new String(b, "UTF-8");
            JSONObject json = JSONObject.parseObject(message);
            openId = json.getString("openid");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return openId;
    }
}