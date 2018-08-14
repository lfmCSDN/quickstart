package com.ty.tybs.web.mapper;

import com.ty.tybs.web.entity.po.UserBaseInfo;
import com.ty.tybs.web.entity.qo.UserAndCardQo;
import com.ty.tybs.web.entity.qo.UserBaseInfoQo;
import com.ty.tybs.web.entity.vo.UserAndCardVo;
import com.ty.tybs.web.entity.vo.UserBaseInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by Lfm
 * on 2018-04-07 12:25
 */
public interface UserBaseInfoMapper {

    UserBaseInfo getObjectByForeignKey(String cardBaseInfoId);

    UserBaseInfo getObjectByPrimarykey(String userBaseInfoid);

    UserBaseInfo getObjectByCardId(String userCardId);

    /*用户基本信息*/
    void addUserBaseInfo(@Param("userAndCardVo") UserAndCardVo userAndCardVo);

    /*查询账户*/
    List<UserAndCardVo> getUserByIdCard(@Param("userAndCardQo") UserAndCardQo userAndCardQo);

    void modifyTelUser(@Param("userBaseInfoQo") UserBaseInfoQo userBaseInfoQo);

    List<UserBaseInfoVo> getAcct(@Param("userBaseInfoQo") UserBaseInfoQo userBaseInfoQo);
}
