package de.gedoplan;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LinkRepository {
    private List<Link> links = new ArrayList<>();

    @GraphQLQuery(name = "links")
    public List<Link> links() {
        links.add(new Link(1L, "url", "bla"));
        return links;
    }

    @GraphQLMutation(name = "createLink")
    public Link saveLink(@GraphQLArgument(name = "link") Link link) {
        links.add(link);
        return links.get(links.size() - 1);
    }
}
