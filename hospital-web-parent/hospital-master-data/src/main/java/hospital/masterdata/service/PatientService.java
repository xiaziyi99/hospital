package hospital.masterdata.service;
import hospital.masterdata.entity.Patient;
import java.util.List;
public interface PatientService {
    List<Patient> findAll();
    List<Patient> findAllBy(String membershipLevel,String createDate,String patientName,String phoneNumber);
}