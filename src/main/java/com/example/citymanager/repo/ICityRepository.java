package com.example.citymanager.repo;
import com.example.citymanager.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository  extends JpaRepository<City, Long> {
}