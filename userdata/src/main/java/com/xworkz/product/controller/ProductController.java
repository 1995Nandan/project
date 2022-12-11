package com.xworkz.product.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.product.service.ProductService;
import com.xworkz.userdata.dto.ProductDTO;
import com.xworkz.userdata.dto.UserDTO;

@Controller
@RequestMapping("/add")
public class ProductController {
	@Autowired
	private ProductService service;

	public ProductController() {
		System.out.println("product controller running");
	}

	@PostMapping
	String onSave(Model model, ProductDTO dto, @RequestParam("file") MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();

		String saveFile = System.currentTimeMillis() + "_" + file.getName();// + " " +
																			// file.getOriginalFilename();//C:\Users\admin\Desktop\MANOJ
		System.out.println(file.getName());
		System.out.println(saveFile);
		// Path path = Paths.get("C://Users//admin//Desktop//nandan/" + fineName);

		Path path = Paths.get("C://Users//admin//Desktop//MANOJ/" + saveFile);//
		Files.write(path, bytes);
		dto.setCreatedBy("Nandan");
		dto.setCreatedDate(LocalDateTime.now());
		dto.setUpdatedBy("Nandan");
		dto.setUpdatedDate(LocalDateTime.now());
		dto.setFileName(saveFile);

		Boolean save = service.validateAndSave(dto);
		
		System.out.println(save);
		model.addAttribute("msg","Product Details Added Sucessfully");

		return "ToAddProduct";

	}
	@GetMapping
public 	String onReadAllProduct(Model model,UserDTO dto) {
		
	List<ProductDTO> findAllProduct = service.validateAndFindAllProduct();
	System.out.println("onReadAllProduct method is runnig");
	System.out.println(findAllProduct);
	System.out.println(dto.getEmail());
	if(!findAllProduct.isEmpty()&& findAllProduct!=null) {
		model.addAttribute("all" , findAllProduct);
		model.addAttribute("size",findAllProduct.size());
	
		return "ProductDetails";
	}
	else {
		model.addAttribute("msg","There is no Product to Show, So add Something ");
		return "ProductDetails";
	}
	
		
	}
	
	@GetMapping(value = { "/image", "/add/image" })
	void sendfile(@RequestParam String fileName, HttpServletResponse response) throws IOException {
		File file = new File("C://Users//admin//Desktop//MANOJ/" + fileName);
		String fromName = URLConnection.guessContentTypeFromName(file.getName());
		response.setContentType(fromName);
		try (ServletOutputStream outputStream = response.getOutputStream()) {
			outputStream.write(Files.readAllBytes(file.toPath()));

		}
	}
	@GetMapping("/add")
public	 String onReadByName(Model model,HttpServletRequest request) {
		 String parameter = request.getParameter("productName");
		 List<ProductDTO> findAllProduct = service.validateAndFindByName(parameter);
		 System.out.println(findAllProduct.isEmpty());
		
		 if(findAllProduct!=null&&!findAllProduct.isEmpty()) {
			 
			 model.addAttribute("all" , findAllProduct);
				model.addAttribute("size",findAllProduct.size());
			
			 return"ProductDetails";
			 
		 }
		 else {
			 
			 
			 model.addAttribute("all" , "there is no product on this name");
				model.addAttribute("size",findAllProduct.size());
			
			 
			 
				return "ProductDetails";
		 }
		
		 
	 }

}
