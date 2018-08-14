package com.ty.tybs.web.mapper;

import com.ty.tybs.web.entity.po.CardBaseInfo;
import com.ty.tybs.web.entity.vo.UserAndCardVo;
import org.apache.ibatis.annotations.Param;


import java.math.BigDecimal;
import java.util.List;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 */
public interface CardBaseInfoMapper {

    CardBaseInfo getObjectByCardId(String cardId);

    CardBaseInfo getObjectByPrimarykey(String cardBaseInfoId);
    /*根据用户外键查询卡对象*/

    boolean payment(@Param("cardId") String cardId, @Param("amount") BigDecimal amount);

    boolean receipt(@Param("cardId") String cardId, @Param("amount") BigDecimal amount);

    void addCardBaseInfo(@Param("userAndCardVo") UserAndCardVo userAndCardVo);

    void lostUser(@Param("userCardId") String userCardId);

    void freezeUser(@Param("userCardId") String userCardId);

    void delCardById(@Param("cardBaseInfoId") String cardBaseInfoId);

    void upLostUser(@Param("userCardId") String userCardId);

    void upFreezeUser(@Param("userCardId") String userCardId);

    void modifyPwd(@Param("transPwd1") String transPwd1, @Param("cardId") String cardId);

    CardBaseInfo getObjectByForeignKey(@Param("userBaseInfoId") String userBaseInfoId,@Param("cardType") String cardType);

    List<CardBaseInfo> getObjectByKey(@Param("userBaseInfoId") String userBaseInfoId);

    void resetPwd(@Param("resetDefault") String resetDefault,@Param("cardId") String cardBaseInfoId);

}
