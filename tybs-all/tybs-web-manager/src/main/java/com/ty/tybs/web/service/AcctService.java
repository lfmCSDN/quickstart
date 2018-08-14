package com.ty.tybs.web.service;


import com.ty.tybs.web.entity.qo.TransListInfoQo;
import com.ty.tybs.web.entity.vo.CardBaseInfoVo;
import com.ty.tybs.web.entity.vo.TransListInfoVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * User:jiaw.j
 * Date:2018/4/4 0004
 */
public interface AcctService {

    String bankSaving(CardBaseInfoVo cardBaseInfoVo);

    String transfer(CardBaseInfoVo cardBaseInfoVo);

    String drawMoney(CardBaseInfoVo cardBaseInfoVo);

    List<TransListInfoVo> getTransList(TransListInfoQo transListInfoQo);

    String transferByMoney(CardBaseInfoVo cardBaseInfoVo);

    String exportXls(TransListInfoQo transListInfoQo, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws IOException;
}
