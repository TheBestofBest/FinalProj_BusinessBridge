package com.app.businessBridge.domain.Article.Service;

import com.app.businessBridge.domain.Article.Entity.Article;
import com.app.businessBridge.domain.Article.Repository.ArticleRepository;
import com.app.businessBridge.domain.member.entity.Member;
import com.app.businessBridge.global.RsData.RsCode;
import com.app.businessBridge.global.RsData.RsData;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }

    public Optional<Article> getArticle(Long id) {
        return this.articleRepository.findById(id);
    }
    @Transactional
    public RsData<Article> create(String subject, String content) {
        Article article = Article.builder()
                .subject(subject)
                .content(content)
                .build();

        this.articleRepository.save(article);

        return RsData.of(RsCode.S_02,
                "게시물이 생성 되었습니다.",
                article
        );
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }
    public RsData<Article> modify(Article article, String subject, String content) {

        article.setSubject(subject);
        article.setContent(content);

        articleRepository.save(article);


        article.setContent(content);
        article.setSubject(subject);


        articleRepository.save(article);

        // 기존 article 객체를 기반으로 article1 객체 생성

        // article1 객체의 subject와 content 필드를 새 값으로 설정
        article.setSubject(subject);
        article.setContent(content);


        // article1 객체를 저장하여 수정된 내용을 DB에 반영
        articleRepository.save(article);
        return RsData.of(RsCode.S_03,
                "%d번 게시물이 수정 되었습니다.".formatted(article.getId()),
                article
        );
    }
    public RsData<Article> deleteById(Long id) {
        articleRepository.deleteById(id);

        return RsData.of(RsCode.S_04,
                "%d번 게시물이 삭제 되었습니다.".formatted(id),
                null
        );
    }
}
