package de.gedoplan;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import de.gedoplan.model.Article;
import de.gedoplan.persistence.ArticleRepository;

public class Query implements GraphQLRootResolver {
    private final ArticleRepository articleRepository;

    public Query(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> allArticles() {
        return articleRepository.getAllArticles();
    }
}
