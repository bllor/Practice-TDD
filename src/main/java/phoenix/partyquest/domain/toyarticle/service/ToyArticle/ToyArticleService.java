package phoenix.partyquest.domain.toyarticle.service.ToyArticle;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import phoenix.partyquest.domain.toyarticle.ToyArticle;
import phoenix.partyquest.domain.toyarticle.ToyMember;
import phoenix.partyquest.domain.toyarticle.myexception.NoAuthenticatedException;
import phoenix.partyquest.domain.toyarticle.repository.ToyArticleRepository;
import phoenix.partyquest.domain.toyarticle.repository.ToyMemberRepository;
import phoenix.partyquest.domain.toyarticle.request.toy.ToyArticleDeleteRequest;
import phoenix.partyquest.domain.toyarticle.request.toy.ToyArticleRequest;
import phoenix.partyquest.domain.toyarticle.request.toy.ToyArticleUpdateRequest;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ToyArticleService {

    private final ToyArticleRepository toyArticleRepository;
    private final ToyMemberRepository toyMemberRepository;


    public void insertArticle(ToyArticleRequest request){
        log.info("request : "+request.toString());
        //member 조회
        ToyMember savedMember = toyMemberRepository.findById(request.getAuthorId()).orElseThrow();
        //Article Insert
        toyArticleRepository.save(request.toToyArticleDomain(savedMember));
    }

    public List<ToyArticle> selectAllArticle(){
        return toyArticleRepository.findAll();
    }
    public ToyArticle selectArticle(long id){
        return toyArticleRepository.findById(id).orElseThrow();
    }

    public void updateArticle(ToyArticleUpdateRequest updateRequest){
        //글의 원작자와 수정하려는 사람이 같은지 확인
        //front에서도 출력되지 않게 만들기




        //업데이트 글쓴이 정보 조회
        ToyMember updateMember = toyMemberRepository.findById(updateRequest.getAuthorId()).orElseThrow();

        //업데이트 되기 전의 글 조회
        ToyArticle selectArticle = toyArticleRepository.findById(updateRequest.getArticleId()).orElseThrow();

        if(selectArticle.getAuthor().getId().equals(updateMember.getId())){
            //업데이트 글쓴이와 원글의 작성자의 정보가 같을 경우

            //업데이트된 title과 content를 원래의 글에 주입
            selectArticle.updateArticle(updateRequest.toArticleDomain());

            //업데이트된 정보를 db에 입력
            toyArticleRepository.save(selectArticle);
    }else{
        throw new NoAuthenticatedException();
    }

    }
    public void deleteArticle(ToyArticleDeleteRequest deleteRequest){
        ToyArticle selectedArticle = toyArticleRepository.findById(deleteRequest.getArticleId()).orElseThrow();
        if(selectedArticle.getAuthor().getId().equals(deleteRequest.getAuthorId())){
            toyArticleRepository.deleteById(deleteRequest.getArticleId());
        }else{
            throw new NoAuthenticatedException();
        }

    }


}
