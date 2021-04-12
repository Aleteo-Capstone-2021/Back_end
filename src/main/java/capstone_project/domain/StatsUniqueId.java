package capstone_project.domain;


import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
public class StatsUniqueId implements Serializable {
    private static final long serialVersionUID = 1L;

    private TrainDataType traindDataType;

    @Column(name="TRAIN_COL_ID")
    private String trainColID;

    @Column(name="TRAIN_DATA_GBN")
    private String Gbn;
}
