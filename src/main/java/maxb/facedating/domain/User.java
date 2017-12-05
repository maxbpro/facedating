package maxb.facedating.domain;

import maxb.facedating.domain.enums.Gender;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by MaxB on 07/11/2017.
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PHOTO_URL")
    private String photoUrl;

    @Column(name = "FACESET_TOKEN")
    private String facesetToken;

    @Column(name = "FACE_TOKEN")
    private String faceToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender;

    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(name = "COUNTRY_ID")
    private Long countryId;

    @Column(name = "REGION_ID")
    private Long regionId;

    @Column(name = "CITY_ID")
    private Long cityId;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ABOUT")
    private String about;

    @Column(name = "PROFESSION")
    private String profession;

    @Column(name = "JOB")
    private String job;


    @Transient
    private String confirmPassword;

    @Transient
    private MultipartFile inputFile;

    @ManyToMany(fetch = FetchType.EAGER)
    //@JoinTable(name = "USER_ROLE",
    //        joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
    //        inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID"))
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles;

    public User(){

    }

    public User(User user){
        this.id = user.id;
        this.email = user.email;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.username = user.username;
    }

    //Check if this is for New of Update
    public boolean isNew() {
        return (this.id == null);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MultipartFile getInputFile() {
        return inputFile;
    }

    public void setInputFile(MultipartFile inputFile) {
        this.inputFile = inputFile;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getFacesetToken() {
        return facesetToken;
    }

    public void setFacesetToken(String facesetToken) {
        this.facesetToken = facesetToken;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
