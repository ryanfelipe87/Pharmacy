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
import java.util.stream.Collectors;

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
        List<Person> person = personRepository.findAll();
        return person.stream()
                .map(this :: convertToDTO)
                .collect(Collectors.toList());
    }

    public PersonDto findId(Long id){
        Person person = personRepository.findById(id).orElse(null);
        if(person != null){
            return convertToDTO(person);
        }
        return null;
    }


    private PersonDto convertToDTO(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setName(person.getName());
        personDto.setCpf(person.getCpf());
        personDto.setGender(person.getGender());
        personDto.setCellPhone(person.getCellPhone());
        personDto.setDepartment(person.getDepartment());
        personDto.setWage(person.getWage());
        personDto.setOffice(person.getOffice());
        personDto.setCertification(person.getCertification());
        return personDto;
    }

}
