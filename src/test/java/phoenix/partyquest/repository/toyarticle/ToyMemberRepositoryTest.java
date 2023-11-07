package phoenix.partyquest.repository.toyarticle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import phoenix.partyquest.domain.toyarticle.ToyMember;
import phoenix.partyquest.domain.toyarticle.ToyMemberRole;
import phoenix.partyquest.domain.toyarticle.repository.ToyMemberRepository;


@SpringBootTest
class ToyMemberRepositoryTest {

    @Autowired
    ToyMemberRepository toyMemberRepository;

    @Test
    public void insert_member(){
        //회원가입
        toyMemberRepository.save(ToyMember.builder()
                        .name("비아")
                        .password("1234")
                        .email("bllor")
                        .role(ToyMemberRole.ROLE_ADMIN)
                    .build());


    }

    @Test
    public void find_member(){
        //email로 아이디 찾기
        ToyMember findMember =  toyMemberRepository.findByEmail("bllor").orElseThrow();
        Assertions.assertThat(findMember.getName()).isEqualTo("비아");
    }

}