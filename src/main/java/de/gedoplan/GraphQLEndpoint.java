package de.gedoplan;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

import de.gedoplan.model.Address;
import de.gedoplan.model.Customer;
import de.gedoplan.model.Name;
import de.gedoplan.persistence.ArticleRepository;
import de.gedoplan.persistence.CustomerRepository;
import de.gedoplan.persistence.OrderingRepository;
import de.gedoplan.persistence.OrderpositionRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;

@WebListener
public class GraphQLEndpoint implements ServletContextListener {

	private static final String SERVLET_NAME = "GraphQLServlet";
	private static final String[] SERVLET_URL = new String[] { "/graphql/*" };

	@Inject
	private ArticleRepository articleRepository;
	@Inject
	private CustomerRepository customerRepository;
	@Inject
	private OrderingRepository orderingRepository;
	@Inject
	private OrderpositionRepository orderpositionRepository;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		this.initTestData();

		GraphQLSchema schema = new GraphQLSchemaGenerator()
				.withResolverBuilders(new AnnotatedResolverBuilder().withDefaultFilters())
				.withOperationsFromSingleton(articleRepository, ArticleRepository.class)
				.withOperationsFromSingleton(customerRepository, CustomerRepository.class)
				.withOperationsFromSingleton(orderingRepository, OrderingRepository.class)
				.withOperationsFromSingleton(orderpositionRepository, OrderpositionRepository.class).generate();

		SimpleGraphQLHttpServlet.Builder builder = SimpleGraphQLHttpServlet.newBuilder(schema);

		SimpleGraphQLHttpServlet graphQLServlet = builder.build();

		ServletContext context = sce.getServletContext();

		ServletRegistration.Dynamic servlet = context.addServlet(SERVLET_NAME, graphQLServlet);
		servlet.addMapping(SERVLET_URL);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void initTestData() {
		this.customerRepository
				.persistCustomer(new Customer(new Name("Krömer", "Kurt"), new Address("Straße", "4", "12345", "Ort")));
	}
}
