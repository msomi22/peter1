/**
 * 
 */
package com.github.msomi22.RestClient;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.msomi22.bean.Item;

/**
 * @author t_pnjeru
 *
 */
@RestController
public class Client {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value="/template/items")
	public Object getItems() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8080/items", HttpMethod.GET, entity, String.class).getBody();
	}

	@RequestMapping(value="/template/items",method = RequestMethod.POST)
	public Object postItems(@RequestBody Item item) { 
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <Item> entity = new HttpEntity<Item>(item,headers); 
		return restTemplate.exchange("http://localhost:8080/items", HttpMethod.POST, entity, String.class).getBody();
	}


	@RequestMapping(value = "/template/items/put/{id}", method = RequestMethod.PUT)
	public String updateProduct(@PathVariable("id") String id, @RequestBody Item item) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Item> entity = new HttpEntity<Item>(item,headers);
		return restTemplate.exchange("http://localhost:8080/items/put/"+id, HttpMethod.PUT, entity, String.class).getBody();
	}






}
