package ai.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.generator.BeforeExecutionGenerator;

import java.util.UUID;

@Entity
@Table(name = "prompts")
public class Prompt extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "uuid", type = BeforeExecutionGenerator.class)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String username;
    private String prompt;



    public Prompt(String username, String prompt){
        this.id = UUID.randomUUID();
        this.username = username;
        this.prompt = prompt;

    }

    public Prompt() {
        this.id = UUID.randomUUID();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prompt{" +
                "username='" + username + '\'' +
                ", prompt='" + prompt + '\'' +
                '}';
    }
}
