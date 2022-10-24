package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.ws.entities.Category;
import esprit.ws.entities.Product;
import esprit.ws.reposot.CategoryRepository;
import esprit.ws.reposot.ProductRepository;

public class Mutation implements GraphQLRootResolver {

	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	public Mutation(CategoryRepository categoryRepository, ProductRepository productRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	public Category createCategory(int ref, String name) {
		Category c= new Category(ref, name);
		this.categoryRepository.createCategory(c);
		return c;
	}
	
	public Category updateCategory (int ref, String name) {
		Category c= new Category(ref, name);
		this.categoryRepository.updateCategory(c);
		return c;
	}
	
	public String deleteCategory(int ref) {
		this.categoryRepository.deleteCategory(ref);
		return "Deleted";
	}
	
	public boolean addProduct(int id,String name,int price,int ref) {
		Product p = new Product(id, name, this.categoryRepository.getCategoryByRef(ref), price);
		return this.productRepository.addProduct(p);
	}
	
	public String deleteProduct(int id) {
		this.productRepository.deleteProduct(id);
		return "deleted";
	}
	
	public boolean updateProduct(int id,String name,int price,int ref) {
		Product p = new Product(id, name, this.categoryRepository.getCategoryByRef(ref), price);
		return this.productRepository.updateProduct(p);
		
	}
	
}
