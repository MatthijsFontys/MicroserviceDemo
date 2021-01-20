package app.entities;
import javax.persistence.*;

@Entity
@Table(name = "user_data")
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String salt;
    @Column(name =  "pass_hash")
    private String passHash;
    private boolean isEmailVerified;

    public UserDto() {
    }

    public UserDto(String username, String email, String salt, String passHash, boolean isEmailVerified) {
        this.username = username;
        this.email = email;
        this.salt = salt;
        this.passHash = passHash;
        this.isEmailVerified = isEmailVerified;
    }

    // region getters and setters...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSalt() {
        return salt;
    }

    public String getPassHash() {
        return passHash;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }
    // endregion

}
