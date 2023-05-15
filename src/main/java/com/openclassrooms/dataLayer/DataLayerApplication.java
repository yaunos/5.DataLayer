package com.openclassrooms.dataLayer;

import com.openclassrooms.dataLayer.model.Category;
import com.openclassrooms.dataLayer.model.Comment;
import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.service.ProductService;
import com.openclassrooms.dataLayer.service.CategoryService;
import com.openclassrooms.dataLayer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Optional;

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

		Iterable<Product> products = productService.getProducts();

		products.forEach(product -> System.out.println(product.getName()));

		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.println(category.getName()));

		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> System.out.println(comment.getContent()));

		//

		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();

		System.out.println(productId1.getName());

		Optional<Category> optCategory = categoryService.getCategoryById(3);
		Category categoryId1 = optCategory.get();



		System.out.println(categoryId1.getName());


		// @ManytoMany



		// A faire fonctionner

		categoryId1.getProducts().forEach(
				product -> System.out.println(product.getName()));


		Optional<Comment> optComment = commentService.getCommentById(3);
		Comment commentId1 = optComment.get();

		System.out.println(commentId1.getContent());
		System.out.println(commentId1.getProduct().getName());

 		// j'affiche une première fois la liste des catégories

		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));

		// NOUS CREONS UNE NOUVELLE CATEGORIE

		// j'instancie un objet Category et je lui définis un nom. Le nom étant la seule information d'une catégorie
		Category newCategory = new Category();
		newCategory.setName("Promotion");

		// j'appelle la methode addCategory créée précédemment
		newCategory = categoryService.addCategory(newCategory);

		// j'affiche de nouveau les catégories présentes en base et je confirme la bonne création de ma nouvelle catégorie
		categoryService.getCategories().forEach(
				category -> System.out.println(category.getName()));


		// j'instancie un objet Produit et je lui définis un nom, une description et un prix


		// PUIS NOUS CREONS UN NOUEAU PRODUIT
		Product newProduct = new Product();
		newProduct.setName("Assurance au Tiers fidélité");
		newProduct.setDescription("Les garanties à un prix moindre");
		newProduct.setCost(1100);

		newCategory.addProduct(newProduct);

		newProduct = productService.addProduct(newProduct);

		productService.getProducts().forEach(
				product -> System.out.println(product.getName()));

		// j'affiche de nouveau les catégories présentes en base et je confirme la bonne création de ma nouvelle catégorie
		newProduct.getCategories().forEach(
				category -> System.out.println(category.getName()));

		// PUIS NOUS CREONS UN NOUVEAU COMMENTAIRE POUR LE PRODUIT CREE

		Comment newComment = new Comment();
		newComment.setContent("Ah c'est une super assurance !");
		newProduct.addComment(newComment);

	}


}
