package com.springexam.api.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Le pseudo est obligatoire")
    private String username;
    
    @Column(name = "password", length = 255, nullable = false)
    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;
    
    @Column(name = "email", length = 100, nullable = false, unique = true)
    @Email(message = "L'adresse email doit être valide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    
}
