package capstone_project.domain;

import capstone_project.LogTime;
import capstone_project.RegMdfTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name ="TB_USER_LOGIN")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User_login extends LogTime {

    @Id
    @Column(name="USER_ID")
    private long id;

    @Builder
    public User_login(long id){
        this.id =id;
    }
}
