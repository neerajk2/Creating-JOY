package com.technocrats.creatingjoy.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
        public int id;

        private String firstName;

        private String lastName;

        /*@NotNull(message = "User Name is required")
        @Size(min=4,max=20,message="Length - at least 4 and at most 20")
        @Pattern(regexp="^[a-zA-Z]+[a-zA-Z\\d]*([#_]?[a-zA-Z0-9]+)*$",message="Invalid user name")*/
        private String userName;

        /*@NotNull(message = "Phone number is required")
        @Size(min=8,max=14)
       // @Pattern(regexp = "^(\\+)?[0-9]+$",message = "Invalid phone number")*/
        private String phoneNumber;

        /* @ToString.Exclude
         @NotNull(message = "Password is required")
         @Size(min=8,max=16,message = "Length - at least 8 and at most 16")
         //@Pattern(regexp="^[\\w]+[@#$%^&*\\w]*$",message="Invalid Password")*/
        private String password;


        private String website;

        private int rating;


        @ToString.Exclude
        private AddressDTO addressDTO;


        /*

        @ToString.Exclude
        @ElementCollection(fetch = FetchType.LAZY)
        private List<Query> queries;
*/



}
