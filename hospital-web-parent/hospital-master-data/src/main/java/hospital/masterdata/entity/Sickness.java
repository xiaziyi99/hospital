package hospital.masterdata.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
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