package com.technocrats.creatingjoy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="query")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Query {


    @Id
    @Column(name="query_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="query_text")
    @Size(min=1,message="is required")
    @NotNull(message="is required")
    private String queryText;


    @ToString.Exclude
    @Column(name="query_image")
    @NotNull(message = "is required")
    private String queryImage;

    @Column(name="timestamp")
    @NotNull(message="is required")
    private String timestamp;


    @Column(name="acceptor_id")
    private int acceptorId;


    @Column(name="likes")
    private int likes;

    @Column(name="dislikes")
    private int dislikes;


    @ToString.Exclude
    //@ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.REFRESH})
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ToString.Exclude
    //@ManyToOne(cascade = {CascadeType.ALL})
    @ManyToOne
    @JoinColumn(name="requestor_id")
    private User requestor;



    @ToString.Exclude
    @OneToOne(mappedBy = "query",cascade={CascadeType.ALL})
    private Address address;


}