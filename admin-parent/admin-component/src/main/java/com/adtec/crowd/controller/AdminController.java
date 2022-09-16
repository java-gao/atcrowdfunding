package com.adtec.crowd.controller;

import com.adtec.crowd.constant.CrowdConstant;
import com.adtec.crowd.entity.po.AdminPO;
import com.adtec.crowd.service.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("admin/do/login.html")
    public String doLogin(AdminPO admin, HttpSession session){
        AdminPO adminPO = adminService.getAdminByAcct(admin);
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIM_ADMIN,adminPO);
        return "redirect:/admin/to/main/page.html";
    }
    @RequestMapping("admin/do/logout.html")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }
    @RequestMapping("admin/get/page.html")
    public String queryAdminlist(@RequestParam(value = "keyword",defaultValue = "") String keyword,
                                 @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 ModelMap modelmap){
        PageInfo<AdminPO> adminPOPageInfo = adminService.getAdminBykeyword(keyword,pageNum,pageSize);
        modelmap.addAttribute("pageInfo",adminPOPageInfo);
        return "admin-page";

    }

    @RequestMapping("/admin/remove/{adminId}/{pageNum}/{keyword}.html")
    public String removeAdmin(
            @PathVariable("adminId") Integer adminId,
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("keyword") String keyword){
        adminService.removeAdminById(adminId);
        return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
    }

    @RequestMapping("/admin/add/page.html")
    public String addAdmin(AdminPO admin){
        adminService.addAdmin(admin);
        return "redirect:/admin/get/page.html?pageNum="+Integer.MAX_VALUE;
    }

    @RequestMapping("/admin/to/edit/page.html")
    public String toEditPage(
            @RequestParam("adminId") Integer adminId,
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("keyword") String keyword,
            ModelMap modelmap
            ){
        AdminPO adminPO = adminService.getAdminById(adminId);
        modelmap.addAttribute("admin",adminPO);
        return "admin-edit";
    }

    @RequestMapping("/admin/update/page.html")
    public String updateAdmin(
            AdminPO adminPO,
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("keyword") String keyword){
        adminService.updateAdminById(adminPO);
        return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
    }
}
