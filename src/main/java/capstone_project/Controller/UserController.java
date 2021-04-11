package capstone_project.Controller;

import capstone_project.DTO.UserLoginDto;
import capstone_project.Service.UserService;
import capstone_project.domain.User;
import capstone_project.domain.User_login;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@SessionAttributes("id")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/home")
    public String login(@ModelAttribute("userLogin") UserLoginDto Dto, Model model){
        User user = userService.search(Dto);

        User_login user_login = new User_login();
        user_login.builder().id(Dto.getId()).build();

        if(user != null) {
            userService.saveLog(user_login);
            model.addAttribute("User", user);
        }
        else
            return ":/redirect";

        return "/project";
    }

}
