package com.wyq.filter;

import com.wyq.utils.WildcardPatternBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;

public class LoginForwarFilter implements Filter {
	private Log log = LogFactory.getLog(getClass());
	
	/** 需要排除（不拦截）的URL的正则表达式 */
	private Pattern excepUrlPattern;

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		/** 获取web.xml配置的文件信息 */
		String excepUrlRegex = cfg.getInitParameter("excepUrlRegex");
		if (!StringUtils.isBlank(excepUrlRegex)) {
			excepUrlPattern = WildcardPatternBuilder.build(excepUrlRegex);
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		// 访问路径
		String servletPath = request.getServletPath();
		log.info("请求链接：" + servletPath);
		log.info("请求参数：" + request.getQueryString());
		// 如果请求的路径与排除检查的路径相同放过
		if (!excepUrlPattern.matcher(servletPath).matches()) {
			if (session != null) {
				if (null == session.getAttribute("loginUser")) {
					if(StringUtils.isBlank(request.getHeader("X-Requested-With"))){
						response.sendRedirect(request.getContextPath()+"/login.jsp");
					}else{
						response.setHeader("sessionstatus","TIMEOUT");
						return;
					}
				} else {// 登录用户不校验
					chain.doFilter(req, resp);
					return;
				}
			} else {
				if(StringUtils.isBlank(request.getHeader("X-Requested-With"))){
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				}else{
					response.setHeader("sessionstatus","TIMEOUT");
					return;
				}
			}
		}
		chain.doFilter(req, resp);
		return;
	}

	@Override
	public void destroy() {
	}

}
