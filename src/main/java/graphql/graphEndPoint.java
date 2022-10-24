package graphql;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import esprit.ws.reposot.CategoryRepository;
import esprit.ws.reposot.ProductRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

@WebServlet("/graphEndPoint")
public class graphEndPoint extends SimpleGraphQLServlet{

	private static final long serialVersionUID = 1L;
	
	public graphEndPoint() {
		super(buildSchema());
		// TODO Auto-generated constructor stub
	}
	
	
	private static GraphQLSchema buildSchema() {
		CategoryRepository categoryRepository= new CategoryRepository();
		ProductRepository productRepository = new ProductRepository();
		
		return SchemaParser
				.newParser()
				.file("schema.graphql")
				.resolvers(new Query(categoryRepository, productRepository), new Mutation(categoryRepository, productRepository))
				.build()
				.makeExecutableSchema();
	
	
	
	
	
	
	}

	
}
