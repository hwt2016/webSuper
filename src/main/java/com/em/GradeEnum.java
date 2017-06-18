package com.em;

/**
 * Created by sa on 2017-05-27.
 * 划分用户等级
 * A B C三个等级
 */
public enum GradeEnum {
    //A级、B级、C、级
    A("A"), B("B"),C("C");

    private String code;

    GradeEnum(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
