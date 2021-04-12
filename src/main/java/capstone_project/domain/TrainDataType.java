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

    @Column(name="DATA_FEATURE")
    private String dataFeature;

    @Column(name="CORRECT_COL_YN")
    private String correctCol_YN;

    @Column(name="CORRECT_COL_CORRELATION")
    private String correlation;

    @Column(name="NULL_YN")
    private String null_YN;

    @Column(name="TRAIN_TGT_YN")
    private String tgt_YN;

    @OneToMany(mappedBy="trainDataType")
    List<StatsUnique> statsUniques = new ArrayList<>();

    void addStatusUnique(StatsUnique statsUnique){
        statsUnique.builder().trainDataType(this).build();
        this.statsUniques.add(statsUnique);
    }

    @OneToMany(mappedBy="trainDataType")
    List<StatsList> statsLists = new ArrayList<>();

    void addStatsList(StatsList statsList){
        statsList.builder().trainDataType(this).build();
        this.statsLists.add(statsList);
    }
    @Builder
    public TrainDataType(Train train, String columnId, String columnName, String dataTyp,
                         long dataLen, String dataFeature, String correctCol_YN, String correlation,
                         String null_YN, String tgt_YN){
        this.train = train;
        this.columnId = columnId;

        this.columnName = columnName;
        this.dataTyp = dataTyp;
        this.dataLen = dataLen;
        this.dataFeature = dataFeature;
        this.correctCol_YN = correctCol_YN;
        this.correlation = correlation;
        this.null_YN = null_YN;
        this.tgt_YN = tgt_YN;
    }

}
