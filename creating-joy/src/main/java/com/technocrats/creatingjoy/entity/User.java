package com.technocrats.creatingjoy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="user_firstname")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String firstName;

    @Column(name="user_lastname")
    @Size(min=1,message="is required")
    @NotNull(message = "is required")
    private String lastName;


    @Column(unique=true,name="username")
    @Size(min=1,message="is required")
    @NotNull(message = "is required")
    private String userName;


    @Column(name="password")
    @Size(min=1,message="is required")
    @NotNull(message="is required")
    private String password;


    @Column(name="user_website")
    private String website;



    @Column(name="user_rating")
    @NotNull(message="is required")
    private int rating;



    @Column(name="user_phoneno")
    @Size(min=1,message="is required")
    @NotNull(message="is required")
    private String phoneNumber;

   /*
    @ToString.Exclude
    @OneToMany(mappedBy = "user",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Query> queries;
    */

    @ToString.Exclude
    @OneToOne(mappedBy = "user",cascade={CascadeType.ALL})
    private Address address;


}