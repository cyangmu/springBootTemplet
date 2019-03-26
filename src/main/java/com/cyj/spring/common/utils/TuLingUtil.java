package com.cyj.spring.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyj.spring.common.utils.comment.HttpUtil;
import com.cyj.spring.system.model.reboot.tuling.TuLingDTO;

import java.util.HashMap;
import java.util.Map;


/**
 * @program: wechat_mangment
 * @description: 图灵机器人对接接口
 * @author: cyj
 * @create: 2018-12-12 16:41
 **/
public class TuLingUtil {

    private static final String URL = "http://openapi.tuling123.com/openapi/api/v2";

    /**
     * 发送文本消息
     */
    public static String sendMsg(String message) {
        TuLingDTO tuLingDTO = new TuLingDTO();
        TuLingDTO.PerceptionBean perceptionBean = new TuLingDTO.PerceptionBean();
        TuLingDTO.PerceptionBean.InputTextBean inputTextBean = new TuLingDTO.PerceptionBean.InputTextBean();
        TuLingDTO.UserInfoBean userInfoBean = new TuLingDTO.UserInfoBean();
        inputTextBean.setText(message);
        perceptionBean.setInputText(inputTextBean);
        userInfoBean.setApiKey("9a6adf9009d44e80bb487b1072c5a778");
        userInfoBean.setUserId("222");
        tuLingDTO.setReqType(0);
        tuLingDTO.setPerception(perceptionBean);
        tuLingDTO.setUserInfo(userInfoBean);
        String result = HttpUtil.HttpPostWithJsonForTuLing(URL, JSON.toJSONString(tuLingDTO));
        System.out.println(result);
        return "";
    }

    private static Map resolveTestReturn(String json) {
        String results = JSON.parseObject(json).getString("results");
        String intent = JSON.parseObject(json).getString("intent");
        String code = JSON.parseObject(intent).getString("code");
        JSONArray jsonArray = JSONArray.parseArray(results);
        Map map = new HashMap(10);
        map.put("code", code);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String resultType = jsonObject.getString("resultType");
            String values = jsonObject.getString("values");
            String data = JSON.parseObject(values).getString(resultType);
            map.put(resultType, data);
        }
        return map;
    }

    public static void main(String[] args) {
        String jsonText = "{\"intent\":{\"actionName\":\"\",\"code\":10004,\"intentName\":\"\"},\"results\":[{\"groupType\":0,\"resultType\":\"text\",\"values\":{\"text\":\"你也好，有何贵干。\"}}]}\n";
        String jsonImage = "{\"intent\":{\"actionName\":\"\",\"code\":10004,\"intentName\":\"\"},\"results\":[{\"groupType\":0,\"resultType\":\"image\",\"values\":{\"silentState\":\"3cc8e240-43ee-4b34-970b-2dc3a29777e8\",\"image\":\"http://turing-chat.oss.tuling123.com/609f20f7a46b2e70d9ba5243c2121ac8.jpg\"}}]}";
        String jsonSkill = "{\"intent\":{\"actionName\":\"\",\"code\":10024,\"intentName\":\"\",\"parameters\":{\"gas_name\":\"汽油\"}},\"results\":[{\"groupType\":1,\"resultType\":\"url\",\"values\":{\"url\":\"http://www.bitauto.com/youjia/\"}},{\"groupType\":1,\"resultType\":\"text\",\"values\":{\"text\":\"亲，已帮你找到汽油的价格信息\"}}]}";
        String jsonJoke = "{\"intent\":{\"actionName\":\"\",\"code\":10006,\"intentName\":\"\"},\"results\":[{\"groupType\":1,\"resultType\":\"text\",\"values\":{\"text\":\"我承认我看到过许多奇葩的四字姓名,但是。。。\"}},{\"groupType\":1,\"resultType\":\"image\",\"values\":{\"silentState\":\"cb40bb1d-36fe-41db-9386-7a9380982a37\",\"image\":\"http://file.tuling123.com/upload/image/xiaohua/20170726/1501079677954.jpg\"}},{\"groupType\":1,\"resultType\":\"text\",\"values\":{\"text\":\"\\n这么奇葩的新生名我还是第一次见.\"}}]}";
        System.out.println(resolveTestReturn(jsonText));
    }
}
