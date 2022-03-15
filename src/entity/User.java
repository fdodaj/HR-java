package entity;

import java.util.Date;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Date birthday;
    private String address;
    private String gender;
    private Date hireDate;
    private Integer paidTimeOff;
    private Boolean deleted;
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", hireDate=" + hireDate +
                ", paidTimeOff=" + paidTimeOff +
                ", deleted=" + deleted +
                ", role='" + role + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String email, String password, String phoneNumber, Date birthday, String address, String gender, Date hireDate, Integer paidTimeOff, Boolean deleted, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.hireDate = hireDate;
        this.paidTimeOff = paidTimeOff;
        this.deleted = deleted;
        this.role = role;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getPaidTimeOff() {
        return paidTimeOff;
    }

    public void setPaidTimeOff(Integer paidTimeOff) {
        this.paidTimeOff = paidTimeOff;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
