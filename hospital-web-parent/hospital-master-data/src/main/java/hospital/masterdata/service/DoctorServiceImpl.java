package hospital.masterdata.service;
import hospital.common.entity.Doctor;
import hospital.masterdata.mapper.DoctorMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorMapper doctorMapper;
    @Override
    public List<Doctor> findAll() {
        return doctorMapper.findAll();
    }
    @Override
    public List<Doctor> findAllBy(String departmentName, String doctorName) {
        return doctorMapper.findAllBy(departmentName, doctorName);
    }
}
