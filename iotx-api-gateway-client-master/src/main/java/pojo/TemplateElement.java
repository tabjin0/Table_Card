package pojo;

import lombok.Data;

@Data
public class TemplateElement {

    /** 元素KEY（⽤户⾃⼰定义，不允许重复） */
    private String elementKey;

    /** 元素类型 线条-line，
     圆形-round，矩形-
     rectangle，三⻆形-
     triangle，LOGOIDlogo,单⾏⽂本-
     sltext，多⾏⽂本-
     mltext，条形码-
     barcode，⼆维码-
     qrcode，浮点-
     float，整数-integer */
    private String elementType;

    /** 元素结构json */
    private String elementStruct;

    public TemplateElement() {

    }

    public TemplateElement(String elementKey, String elementType, String elementStruct) {
        this.elementKey = elementKey;
        this.elementType = elementType;
        this.elementStruct = elementStruct;
    }
}
