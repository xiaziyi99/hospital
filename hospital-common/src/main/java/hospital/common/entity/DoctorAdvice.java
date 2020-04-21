package hospital.common.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

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