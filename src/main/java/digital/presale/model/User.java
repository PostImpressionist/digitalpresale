package digital.presale.model;

import java.util.Objects;

/**
 * created by E.K.
 * 2021 November 18
 **/

public class User extends AbstractNamedEntity {

    private String email;

    private String password;

    private String company;

    private String position;

    private Role role;

    public User() {

    }

    public User(Integer id, String name, String email, String password, String company, String position, Role role) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.company = company;
        this.position = position;
        this.role = role;
    }

    public User(User u) {
        this(u.id, u.name, u.email, u.password, u.company, u.position, u.role);
    }

    //  w/o Role
    public User(Integer id, String name, String email, String password, String company, String position) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.company = company;
        this.position = position;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(company, user.company) && Objects.equals(position, user.position) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, company, position, role);
    }
}
