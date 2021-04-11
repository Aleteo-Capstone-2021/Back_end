package capstone_project.Service;

import capstone_project.DTO.UserLoginDto;
import capstone_project.domain.User;
import capstone_project.domain.User_login;
import capstone_project.repository.UserLoginRepository;
import capstone_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    final UserRepository userRepository;
    final UserLoginRepository userLoginRepository;

    //INSERT to table TB_USER_LOGIN
    public void saveLog(User_login user_login){
         userLoginRepository.save(user_login);
    }

    public User search(UserLoginDto Dto){
        User user = userRepository.findByIdAndPwd(Dto.getId(),Dto.getPwd());
        return user;
    }

}
