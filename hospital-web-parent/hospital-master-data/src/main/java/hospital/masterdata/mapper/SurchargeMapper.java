package hospital.masterdata.mapper;
import hospital.masterdata.entity.Surcharge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface SurchargeMapper {
    List<Surcharge> findAll();
    List<Surcharge> findAllBy(@Param("surchargeName") String surchargeName, @Param("surchargeType") String surchargeType);
}