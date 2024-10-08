package com.backendtravelbox.user.domain.model.aggregates;

import com.backendtravelbox.user.domain.model.commands.CreateUserCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@Table(name = "User")
public class User extends AbstractAggregateRoot<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String email;

    @Getter
    private String userName;

    @Getter
    private String password;

    @Getter
    private String phoneNumber;

    public User() {
        this.firstName = Strings.EMPTY;
        this.lastName = Strings.EMPTY;
        this.email = Strings.EMPTY;
        this.userName = Strings.EMPTY;
        this.password = Strings.EMPTY;
        this.phoneNumber = Strings.EMPTY;
    }

    public User(String firstName, String lastName, String email, String userName, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User (CreateUserCommand command){
        this();
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.email = command.email();
        this.userName = command.userName();
        this.password = command.password();
        this.phoneNumber = command.phoneNumber();
    }

    public User updateUser(String firstName, String lastName, String email, String userName, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        return this;
    }
}