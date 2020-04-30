package com.technocrats.creatingjoy.dto;


import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDTO {

    @ToString.Exclude
    private int id;

    private String categoryName;

    private List<QueryDTO> queries;

}