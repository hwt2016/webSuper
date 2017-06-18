package com.em;

/**
 * Created by sa on 2017-05-27.
 * 状态专用 当前分为正常、停用、跟进、结束
 */
public enum  StatusEnum {

    NORMAL("正常"), DELETED("停用"),FOLLOWING("跟进"),END("结束");

    private String code;

    StatusEnum(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
