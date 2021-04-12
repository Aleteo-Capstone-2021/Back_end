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
@Table(name=("TB_TRAIN_DATA_STATUS_UNIQUE"))
@IdClass(StatsUniqueId.class)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class StatsUnique extends LogTime {

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
    private String Gbn;

    @Column(name="DATA_ROW_CNT")
    private long rowCnt;

    @Column(name="UNIQUE_CNT")
    private long uniqueCnt;

    @Column(name="MISSING_VAL_CNT")
    private long missCnt;

    @Column(name="MISSING_VAL_EXCEPT_TGT_YN")
    private String missExcept;

    @Column(name="ENC_MIN_VAL")
    private long encMin;

    @Column(name="ENC_MAX_VAL")
    private long encMax;

    @Column(name="ENC_MEAN_VAL")
    private long encMean;

    @Column(name="ENC_MEDIAN_VAL")
    private long encMedian;

    @Column(name="ENC_25PER_VAL")
    private long enc25;

    @Column(name="ENC_75PER_VAL")
    private long enc75;

    @Column(name="ENC_TRIM_MEAN_VAL")
    private long encTrimMean;

    @Column(name="ENC_MODE_VAL")
    private long encMode;

    @Builder
    public StatsUnique(TrainDataType trainDataType, String trainColId, String Gbn, long rowCnt, long uniqueCnt,
                       long missCnt, String missExcept, long encMin, long encMax, long encMean,
                       long encMedian, long enc25, long enc75, long encTrimMean, long encMode){

        this.trainDataType = trainDataType;
        this.trainColId = trainColId;
        this.Gbn = Gbn;
        this.rowCnt = rowCnt;
        this.uniqueCnt = uniqueCnt;
        this.missCnt = missCnt;
        this.missExcept = missExcept;
        this.encMax = encMax;
        this.encMin = encMin;
        this.encMean = encMean;
        this.encMedian = encMedian;
        this.enc25 = enc25;
        this.enc75 = enc75;
        this.encTrimMean = encTrimMean;
        this.encMode = encMode;
    }
}
