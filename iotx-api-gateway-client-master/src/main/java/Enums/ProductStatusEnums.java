package Enums;

public enum ProductStatusEnums {

    NO_ACTIVE(0, "未激活"),
    ONLINE(1, "在线"),
    OFFLINE(3, "离线"),
    FORBID(8, "禁用");


    public final Integer type;
    public final String content;

    ProductStatusEnums(Integer type, String content) {
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }
}
