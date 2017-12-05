package maxb.facedating.domain;


import javax.persistence.*;

/**
 * Created by MaxB on 27/11/2017.
 */
@Entity
@Table(name = "COMPARES")
public class CompareInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="USER_FACE_TOKEN")
    private String userFaceToken;

    @Column(name="FACESET_TOKEN")
    private String facesetToken;

    @Column(name="FACE_TOKEN")
    private String faceToken;

    @Column(name="VALUE")
    private double value;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserFaceToken() {
        return userFaceToken;
    }

    public void setUserFaceToken(String userFaceToken) {
        this.userFaceToken = userFaceToken;
    }

    public String getFacesetToken() {
        return facesetToken;
    }

    public void setFacesetToken(String facesetToken) {
        this.facesetToken = facesetToken;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
