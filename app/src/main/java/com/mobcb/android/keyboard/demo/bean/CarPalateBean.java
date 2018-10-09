package com.mobcb.android.keyboard.demo.bean;

public class CarPalateBean {
    public static final String CODE_PROVINCE = "province";//省份
    public static final String CODE_CHAR = "char";//ABCD之类的,苏A中的A
    public static final String CODE_NUMBER = "number";//车牌号内容
    public static final String CODE_END = "end";//新能源; 学;港 ;澳 ;警
    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
