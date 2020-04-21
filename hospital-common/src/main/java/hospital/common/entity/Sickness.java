package hospital.common.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 疾病名称表
 */
@Data
@Builder
@ToString
public class Sickness {
    private Integer id;
    private String sicknessName;
}