package com.technocrats.creatingjoy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address {


    public Address(int id, String houseNo,String street, String city, String landmark,String ZIP,String state,String country, User user) {
        this.id = id;
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.landmark = landmark;
        this.ZIP = ZIP;
        this.state = state;
        this.country = country;
        this.user = user;
    }

    public Address(int id,String houseNo,String street,String city, String landmark,String ZIP,String state,String country, Query query) {
        this.id = id;
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.landmark = landmark;
        this.ZIP = ZIP;
        this.state = state;
        this.country = country;
        this.query = query;
    }

    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name="house_no")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String houseNo;

    @Column(name="street")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String street;


    @Column(name="city")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String city;


    @Column(name="landmark")
    private String landmark;


    @Column(name="ZIP")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String ZIP;


    @Column(name="state")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String state;


    @Column(name="country")
    @Size(min=1,message = "is required")
    @NotNull(message="is required")
    private String country;


    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="user_id")
    private User user;


    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="query_id")
    private Query query;






}
