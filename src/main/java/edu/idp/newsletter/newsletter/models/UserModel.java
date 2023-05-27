package edu.idp.newsletter.newsletter.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
@Entity
@Table(name = "USER_TB")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer ra;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;


    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
