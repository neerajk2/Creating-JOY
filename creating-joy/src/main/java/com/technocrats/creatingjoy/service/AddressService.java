package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dto.AddressDTO;

public interface AddressService {


    AddressDTO findById(int id);
    void deleteById(int id);

    AddressDTO findByQueryId(int id);
    void deleteByQueryId(int id);


}
