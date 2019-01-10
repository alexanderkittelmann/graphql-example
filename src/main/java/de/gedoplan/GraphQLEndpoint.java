package de.gedoplan;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import de.gedoplan.persistence.CustomerRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;


@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends AbstractGraphQLHttpServlet {
	
	private CustomerRepository customerRepository;

    public GraphQLEndpoint() {
    	super();
    }

    public static GraphQLSchema buildSchema() {
        CustomerRepository customerRepository = new CustomerRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new CustomerQuery(customerRepository), new CustomerMutation(customerRepository))
                .build()
                .makeExecutableSchema();
    }
}

