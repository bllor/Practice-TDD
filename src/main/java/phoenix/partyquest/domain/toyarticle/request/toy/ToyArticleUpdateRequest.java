package phoenix.partyquest.domain.toyarticle.request.toy;


import lombok.*;
import phoenix.partyquest.domain.toyarticle.ToyArticle;
import phoenix.partyquest.domain.toyarticle.ToyMember;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToyArticleUpdateRequest {

    private Long authorId ;
    private Long articleId ;
    private String title;
    private String content;

    @Builder
    public ToyArticle toArticleDomain(){
       return ToyArticle.builder()
                .title(this.title)
                .content(this.content)
                .build();
    };


}
