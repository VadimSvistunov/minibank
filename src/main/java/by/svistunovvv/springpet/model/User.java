package by.svistunovvv.springpet.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    @NonNull
    private String email;
    private String age;
    private String password;
    private Float accountAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Account> accounts = new ArrayList<>();
}
