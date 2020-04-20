package hospital.prescription.controller;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.common.http.HttpClientHelper;
import hospital.common.response.Response;
/**
 * api调用demo
 * @author Administrator
 *
 */
@Api
@RestController
public class DemoController {
	@Value("${server.medicine.url}")
	private String serverMedicineUrl;
	@Value("${server.masterdata.url}")
	private String serverMasterdataUrl;

	@Autowired private HttpClientHelper httpClientHelper;

	@GetMapping("api/masterdata/users")
	public Response getMasterdataUsers() {
		return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/masterdata/users");
	}

	@GetMapping("api/medicine/users")
	public Response getUsers() {
		return httpClientHelper.getForResponse(serverMedicineUrl + "/api/medicine/users");
	}
}
