package com.technocrats.creatingjoy.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.technocrats.creatingjoy.dao.UserRepository;
import com.technocrats.creatingjoy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testSaveUser(){
        User user = getUser1();
        User savedInDb = entityManager.persist(user);
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
        user.setWebsite("wwww.ajaygithub.github.io");
        user.setPhoneNo("9948750016");
        user.setRating(2);

        return user;
    }

    @Test
    public void testRemoveUser(){
        User user = getUser1();
        User savedInDb = entityManager.persist(user);
        entityManager.remove(user);
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

        entityManager.persist(user1);
        entityManager.persist(user2);

        List<User> actualUsers = userRepository.findAll();

        assertThat(actualUsers).isEqualTo(expectedUsersList);
    }

    @Test
    public void testFindById() {
        User expectedUser=getUser1();
        entityManager.persist(expectedUser);
        Optional<User> actualUser=userRepository.findById(expectedUser.getId());
        assertThat(actualUser.get()).isEqualTo(expectedUser);
    }



}

