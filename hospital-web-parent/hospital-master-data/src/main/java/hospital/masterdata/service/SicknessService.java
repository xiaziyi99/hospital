package hospital.masterdata.service;
import hospital.masterdata.entity.Sickness;
import java.util.List;
public interface SicknessService {
    List<Sickness> findAll();
    List<Sickness> findAllBy(String sicknessName);
}