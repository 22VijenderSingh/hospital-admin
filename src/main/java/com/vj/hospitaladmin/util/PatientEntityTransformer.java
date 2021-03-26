package com.vj.hospitaladmin.util;

import com.vj.hospitaladmin.entity.PatientEntity;
import com.vj.hospitaladmin.model.Patient;

public class PatientEntityTransformer {

  public static PatientEntity toEntity(Patient patient) {
    PatientEntity entity = new PatientEntity();
    entity.setName(patient.getName());
    entity.setAddress(patient.getAddress());
    entity.setEmailId(patient.getEmailId());
    entity.setPhoneNumber(patient.getPhoneNumber());
    entity.setPassword(patient.getPassword());
    return entity;
  }

  public static Patient toModel(PatientEntity entity) {
    Patient patient = new Patient();
    patient.setId(entity.getId());
    patient.setName(entity.getName());
    patient.setAddress(entity.getAddress());
    patient.setEmailId(entity.getEmailId());
    patient.setPhoneNumber(entity.getPhoneNumber());
    return patient;
  }
}
