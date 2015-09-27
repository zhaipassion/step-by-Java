package liXingHua.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

/**
 * 登陆验证过滤器，记得在web.xml中也要配置
 * 
 * @author HZ
 * 
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("登录验证过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
        ServletException {
        System.out.println("执行登录验证方法之前");
        // HttpServletRequest req = (HttpServletRequest) request;
        // HttpSession session = req.getSession();
        // Object userName = session.getAttribute("userName");
        // 如果没有登录跳转到登录页面，这里为了程序中其他测试范例的测试方便，就注释掉了，需要的时候参考这个范例即可
        // if (userName != null) {
        chain.doFilter(request, response);
        // } else {
        // request.getRequestDispatcher("login.jsp").forward(request, response);
        // }
        System.out.println("执行登录验证方法之后");
    }

    @Override
    public void destroy() {
        System.out.println("登录验证过滤器销毁");
    }

}
