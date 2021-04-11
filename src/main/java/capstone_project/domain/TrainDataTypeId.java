package capstone_project.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
public class TrainDataTypeId implements Serializable {
    private static final long serialVersionUID =1L;

    @Column(name = "DATA_TYP_COL_ID")
    private String dataType;

    private Train train;

}
