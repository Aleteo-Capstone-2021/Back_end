package capstone_project.Service;

import capstone_project.DTO.ProjectDto;
import capstone_project.domain.Project;
import capstone_project.domain.User;
import capstone_project.repository.ProjectRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ProjectService {

    private ProjectRepository projectRepository;

    public List<Object> showList(User user){
        List<Object> projectList = new ArrayList<>();
        projectList = projectRepository.findProject(user);

        return projectList;
    }

    public void create(){


    }

    public void update(long id, ProjectDto Dto){
        Project project = new Project();
        project = projectRepository.findbyId(id);
        project.builder().name(Dto.getName()).desc(Dto.getDesc()).algorithmType(Dto.getAlgorithmType());
        projectRepository.save(project);
    }

    public void delete(long id){
        projectRepository.deleteById(id);
    }
}
