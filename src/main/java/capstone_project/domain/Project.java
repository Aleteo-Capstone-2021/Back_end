package capstone_project.domain;

import capstone_project.RegMdfTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name="TB_PROJECT")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Project extends RegMdfTime {
    @Id
    @GeneratedValue
    @Column(name="PROJECT_ID")
    private long id;

    @Column(name="PROJECT_NM")
    private String name;

    @Column(name="PROJECT_DESC")
    private String desc;

    @Column(name="PROJECT_ALGORITHM_TYP")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(mappedBy="project")
    List<Train> trains = new ArrayList<>();

    public void addTrain(Train train){
        train.builder().project(this).build();
        this.trains.add(train);
    }

    @Builder
    public Project(String name, String desc, String type, User user){
        this.name=name;
        this.desc=desc;
        this.type=type;
        this.user=user;
    }

}
