package com.ysh.car.user.service;

import com.ysh.car.common.vo.R;
import com.ysh.car.dto.MemberQueryDto;
import com.ysh.car.user.entity.Member;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 易水寒
 * @version : 1.0.1
 * @date : 2019/12/10/21:22
 */
public interface MemberService {
    //查询
    R queryByMsg(String msg);
    //注册
    R register(Member member);
    //登录
    R login(String name,String pass);
    //后台管理系统 搜索接口 分页
    R search(MemberQueryDto memberQueryDto);
}
