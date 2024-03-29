package controller;

import model.Person;
import repository.PersonRepository;

import java.util.List;

public class PersonController {

    private PersonRepository personRepository;

    public PersonController() {

        personRepository=new PersonRepository();
    }

    public void insert(Person person){

        personRepository.insert(person);

    }

    public void delete(String name){
        personRepository.delete(name);
    }

    public void updateRole(String name, String role){
        personRepository.updateRole(name,role);
    }

    public void  updateNewRole(String old_role, String role){
        personRepository.updateNewRole(old_role, role);
    }

    public void updateAddress(String name, String address){
        personRepository.updateAddress(name,address);
    }

    public void updatePassword(String email, String password){
        personRepository.updatePassword(email,password);
    }

    public void display(){
        for(Person person: personRepository.allPersons()){
            System.out.println(person.toString());
        }
    }

    public Person personEmail( String email){
        for(Person person: personRepository.allPersons()){
            if(person.getEmail().equals(email)){
                return person;
            }
        }

        return new Person(-1,"","","","","");
    }

    public Person personName( String name){
        for(Person person: personRepository.allPersons()){
            if(person.getEmail().equals(name)){
                return person;
            }
        }

        return new Person(-1,"","","","","");
    }

    public List<Person> allPersons(){
        return personRepository.allPersons();

    }
}
