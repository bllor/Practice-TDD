package phoenix.partyquest.service.ToyArticle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import phoenix.partyquest.domain.toyarticle.ToyArticle;
import phoenix.partyquest.domain.toyarticle.ToyMember;
import phoenix.partyquest.domain.toyarticle.myexception.NoAuthenticatedException;
import phoenix.partyquest.domain.toyarticle.repository.ToyArticleRepository;
import phoenix.partyquest.domain.toyarticle.repository.ToyMemberRepository;
import phoenix.partyquest.domain.toyarticle.request.toy.ToyArticleDeleteRequest;
import phoenix.partyquest.domain.toyarticle.request.toy.ToyArticleRequest;
import phoenix.partyquest.domain.toyarticle.request.toy.ToyArticleUpdateRequest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class ToyArticleServiceTest {

    @Autowired
    ToyMemberRepository toyMemberRepository;

    @Autowired
    ToyArticleRepository toyArticleRepository;

    @DisplayName("insertArticle")
    public void insertArticle(){
        ToyArticleRequest request= new ToyArticleRequest();
        request.setTitle("test1");
        request.setContent("test1");
        request.setAuthorId(Long.valueOf("1"));


        //member 조회
        ToyMember savedMember = toyMemberRepository.findById(request.getAuthorId()).orElseThrow();
        //Article Insert
    ToyArticle toyArticle =toyArticleRepository.save(request.toToyArticleDomain(savedMember));
    Assertions.assertThat(toyArticle.getTitle()).isEqualTo("test1");
    }

    //Article 전체조회
    public void findAllArticle(){
    List<ToyArticle> toyArticles = toyArticleRepository.findAll();
    System.out.println("toyArticles : "+ Arrays.toString(toyArticles.stream().toArray()));
        Assertions.assertThat(toyArticles.size()).isGreaterThan(0);
    }


    public void selectArticle(){
        Long id = Long.valueOf(1);
    ToyArticle Article = toyArticleRepository.findById(id).orElseThrow();
    Assertions.assertThat(Article.getTitle()).isEqualTo("test1");
    System.out.println("article :"+Article.toString());
    }


    @Test
    public void updateArticle(){
        ToyArticleUpdateRequest updateRequest  = new ToyArticleUpdateRequest();
        //updateRequest는 front에서 update를 할 때 넘어오는 정보들
        //글번호, 글쓴이Id, title, content
        updateRequest.setTitle("updateTitle");//업데이트된 제목
        updateRequest.setArticleId(Long.valueOf(1));//글번호
        updateRequest.setContent("updateContent");//업데이트된 글정보
        updateRequest.setAuthorId(Long.valueOf(152));//글쓴이 정보

        //업데이트 글쓴이 정보 조회
        ToyMember updateMember = toyMemberRepository.findById(updateRequest.getAuthorId()).orElseThrow();

        //업데이트 되기 전의 글 조회
        ToyArticle selectArticle = toyArticleRepository.findById(updateRequest.getArticleId()).orElseThrow();

        //업데이트 글쓴이의 정보와 업데이트 되기 전 글을 작성한 작성자와의 정보를 비교
        if(selectArticle.getAuthor().getId().equals(updateMember.getId())){
            //업데이트 글쓴이와 원글의 작성자의 정보가 같을 경우

            //업데이트된 title과 content를 원래의 글에 주입
            selectArticle.updateArticle(updateRequest.toArticleDomain());

            //업데이트된 정보를 db에 입력
            toyArticleRepository.save(selectArticle);
        }else {
            System.out.println("noAuthentication");
        }
        Assertions.assertThat(selectArticle.getTitle()).isEqualTo("updateTitle");


    };

    @Test
    public void deleteArticle(){
        ToyArticleDeleteRequest deleteRequest = new ToyArticleDeleteRequest();
        deleteRequest.setArticleId(Long.valueOf(1));
        deleteRequest.setAuthorId(Long.valueOf(152));

    ToyArticle selectedArticle = toyArticleRepository.findById(deleteRequest.getArticleId()).orElseThrow();
    if(selectedArticle.getAuthor().getId().equals(deleteRequest.getAuthorId())){
        toyArticleRepository.deleteById(deleteRequest.getArticleId());
    }else{
        throw new NoAuthenticatedException();
    }

    }

}