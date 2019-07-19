package Controller;

import Contants.APIVersionContants;
import Contants.AuthContants;
import Contants.PathContants;
import Contants.URLContants;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.aliyun.iotx.api.client.IoTApiClientBuilderParams;
import com.aliyun.iotx.api.client.IoTApiRequest;
import com.aliyun.iotx.api.client.SyncApiClient;

import java.io.UnsupportedEncodingException;

public class Product {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        getThingProductList();// 查询物的产品列表 ok
//        getThingProduct();// 查询物的产品 ok
//        generateAmountDevice();// 云端开放的产品量产接口（动态生成设备名称）
//        uploadDeviceName();// 上传三元组设备名称列表获取批次号
//        generateNameDevice();// 云端开放的产品量产接口（根据批次号，与指定设备名称配合使用）
    }

    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 查询物的产品列表
     * ok
     *
     * @throws UnsupportedEncodingException
     */
    public static void getThingProductList() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        request.setId("1508232047194");
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());
        //设置api的版本
        request.setApiVer(APIVersionContants.PRODUCT_GET_THING_PRODUCTLIST); // 注意版本

        request.putParam("pageNo", 1);
        request.putParam("pageSize", 10);

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.PRODUCT_GET_THING_PRODUCTLIST;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("查询物的产品列表成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 查询物的产品
     * ok
     *
     * @throws UnsupportedEncodingException
     */
    public static void getThingProduct() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        request.setId("1508232047194");
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());
        //设置api的版本
        request.setApiVer(APIVersionContants.PRODUCT_GET_THING_PRODUCT); // 注意版本

        request.putParam("productKey", "a1A4mypFduo");

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.PRODUCT_GET_THING_PRODUCT;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("查询物的产品成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 云端开放的产品量产接口（动态生成设备名称）
     *
     * @throws UnsupportedEncodingException
     */
    public static void generateAmountDevice() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        request.setId("1508232047194");
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());
        //设置api的版本
        request.setApiVer(APIVersionContants.PRODUCT_GENERATE_AMOUNT_DEVICE); // 注意版本

        request.putParam("productKey", "a1A4mypFduo");
        request.putParam("amount", 100);

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.PRODUCT_GENERATE_AMOUNT_DEVICE;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("云端开放的产品量产接口（动态生成设备名称）,成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 上传三元组设备名称列表获取批次号
     *
     * @throws UnsupportedEncodingException
     */
    public static void uploadDeviceName() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        request.setId("1508232047194");
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());
        //设置api的版本
        request.setApiVer(APIVersionContants.PRODUCT_UPLOAD_DEVICE_NAME); // 注意版本

        request.putParam("productKey", "a1A4mypFduo");
        request.putParam("deviceNames", "");

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.PRODUCT_UPLOAD_DEVICE_NAME;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("云端开放的产品量产接口（根据批次号，与指定设备名称配合使用）,成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    /**
     * 生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 上传三元组设备名称列表获取批次号
     *
     * @throws UnsupportedEncodingException
     */
    public static void generateNameDevice() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        //设置接口的参数
        IoTApiRequest request = new IoTApiRequest();
        request.setId("1508232047194");
        // 获取云端CloudToken
        request.setCloudToken(CloudToken.getCloudToken());
        //设置api的版本
        request.setApiVer(APIVersionContants.PRODUCT_GENERATE_NAME_DEVICE); // 注意版本

        request.putParam("productKey", "a1A4mypFduo");
        request.putParam("batchId", "1");

        request.setVersion(APIVersionContants.API_VERSION);

        //请求参数域名、path、request
        String host = URLContants.API_MAIN_URL;
        String path = PathContants.PRODUCT_GENERATE_NAME_DEVICE;
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("上传三元组设备名称列表获取批次号,成功！");
        String result = new String(response.getBody());

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }


}
