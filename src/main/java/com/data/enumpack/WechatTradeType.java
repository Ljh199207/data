package com.data.enumpack;


/**
 * 交易类型
 * （交易方式）
 *
 * @author defei
 */
public enum WechatTradeType   {

    APP("APP", 20, "APP支付(微信)", "APP"),

    NATIVE("NATIVE", 21, "扫码支付(微信)", "NATIVE"),

    MWEB("WEB", 22, "H5支付(微信)", "MWEB"),

    JSAPI("JSAPI", 23, "公众号支付(微信)", "JSAPI"),

    SMALL_PROGRAM("SMALL_PROGRAM", 24, "小程序(微信)", "SMALL_PROGRAM");

    public static WechatTradeType valueOf(Integer type) {
        for (WechatTradeType paymentType : values()) {
            if (paymentType.getValue() == type) {
                return paymentType;
            }
        }
        return null;
    }

    public static class Converter<WechatTradeType> {
    }

    private String paymentScene;

    private final int value;

    private final String tradeType;

    private final String desc;

    public int getValue() {
        return value;
    }
    public String getDesc() {
        return desc;
    }

    /**
     * {@linkplain WechatTradeType#tradeType}
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * {@linkplain WechatTradeType#paymentScene}
     */
    public String getPaymentScene() {
        return paymentScene;
    }

    WechatTradeType(String paymentScene, int value, String desc, String tradeType) {
        this.paymentScene = paymentScene;
        this.value = value;
        this.desc = desc;
        this.tradeType = tradeType;
    }

}
