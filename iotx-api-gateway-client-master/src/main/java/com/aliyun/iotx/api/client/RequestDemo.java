package com.aliyun.iotx.api.client;
/*
 * Copyright 2017 Alibaba Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import Contants.AuthContants;
import Contants.URLContants;
import Utils.BeanByteArray;
import Utils.ObjectSerializer;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.iot.api.Profile;
import com.aliyun.openservices.iot.api.message.MessageClientFactory;
import com.aliyun.openservices.iot.api.message.api.MessageClient;
import com.aliyun.openservices.iot.api.message.callback.MessageCallback;
import com.aliyun.openservices.iot.api.message.entity.Message;
import com.aliyun.openservices.iot.api.message.entity.MessageToken;
import pojo.http2.ProductProperitiesChangeMessage;

import static org.mozilla.javascript.TopLevel.Builtins.String;

/**
 * @author zhongfu.xiezf
 */
public class RequestDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        getCloudToken();
//        getRequestDemo();
//        cloudTokenRefresh();
//        getProductList();
        getProduct();
//        http2Contect();
    }


    /**
     * 获取云端cloudToken
     * ok
     *
     * @throws UnsupportedEncodingException
     */
    public static String getCloudToken() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 测试环境
//        builderParams.setAppKey("27618806");
//        builderParams.setAppSecret("47a4c4c1489040a518fa49cf1f51815c");
        // 线上环境
        builderParams.setAppKey("27584788");
        builderParams.setAppSecret("a849557cc76091a58e83eaa717873940");

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        IoTApiRequest request = new IoTApiRequest();
        //设置api的版本
        request.setApiVer("1.0.0");

        //如果需要登陆，设置当前的会话的token
        request.setIotToken("xxxxxxxxxxxxxxx");

        //设置接口的参数
        request.putParam("grantType", "project");
        request.putParam("res", "a124IJQXpjRZWHUs");

        //请求参数域名、path、request
        String host = "api.link.aliyun.com";
        String path = "/cloud/token";
        ApiResponse response = syncClient.postBody(host, path, request, true);
        // 取出cloudToken
        String result = new String(response.getBody());
        JSONObject jsonObject = JSON.parseObject(result);
        String strData = jsonObject.getString("data");
        JSONObject data = JSON.parseObject(strData);
        String cloudToken = data.getString("cloudToken");
        System.out.println("获取cloudToken成功!");
        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));

        return cloudToken;
    }

    /**
     * 刷新云端Token
     * ok
     *
     * @throws UnsupportedEncodingException
     */
    public static void cloudTokenRefresh() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 测试环境
//        builderParams.setAppKey("27618806");
//        builderParams.setAppSecret("47a4c4c1489040a518fa49cf1f51815c");
        // 线上环境
        builderParams.setAppKey("27584788");
        builderParams.setAppSecret("a849557cc76091a58e83eaa717873940");

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        IoTApiRequest request = new IoTApiRequest();
        //设置api的版本
        request.setApiVer("1.0.0");

        // 获取当前cloudToken
        request.setCloudToken(getCloudToken());

        //设置接口的参数
        request.putParam("grantType", "project");
        request.putParam("res", "a124IJQXpjRZWHUs");

        //请求参数域名、path、request
        String host = "api.link.aliyun.com";
        String path = "/cloud/token";
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("刷新cloudToken成功！");
        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));

    }

    /**
     * 产品服务管理->查询物的产品列表
     * ok
     */
    public static void getProductList() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 测试环境
//        builderParams.setAppKey("27618806");
//        builderParams.setAppSecret("47a4c4c1489040a518fa49cf1f51815c");
        // 线上环境
        builderParams.setAppKey("27584788");
        builderParams.setAppSecret("a849557cc76091a58e83eaa717873940");

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        IoTApiRequest request = new IoTApiRequest();
        //设置api的版本

        request.setId("1509086454180");

        //设置接口的参数
//        request.putParam("grantType", "project");
//        request.putParam("res", "a124IJQXpjRZWHUs");

        // 获取当前cloudToken
        request.setCloudToken(getCloudToken());
        request.setApiVer("1.1.0"); // 注意版本

        request.putParam("pageNo", 1);
        request.putParam("pageSize", 10);

        request.setVersion("1.0");

        //请求参数域名、path、request
        String host = "api.link.aliyun.com";
        String path = "/cloud/thing/productList/get";
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("获取物的列表成功！");
        String result = new String(response.getBody());
        JSONObject jsonResult = JSON.parseObject(result);
        String strData = jsonResult.getString("data");
//        JSONObject data = JSON.parseObject(strData);
//        String strExtendProperties = data.getString("extendProperties");

        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    /**
     * 查询物的产品
     * @throws UnsupportedEncodingException
     */
    public static void getProduct() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        // 线上环境
        builderParams.setAppKey(AuthContants.API_ONLINE_APPKEY);
        builderParams.setAppSecret(AuthContants.API_ONLINE_APPSECRET);

        SyncApiClient syncClient = new SyncApiClient(builderParams);

        IoTApiRequest request = new IoTApiRequest();
        //设置api的版本

        request.setId("1509086454180");

        // 获取当前cloudToken
        request.setCloudToken(getCloudToken());
        request.setApiVer("1.1.0"); // 注意版本
        request.putParam("productKey", "a1A4mypFduo");

        request.setVersion("1.0");

        //请求参数域名、path、request
        String host = "api.link.aliyun.com";
        String path = "/cloud/thing/product/get";
        ApiResponse response = syncClient.postBody(host, path, request, true);
        System.out.println("获取物成功！");
        String str = new String(response.getBody());
        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));
    }

    public static void getRequestDemo() throws UnsupportedEncodingException {
        IoTApiClientBuilderParams builderParams = new IoTApiClientBuilderParams();
        builderParams.setAppKey("xxxx");
        builderParams.setAppSecret("xxxx");
        SyncApiGetClient syncClient = new SyncApiGetClient(builderParams);

        Map<String, String> headers = new HashMap<>(8);

        Map<String, String> querys = new HashMap<>(8);
        // 必填
        querys.put("apiVer", "1.0.0");
        querys.put("id", UUID.randomUUID().toString());
        // 可选
        querys.put("iotToken", "XXXXXXXXXX");
        querys.put("xxxxx", "xxxxxx");

        //请求参数域名、path、request
        String host = "xxx.xxx.xxx:8080";
        String path = "/xxxx/xxxx/xxxx";
        ApiResponse response = syncClient.doGet(host, path, true, headers, querys);


        System.out.println(
                "response code = " + response.getCode() + " response content = " + new String(response.getBody(),
                        "utf-8"));

    }

}

