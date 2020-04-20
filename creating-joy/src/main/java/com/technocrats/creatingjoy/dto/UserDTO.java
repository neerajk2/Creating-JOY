package com.technocrats.creatingjoy.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {


        private int id;

        private String firstName;

        private String lastName;

        private String userName;

        private String password;

        private String website;

        private int rating;

        private String phoneNo;

        private List<RoleDTO> roles;

        private List<CategoryDTO> categories;

        private List<QueryDTO>queries;

        private List<AddressDTO> addresses;




}
