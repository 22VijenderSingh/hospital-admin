package com.vj.hospitaladmin.repository;

import com.vj.hospitaladmin.entity.PatientEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

  List<PatientEntity> findAllByOrderByUpdatedAtDesc();
}
