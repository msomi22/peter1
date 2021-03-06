/**
 * 
 */
package com.github.msomi22.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * @author t_pnjeru
 *
 */
@Component
public class ItemFilter implements Filter{

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Remote Host:"+request.getRemoteHost());
		System.out.println("Remote Address:"+request.getRemoteAddr());
		System.out.println("Remote Port:"+ request.getRemotePort());
		System.out.println("--------------------------------------");
		System.out.println("Local Host:"+request.getLocalName());
		System.out.println("Local Address:"+request.getLocalAddr());
		System.out.println("Local Port:"+ request.getLocalPort());
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {}

}
