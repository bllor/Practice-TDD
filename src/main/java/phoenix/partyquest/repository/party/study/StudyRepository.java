package phoenix.partyquest.repository.party.study;

import org.springframework.data.jpa.repository.JpaRepository;
import phoenix.partyquest.domain.party.study.Study;

public interface StudyRepository extends JpaRepository<Study,Long> {
}
