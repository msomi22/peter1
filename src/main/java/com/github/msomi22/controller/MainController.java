/**
 * 
 */
package com.github.msomi22.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.msomi22.bean.Item;

/**
 * @author t_pnjeru
 *
 */
@RestController
public class MainController {
	
	@RequestMapping(value="/items")
	public Object getItem() {
		return "GET Request values item1, item2, item3, item4, item5";
	}
	
	@RequestMapping(value="/items", method=RequestMethod.POST)
	public Object postItem(@RequestBody Item item) { 
		return "POST Request item is " + item; 
	}
	
	@RequestMapping(value="/items/{id}", method=RequestMethod.PUT) 
	public Object putItem(@PathVariable("id") String id,@RequestBody Item item) { 
		return "PUT Request item is, id " + id + " " + item;  
	}
	
	

}
