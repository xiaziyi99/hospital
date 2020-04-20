package hospital.masterdata.service;
import hospital.masterdata.entity.Surcharge;
import java.util.List;
public interface SurchargeService {
    List<Surcharge> findAll();
    List<Surcharge> findAllBy(String surchargeName, String surchargeType);
}