package com.technocrats.creatingjoy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryAddressDTO {

    private QueryDTO query;
    private AddressDTO address;
    private UserDTO acceptor;

}
