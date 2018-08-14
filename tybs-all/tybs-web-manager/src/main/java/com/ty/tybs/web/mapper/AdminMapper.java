package com.ty.tybs.web.mapper;

import com.ty.tybs.web.entity.po.UserAdminInfo;
import com.ty.tybs.web.entity.po.UserOperInfo;
import com.ty.tybs.web.entity.qo.UserOperInfoQo;
import com.ty.tybs.web.entity.vo.UserOperInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by Lfm
 * on 2018-03-18 12:00
 */
public interface AdminMapper {
    UserAdminInfo getUser(@Param("adminName") String adminName, @Param("adminPwd") String adminPwd);

//    void addOper(@Param("UsrOperInfoQo") UserOperInfoQo userOperInfoQo);

    List<UserOperInfoVo> getOperator(@Param("userOperInfoQo") UserOperInfoQo userOperInfoQo);

    void deleteOperator(@Param("userOperInfoId") String userOperInfoId);

    void updateOperator(@Param("userOperInfoVo") UserOperInfoVo userOperInfoVo);

    UserOperInfo getObjectByIdCard(@Param("operCardId") String operCardId);

    UserOperInfo getObjectByPrimarykey(@Param("userOperInfoId") String userOperInfoId);

    UserOperInfo getObjectByName(@Param("operName") String operName);

    void addOperator(@Param("userOperInfoVo") UserOperInfoVo userOperInfoVo);
}
