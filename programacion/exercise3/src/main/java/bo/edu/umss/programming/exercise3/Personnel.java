package bo.edu.umss.programming.exercise3;

import java.util.Date;

public class Personnel implements Comparable<Personnel> {

    private String id;
    private String fullName;
    private String nationalID;
    private Date birthDate;
    private Integer phone;
    private String address;
    private String position;
    private Date registrationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", nationalID='" + nationalID + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    @Override
    public int compareTo(Personnel o) {
        return getFullName().compareTo(o.getFullName());
    }
}
