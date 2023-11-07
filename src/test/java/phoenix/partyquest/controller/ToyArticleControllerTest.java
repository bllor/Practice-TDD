package phoenix.partyquest.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import phoenix.partyquest.domain.toyarticle.ToyArticle;
import phoenix.partyquest.domain.toyarticle.ToyMember;
import phoenix.partyquest.repository.toyarticle.ToyArticleRepository;
import phoenix.partyquest.repository.toyarticle.ToyMemberRepository;
import phoenix.partyquest.request.toy.ToyArticleRequest;
import phoenix.partyquest.request.toy.ToyArticleUpdateRequest;
import phoenix.partyquest.service.ToyArticle.ToyArticleService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ToyArticleControllerTest {

    @Autowired
    ToyArticleService toyArticleService;

    @Autowired
    ToyMemberRepository memberRepository;



    public void insertArticle(){
        ToyArticleRequest request = new ToyArticleRequest();
        request.setTitle("test1107");
        request.setContent("test1107");
        request.setAuthorId(Long.valueOf(1));
        toyArticleService.insertArticle(request);
    }

    public void findAllArticle(){
    List<ToyArticle> articles =  toyArticleService.selectAllArticle();
        Assertions.assertThat(articles.size()).isGreaterThan(0);
    }

    public void findArticle(){
        String id = "1";

        ToyArticle toyArticle =  toyArticleService.selectArticle(Long.valueOf(1));
        Assertions.assertThat(toyArticle.getTitle()).isEqualTo("test1");

    }

    @Test
    public void updateArticle(){
        ToyArticleUpdateRequest updateRequest  = new ToyArticleUpdateRequest();
        updateRequest.setTitle("Controller updateTitle");//업데이트된 제목
        updateRequest.setArticleId(Long.valueOf(2));//글번호
        updateRequest.setContent("Controller updateContent");//업데이트된 글정보
        updateRequest.setAuthorId(Long.valueOf(102));//글쓴이 정보

        toyArticleService.updateArticle(updateRequest);

    }

}