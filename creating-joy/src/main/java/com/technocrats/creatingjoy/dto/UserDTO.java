package com.technocrats.creatingjoy.dto;


import com.technocrats.creatingjoy.entity.Query;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
        public int id;

        private String firstName;

        private String lastName;

        @NotNull(message = "User Name is required")
        private String userName;

        @NotNull(message = "Phone number is required")
        private String phoneNumber;

         @ToString.Exclude
         @NotNull(message = "Password is required")
        private String password;


        private String website;

        private int rating;


        @ToString.Exclude
        private AddressDTO addressDTO;




        @ToString.Exclude
        @ElementCollection(fetch = FetchType.LAZY)
        private List<Query> queries;




}
