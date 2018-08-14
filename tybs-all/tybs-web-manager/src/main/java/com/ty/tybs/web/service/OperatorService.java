package com.ty.tybs.web.service;


import com.ty.tybs.web.entity.po.UserOperInfo;
import com.ty.tybs.web.entity.qo.UserAndCardQo;
import com.ty.tybs.web.entity.qo.UserBaseInfoQo;
import com.ty.tybs.web.entity.vo.CardBaseInfoVo;
import com.ty.tybs.web.entity.vo.UserAndCardVo;
import com.ty.tybs.web.entity.vo.UserBaseInfoVo;

import java.util.List;

/**
 * create by Lfm
 * on 2018-03-19 22:20
 */
public interface OperatorService {
    //操作员登录
    UserOperInfo login(String username, String password);

    //开通账户
    String addUser(UserAndCardVo userAndCardVo);

    // 查询账户
    List<UserAndCardVo> getUser(UserAndCardQo userAndCardQo);

    // 删除账户
    String deleteUser(UserAndCardVo userAndCardVo);

    //挂失账户
    String lostUser(UserAndCardVo userAndCardVo);

    //冻结账户
    String freezeUser(UserAndCardVo userAndCardVo);

    //解挂账户
    String upLostUser(UserAndCardVo userAndCardVo);

    //解冻账户
    String upFreezeUser(UserAndCardVo userAndCardVo);

    //修改密码
    String modifyPwd(CardBaseInfoVo cardBaseInfoVo);

    //密码重置
    String resetPwd(CardBaseInfoVo cardBaseInfoVo);

    String modifyUser(UserBaseInfoQo userBaseInfoQo);

    List<UserBaseInfoVo> getAcct(UserBaseInfoQo userBaseInfoQo);
}
