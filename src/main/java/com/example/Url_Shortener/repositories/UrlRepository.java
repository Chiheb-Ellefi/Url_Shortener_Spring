package com.example.Url_Shortener.repositories;


import com.example.Url_Shortener.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {
    @Query(value = "SELECT * FROM urls WHERE hash = ?1 LIMIT 1", nativeQuery = true)
    Url findByHash(String hash);
    @Modifying
    @Query(value = "UPDATE urls SET clicks=?2 WHERE hash = ?1 ", nativeQuery = true)
   void updateCountByHash(String hash,Long count);
}
