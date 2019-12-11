package com.ysh.car.common.vo;

import com.ysh.car.common.result.ResultCode;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 易水寒
 * @version : 1.0.1
 * @date : 2019/12/10/21:45
 */
@Data
public class R {
    private int code;//状态码
    private String msg;//字符串
    private Object data;//携带数据

    public static R getR(int code, String msg, Object data) {
        R r = new R();

        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public static R OK() {
        return getR(ResultCode.OK.getVal(),"OK",null);
    }

    public static R OK(Object data) {
        return getR(ResultCode.OK.getVal(),"OK",data);
    }

    public static R fail() {
        return getR(ResultCode.ERROR.getVal(),"Error",null);
    }

    public static R fail(String msg) {
        return getR(ResultCode.ERROR.getVal(),msg,null);
    }
}
