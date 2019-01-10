package de.gedoplan;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import de.gedoplan.persistence.ArticleRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;


@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    public static GraphQLSchema buildSchema() {
        ArticleRepository articleRepository = new ArticleRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(articleRepository))
                .build()
                .makeExecutableSchema();
    }
}

