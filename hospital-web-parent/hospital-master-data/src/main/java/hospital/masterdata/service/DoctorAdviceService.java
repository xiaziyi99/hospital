package hospital.masterdata.service;
import hospital.common.entity.DoctorAdvice;
import java.util.List;
public interface DoctorAdviceService {
    List<DoctorAdvice> findAll();
    List<DoctorAdvice> findAllBy(String adviceInfo);
}