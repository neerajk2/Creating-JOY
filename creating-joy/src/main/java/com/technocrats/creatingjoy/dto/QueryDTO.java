package com.technocrats.creatingjoy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryDTO {

    private int id;

    private String queryText;

    private String queryImage;

    private String timestamp;

    private int likes;

    private int dislikes;

    private CategoryDTO categoryDTO;

    private UserDTO requestor;

    private int acceptorId;

    private AddressDTO addressDTO;

}