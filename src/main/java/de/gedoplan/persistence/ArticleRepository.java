package de.gedoplan.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import de.gedoplan.model.Article;

@RequestScoped
public class ArticleRepository {
	private final List<Article> articles;

    public ArticleRepository() {
    	articles = new ArrayList<>();
    	articles.add(new Article(1L, 12345, "Test", "Test"));
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public void saveArticle(Article article) {
    	articles.add(article);
    }
}
