package com.ysh.car.dto;


import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 易水寒
 * @version : 1.0.1
 * @date : 2019/12/10/17:48
 */
@Data
public class MemberQueryDto {
    private int page;
    private int size;
    private String name;
    private int sex;
}
