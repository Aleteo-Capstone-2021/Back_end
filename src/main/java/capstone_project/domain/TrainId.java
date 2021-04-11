package capstone_project.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;


@NoArgsConstructor
public class TrainId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Project project;

    @Column(name="TRAIN_ID")
    private long trainId;

}
