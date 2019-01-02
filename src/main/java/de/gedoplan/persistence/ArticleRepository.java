package de.gedoplan.persistence;

import de.gedoplan.model.Article;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class ArticleRepository {

    @Inject
    private EntityManager entityManager;

    @GraphQLQuery(name = "articles")
    public List<Article> getAllCustomers() {
        return this.entityManager.createQuery("select a from Article a", Article.class)
                .getResultList();
    }

    @Transactional
    @GraphQLMutation(name = "createarticle")
    public Article persistCustomer(@GraphQLArgument(name = "article") Article article) {
        this.entityManager.persist(article);
        return article;
    }
}
