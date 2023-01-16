package com.example.demo.result;

/**
 * 通用响应码枚举
 *
 * @author pengzb189
 * @since 2022/04/21
 **/
public enum RespCodeEnum {

    UNKNOWN_ERROR(-1, "未知异常"),

    SUCCESS(0, "成功"),

    FAIL(-1, "操作失败"),

    SYS_VERSION_TOO_LOW(10000, "版本过低，请升级到最新版本"),

    /**
     * 10001： 无效或失效 access_token
     */
    SYS_ACCESS_TOKEN_INVALID_ERROR(10001, "登录凭证已失效，请重新登录"),

    /**
     * 10002：access_token 已失效
     */
    SYS_ACCESS_TOKEN_EXPIRE_ERROR(10002, "access_token已失效"),

    /**
     * 10003：请求参数错误
     */
    SYS_REQUEST_PARAMS_ERROR(10003, "请求参数错误"),

    /**
     * 10004：无效手机号码
     */
    SYS_INVALID_MOBILE_ERROR(10004, "无效手机号码"),

    /**
     * 10005：无效userid
     */
    SYS_INVALID_TYUSER_ERROR(10005, "无效用户"),


    /**
     * 10006：请求签名验证失败
     */
    SYS_SIGNATURE_CHECK_ERROR(10006, "请求签名验证失败"),

    /**
     * 10007：参数解密失败
     */
    SYS_DECRYPT_PARAMS_ERROR(10007, "参数解密失败"),

    /**
     * 10011：系统繁忙
     */
    SYS_ERROR(10011, "系统繁忙"),

    /**
     * 10012：密码签名验证失败
     */
    SYS_PWD_SIGNATURE_CHECK_ERROR(10012, "密码签名验证失败"),

    /**
     * 10014：请求已过期
     */
    SYS_REQUEST_EXPIRE_ERROR(10014, "请求已过期"),

    /**
     * 10015：参数判空时发生错误
     */
    SYS_CHECK_EACH_PARAMETER_ERROR(10015, "参数判空时错误"),
    /**
     * 10016：缺少必要参数
     */
    SYS_LACK_NECESSARY_PARAMETER_ERROR(10016, "缺少必要参数"),

    /**
     * 10017：参数解析异常
     */
    PARAMS_UNRESOLVED(10017,"参数解析异常"),

    /**
     * 短信验证码错误
     */
    DEVICE_LOCK_SMS_VERIFICATION_CODE_ERROR(20000, "短信验证码错误"),

    /**
     * 发送短信已超过10次
     */
    DEVICE_LOCK_SEND_SMS_OVER_TIME(20001, "发送短信已超过10次"),

    /**
     * 设备锁密码错误
     */
    DEVICE_LOCK_PASSWORD_ERROR(20003, "设备锁密码错误"),

    /**
     * 已有设备锁
     */
    DEVICE_LOCK_IS_EXIST(20006, "已存在设备锁"),

    /**
     * 设备锁已关闭
     */
    DEVICE_LOCK_IS_OFF(20007, "设备锁已为关闭状态"),

    /**
     * 设备锁开关操作失败
     */
    DEVICE_LOCK_OPERATE_ERROR(20004, "设备锁开关操作失败"),

    /**
     * 发送短信失败
     */
    DEVICE_LOCK_SEND_SMS_FAIL(20005, "发送短信失败"),

    /**
     * 无权限操作该设备(分享)
     */
    DEVICE_LOCK_NO_AUTH_OPERATE(30001, "无权限操作该设备(分享)"),
    XYGJ_UNBIND_FAIL(40009, "小翼管家解绑设备失败"),
    XYGJ_UNBIND_WORK_ORDER_DEVICE_NOT_BIND(40010, "小翼管家自助解绑，当前设备不存在绑定关系!"),
    XYGJ_UNBIND_WORK_ORDER_DEVICE_FAIL(40011, "小翼管家自助解绑失败!"),

    /**
     * 无法找到注解
     */
    DECRYPT_TARGET_ANNOTATION_ERROR(99999, "Can not find the declaredField with @DecryptTarget"),

    /**
     * 解密失败
     */
    DECRYPT_ERROR(90000, "DECRYPT ERROR"),

