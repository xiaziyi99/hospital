package hospital.prescription.dto;

import lombok.Data;
import lombok.ToString;

//处方药品
@Data@ToString
public class Medicine {
	private String medicineId;
	private String medicinePrice;
	private String usage;
}