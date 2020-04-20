package hospital.masterdata.service;
import hospital.masterdata.entity.DoctorAdvice;
import java.util.List;
public interface DoctorAdviceService {
    List<DoctorAdvice> findAll();
    List<DoctorAdvice> findAllBy(String adviceInfo);
}