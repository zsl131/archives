package com.zslin.web.controller;

import com.zslin.basic.annotations.AdminAuth;
import com.zslin.basic.annotations.Token;
import com.zslin.basic.tools.MyBeanUtils;
import com.zslin.basic.tools.TokenTools;
import com.zslin.basic.utils.PageableUtil;
import com.zslin.basic.utils.ParamFilterUtil;
import com.zslin.web.model.Team;
import com.zslin.web.service.ITeamService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 组/队管理controller
 * Created by 马旭 on 2016/10/30.
 */
@Controller
@RequestMapping(value = "admin/team")
@AdminAuth(name="组/队", orderNum=20, psn="系统应用", pentity=0, porderNum=20)
public class TeamController {

    @Autowired
    private ITeamService teamService;

    /**
     * 组/队列表
     * @param model
     * @param page
     * @param request
     * @return
     */
    @AdminAuth(name = "组/队列表", orderNum = 1, icon="icon-list", type = "1")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model, Integer page, HttpServletRequest request) {
        Page<Team> datas = teamService.findAll(new ParamFilterUtil<Team>().buildSearch(model, request), PageableUtil.basicPage(page));
        model.addAttribute("datas", datas);
        return "admin/team/list";
    }

    /**
     * 组/队数据添加
     * @param model
     * @param request
     * @return
     */
    @Token(flag = Token.READY)
    @AdminAuth(name = "添加组/队", orderNum = 2, icon = "icon-plus")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model, HttpServletRequest request) {
        Team team = new Team();
        model.addAttribute("team", team);
        return "admin/team/add";
    }

    @Token(flag = Token.CHECK)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Team team, HttpServletRequest request) {
        if(TokenTools.isNoRepeat(request)) {
            teamService.save(team);
        }

        return "redirect:/admin/team/list";
    }

    /**
     * 组/队信息修改
     * @param model
     * @param id
     * @param request
     * @return
     */
    @Token(flag = Token.READY)
    @AdminAuth(name = "修改组/队", orderNum = 3, icon = "icon-pencil")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable Integer id, HttpServletRequest request) {
        Team team = teamService.findOne(id);
        model.addAttribute("team", team);
        return "admin/team/update";
    }

    @Token(flag = Token.CHECK)
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(Team team, @PathVariable Integer id, HttpServletRequest request) {
        if(TokenTools.isNoRepeat(request)) {
            Team temp = teamService.findOne(id);
            MyBeanUtils.copyProperties(team, temp, new String[]{"id"});
            teamService.save(temp);
        }

        return "redirect:/admin/team/list";
    }

    /**
     * 组/队信息删除
     * @param id
     * @return
     */
    @AdminAuth(name = "删除组/队", orderNum = 4)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody String delete(@PathVariable Integer id) {
        try {
            teamService.delete(id);
            return "1";
        } catch (Exception e) {
            return "0";
        }
    }

}
