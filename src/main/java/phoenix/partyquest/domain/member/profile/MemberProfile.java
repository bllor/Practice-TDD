package phoenix.partyquest.domain.member.profile;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import phoenix.partyquest.domain.base.BaseLocation;
import phoenix.partyquest.domain.member.Member;
import phoenix.partyquest.domain.member.map.MiddleMemberMap;
import phoenix.partyquest.domain.member.map.SmallMemberMap;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class MemberProfile extends BaseLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "member_profile_id")
    private Long id;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private Member member;

    @Column(unique = true)
    private String nickName;

    @Enumerated(EnumType.STRING)
    private MemberMBTI mbti;
    private String bio;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<MiddleMemberMap> favoriteMiddles = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<SmallMemberMap> favoriteSmalls = new ArrayList<>();

    public void allocateMember(Member member) {
        this.member = member;
    }

}
