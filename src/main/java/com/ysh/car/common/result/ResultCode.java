package com.ysh.car.common.result;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 易水寒
 * @version : 1.0.1
 * @date : 2019/12/10/21:57
 */
public enum  ResultCode {
    OK(200),ERROR(500),NOTFOUNT(404);
    private ResultCode(int v){
        val = v;
    }
    private int val;

    public int getVal() {
        return val;
    }
}
