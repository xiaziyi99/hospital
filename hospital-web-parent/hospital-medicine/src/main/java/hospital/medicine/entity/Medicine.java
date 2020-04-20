package hospital.medicine.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
/**
 * 药品基本信息表
 */
@Data
@Builder
@ToString
public class Medicine {
    private Long id;
    private String typeId;
    private String code;
    private String barcode;
    private String name;
    private String spec;
    private Integer stock;
    private String otc;
    private Integer costPrice;
    private Integer salePrice;
    private String factory;
}