package com.em;

/**
 * Created by sa on 2017-06-18.
 * 阶段分为无个阶段，分为：受理、审批、批复、贷后监控，结束
 */
public enum PeriodStatusEnum {

    accept("受理"),approval("审批"),reply("批复"),monitor("贷后监控"),end("结束");

    private String code;

    PeriodStatusEnum(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
