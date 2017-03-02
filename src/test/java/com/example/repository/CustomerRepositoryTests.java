package com.example.repository;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import groovy.util.logging.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Axe on 31.01.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository repository;

    @Test
    public void providesFindOneWithOptional() {
        Customer carter = repository.save(new Customer("Carter", "Jimmy"));

        assertThat(repository.findOne(carter.id).isPresent(), is(true));
        assertThat(repository.findOne(carter.id + 1), is(Optional.<Customer> empty()));
        assertThat(((Collection<?>)repository.findAll()).size(), is(1));
    }

    @Test
    public void findAll() {
        repository.save(new Customer("C1", "c1"));
        repository.save(new Customer("C2", "c2"));
        repository.save(new Customer("C3", "c3"));

        assertThat(((Collection<?>)repository.findAll()).size(), is(3));
    }

}
