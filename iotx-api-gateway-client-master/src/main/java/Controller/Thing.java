package Controller;

import Contants.APIVersionContants;
import Contants.AuthContants;
import Contants.PathContants;
import Contants.URLContants;
import Enums.ProductStatusEnums;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.iotx.api.client.IoTApiClientBuilderParams;
import com.aliyun.iotx.api.client.IoTApiRequest;
import com.aliyun.iotx.api.client.SyncApiClient;

import java.io.UnsupportedEncodingException;

public class Thing {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        getProductProperities();// 获取物的属性 ok
//        getProductTemplate();// 获取物的模板 ok
//        invokeThingService();// 触发物的服务
//        setThingPropertities();// 设置物的属性
        getThingStatus();// 获取物的状态 ok
        getThingInfo();// 获取物的基本信息 ok
//        batchToGetProduct();// 批量获取物 ok

    }

    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 获取物的属性
     * ok
     *
     * @throws UnsupportedEncodingException
     */
    public static void getProductProperities() throws UnsupportedEncodingException {
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
        request.setApiVer(APIVersionContants.THING_GET_THING_PROPERITIES); // 注意版本

        request.putParam("iotId", "aFtFoIRJrzbLZW0p7hNW000100");
//        request.putParam("productKey", "a1A4mypFduo");// 有iotID这边可选
//        request.putParam("deviceName");// 有iotID这边可选

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.THING_GET_THING_PROPERITIES;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("获取物的属性成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }


    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 获取物的模板
     * ok
     *
     * @throws UnsupportedEncodingException
     */
    public static void getProductTemplate() throws UnsupportedEncodingException {
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
        request.setApiVer(APIVersionContants.THING_GET_THING_TEMPLATE); // 注意版本

        request.putParam("iotId", "aFtFoIRJrzbLZW0p7hNW000100");
        request.putParam("productKey", "a1A4mypFduo");// 有iotID这边可选
//        request.putParam("deviceName");// 有iotID这边可选

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.THING_GET_THING_TEMPLATE;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("获取物的模板成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }


    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 触发物的服务
     *
     * @throws UnsupportedEncodingException
     */
    public static void invokeThingService() throws UnsupportedEncodingException {
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
        request.setApiVer(APIVersionContants.THING_INVOKE_THING_SERVICE); // 注意版本

        request.putParam("iotId", "aFtFoIRJrzbLZW0p7hNW000100");
        request.putParam("productKey", "a1A4mypFduo");// 有iotID这边可选
        request.putParam("deviceName", "d896e000090002ab");// 有iotID这边可选
        request.putParam("identifier", "ScreenWidth");
        Object ob = JSON.parseObject("{}");
        request.putParam("args", ob);

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.THING_INVOKE_THING_SERVICE;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("触发物的服务成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }


    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 设置物的属性
     *
     * @throws UnsupportedEncodingException
     */
    public static void setThingPropertities() throws UnsupportedEncodingException {
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
        request.setApiVer(APIVersionContants.THING_SET_THING_PROPERTITIES); // 注意版本

        request.putParam("iotId", "aFtFoIRJrzbLZW0p7hNW000100");
//        request.putParam("productKey", "a1A4mypFduo");// 有iotID这边可选
//        request.putParam("deviceName", "d896e000090002ab");// 有iotID这边可选
        Object ob = JSONObject.parseObject("{\"LightSwitch1\": 0, \"LightSwitch2\": 0}");

        request.putParam("items", ob);

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.THING_SET_THING_PROPERTITIES;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("修改物的属性成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 获取物的连接状态
     */
    public static void getThingStatus() throws UnsupportedEncodingException {
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
        request.setApiVer(APIVersionContants.THING_GET_THING_STATUS); // 注意版本

        request.putParam("iotId", "aFtFoIRJrzbLZW0p7hNW000100");
        request.putParam("productKey", "a1A4mypFduo");// 有iotID这边可选
        request.putParam("deviceName", "d896e000090002ab");// 有iotID这边可选


        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.THING_GET_THING_STATUS;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("获取物的连接状态成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }


    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 获取物的基本信息
     * ok
     *
     * @throws UnsupportedEncodingException
     */
    public static void getThingInfo() throws UnsupportedEncodingException {
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
        request.setApiVer(APIVersionContants.THING_GET_THING_INFO); // 注意版本

        request.putParam("iotId", "aFtFoIRJrzbLZW0p7hNW000100");


        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.THING_GET_THING_INFO;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("获取物的基本信息成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }


    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 批量获取物
     *
     * @throws UnsupportedEncodingException
     */
    public static void batchToGetProduct() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 测试环境
//        builderParams.setAppKey("27618806");
//        builderParams.setAppSecret("47a4c4c1489040a518fa49cf1f51815c");
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        request.setId("1509086454180");

        // 获取当前cloudToken
        request.setCloudToken(CloudToken.getCloudToken());
        //设置api的版本
        request.setApiVer(APIVersionContants.THING_BATCH_TO_GET_THING); // 注意版本

        request.putParam("productKey", "a1A4mypFduo");
        request.putParam("status", ProductStatusEnums.ONLINE.getType());
        request.putParam("currentPage", 1);
        request.putParam("pageSize", 10);

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.THING_BATCH_TO_GET_THING;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("批量获取物成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

}
