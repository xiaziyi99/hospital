package hospital.masterdata.service;
import hospital.masterdata.entity.Surcharge;
import hospital.masterdata.mapper.SurchargeMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class SurchargeServiceImpl implements SurchargeService {
    @Resource
    private SurchargeMapper surchargeMapper;
    @Override
    public List<Surcharge> findAll() {
        return surchargeMapper.findAll();
    }
    @Override
    public List<Surcharge> findAllBy(String surchargeName, String surchargeType) {
        return surchargeMapper.findAllBy(surchargeName,surchargeType);
    }
}