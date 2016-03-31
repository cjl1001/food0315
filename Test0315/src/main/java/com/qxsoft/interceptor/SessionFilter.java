package com.qxsoft.interceptor;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cjl on 2016/3/31.
 * desc:
 */
@WebFilter(filterName = "SessionFilter")
public class SessionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 不过滤的uri(登陆,注册,访问/resources/中的css,js文件,注册时用户名重复的验证)
        String[] notFilter = new String[] { "/toregist","/regist","/repeatName","/login","/resources/" };
        // 请求的uri
        String uri = request.getRequestURI();
        String uriii=request.getServletPath();
        // uri中包含background时才进行过滤
        //if (uri.indexOf("do") != -1) {
            // 是否过滤
            boolean doFilter = true;
            for (String s : notFilter) {
                if (uri.indexOf(s) != -1 || "/test0315/".equals(uri)) {
                    // 如果uri中包含不过滤的uri，则不进行过滤
                    doFilter = false;
                    break;
                }
            }
        System.out.println("uriii = " + uriii);
        System.out.println("uri = " + uri);
        System.out.println("是否过滤:"+doFilter);
            if (doFilter) {
                // 执行过滤
                // 从session中获取登录者实体
                Object obj = request.getSession().getAttribute("user");
                if (null == obj) {
                    // 如果session中不存在登录者实体，则弹出框提示重新登录
                    // 设置request和response的字符集，防止乱码
                    request.setCharacterEncoding("UTF-8");
                    response.setCharacterEncoding("UTF-8");

                    response.sendRedirect("/test0315");
                    //request.getRequestDispatcher("/test0315").forward(request,response);
                } else {
                    // 如果session中存在登录者实体，则继续
                    filterChain.doFilter(request, response);
                }
            } else {
                // 如果不执行过滤，则继续
                filterChain.doFilter(request, response);
            }
        /*} else {
            // 如果uri中不包含do，则继续
            filterChain.doFilter(request, response);
        }*/
    }
}
