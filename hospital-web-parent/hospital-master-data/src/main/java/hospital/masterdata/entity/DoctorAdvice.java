package hospital.masterdata.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
/**
 * 医嘱信息表
 */
@Data
@Builder
@ToString
public class DoctorAdvice {
    private Integer id;
    private String adviceInfo;
}