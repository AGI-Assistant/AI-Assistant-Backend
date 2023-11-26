package ai.User;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.generator.BeforeExecutionGenerator;

import java.util.UUID;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "uuid", type = BeforeExecutionGenerator.class)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String email;

    private String password;

    private String name;

    private Role role;

    public User(String email, String password, String name, Role role) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public User() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + "'" +
                ", password='" + password + "'" +
                ", name='" + name + "'" +
                ", role='" + role + "'" +
                '}';
    }


}
