package com.example.demo.result;

/**
 * 响应结果基类
 *
 * @author pengzb189
 * @since 2022/04/21
 **/
public class Result<T> {

    /**
     * 响应码
     */
    protected int code;
    /**
     * 响应信息
     */
    protected String msg;
    /**
     * 响应数据
     */
    protected T data;

    public Result() {
    }

    public Result(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(RespCodeEnum errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean checkSuccess() {
        return RespCodeEnum.SUCCESS.getCode() == code;
    }

    public static Result FAIL(RespCodeEnum error) {
        return new Result(error);
    }

}
