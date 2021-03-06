package hospital.masterdata.service;
import hospital.common.entity.Doctor;
import java.util.List;
public interface DoctorService {
    List<Doctor> findAll();
    List<Doctor> findAllBy(String departmentName, String doctorName);
}