    AI_ENCRYPT_ERROR(50001, "AI请求参数加密异常"),
    AI_IF_UPDATE_LACK(50002, "当 ifUpdate 字段为 0 时，flag 中 faceExactMatch, intelligence 以下字段为必填字段"),
    AI_FACE_EXACT_MATCH_LACK(50003, "当 flag 中 faceExactMatch 字段为0时，image 为必填字段"),

    OVER_QUERY_MAX_NUM(50004,"超出最大查询数目"),

    GET_BATCH_REGION_ERROR(90010, " 批量查询设备所在单元接口异常"),
    GET_DEVICE_INFO_ERROR(90011, "获取设备上报信息异常"),
    GET_CLOUD_PACKAGE_LIST_ERROR(90012,"获取套餐信息异常"),
    QUERY_DEVICE_CTEI_IS_NULL(90013,"设备ctei信息为空"),
    GET_DEVICE_UID_ERROR(90014,"获取设备信息异常"),
    QUERY_DEVICE_INFO_IS_NULL(90015,"未获取此设备上报信息"),
    GET_DEVICE_FIRMWARE_INFO_ERROR(90016, "获取设备固件信息异常"),
    SYS_NOT_FIND_USER_INFO(10124,"未找到用户相关信息"),
    SYS_BIND_INFO_NOT_EXISTS(10124, "无此设备绑定信息"),

    BATCH_TARGET_AND_SET_TYPE_NOT_MATCH(33333, "@BatchTarget注解设置的类型与入参类型不一致"),
    BATCH_HANDLING_LACK_CONFIG(33334, "@BatchHandling注解需在配置文件中配置，模板设置见 BatchHandling注解说明"),
    BATCH_TARGET_NOT_FOUND(33335, "找不到@BatchTarget"),

    APPLR_VIRTUAL_DEVICE_FAIL(-1, "申请虚拟设备超出数量"),
    APPLR_VIRTUAL_DEVICE_ALREADY_USE(-1, "该账号已经申请过设备"),
    APPLR_VIRTUAL_DEVICE_NOT_ENOUGH(-1, "虚拟设备资源有限，请稍后再试"),

    DEVICE_NEVER_HAS_BIND_CLOUD(10125,"设备未绑定过云存"),
    GET_DEVICE_LATEST_CLOUD_FILE_FAIL(10126,"获取设备云存文件列表异常"),

    SYS_DEVICE_CODE_NOT_EXIST(10022,"设备码不存在"),
    SYS_ACCOUNT_NOT_EXIST(10023,"账号信息不存在"),
    SYS_DEVICE_NOT_BANDING_ACCOUNT(10125, "设备与天翼账号不存在绑定关系"),
    SYS_DEVICE_CODE_HAS_BIND(10023, "设备码已绑定"),
    SYS_DEVICE_CODE_HAS_BIND_BY_MINE(10026, "您已经绑定了这个设备"),
    SYS_DEVICE_HAS_BIND_IN_CLOUD_EYE(10027,"您已在天翼云眼绑定了该设备"),
    GET_DEVICE_LIST_FAIL(10028, "获取设备列表失败"),
    RESET_DEVICE_FAIL(30014, "设备重置失败"),
    /**
     * 自助工单发送短信次数已超过限制
     */
    SELF_WORK_ORDER_SEND_SMS_OVER_TIME(30015, "发送短信已超过次数限制"),
    /**
     * 自助工单发送短信验证码失败
     */
    SELF_WORK_ORDER_SEND_SMS_FAIL(30016, "短信验证码发送失败"),
    /**
     * 短信验证码错误
     */
    SELF_WORK_ORDER_SMS_VERIFICATION_CODE_ERROR(30017, "短信验证码错误"),
    /**
     * 短信验证码错误
     */
    SELF_WORK_ORDER_NO_NEED_SUBMIT(30018, "当前设备绑定账号与输入手机号一致，请登录手机号解绑"),
    /**
     * 提交工单失败
     * */
    SELF_WORK_ORDER_SUBMIT_FAIL(30019, "自助解绑工单提交失败"),
    /**
     * 重复提交工单
     * */
    SELF_WORK_ORDER_REPEAT_SUBMIT(30020, "当前设备已提交审核中，请勿重复提交");

    int code;
    String msg;

    RespCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
