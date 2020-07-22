package com.fr.commom.enums;

/**
 * @author : hong.Four
 * @date : 2020-03-13 13:39
 **/
public enum UploadStyle {
    FILE(0,"文件"),
    IMAGE(1,"图片");

    public final Integer type;
    public final String value;
    UploadStyle(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
