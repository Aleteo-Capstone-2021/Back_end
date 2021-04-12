package capstone_project.domain;

import capstone_project.LogTime;
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
@Table(name=("TB_TRAIN_DATA_STATS_VAL_LIST"))
@IdClass(StatsListId.class)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class StatsList extends LogTime {

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="PROJECT_ID"),
            @JoinColumn(name="TRAIN_ID"),
            @JoinColumn(name="DATA_TYP_COL_ID")
    })
    private TrainDataType trainDataType;

    @Id
    @Column(name="TRAIN_COL_ID")
    private String trainColId;

    @Id
    @Column(name="TRAIN_DATA_GBN")
    private String gbn;

    @Id
    @Column(name="UNIQUE_VAL")
    private String uniqueVal;

    @Column(name="UNIQUE_VAL_CNT")
    private long uniqueValCnt;

    @Column(name="REPLACE_VAL")
    private String replaceVal;

    @Column(name="ABN_YN")
    private String abn_YN;

    @OneToMany(mappedBy = "stautsList")
    List<RPLLog> RPLLogs = new ArrayList<>();

    void addRpl(RPLLog rplLog){
        rplLog.builder().statsList(this).build();
        this.RPLLogs.add(rplLog);
    }

    @Builder
    public StatsList(TrainDataType trainDataType, String trainColId, String gbn, String uniqueVal, long uniqueValCnt, String replaceVal, String abn_YN){
        this.trainDataType = trainDataType;
        this.trainColId = trainColId;
        this.gbn = gbn;
        this.uniqueVal = uniqueVal;
        this.uniqueValCnt = uniqueValCnt;
        this.replaceVal = replaceVal;
        this.abn_YN = abn_YN;
    }

}
