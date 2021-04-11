package capstone_project.domain;

import capstone_project.RegMdfTime;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name=("TB_TRAIN_DATA_TYP"))
@IdClass(TrainDataTypeId.class)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class TrainDataType extends RegMdfTime {

    @Id
    @Column(name="DATA_TYP_COL_ID")
    private String columnId;

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="PROJECT_ID"),
            @JoinColumn(name="TRAIN_ID")
    })
    private Train train;

    @Column(name="DATA_TYP_COL_NM")
    private String columnName;

    @Column(name="DATA_TYP")
    private String dataTyp;

    @Column(name="DATA_LEN")
    private long dataLen;

    @Column(name="CORRECT_COL_YN")
    private String correctCol_YN;

    @Column(name="CORRECT_COL_CORRELATION")
    private String correlation;

    @Column(name="NULL_YN")
    private String null_YN;

    @Column(name="TRAIN_TGT_YN")
    private String tgt_YN;

    @Builder
    public TrainDataType(Train train, String columnName, String dataTyp, long dataLen, String correctCol_YN, String correlation, String null_YN, String tgt_YN){
        this.train = train;
        this.columnName = columnName;
        this.dataTyp = dataTyp;
        this.dataLen = dataLen;
        this.correctCol_YN = correctCol_YN;
        this.correlation = correlation;
        this.null_YN = null_YN;
        this.tgt_YN = tgt_YN;
    }

}
