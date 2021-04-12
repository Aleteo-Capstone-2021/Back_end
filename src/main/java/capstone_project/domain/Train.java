package capstone_project.domain;


import capstone_project.RegMdfTime;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name=("TB_TRAIN"))
@IdClass(TrainId.class)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Train extends RegMdfTime {

    @Id
    @GeneratedValue
    @Column(name="TRAIN_ID")
    private long id;

    @Id
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="PROJECT_ID")
    private Project project;

    @Column(name="TRAIN_NM")
    private String name;

    @Column(name="TRAIN_DATA_UP_PATH")
    private String dataPath;

    @Column(name="TRAIN_COL_CNT")
    private long colCnt;

    @Column(name="TRAIN_LIMIT_TIME_SECOND")
    private long limit;

    @Column(name="TRAIN_DATA_RATIO")
    private long trainRatio;

    @Column(name="TEST_DATA_RATIO")
    private long testRatio;

    @Column(name="TRAIN_DATA_STATUS")
    private String trainDataStatus;

    @Column(name="TRAIN_STATUS")
    private String trainStatus;

    @OneToMany(mappedBy = "train")
    List<TrainDataType> trainDataTypes = new ArrayList<>();

    void addTrainDataType(TrainDataType trainDataType){
        trainDataType.builder().train(this).build();
        this.trainDataTypes.add(trainDataType);
    }

    @Builder
    public Train(Project project, String name, String dataPath, long colCnt,
                 long limit,long trainRatio, long testRatio,
                 String trainDataStatus,String trainStatus){
        this.project = project;
        this.name = name;
        this.dataPath = dataPath;
        this.colCnt = colCnt;
        this.limit = limit;
        this.trainRatio= trainRatio;
        this.testRatio = testRatio;
        this.trainDataStatus = trainDataStatus;
        this.trainStatus = trainStatus;
    }

}
