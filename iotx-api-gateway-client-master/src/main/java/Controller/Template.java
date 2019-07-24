package Controller;

import Contants.APIVersionContants;
import Contants.AuthContants;
import Contants.PathContants;
import Contants.URLContants;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.iotx.api.client.IoTApiClientBuilderParams;
import com.aliyun.iotx.api.client.IoTApiRequest;
import com.aliyun.iotx.api.client.SyncApiClient;
import pojo.TemplateElement;
import pojo.TemplateElementStruct;
import pojo.TemplateMain;;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Template {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        addTemplate();
//        getTemplate();
//        queryTemplate();
//        deviceBindTemplate();
        templateMessageSend();
    }


    /**
     * 模板 -> 创建模板
     *
     * @throws UnsupportedEncodingException
     */
    public static void addTemplate() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());

        //设置api的版本
        request.setApiVer(APIVersionContants.TEMPLATE_ADD_TEMPLATE); // 注意版本
        TemplateMain templateMain = new TemplateMain();
        templateMain.setName("新的");
        templateMain.setCode("2433");
        templateMain.setVersion("2433");
        templateMain.setType(1L);
        templateMain.setHeight(100L);
        templateMain.setWidth(100L);

        List<TemplateElement> templateElementList = new ArrayList<>();
        TemplateElement templateElement = new TemplateElement();
        templateElement.setElementKey("2433");
        templateElement.setElementType("sltext");

        TemplateElementStruct templateElementStruct = new TemplateElementStruct();
        templateElementStruct.setLeft(100L);
        templateElementStruct.setTop(100L);
        templateElementStruct.setFontSize(24L);
        templateElementStruct.setColor(1L);
        templateElementStruct.setDrawLineType(3L);
        templateElementStruct.setFontType(1L);
        templateElementStruct.setLevelAlign(2L);
        templateElementStruct.setEncode(1L);
        String templateElementStructJsonStr = JSON.toJSONString(templateElementStruct);
        templateElement.setElementStruct(templateElementStructJsonStr);
        templateElementList.add(templateElement);
        templateMain.setElementList(templateElementList);
        request.putParam("params", JSONObject.toJSON(templateMain));

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.TEMPLATE_ADD_TEMPLATE;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("创建桌牌模板成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }


    /**
     * 模板 -> 模板详情查询
     *
     * @throws UnsupportedEncodingException
     */
    public static void getTemplate() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());

        //设置api的版本
        request.setApiVer(APIVersionContants.TEMPLATE_GET_TEMPLATE); // 注意版本
        request.putParam("params", JSONObject.parse("{\"templateCode\":\"2433\",\"templateVersion\":\"2433\"}"));

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.TEMPLATE_GET_TEMPLATE;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("模板详情查看成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    /**
     * 模板 -> 模板查询（分页）
     *
     * @throws UnsupportedEncodingException
     */
    public static void queryTemplate() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());

        //设置api的版本
        request.setApiVer(APIVersionContants.TEMPLATE_QUERY_TEMPLATE); // 注意版本
        request.putParam("params", JSONObject.parse("{\"pageNo\":1,\"pageSize\":10}"));


        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.TEMPLATE_QUERY_TEMPLATE;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("模板查询（分页）成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    /**
     * 模板 -> 绑定设备模板
     *
     * @throws UnsupportedEncodingException
     */
    public static void deviceBindTemplate() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());

        //设置api的版本
        request.setApiVer(APIVersionContants.TEMPLATE_DEVICE_BIND_TEMPLATE); // 注意版本
        request.putParam("params", JSONObject.parse("{\"templateCode\":\"2433\",\"templateVersion\":\"2433\",\"deviceName\":\"d896e000090002ab\",\"productKey\":\"a1A4mypFduo\",\"screenIndex\":\"0\"}"));


        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.TEMPLATE_DEVICE_BIND_TEMPLATE;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("绑定设备模板成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    /**
     * 模板 -> 发送模板数据
     *
     * @throws UnsupportedEncodingException
     */
    public static void templateMessageSend() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());

        //设置api的版本
        request.setApiVer(APIVersionContants.TEMPLATE_MESSAGE_SEND); // 注意版本


        String str = "{\"templateCode\":\"2433\",\"templateVersion\":\"2433\",\"deviceName\":\"d896e000090002ab\",\"productKey\":\"a1A4mypFduo\",\"templateContent\":\"{'SPrice':'19999','OPrice':'19999','unit':'元','goodsName':'ISV','Numbering':'CP000000000000001111','Introduction':'好','specification':'4000','qrcode01':'https://www.aliyun.com/','barcode01':'123456789','specificationPrefix':'规格:','specificationUnit':'克/堆','OPricePrefix':'¥','SPricePrefix':'¥'}\"}";
        request.putParam("params", JSONObject.parse(str));

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.TEMPLATE_MESSAGE_SEND;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("发送模板数据成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }


}
