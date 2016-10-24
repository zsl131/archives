package com.zslin.web.controller.basic;

import com.zslin.basic.auth.annotations.AdminAuth;
import com.zslin.basic.auth.annotations.Token;
import com.zslin.basic.auth.iservice.IMenuService;
import com.zslin.basic.auth.model.Menu;
import com.zslin.basic.auth.service.MenuServiceImpl;
import com.zslin.basic.auth.tools.AuthTools;
import com.zslin.basic.auth.tools.TokenTools;
import com.zslin.basic.utils.BaseSearch;
import com.zslin.basic.utils.PageableUtil;
import com.zslin.basic.utils.SearchDto;
import com.zslin.basic.utils.SortDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 菜单管理Controller
 * @author zsl-pc 20160511
 *
 */
@Controller
@RequestMapping(value="admin/menu")
@AdminAuth(name = "菜单管理", psn="权限管理", orderNum = 1, pentity=0, porderNum=2)
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    /** 列表 */
    @AdminAuth(name = "菜单列表", orderNum = 1, icon="icon-list")
    @RequestMapping(value="list", method= RequestMethod.GET)
    public String list(Model model, Integer pid, Integer page, HttpServletRequest request) {
        String treeJson = menuServiceImpl.queryTreeJson(null);
        Page<Menu> datas ;
        if(pid==null || pid<=0) {
            BaseSearch<Menu> spec = new BaseSearch<>(new SearchDto("pid", "isnull", ""));
            datas = menuService.findAll(Specifications.where(spec), PageableUtil.basicPage(page, 15, new SortDto("asc", "orderNum")));
        } else {
            BaseSearch<Menu> spec = new BaseSearch<>(new SearchDto("pid", "eq", pid));
            datas = menuService.findAll(Specifications.where(spec), PageableUtil.basicPage(page, 15, new SortDto("asc", "orderNum")));
        }
        model.addAttribute("treeJson", treeJson);
        model.addAttribute("datas", datas);
        return "admin/menu/list";
    }

    @AdminAuth(name="重构菜单", orderNum=3, type="2")
    @RequestMapping(value="rebuildMenus", method=RequestMethod.POST)
    public @ResponseBody String rebuildMenus(Model model, HttpServletRequest request) {
        AuthTools.getInstance().buildSystemMenu(menuServiceImpl);
        return "1";
    }

    @Token(flag=Token.READY)
    @AdminAuth(name="修改菜单", orderNum=3, type="2")
    @RequestMapping(value="update/{id}", method=RequestMethod.GET)
    public String update(Model model, @PathVariable Integer id, HttpServletRequest request) {
        Menu m = menuService.findById(id);
        model.addAttribute("menu", m);
        return "admin/menu/update";
    }

    @Token(flag=Token.CHECK)
    @RequestMapping(value="update/{id}", method=RequestMethod.POST)
    public String update(Model model, @PathVariable Integer id, Menu menu, HttpServletRequest request) {
        if(TokenTools.isNoRepeat(request)) {
            Menu m = menuService.findById(id);
            m.setIcon(menu.getIcon());
            menuService.save(m);
        }
        return "redirect:/admin/menu/list";
    }

    @RequestMapping("updateSort")
    @AdminAuth(name="菜单排序", orderNum=4, type="2")
    public @ResponseBody String updateSort(Integer[] ids) {
        try {
            menuServiceImpl.updateSort(ids);
        } catch (Exception e) {
            return "0";
        }
        return "1";
    }
}