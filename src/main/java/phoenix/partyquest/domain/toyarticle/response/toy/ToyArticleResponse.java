package phoenix.partyquest.domain.toyarticle.response.toy;

import lombok.*;
import phoenix.partyquest.domain.toyarticle.ToyArticle;

@Getter
@Setter
@NoArgsConstructor
public class ToyArticleResponse {

    private Long articleId;
    private Long authorId;
    private String title;
    private String content;

    @Builder
    public ToyArticleResponse(Long articleId, Long authorId, String title, String content){
          this.articleId = articleId;
          this.authorId = authorId;
          this.title = title;
          this.content = content;
    }
    //https://github.com/luxleo/spring_board/blob/main/src/main/java/com/luxlog/api/service/PostService.java
    //https://github.com/luxleo/spring_board/blob/main/src/main/java/com/luxlog/api/response/PostResponse.java
    //reponse Stream으로 처리하는 것 예제
}
