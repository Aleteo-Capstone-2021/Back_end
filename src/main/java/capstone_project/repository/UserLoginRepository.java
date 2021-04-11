package capstone_project.repository;

import capstone_project.domain.User_login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<User_login, Long> {

}
