package Controller;

import Contants.AuthContants;
import Contants.URLContants;
import Utils.ObjectSerializer;
import com.aliyun.openservices.iot.api.Profile;
import com.aliyun.openservices.iot.api.message.MessageClientFactory;
import com.aliyun.openservices.iot.api.message.api.MessageClient;
import com.aliyun.openservices.iot.api.message.callback.MessageCallback;
import com.aliyun.openservices.iot.api.message.entity.Message;
import com.aliyun.openservices.iot.api.message.entity.MessageToken;
import pojo.http2.ProductProperitiesChangeMessage;

import java.io.UnsupportedEncodingException;

public class DeviceHttp2Connect {

    public static void main(String[] args) {

    }


    /**
     * http2建连
     *
     *
     * @throws UnsupportedEncodingException
     */
    public static void http2Contect() throws UnsupportedEncodingException {
        // Profile需要提供EndPoint，AppKey和AppSecret用于鉴权
        Profile profile = Profile.getAppKeyProfile(URLContants.HTTP2_CONTACT, AuthContants.DATA_SYNC_APPKEY, AuthContants.DATA_SYNC_APPSECRET);
        // MessageCallback为默认的消息回调，用于接收消息

        ProductProperitiesChangeMessage productProperitiesChangeMessage = new ProductProperitiesChangeMessage();
        productProperitiesChangeMessage.setDeviceType("");
        productProperitiesChangeMessage.setDeviceName("设备名称");


        Message message = new Message();
        message.setMessageId("123456");
        try {
            message.setPayload(ObjectSerializer.serialize(productProperitiesChangeMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO 实体类转byte[]传给message.setPayload();
        MessageCallback messageCallback = new MessageCallback() {
            public Action consume(MessageToken messageToken) {

                System.out.println("receive : " + new String(messageToken.getMessage().getPayload()));
                return Action.CommitSuccess;// 成功
            }
        };

        // 连接建立后，服务端会立即向SDK推送已订阅的消息，
        // 因此建连时需要提供默认消息接收接口，用于处理未设置回调的消息。
        // 建议在connect之前，调用setMessageListener设置消息回调。
        MessageClient messageClient = MessageClientFactory.messageClient(profile);
        messageClient.setMessageListener(messageCallback);
        messageClient.connect(messageCallback);

        try {
            System.in.read();
        } catch (Exception e) {
        }
    }




}
