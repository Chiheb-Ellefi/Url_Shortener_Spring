package com.example.Url_Shortener.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String email;
    private String password;
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = false,fetch = FetchType.LAZY)
    private List<Url> urls = new ArrayList<>();



}
