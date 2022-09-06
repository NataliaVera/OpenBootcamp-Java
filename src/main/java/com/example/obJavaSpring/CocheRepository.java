package com.example.obJavaSpring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Almacenar en DB, Lo que se necesite hacer en la DB
@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {

}
