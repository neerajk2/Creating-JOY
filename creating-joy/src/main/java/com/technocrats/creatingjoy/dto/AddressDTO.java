package com.technocrats.creatingjoy.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {


    private int id;

    private String houseNo;

    private String street;

    private String city;

    private String landmark;

    private String ZIP;

    private String state;

    private String country;

    private UserDTO userDto;






}
