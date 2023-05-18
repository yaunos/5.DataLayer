package com.openclassrooms.dataLayer;

import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.service.CategoryService;
import com.openclassrooms.dataLayer.service.CommentService;
import com.openclassrooms.dataLayer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	// @Transactional signifie FIABILITE dans le traitement des données
	// ACID : Atomicité, Cohérence, Isolation, Durabilité : une fois la transaction validée, la base n'est pas affectée par les pannes (l'état de la base est permament)
	@Transactional
	public void run(String... args) throws Exception {

		Product existingProduct = productService.getProductById(1).get();
		System.out.println(existingProduct.getCost());

		existingProduct.setCost(3000);
		productService.addProduct(existingProduct);

		existingProduct = productService.getProductById(1).get();
		System.out.println(existingProduct.getCost());

	}


}
