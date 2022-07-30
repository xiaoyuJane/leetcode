package basic.classDemo;

import java.io.*;

/**
 * 利用序列化和反序列化进行对象的深拷贝
 */
public class DeepCloneTest{
    public static void main(String[] args) throws Exception {
        Person person = new Person(15, "sowhat", new Address("河北", "建华南大街"));
        Person clonePerson = (Person) person.deepClone();

        System.out.println(person); //basic.classDemo.Person@6477463f
        System.out.println(clonePerson); //basic.classDemo.Person@f2a0b8e

        System.out.println(person.display());
        //Person{age=15, name='sowhat', address=Street{province='河北', street='建华南大街'}}

        System.out.println(clonePerson.display());
        //Person{age=15, name='sowhat', address=Street{province='河北', street='建华南大街'}}

        clonePerson.setName("sowhat1412");
        clonePerson.setAge(20);
        Address address = clonePerson.getAddress();
        address.setStreet("中山路");
        System.out.println(clonePerson.display());
        //Person{age=20, name='sowhat1412', address=Street{province='河北', street='中山路'}}

        System.out.println(person.display());
        //Person{age=15, name='sowhat', address=Street{province='河北', street='建华南大街'}}

    }
}

class DeepClone implements Serializable {
    public Object deepClone() throws Exception
    {
        final long serialVersionUID = 1412L;
        //序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

}

class Person extends DeepClone{
    private static final long serialVersionUID = 1L;

    private int age;
    private String name;
    private Address address;

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age, String name, Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }


    public String display() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}


class Address  extends DeepClone{
    private static final long serialVersionUID = 1412L;
    private String province;
    private String street;

    public Address (String province, String street) {
        this.province = province;
        this.street = street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Street{" +
                "province='" + province + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
