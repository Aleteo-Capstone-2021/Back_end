package capstone_project.repository;

import capstone_project.domain.Project;
import capstone_project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("select p.id, p.type, p.name, p.REG_DT, p.MDF_DT from Project p where p.user = :user order by p.id")
    List<Object> findProject(@Param("User") User user);

    Project findbyId(long id);
}
