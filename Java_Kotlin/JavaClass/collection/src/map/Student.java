package map;

public class Student {
    String name;
    int age;
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            Student s = (Student)obj;
            return this.name.equals(s.name) && this.age==s.age;
        } else{
            return false;
        }
    }
}
