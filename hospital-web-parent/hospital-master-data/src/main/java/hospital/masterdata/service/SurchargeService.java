package hospital.masterdata.service;
import hospital.common.entity.Surcharge;
import java.util.List;
public interface SurchargeService {
    List<Surcharge> findAll();
    List<Surcharge> findAllBy(String surchargeName, String surchargeType);
}