package com.ty.tybs.web.mapper;

import com.ty.tybs.web.entity.po.RsaPwdInfo;
import com.ty.tybs.web.entity.vo.RsaPwdInfoVo;
import org.apache.ibatis.annotations.Param;

/**
 * create by Lfm
 * on 2018-06-13 16:07
 */
public interface RsaPwdInfoMapper {
    void saveRsaPwdInfo(@Param("rsaPwdInfoVo") RsaPwdInfoVo rsaPwdInfoVo);

    RsaPwdInfo getObjectByCardBaseInfoId(@Param("cardBaseInfoId")String cardBaseInfoId);
}
