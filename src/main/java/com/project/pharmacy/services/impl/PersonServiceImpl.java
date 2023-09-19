package com.project.pharmacy.services.impl;

import com.project.pharmacy.dtos.PersonDto;
import com.project.pharmacy.models.Login;
import com.project.pharmacy.models.Person;
import com.project.pharmacy.repositories.LoginRepository;
import com.project.pharmacy.repositories.PersonRepository;
import com.project.pharmacy.services.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createUser(PersonDto personDto) {
        Person person = new Person();
        Login login = new Login();
        BeanUtils.copyProperties(personDto, person);
        BeanUtils.copyProperties(personDto, login);
        person.setDateRegister(LocalDateTime.now());
        Login log = loginRepository.save(login);
        person.setLogin(log);
        return personRepository.save(person);
    }

    @Override
    public List<PersonDto> listAll() {
        return null;
    }


}
