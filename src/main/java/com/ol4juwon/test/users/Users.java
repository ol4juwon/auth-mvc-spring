package com.ol4juwon.test.users;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.*;
import com.ol4juwon.test.entity.Role;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    private static final long serialVersionUID = 1L;
     @Id 
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
    )
    private List<Role> roles = new ArrayList<>();












    // public Users() {

    // }

    // public Users(@NotBlank String username,
    //         @NotBlank String password) {
    //     this.username = username;
    //     this.password = password;
    //     this.loggedIn = false;
    // }






    // public long getId() {
    //     return Id;
    // }

    // public void setId(long id) {
    //     Id = id;
    // }

    // public String getUsername() {
    //     return username;
    // }

    // public void setUsername(String username) {
    //     this.username = username;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public boolean isLoggedIn() {
    //     return loggedIn;
    // }

    // public void setLoggedIn(boolean loggedIn) {
    //     this.loggedIn = loggedIn;
    // }

    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + (int) (Id ^ (Id >>> 32));
    //     result = prime * result + ((username == null) ? 0 : username.hashCode());
    //     result = prime * result + ((password == null) ? 0 : password.hashCode());
    //     result = prime * result + (loggedIn ? 1231 : 1237);
    //     return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (!(obj instanceof Users))
    //         return false;

    //     Users other = (Users) obj;
    //     return Objects.equals(username, other.username) && Objects.equals(password, other.password);
    // }

    // @Override
    // public String toString() {
    //     return "Users [Id=" + Id + ", username=" + username + ", password=" + password + ", loggedIn=" + loggedIn + "]";
    // }

}
