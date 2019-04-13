/**
 * 
 */
package com.github.msomi22.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author t_pnjeru
 *
 */
@Component
public class ItemInterceptorAppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	ItemInterceptor itemInterceptor;
	
	 @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(itemInterceptor);
	   }

}
