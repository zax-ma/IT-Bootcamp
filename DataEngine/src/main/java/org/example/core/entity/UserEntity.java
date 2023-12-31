package org.example.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @NotNull
    @Column(name = "id", nullable = false, unique=true)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String uuid;

    @Column(name = "surname")
    @NotNull
    private String surname;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "middle_name")
    @NotNull
    private String middle_name;

    @Column(name = "email")
    @NotNull
    private String email;


    @ManyToOne
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private RoleEntity role;

    @Column(name = "dt_create")
    private LocalDateTime dt_create;

    @Column(name = "dt_update")
    private LocalDateTime dt_update;

    public UserEntity(String uuid, String surname, String name, String middle_name, String email, RoleEntity role, LocalDateTime dt_create, LocalDateTime dt_update) {
        this.uuid = uuid;
        this.surname = surname;
        this.name = name;
        this.middle_name = middle_name;
        this.email = email;
        this.role = role;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
    }
}
