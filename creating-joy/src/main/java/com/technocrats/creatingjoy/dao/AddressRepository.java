package com.technocrats.creatingjoy.dao;

import com.technocrats.creatingjoy.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    Address findByQueryId(int id);
    void deleteByQueryId(int id);

}
