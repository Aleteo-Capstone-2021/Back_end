package capstone_project.domain;

import capstone_project.RegMdfTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name="TB_USER")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User extends RegMdfTime {
    @Id
    @Column(name="USER_ID")
    private long id;

    @Column(name="USER_NM")
    private String name;

    @Column(name="USER_PASS")
    private String pwd;

    @Builder
    public User(long id, String name, String pwd){
        this.id =id;
        this.name =name;
        this.pwd = pwd;
    }

    @OneToMany(mappedBy = "user")
    List<Project> projects = new ArrayList<>();

    public void addProject(Project project) {
        project.builder().user(this).build();
        this.projects.add(project);
    }
}
