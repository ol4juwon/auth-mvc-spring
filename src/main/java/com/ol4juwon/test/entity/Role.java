package com.ol4juwon.test.entity;


import java.util.ArrayList;
import java.util.List;



import com.ol4juwon.test.users.Users;

import javax.persistence.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<Users> users = new ArrayList<>();
}
