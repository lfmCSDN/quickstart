package com.ty.tybs.web.service;

import com.ty.tybs.web.entity.po.UserAdminInfo;
import com.ty.tybs.web.entity.qo.UserOperInfoQo;
import com.ty.tybs.web.entity.vo.UserOperInfoVo;

import java.util.List;

/**
 * create by Lfm
 * on 2018-03-18 12:04
 */
public interface AdminService {
    //管理员登录
    UserAdminInfo login(String username, String password);

    //增加操作员
    String addOperator(UserOperInfoVo userOperInfoVo);

    //查询操作员
    List<UserOperInfoVo> getOperator(UserOperInfoQo userOperInfoQo);

    //删除操作员
    String deleteOperator(UserOperInfoQo userOperInfoQo);

    //修改操作员
    String updateOperator(UserOperInfoVo userOperInfoVo);


}
