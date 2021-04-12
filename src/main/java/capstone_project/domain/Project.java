package capstone_project.domain;

import capstone_project.RegMdfTime;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class )
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
    private String algorithmType;

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
    public Project(String name, String desc, String algorithmType, User user){
        this.name=name;
        this.desc=desc;
        this.algorithmType=algorithmType;
        this.user=user;
    }

}
