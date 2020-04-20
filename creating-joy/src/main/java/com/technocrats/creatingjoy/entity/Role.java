package com.technocrats.creatingjoy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="role")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="role_name")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String roleName;




}
