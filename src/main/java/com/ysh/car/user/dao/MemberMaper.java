package com.ysh.car.user.dao;

import com.ysh.car.user.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 易水寒
 * @version : 1.0.1
 * @date : 2019/12/10/22:25
 */
@Repository
public interface MemberMaper {
    int insert(Member record);

    Member selectByMsg(String msg);

    List<Member> selectPage(@Param("page") int page, @Param("size") int size);

    long selectCount();
}
