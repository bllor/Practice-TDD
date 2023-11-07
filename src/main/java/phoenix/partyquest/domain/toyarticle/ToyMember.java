package phoenix.partyquest.domain.toyarticle;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor
public class ToyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String password;
    private String name;
    @Enumerated(EnumType.STRING)
    private ToyMemberRole role;

    @Builder
    public ToyMember( String email, String password, String name, ToyMemberRole role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}
