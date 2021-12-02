package casestudy.services.Impl;

import casestudy.models.Employee;
import casestudy.models.Person;
import casestudy.services.Service;

import java.util.Scanner;

public class PersonServiceImpl implements Service {
    private Scanner scanner = new Scanner(System.in);
    public static Person[] personList = new Person[100];
    static {
        personList[0]=new Employee(1,"chanh1",23,"nam","1234567889","chanh1@gmail.com","giaovien","DN",15);
        personList[0]=new Employee(2,"chanh2",25,"nam","1234567888","chanh2@gmail.com","giaovien","DN",25);
        personList[0]=new Employee(3,"chanh3",23,"nam","1234567899","chanh3@gmail.com","giaovien","DN",35);
    }

    @Override
    public void display() {
            System.out.println("hiên thi ra danh sách");
            for (Person person: personList) {
                if (person !=null){
                    if (person instanceof Employee){
                        System.out.println(person.toString());
//                    ((Student)person).study();
//                    }else if (person instanceof Teacher){
//                    System.out.println(person.toString());
//                        ((Teacher)person).teach();
                    }

                }else {
                    break;
                }
            }

    }

    @Override
    public void addNew() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
    public static void main(String[] args) {
        PersonServiceImpl personServiceImpl = new PersonServiceImpl();
        personServiceImpl.display();
    }
}
