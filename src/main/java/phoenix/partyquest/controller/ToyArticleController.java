package phoenix.partyquest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import phoenix.partyquest.request.toy.ToyArticleRequest;
import phoenix.partyquest.service.ToyArticle.ToyArticleService;

@Controller
@RequiredArgsConstructor
public class ToyArticleController {

    private ToyArticleService toyArticleService;

    @PostMapping
    public void insertArticle(ToyArticleRequest request){

        toyArticleService.insertArticle(request);
    }

    public void selectAllArticle(){
    //모든 article을 조회
        toyArticleService.selectAllArticle();
    }

    public void selectArticle(String id){
     //article 1개 조회
     //front에서 String 타입으로 넘어올 것이므로 Long타입으로 변환이 필요하다.
     toyArticleService.selectArticle(Long.valueOf(id));
    }

}
