package phoenix.partyquest.domain.toyarticle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phoenix.partyquest.domain.toyarticle.ToyArticle;

import java.util.Optional;

@Repository
public interface ToyArticleRepository  extends JpaRepository<ToyArticle, Long > {

    Optional<ToyArticle> findByTitle(String title);


}
