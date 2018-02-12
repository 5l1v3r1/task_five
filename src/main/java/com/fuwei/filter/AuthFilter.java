/*

package com.fuwei.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="/AuthFilter",urlPatterns="/index"
        ,initParams={@WebInitParam(name ="EXCLUDED_PAGES" , value = "/index;indexAction")})

public class AuthFilter implements Filter {


    private String excludedPages;
    private String[] excludedPageArray;
    private String excludedPageArray1;



    public void init(FilterConfig fConfig) throws ServletException {
        excludedPages = fConfig.getInitParameter("EXCLUDED_PAGES");
        if (null!=excludedPages && excludedPages.length()!=0) { // 例外页面不为空
            excludedPageArray = excludedPages.split(String.valueOf(';'));
            System.out.println(excludedPageArray.toString());
            excludedPageArray1=excludedPageArray.toString();
        }
    }


    public void destroy() {
        System.out.println("+++++++++++++++++++++++++++++++");
        this.excludedPages = null;
        this.excludedPageArray = null;
    }



    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        boolean isExcludedPage = false;
        excludedPageArray1=excludedPageArray.toString();
        for (String page : excludedPageArray) {// 遍历例外url数组

            // 判断当前URL是否与例外页面相同
            if (req.getServletPath().substring(1).equals(page)) { // 从第2个字符开始取（把前面的/去掉）
                System.out.println(page + ", you're excluded.");
                isExcludedPage = true;
                break;
            }
        }
        if (isExcludedPage) {//在过滤url之外
            chain.doFilter(request, response);
        } else {// 不在过滤url之外

        }
    }}
*/
