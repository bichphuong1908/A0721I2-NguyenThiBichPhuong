package casestudy.models;

public class Employee extends Person {
    private String level;
    private String position;
    private int salary;

    public Employee(int i, String s, int parseInt, String s1, String anInt, String s2){

    }

    public Employee(int id, String name, int age, String sex, String idCard, String email, String level, String position, int salary){
        super(id, name, age, sex, idCard, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String geLevel(){
        return level;
    }

    public String getPosition(){
        return position;
    }

    public String getSalary(){
        return level;
    }

    @Override
    public String toString() {
        return  "id=" + getId() + '\'' +
                ", name=" + getName() + '\'' +
                ", age=" + getAge() + '\'' +
                ", sex=" + getSex() + '\'' +
                ", idCard=" + getIdCard() + '\'' +
                ", email=" + getEmail() + '\'' +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary ;
    }

    @Override
    public void goToBy() {

    }
    public String getInfoToCSV(){
        return this.getId()+ ","+ this.getName()+ "," +this.getAge()+ ","+this.getSex()+ ","+this.getIdCard()+","+this.getEmail();
    }

}
