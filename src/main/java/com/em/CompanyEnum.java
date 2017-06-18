package com.em;

/**
 * Created by sa on 2017-06-06.
 * 公司相关数据专用
 *
 */
public enum CompanyEnum {
    //公司id为1
    id(1);

    private int code;

    CompanyEnum(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

}
