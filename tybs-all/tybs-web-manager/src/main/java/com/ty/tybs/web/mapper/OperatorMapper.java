package com.ty.tybs.web.mapper;

import com.ty.tybs.web.entity.po.UserOperInfo;
import org.apache.ibatis.annotations.Param;

/**
 * create by Lfm
 * on 2018-03-19 22:19
 */
public interface OperatorMapper {

    UserOperInfo getOperator(@Param("operName") String operName, @Param("loginPwd") String loginPwd);
}
