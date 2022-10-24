package esprit.ws.reposot;

import java.util.ArrayList;
import java.util.List;

import esprit.ws.entities.Category;

public class CategoryRepository {
	
	private  List<Category> listCategory;
	
	
	public CategoryRepository()
	{
		listCategory=new ArrayList<Category>();
		listCategory.add(new Category(123, "Category1"));
		listCategory.add(new Category(456, "Category 2"));
	}
	//create student
	public Category createStudent(Category s) {
		this.listCategory.add(s);
		return s;
	}
	
	public List<Category>getListStudent()
	{return listCategory;}

	public Category getCategoryByRef(int ref)
	{
		for (Category S:listCategory)
		{if (S.equals(ref))
			
		return S;
		
		}
		return null;
		
		}
	public void deleteCategory(int ref) {
		Category c = this.getCategoryByRef(ref);
		this.listCategory.remove(c);
		
	}
	public void updateStudent(Category c) {
		int i = listCategory.indexOf(c);
		if(i!=-1) {
			this.listCategory.set(i, c);
		}
	
	}
	
	
}
