package com.convert;

import com.em.GradeEnum;

/**
 * Created by sa on 2017-06-09.
 * 用来表示级别调整
 */
public class GradeConvert {

    //级别提高
    public static String upGrade(String grade){
        switch(grade){
            case "B":
                return GradeEnum.A.code();
            case "C":
                return GradeEnum.B.code();
            default:
                return GradeEnum.A.code();
        }
    }

    //级别下降
    public static String downGrade(String grade){
        switch(grade){
            case "A":
                return GradeEnum.B.code();
            case "B":
                return GradeEnum.C.code();
            default:
                return GradeEnum.C.code();
        }
    }
}
