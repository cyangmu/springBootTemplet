package com.cyj.spring.system.model.reboot.tuling;

/**
 * @program: wechat_mangment
 * @description: 图灵机器人DTO
 * @author: cyj
 * @create: 2018-12-12 16:42
 **/
public class TuLingDTO {

    /**
     * reqType : 0
     * perception : {"inputText":{"text":"快递单号"}}
     * userInfo : {"apiKey":"9a6adf9009d44e80bb487b1072c5a778","userId":"9999"}
     */

    private int reqType;
    private PerceptionBean perception;
    private UserInfoBean userInfo;

    public int getReqType() {
        return reqType;
    }

    public void setReqType(int reqType) {
        this.reqType = reqType;
    }

    public PerceptionBean getPerception() {
        return perception;
    }

    public void setPerception(PerceptionBean perception) {
        this.perception = perception;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public static class PerceptionBean {
        /**
         * inputText : {"text":"快递单号"}
         */

        private InputTextBean inputText;

        public InputTextBean getInputText() {
            return inputText;
        }

        public void setInputText(InputTextBean inputText) {
            this.inputText = inputText;
        }

        public static class InputTextBean {
            /**
             * text : 快递单号
             */

            private String text;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }

    public static class UserInfoBean {
        /**
         * apiKey : 9a6adf9009d44e80bb487b1072c5a778
         * userId : 9999
         */

        private String apiKey;
        private String userId;

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
