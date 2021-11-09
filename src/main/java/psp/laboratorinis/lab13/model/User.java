package psp.laboratorinis.lab13.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {

    @Id
    private UUID id;
    private String name;
    private String surname;
    private String eMail;
    private String phone;
    private String address;
    private String password;

    public User(String name, String surname, String eMail, String address, String password, String phone) {
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.address = address;
        this.password = password;
        this.phone = phone;
    }

    public User() {
    }

    public void setId(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Vartotojas { ");
        if(this.id != null) sb.append("Id : " + this.id + " , ");
        sb.append("Vardas : " + this.name + " , ");
        sb.append("Pavarde : " + this.surname + " , ");
        sb.append("Tel. Nr : " + this.phone + " , ");
        sb.append("Email : " + this.eMail + " , ");
        sb.append("Address : " + this.address + " , ");
        sb.append("Password : " + this.password + " }");
        return sb.toString();
    }
}
