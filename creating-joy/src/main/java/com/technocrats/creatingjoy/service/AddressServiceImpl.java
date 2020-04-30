package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dao.AddressRepository;
import com.technocrats.creatingjoy.dto.AddressDTO;
import com.technocrats.creatingjoy.entity.Address;
import com.technocrats.creatingjoy.objectmapper.AddressMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {



    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }


    @Override
    @Transactional
    public AddressDTO findById(int id) {

        Optional<Address> result=addressRepository.findById(id);

        if(result.isPresent()){
            return addressMapper.convertToDto(result.get());
        }
        else{
            throw new RuntimeException("Did not found Address with id "+id);
        }
    }

    @Override
    @Transactional
    public AddressDTO findByQueryId(int id) {

        Address result=addressRepository.findByQueryId(id);
        if(result!=null){
            return addressMapper.convertToDto(result);
        }
        else{
            throw new RuntimeException("Did not found Query with id "+id);
        }

    }


    @Override
    @Transactional
    public void deleteById(int id) {

        if(id>0) {
            addressRepository.deleteById(id);
        }

    }

    @Override
    @Transactional
    public void deleteByQueryId(int id) {
        if(id>0) {

            addressRepository.deleteByQueryId(id);
        }

    }







}
