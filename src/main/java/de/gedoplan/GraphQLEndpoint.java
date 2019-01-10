package de.gedoplan;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

import com.coxautodev.graphql.tools.SchemaParser;

import de.gedoplan.persistence.CustomerRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;

@WebListener
public class GraphQLEndpoint implements ServletContextListener {

	private static final String SERVLET_NAME = "GraphQLServlet";
	private static final String[] SERVLET_URL = new String[] { "/graphql/*" };
	
	@Inject
	private CustomerQuery customerQuery;
	
	@Inject
	private CustomerMutation customerMutation;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		SimpleGraphQLHttpServlet.Builder builder = SimpleGraphQLHttpServlet.newBuilder(buildSchema());

		SimpleGraphQLHttpServlet graphQLServlet = builder.build();

		ServletContext context = sce.getServletContext();

		ServletRegistration.Dynamic servlet = context.addServlet(SERVLET_NAME, graphQLServlet);
		servlet.addMapping(SERVLET_URL);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	public GraphQLSchema buildSchema() {
		CustomerRepository customerRepository = new CustomerRepository();
		return SchemaParser.newParser().file("schema.graphqls")
				.resolvers(this.customerQuery, this.customerMutation).build()
				.makeExecutableSchema();
	} 
}


