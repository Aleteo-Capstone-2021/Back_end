package capstone_project.Controller;

import capstone_project.DTO.ProjectDto;
import capstone_project.Service.ProjectService;
import capstone_project.domain.Project;
import capstone_project.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor

public class ProjectController {

    private ProjectService projectService;

    @PostMapping("project/create") // project create
    public String createProject(@ModelAttribute("User") User user, ProjectDto Dto){
        Project project = new Project();
        project.builder().name(Dto.getName()).desc(Dto.getDesc()).algorithmType(Dto.getAlgorithmType()).user(user).build();
        user.addProject(project);

        return "project";
    }

    @GetMapping("/project/") // projects read
    public String List(@ModelAttribute ("User") User user, Model model){
        model.addAttribute("projectList",projectService.showList(user));
        return "/project/list";
    }

    @PutMapping("/project/set") // project update
    public String projectUpdate(@ModelAttribute("ProjectDto") ProjectDto Dto, @RequestParam("projectID") long id){
        projectService.update(id, Dto);
        return "project";
    }

    @DeleteMapping("/project/set") // project remove
    public String projectDelete(@RequestParam("projectID") long id) {
        projectService.delete(id);
        return "/project";
    }
}
