package graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.ws.entities.Category;
import esprit.ws.entities.Product;
import esprit.ws.reposot.CategoryRepository;
import esprit.ws.reposot.ProductRepository;

public class Query implements GraphQLRootResolver {

	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	
	public Query(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	public List<Category> getListCategory(){
		return this.categoryRepository.getListCategory();
	}
	
	public Category getCategoryByRef(int ref) {
		return this.categoryRepository.getCategoryByRef(ref);
	}
	
	public List<Product> getListProduct(){
		return this.productRepository.getListProduct();
	}
	
	public Product getProductById(int id) {
		return this.productRepository.getProductById(id);
	}
	
	public List<Product> getProductByCategoryRef(int ref){
		return this.productRepository.getProductByCategoryRef(ref);
	}
}
