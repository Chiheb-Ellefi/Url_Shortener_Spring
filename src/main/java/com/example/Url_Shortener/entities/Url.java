package com.example.Url_Shortener.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name = "urls")
@Timestamp
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Url {
    @Id()
    private Long id;
    @Column(name = "url",nullable = false)
    private String url;
    @Column(name = "hash", nullable = false)
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
