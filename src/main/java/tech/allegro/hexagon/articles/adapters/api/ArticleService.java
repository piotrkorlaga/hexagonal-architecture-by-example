package tech.allegro.hexagon.articles.adapters.api;

import tech.allegro.hexagon.articles.domain.ArticleFacade;
import tech.allegro.hexagon.articles.domain.model.ArticleId;
import org.springframework.stereotype.Component;

@Component
class ArticleService {

    private final ArticleFacade articleFacade;

    ArticleService(final ArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }

    ArticleResponse get(final String articleId) {
        return ArticleResponse.of(articleFacade.get(ArticleId.of(articleId)));
    }

    ArticleIdResponse create(final ArticleRequest articleRequest) {
        final ArticleId articleId = articleFacade.create(articleRequest.authorId(), articleRequest.title(), articleRequest.content());
        return ArticleIdResponse.of(articleId);
    }
}