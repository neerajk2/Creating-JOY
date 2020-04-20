package com.technocrats.creatingjoy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;

@Entity
@Table(name="query")
@Getter
@Setter
@NoArgsConstructor
public class Query {


    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="query_text")
    @Size(min=1,message="is required")
    @NotNull(message="is required")
    private String queryText;


    @Lob
    @Column(name="query_image")
    @NotNull(message = "is required")
    private byte[] queryImage;

    @Column(name="timestamp")
    @NotNull(message="is required")
    private Time timestamp;


    @Column(name="likes")
    private int likes;

    @Column(name="dislikes")
    private int dislikes;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="requestor_id")
    private User requestor;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="acceptor_id")
    private User acceptor;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="address_id")
    private Address address;






}
