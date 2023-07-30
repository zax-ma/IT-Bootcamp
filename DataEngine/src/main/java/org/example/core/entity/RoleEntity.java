package org.example.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class RoleEntity {


    @Column(name = "role_id", nullable = false, unique=true)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String uuid;

    @Id
    @Column(name = "role_name")
    private String name;

}
