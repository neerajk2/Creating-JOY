package com.technocrats.creatingjoy.repository;

/*import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.technocrats.creatingjoy.entity.Address;
import com.technocrats.creatingjoy.entity.User;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;



    @Test
    public void testSaveUser(){
        User user = getUser1();
        User savedInDb = userRepository.save(user);
        Optional<User> getFromDb = userRepository.findById(savedInDb.getId());
        assertThat(getFromDb.get()).isEqualTo(savedInDb);
    }
    private User getUser1() {
        User user = new User();
        user.setFirstName("shravan");
        user.setLastName("vemula");
        user.setPassword("123456");
        user.setUserName("shravan172");
        user.setWebsite("wwww.shravanvemula.github.io");
        user.setPhoneNo("9908338102");
        user.setRating(2);

        return user;
    }

    private User getUser2() {
        User user = new User();
        user.setFirstName("ajay");
        user.setLastName("lala");
        user.setPassword("123456");
        user.setUserName("ajay172");
        user.setWebsite("wwww.ajaylala.github.io");
        user.setPhoneNo("9948750016");
        user.setRating(2);



        return user;
    }

    private Address getAddress(){
        Address address=new Address();

        address.setCity("Hyderabad");
        address.setHouseNo("1-5/2/A");
        address.setState("Telangana");
        address.setStreet("Durshed");
        address.setZIP("505001");
        address.setCountry("India");

        return address;

    }

    @Test
    public void testRemoveUser(){
        User user = getUser1();
        User savedInDb = userRepository.save(user);
        userRepository.delete(user);
        boolean result=userRepository.existsById(savedInDb.getId());

        assertThat(result).isEqualTo(false);
    }


    @Test
    public void testFindAll() {

        User user1=getUser1();
        User user2=getUser2();

        List<User> expectedUsersList = new ArrayList<>();
        expectedUsersList.add(user1);
        expectedUsersList.add(user2);

        userRepository.save(user1);
        userRepository.save(user2);




        List<User> actualUsers = userRepository.findAll();

        assertThat(actualUsers).isEqualTo(expectedUsersList);
    }

    @Test
    public void testFindById() {
        User expectedUser=getUser1();
        userRepository.save(expectedUser);
        Optional<User> actualUser=userRepository.findById(expectedUser.getId());
        assertThat(actualUser.get()).isEqualTo(expectedUser);
    }


    @Test
    public void testUserAndAddress(){
        User user = getUser1();
        Address address=getAddress();
        user.setAddress(address);

        User savedUserInDb = userRepository.save(user);

        Address addressFromDB=savedUserInDb.getAddress();
        log.info("User details : {} ",savedUserInDb);
        log.info("Address details:{}",addressFromDB);

        assertThat(addressFromDB).isEqualTo(address);


    }

}

 */







