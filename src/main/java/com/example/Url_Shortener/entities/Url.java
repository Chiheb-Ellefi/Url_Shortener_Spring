package com.example.Url_Shortener.entities;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;


@Entity
@Table(name = "urls",indexes = @Index(columnList = "hash",unique = true,name = "hash_index"))
@Timestamp
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Url {
    @Id()
    private Long id;
    @Column(name = "url",nullable = false,unique = true)
    private String url;
    @Column(name = "hash", nullable = false,unique = true)
    private String hash;
    @Column(name = "clicks")
    private Long clicks ;
    @Column(name = "qr_code")
    private String qrCode;
    @Column(name = "status")
    private Boolean status ;
    @Column(name = "user_id", nullable = false)
    private Long userId;

}
