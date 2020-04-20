package com.technocrats.creatingjoy.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO {


    private int id;

    private String roleName;

    private List<UserDTO> users;

}
