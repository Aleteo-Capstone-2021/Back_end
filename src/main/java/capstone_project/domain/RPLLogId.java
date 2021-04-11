package capstone_project.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
public class RPLLogId implements Serializable {

    private StatusList statusList;

    @Column(name="RPL_SEQ")
    private long rplSeq;
}
