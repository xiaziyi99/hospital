package hospital.masterdata.service;
import hospital.masterdata.entity.Patient;
import hospital.masterdata.mapper.PatientMapper;
import javax.annotation.Resource;
import java.util.List;
public class PatientServiceImpl implements PatientService {
    @Resource
    private PatientMapper patientMapper;
    @Override
    public List<Patient> findAll() {
        return patientMapper.findAll();
    }
    @Override
    public List<Patient> findAllBy(String membershipLevel, String createDate, String patientName, String phoneNumber) {
        return patientMapper.findAllBy(membershipLevel,createDate,patientName,phoneNumber);
    }
}
