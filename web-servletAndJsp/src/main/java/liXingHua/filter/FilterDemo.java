package liXingHua.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo implements Filter {
    /**
     * 程序启动的时候，此初始化方法就会执行
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initParam = filterConfig.getInitParameter("ref");
        System.out.println("过滤器初始化，初始化参数：" + initParam);
    }

    /**
     * 有访问服务器自愿的请求的时候会调用此过滤器
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        System.out.println("执行doFilter方法之前");
        /**
         * 一定要记得调用此方法，不然，过滤器就会断掉，不再往下进行
         */
        chain.doFilter(request, response);
        System.out.println("执行doFilter方法之后");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁。");
    }

}
