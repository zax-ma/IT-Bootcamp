package org.example.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
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
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "email")
    private String email;


    @ManyToOne
    @PrimaryKeyJoinColumn(name = "role_name", referencedColumnName = "role_id")
    private RoleEntity role;

    @Column(name = "dt_create")
    private LocalDateTime dt_create;

    @Column(name = "dt_update")
    private LocalDateTime dt_update;

    public UserEntity(String surname, String name, String middle_name, String email, RoleEntity role, LocalDateTime dt_create, LocalDateTime dt_update) {
        this.surname = surname;
        this.name = name;
        this.middle_name = middle_name;
        this.email = email;
        this.role = role;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
    }
}
