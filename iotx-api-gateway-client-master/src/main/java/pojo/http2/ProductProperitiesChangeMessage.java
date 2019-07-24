package pojo.http2;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductProperitiesChangeMessage implements Serializable {

    // 设备品类   EpdTable
    private String deviceType;

    // 数据流转消息产生时间, 自1970-1-1起流逝的毫秒值
    private Long gmtCreate;

    // 物的唯一id  2026393
    private String iotId;

    // 	设备所属产品  a1A4mypFduo
    private String productKey;

    // 设备名称  LoRa电子标签
    private String deviceName;


    // 变更的状态列表，列表元素包括：attribute - 变更属性, value - 变更值, time - 采样时间
    private JSON items;

    public JSON getItems() {
        return items;
    }

    public void setItems(JSON items) {
        this.items = items;
    }
}
