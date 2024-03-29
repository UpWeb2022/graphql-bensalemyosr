package esprit.ws.reposot;

import java.util.ArrayList;
import java.util.List;

import esprit.ws.entities.Category;
import esprit.ws.entities.Product;
import javassist.bytecode.Descriptor.Iterator;

public class ProductRepository {
	private  List<Product> listProduct;
	public   CategoryRepository catRepo= new CategoryRepository();
	public ProductRepository() {
		listProduct=new ArrayList<Product>();
		listProduct.add(new Product(1, "Product 1", this.catRepo.getCategoryByRef(123) ,40));
		listProduct.add(new Product(2, "Product 2", this.catRepo.getCategoryByRef(456) ,10));
	}
	
    public List<Product> getListProduct() {
		return listProduct;
    }
    //function to add a product
    //verify if the given category exist in the list or not
    public boolean addProduct(Product p){
		int refCat=p.getCategory().getRef();
		Category category=catRepo.getCategoryByRef(refCat);
		if(category!=null){
			p.setCategory(category);
			return listProduct.add(p);}
		return false;
	}
    //function to return the list of product by Category
    public List<Product> getProductByCategoryRef(int ref) {
		List<Product> list=new ArrayList<Product>();
		for(Product p:listProduct){
			if(p.getCategory().getRef()==ref)
				list.add(p);
		}
		return list;
	}
    //update Product
    public boolean updateProduct(Product product){
 		for (Product p: listProduct)
 		{
 			if(p.getId()==product.getId())
 			{
 				p.setName(product.getName());
 				p.setCategory(product.getCategory());
 				p.setPrice(product.getPrice());
 				return true;
 			}
 		}
 		return false;
 	}
    
    public void deleteProduct(int id){
    		Product p = this.getProductById(id);
    		this.listProduct.remove(p);
    		
    	
	}
    public Product getProductById(int id)
	{
		for (Product p:listProduct)
		{if (p.getId() ==id)
			
		return p;
		
		}
		return null;
		
		}

}
