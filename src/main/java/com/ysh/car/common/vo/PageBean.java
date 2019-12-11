package com.ysh.car.common.vo;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 易水寒
 * @version : 1.0.1
 * @date : 2019/12/10/21:39
 */
@Data
public class PageBean<T> {
    private int page;
    private int total;
    private int size;
    private long totalPage;
    private List<T> data;
}
