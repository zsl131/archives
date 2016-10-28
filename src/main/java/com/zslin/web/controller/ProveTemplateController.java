package com.zslin.web.controller;

import com.zslin.web.model.ProveTemplate;
import com.zslin.web.service.IProveTemplateService;
import com.zslin.basic.annotations.AdminAuth;
import com.zslin.basic.annotations.Token;
import com.zslin.basic.tools.TokenTools;
import com.zslin.basic.tools.MyBeanUtils;
import com.zslin.basic.tools.PinyinToolkit;
import com.zslin.basic.utils.PageableUtil;
import com.zslin.basic.utils.ParamFilterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/21 14:22.
 */
@Controller
@RequestMapping(value = "admin/proveTemplate")
@AdminAuth(name="证明管理", orderNum=10, psn="系统应用", pentity=0, porderNum=20)
public class ProveTemplateController {

    @Autowired
    private IProveTemplateService proveTemplateService;

    /** 列表 */
    @AdminAuth(name = "证明模板管理", orderNum = 1, icon="icon-list", type = "1")
    @RequestMapping(value="list", method= RequestMethod.GET)
    public String list(Model model, Integer page, HttpServletRequest request) {
        Page<ProveTemplate> datas = proveTemplateService.findAll(new ParamFilterUtil<ProveTemplate>().buildSearch(model, request), PageableUtil.basicPage(page));
        model.addAttribute("datas", datas);
        return "admin/proveTemplate/list";
    }

    @Token(flag= Token.READY)
    @AdminAuth(name = "添加模板", orderNum = 2, icon="icon-plus")
    @RequestMapping(value="add", method=RequestMethod.GET)
    public String add(Model model, HttpServletRequest request) {
        ProveTemplate proveTemplate = new ProveTemplate();
        model.addAttribute("proveTemplate", proveTemplate);
        return "admin/proveTemplate/add";
    }

    @Token(flag=Token.CHECK)
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Model model, ProveTemplate proveTemplate, HttpServletRequest request) {
        if(TokenTools.isNoRepeat(request)) { //不是重复提交
            proveTemplate.setSn(PinyinToolkit.cn2Spell(proveTemplate.getName(), ""));
            proveTemplate.setCreateDate(new Date());
            proveTemplateService.save(proveTemplate);
        }
        return "redirect:/admin/proveTemplate/list";
    }

    @Token(flag=Token.READY)
    @AdminAuth(name="修改模板", orderNum=3)
    @RequestMapping(value="update/{id}", method=RequestMethod.GET)
    public String update(Model model, @PathVariable Integer id, HttpServletRequest request) {
        ProveTemplate temp = proveTemplateService.findOne(id);
        model.addAttribute("proveTemplate", temp);
        return "admin/proveTemplate/update";
    }

    @Token(flag=Token.CHECK)
    @RequestMapping(value="update/{id}", method=RequestMethod.POST)
    public String update(Model model, @PathVariable Integer id, ProveTemplate proveTemplate, HttpServletRequest request) {
        if(TokenTools.isNoRepeat(request)) {
            ProveTemplate temp = proveTemplateService.findOne(id);
            MyBeanUtils.copyProperties(proveTemplate, temp, new String[]{"id", "createDate"});
            proveTemplateService.save(temp);
        }
        return "redirect:/admin/proveTemplate/list";
    }

    @AdminAuth(name="删除模板", orderNum=4)
    @RequestMapping(value="delete/{id}", method=RequestMethod.POST)
    public @ResponseBody String delete(@PathVariable Integer id) {
        try {
            proveTemplateService.delete(id);
            return "1";
        } catch (Exception e) {
            return "0";
        }
    }
}
