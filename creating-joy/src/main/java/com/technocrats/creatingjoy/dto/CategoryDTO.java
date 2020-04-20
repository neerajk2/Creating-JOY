package com.technocrats.creatingjoy.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private int id;

    private String categoryName;

    private List<UserDTO> users;

    private List<QueryDTO> queries;

}
