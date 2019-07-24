package pojo;

import lombok.Data;

@Data
public class TemplateElementStruct {

    private Long left;
    private Long top;
    private Long fontSize;
    private Long color;

    /** 画线 1上划线
     2中划线 3下划线 */
    private Long drawLineType;

    private Long fontType;
    private Long levelAlign;
    private Long encode;
}
