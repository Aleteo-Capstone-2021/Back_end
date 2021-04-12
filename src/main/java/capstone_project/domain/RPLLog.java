package capstone_project.domain;

import capstone_project.LogTime;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name=("TB_TRAIN_DATA_STATS_VAL_RPL_LOG"))
@IdClass(RPLLogId.class)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class RPLLog extends LogTime {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="PROJECT_ID"),
            @JoinColumn(name="TRAIN_ID"),
            @JoinColumn(name="DATA_TYP_COL_ID"),
            @JoinColumn(name="TRAIN_COL_ID"),
            @JoinColumn(name="TRAIN_DATA_GBN"),
            @JoinColumn(name="UNIQUE_VAL")
    })
    private StatsList statsList;

    @Id
    @Column(name="RPL_SEQ")
    private long rplSeq;

    @Column(name="UNIQUE_VAL_CNT")
    private long uniqueValCnt;

    @Column(name="REPLACE_VAL")
    private String replaceVal;

    @Column(name="ABN_YN")
    private String abn_YN;

    @Builder
    public RPLLog (StatsList statsList, long rplSeq, long uniqueValCnt, String replaceVal, String abn_YN){
        this.statsList = statsList;
        this.rplSeq = rplSeq;
        this.uniqueValCnt = uniqueValCnt;
        this.replaceVal = replaceVal;
        this.abn_YN = abn_YN;
    }

}
