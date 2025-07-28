package com.aluracursos.forohub.domains.profile;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Profile")
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 512)
    private String name;
}
