package hospital.prescription.dto;

import lombok.Data;
import lombok.ToString;

//患者
@Data
@ToString
public class Patient {
	private String patientName;
	private String cardNo;
}