package Contants;

public class PathContants {



    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 查询物的产品列表 */
    public static final String PRODUCT_GET_THING_PRODUCTLIST = "/cloud/thing/productList/get";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 查询物的产品 */
    public static final String PRODUCT_GET_THING_PRODUCT = "/cloud/thing/product/get";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 云端开放的产品量产接口（动态生成设备名称） */
    public static final String PRODUCT_GENERATE_AMOUNT_DEVICE = "/cloud/amount/device/generate";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 上传三元组设备名称列表获取批次号 */
    public static final String PRODUCT_UPLOAD_DEVICE_NAME = "/cloud/device/name/upload";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 产品管理服务 -> 云端开放的产品量产接口（根据批次号，与指定设备名称配合使用） */
    public static final String PRODUCT_GENERATE_NAME_DEVICE = "/cloud/name/device/generate";


    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 获取物的属性 */
    public static final String THING_GET_THING_PROPERITIES = "/cloud/thing/properties/get";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 获取物的模板 */
    public static final String THING_GET_THING_TEMPLATE = "/cloud/thing/tsl/get";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 触发物的服务 */
    public static final String THING_INVOKE_THING_SERVICE = "/cloud/thing/service/invoke";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 设置物的属性 */
    public static final String THING_SET_THING_PROPERTITIES = "/cloud/thing/properties/set";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 获取物的基本信息 */
    public static final String THING_GET_THING_INFO = "/cloud/thing/info/get";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 获取物的连接状态 */
    public static final String THING_GET_THING_STATUS = "/cloud/thing/status/get";

    /**  生活物联网平台 -> 开发指南 -> 远端开发指南 -> 物的模型服务 -> 批量获取物 */
    public static final String THING_BATCH_TO_GET_THING = "/cloud/things/get";

    /**  模板 -> 创建模板  */
    public static final String TEMPLATE_ADD_TEMPLATE = "/living/esl/template/add";

    /**  模板 -> 修改模板  */
    public static final String TEMPLATE_UPDATE_TEMPLATE = "/living/esl/template/update";

    /**  模板 -> 删除模板  */
    public static final String TEMPLATE_DELETE_TEMPLATE = "/living/esl/template/delete";

    /**  模板 -> 模板详情查询  */
    public static final String TEMPLATE_GET_TEMPLATE = "/living/esl/template/get";

    /**  模板 -> 模板查询（分页）  */
    public static final String TEMPLATE_QUERY_TEMPLATE = "/living/esl/template/query";

    /**  模板 -> 绑定设备模板  */
    public static final String TEMPLATE_DEVICE_BIND_TEMPLATE = "/living/esl/template/device/bind";

    /**  模板 -> 发送模板数据  */
    public static final String TEMPLATE_MESSAGE_SEND = "/living/esl/template/message/send";
//
//    /**  模板 -> 模板详情查询  */
//    public static final String TEMPLATE_ADD_TEMPLATE = "/living/esl/template/add";

}