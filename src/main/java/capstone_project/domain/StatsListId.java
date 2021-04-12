package capstone_project.domain;


import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
public class StatsListId implements Serializable {
    private static final long serialVersionUID =1L;

    private TrainDataType trainDataType;

    @Column(name="TRAIN_COL_ID")
    private String trainColId;

    @Column(name="TRAIN_DATA_GBN")
    private String Gbn;

    @Column(name="UNIQUE_VAL")
    private String uniqueVal;

}
