package phoenix.partyquest.request.toy;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import phoenix.partyquest.domain.toyarticle.ToyArticle;
import phoenix.partyquest.domain.toyarticle.ToyMember;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToyArticleRequest {

    private Long authorId;
    private String title;
    private String content;

    public ToyArticle toToyArticleDomain(ToyMember member){
      return  ToyArticle.builder()
                .author(member)
                .title(this.title)
                .content(this.content)
                .build();
    };
}
