/**
 * 
 */
package com.github.msomi22.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.msomi22.bean.Item;
import com.github.msomi22.exception.ItemException;

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

	@RequestMapping(value="/items/put/{id}", method=RequestMethod.PUT) 
	public Object putItem(@PathVariable("id") String id,@RequestBody Item item) {
		if(id.isEmpty())
			throw new ItemException();
		return "PUT Request item is, id " + id + " " + item;  
	}


	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File("/var/tmp/"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return "File is upload successfully";
	}


	@RequestMapping(value = "/download", method = RequestMethod.GET) 
	public ResponseEntity<Object> downloadFile() throws IOException  {
		String filename = "/var/tmp/test.txt";
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> 
		responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
				MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}



}
