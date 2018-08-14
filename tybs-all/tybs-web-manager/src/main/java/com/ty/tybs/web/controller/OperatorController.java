package com.ty.tybs.web.controller;

import com.ty.tybs.web.entity.po.UserOperInfo;
import com.ty.tybs.web.entity.qo.UserAndCardQo;
import com.ty.tybs.web.entity.qo.UserBaseInfoQo;
import com.ty.tybs.web.entity.qo.UserOperInfoQo;
import com.ty.tybs.web.entity.vo.CardBaseInfoVo;
import com.ty.tybs.web.entity.vo.TableVo;
import com.ty.tybs.web.entity.vo.UserAndCardVo;
import com.ty.tybs.web.entity.vo.UserBaseInfoVo;
import com.ty.tybs.web.service.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * create by Lfm
 * on 2018-03-18 21:12
 * 操作员管理
 */
@Controller
@RequestMapping("/operator")
public class OperatorController {
    private static Logger log = LoggerFactory.getLogger(OperatorController.class);

    @Autowired
    private OperatorService operatorService;


    /**
     * 登录
     *
     * @param userOperInfoQo
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String OperatorLogin(UserOperInfoQo userOperInfoQo, Model model) {
        String name = userOperInfoQo.getOperName();
        String password = userOperInfoQo.getLoginPwd();
        UserOperInfo operator = operatorService.login(name, password);
        String loginName = userOperInfoQo.getOperName();
        String loginTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        model.addAttribute("loginTime", loginTime);
        model.addAttribute("loginName", loginName);
        if (operator == null || "不正常".equals(operator.getOperStatu())) {
            return "login";
        } else {
            return "operatorMain";
        }
    }

    /*跳转开通账户*/
    @RequestMapping("/addUserVm")
    public String addUserVm() {
        return "addUser";
    }

    /**
     * 跳转查找账户
     *
     * @return
     */
    @RequestMapping("/queryUserVm")
    public String queryUserVm() {
        return "queryUser";
    }

    //账户开通
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorService.addUser(userAndCardVo);
    }

    //注销账户
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorService.deleteUser(userAndCardVo);
    }


    /* 查询账户*/
    @RequestMapping("/getUser")
    @ResponseBody
    public TableVo<UserAndCardVo> getUser(UserAndCardQo userAndCardQo, Model model) {
        List<UserAndCardVo> list = operatorService.getUser(userAndCardQo);
        TableVo<UserAndCardVo> tableVo = new TableVo<>();
        tableVo.setCode(0);
        tableVo.setMsg("success");
        tableVo.setCount(list.size());
        tableVo.setData(list);
        return tableVo;
    }

    @RequestMapping("/getAcct")
    @ResponseBody
    public TableVo<UserBaseInfoVo> getAcct(UserBaseInfoQo userBaseInfoQo, Model model) {
        List<UserBaseInfoVo> list = operatorService.getAcct(userBaseInfoQo);
        TableVo<UserBaseInfoVo> tableVo = new TableVo<>();
        tableVo.setCode(0);
        tableVo.setMsg("success");
        tableVo.setCount(list.size());
        tableVo.setData(list);
        return tableVo;
    }

    /**
     * 跳转卡操作
     */
    @RequestMapping("/operCardVm")
    public String operCardVm() {
        return "operCard";
    }

    /*冻结账号*/
    @RequestMapping("/freezeUser")
    @ResponseBody
    public String freezeUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorService.freezeUser(userAndCardVo);
    }

    /*解冻账户*/
    @RequestMapping("/upFreezeUser")
    @ResponseBody
    public String upFreezeUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorService.upFreezeUser(userAndCardVo);

    }

    /*挂失账户*/
    @RequestMapping("/lostUser")
    @ResponseBody
    public String lostUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorService.lostUser(userAndCardVo);
    }

    /*解挂账户*/
    @RequestMapping("/upLostUser")
    @ResponseBody
    public String upLostUser(UserAndCardVo userAndCardVo, Model model) {
        return operatorService.upLostUser(userAndCardVo);
    }

    /*跳转修改密码*/
    @RequestMapping("/toModifyPwd")
    public String toModifyPwd() {
        return "modifyPwd";
    }

    /*修改密码*/
    @RequestMapping("/modifyPwd")
    @ResponseBody
    public String modifyPwd(CardBaseInfoVo cardBaseInfoVo, Model model) {
        return operatorService.modifyPwd(cardBaseInfoVo);
    }

    /*跳转密码重置页面*/
    @RequestMapping("/jumpInputPwd")
    public  String jumpInputPwd(){
        return "jumpInputPwd";
    }

    /*跳转重置密码*/
    @RequestMapping("/toResetPwd")
    public String toResetPwd() {
        return "resetPwd";
    }

    /*重置密码*/
    @RequestMapping("/resetPwd")
    @ResponseBody
    public String resetPwd(CardBaseInfoVo cardBaseInfoVo, Model model) {
        return operatorService.resetPwd(cardBaseInfoVo);
    }

    /*跳转修改手机号*/
    @RequestMapping("/toModifyUser")
    public String toModifyUser() {
        return "modifyUser";
    }

    /*修改账户*/
    @RequestMapping("/modifyUser")
    @ResponseBody
    public String modifyUser(UserBaseInfoQo userBaseInfoQo, Model model) {
        return operatorService.modifyUser(userBaseInfoQo);
    }

    /*退出*/
    @RequestMapping("/exit")
    public String exit(HttpSession session, SessionStatus sessionStatus) {
        log.info("退出......");
        session.removeAttribute("useroper");
        sessionStatus.setComplete();
        return "redirect:login";
    }


}
