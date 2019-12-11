package com.ysh.car.user.service.impl;

import com.ysh.car.common.result.ResultCode;
import com.ysh.car.common.vo.PageBean;
import com.ysh.car.common.vo.R;
import com.ysh.car.dto.MemberQueryDto;
import com.ysh.car.user.dao.MemberMaper;
import com.ysh.car.user.entity.Member;
import com.ysh.car.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 易水寒
 * @version : 1.0.1
 * @date : 2019/12/10/22:29
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMaper memberMapper;

    @Override
    public R queryByMsg(String msg) {
        Member member = memberMapper.selectByMsg(msg);

        if (member == null) {
            return R.OK();
        } else {
            return R.fail();
        }


    }

    @Override
    public R register(Member member) {
        if (queryByMsg(member.getUsername()).getCode() == ResultCode.OK.getVal()) {
            int i = memberMapper.insert(member);

            if (i > 0) {
                return R.OK();
            } else {
                return R.fail();
            }
        } else {
            return R.fail("用户名已经被注册");
        }


    }

    @Override
    public R login(String name, String pass) {
        Member member = memberMapper.selectByMsg(name);

        if (member != null) {
            if (member.getPassword().equals(pass)) {
                return R.OK(member.getId());
            }
        }


        return R.fail("用户名或密码错误");
    }

    @Override
    public R search(MemberQueryDto memberQueryDto) {
        //查询所有的数据
        List<Member> memberList = memberMapper.selectPage(memberQueryDto.getPage(), memberQueryDto.getSize());
        //实例化分页类
        PageBean<Member> pageBean = new PageBean<>();
        pageBean.setData(memberList);
        pageBean.setPage(memberQueryDto.getPage());
        pageBean.setSize(memberQueryDto.getSize());
        pageBean.setTotalPage(memberMapper.selectCount());
        //计算总页数
        pageBean.setTotalPage(pageBean.getTotal() % memberQueryDto.getSize() == 0 ? pageBean.getTotal() / pageBean.getSize()
                : pageBean.getTotal() / pageBean.getSize() + 1);
        return R.OK(pageBean);
    }
}
