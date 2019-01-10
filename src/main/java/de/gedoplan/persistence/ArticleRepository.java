package de.gedoplan.persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.gedoplan.model.Article;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@RequestScoped
public class ArticleRepository {

    @Inject
    private EntityManager entityManager;

    @GraphQLQuery(name = "articles")
    public List<Article> getAllArticles() {
        return this.entityManager.createQuery("select a from Article a", Article.class)
                .getResultList();
    }
    
    @GraphQLQuery(name = "article")
    public Article getArticle(@GraphQLArgument(name = "id") Long id) {
        return this.entityManager.find(Article.class, id);
    }

    @Transactional
    @GraphQLMutation(name = "createarticle")
    public Article persistArticle(@GraphQLArgument(name = "article") Article article) {
        this.entityManager.persist(article);
        return article;
    }
}
