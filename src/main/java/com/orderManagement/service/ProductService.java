package com.orderManagement.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderManagement.DTO.ProductDTO;
import com.orderManagement.entity.Product;
import com.orderManagement.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	static int index=100;
	
	public ProductDTO getProductDetails(String productId) {
		Product prod=productRepo.findById(productId).get();
		ProductDTO p=ProductDTO.valueOf(prod);
		return p;
	}
	
	public List<Product> getProductByCategory(String category){
		List<Product> p=productRepo.findAllByCategory(category);
		return p;
	}
	
	public List<Product> getProductByName(String name){
		List<Product> p=productRepo.findAllByProductName(name);
		return p;
	}
	
	public List<Product> getAllProducts(){
		List<Product> p=productRepo.findAll();
		return p;
	}
	
	public String addProduct(String sellerId,ProductDTO productDTO) {
		try {
			String s="P"+ index++;
			Product product=new Product();
			product.setProductId(s);
			product.setProductName(productDTO.getProductName());
			product.setPrice(productDTO.getPrice());
			product.setCategory(productDTO.getCategory());
			product.setDescription(productDTO.getDescription());
			product.setImage(productDTO.getImage());
			product.setSubcategory(productDTO.getSubcategory());
			product.setSeller_id(productDTO.getSeller_id());
			product.setProductRating(productDTO.getProductRating());
			product.setStock(productDTO.getStock());
			
			productRepo.save(product);
			return "Product Added Successfully";
		}
		catch(Exception e){
			return "Product couldn't be added.Bad request";
			
		}
	}
		
	public String removeProduct(String productId) {
		productRepo.deleteById(productId);
		return "Product Removed Successfully";
	}
	
	public String updateStock(String productId,Integer Stock) {
		Product p=productRepo.findById(productId).get();
		p.setStock(p.getStock()-Stock);
		productRepo.save(p);
		return "Updated Stock Successfully";
		
	}
	
}
