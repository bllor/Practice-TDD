package phoenix.partyquest.request.toy;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToyArticleDeleteRequest {
    private Long authorId ;
    private Long articleId ;
}
