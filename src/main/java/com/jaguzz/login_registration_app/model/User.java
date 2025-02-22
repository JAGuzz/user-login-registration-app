package com.jaguzz.login_registration_app.model;

import java.util.Collection;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // FetchType eager for every time a user is called it will be retrived also with all his roles
    // CascadeType.ALL to apply any kind of operation on a parent class/object to his childs
    @JoinTable(
         name = "users_roles",
         joinColumns =  @JoinColumn(
            name = "user_id", referencedColumnName = "id"
        ),
         inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "id"
         )
    )
    private Collection<Role> roles;

    public User(String firstname, String lastname, String email, String password, Collection<Role> roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    

}
