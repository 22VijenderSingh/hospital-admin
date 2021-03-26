package com.vj.hospitaladmin.service;

import com.vj.hospitaladmin.entity.PatientEntity;
import com.vj.hospitaladmin.model.Patient;
import com.vj.hospitaladmin.repository.PatientRepository;
import com.vj.hospitaladmin.util.PatientEntityTransformer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientManagementService {

  private PatientRepository repository;

  private Logger logger = LoggerFactory.getLogger(PatientManagementService.class);

  @Autowired
  public PatientManagementService(PatientRepository repository) {
    this.repository = repository;
  }

  public Patient addPatient(Patient patient) {
    PatientEntity entity = PatientEntityTransformer.toEntity(patient);
    PatientEntity savedEntity = repository.save(entity);
    return PatientEntityTransformer.toModel(savedEntity);
  }

  public Patient update(Patient patient) throws Exception {
    Optional<PatientEntity> entityOptional = repository.findById(patient.getId());
    if (!entityOptional.isPresent()) {
      logger.error("Patient not found for id - {}", patient.getId());
      throw new EntityNotFoundException("Patient not found for id - " + patient.getId());
    }
    PatientEntity entity = entityOptional.get();
    if (Objects.nonNull(patient.getName())) {
      entity.setName(patient.getName());
    }
    if (Objects.nonNull(patient.getAddress())) {
      entity.setAddress(patient.getAddress());
    }
    if (Objects.nonNull(patient.getEmailId())) {
      entity.setEmailId(patient.getEmailId());
    }
    if (Objects.nonNull(patient.getPhoneNumber())) {
      entity.setPhoneNumber(patient.getPhoneNumber());
    }
    if (Objects.nonNull(patient.getPassword())) {
      entity.setPassword(patient.getPassword());
    }
    PatientEntity savedEntity = repository.save(entity);
    return PatientEntityTransformer.toModel(savedEntity);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  public List<Patient> fetchAll() {
    List<PatientEntity> entities = repository.findAllByOrderByUpdatedAtDesc();
    List<Patient> patientList = new ArrayList<>();
    for (PatientEntity entity : entities) {
      patientList.add(PatientEntityTransformer.toModel(entity));
    }
    return patientList;
  }
}
