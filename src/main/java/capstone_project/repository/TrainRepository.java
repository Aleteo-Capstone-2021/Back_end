package capstone_project.repository;

import capstone_project.domain.Train;
import capstone_project.domain.TrainId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, TrainId> {
}
