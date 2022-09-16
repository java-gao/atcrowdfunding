package com.adtec.crowd.interceptor;

import com.adtec.crowd.constant.CrowdConstant;
import com.adtec.crowd.entity.po.AdminPO;
import com.adtec.crowd.exception.AccessForbiddenException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        AdminPO adminPO = (AdminPO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIM_ADMIN);
        if (adminPO == null){
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDDEN);
        }
        return true;
    }

}
