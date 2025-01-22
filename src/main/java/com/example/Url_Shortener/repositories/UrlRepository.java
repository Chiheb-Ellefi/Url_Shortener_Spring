package com.example.Url_Shortener.repositories;


import com.example.Url_Shortener.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {
    @Query(value = "SELECT * FROM urls WHERE hash = ?1 LIMIT 1", nativeQuery = true)
   public Url findByHash(String hash);
}
