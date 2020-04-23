package hospital.prescription.controller;
import hospital.common.entity.Prescription;
import hospital.common.entity.PrescriptionDrugs;
import hospital.common.http.HttpClientHelper;
import hospital.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "就诊保存模块")
@RestController
@Slf4j
@RequestMapping("/api/add")
public class PrescriptionAddController {
    @Value("${server.medicine.url}")
    private String serverMedicineUrl;
    @Value("${server.masterdata.url}")
    private String serverMasterdataUrl;
    @Resource
    private HttpClientHelper httpClientHelper;

    private static final String CURRENT_SERVER_URL = "http://localhost:9005";

    //处方医嘱保存接口
    @ApiOperation(value = "处方医嘱保存接口api,添加处方医嘱信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "医嘱ID",name = "adviceId[]", required = true)
    })
    @GetMapping(value = "relation/addDoctorAdvice")
    public Response addPrescriptionDoctorAdvice(Integer prescriptionId, Integer[] adviceId) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(adviceId!=null) {
            params.put("adviceId",adviceId);
        }
        log.debug("params:{}", params);
        return httpClientHelper.postForResponse(serverMasterdataUrl + "/api/relation/addDoctorAdvice",params,CURRENT_SERVER_URL);
    }

    //处方疾病保存接口
    @ApiOperation(value = "处方疾病保存接口api,添加处方疾病信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "疾病ID",name = "sicknessId[]", required = true)
    })
    @GetMapping(value = "relation/addSickness")
    public Response addPrescriptionDoctorSickness(Integer prescriptionId, Integer[] sicknessId) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(sicknessId!=null) {
            params.put("sicknessId",sicknessId);
        }
        log.debug("params:{}", params);
        return httpClientHelper.postForResponse(serverMasterdataUrl + "/api/relation/addSickness",params);
    }

    //处方附加费用保存接口
    @ApiOperation(value = "处方附加费用接口api,添加处方附加费用信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "附加费用ID",name = "surchargeId[]", required = true)
    })
    @GetMapping(value = "relation/addSurcharge")
    public Response addPrescriptionSurcharge(Integer prescriptionId, Integer[] surchargeId) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(surchargeId!=null) {
            params.put("surchargeId",surchargeId);
        }
        log.debug("params:{}", params);
        return httpClientHelper.postForResponse(serverMasterdataUrl + "/api/relation/addSurcharge",params);
    }

    //处方检查项目保存接口
    @ApiOperation(value = "处方检查项目保存接口api,添加处方检查项目信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "检查项目ID",name = "itemId[]", required = true)
    })
    @GetMapping(value = "relation/addItem")
    public Response addPrescriptionItem(Integer prescriptionId, Integer[] itemId) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(itemId!=null) {
            params.put("itemId",itemId);
        }
        log.debug("params:{}", params);
        return httpClientHelper.postForResponse(serverMasterdataUrl + "/api/relation/addItem",params);
    }

    //处方药品保存接口
    @ApiOperation(value = "处方药品保存接口api,添加处方药品信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "药品ID",name = "drugsId", required = true),
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "单次用量",name = "singleDose", required = true),
            @ApiImplicitParam(value = "用法",name = "usage", required = true),
            @ApiImplicitParam(value = "频度",name = "frequency", required = true),
            @ApiImplicitParam(value = "天数",name = "days", required = true),
            @ApiImplicitParam(value = "单价",name = "price", required = true),
            @ApiImplicitParam(value = "总量",name = "total", required = true)
    })
    @GetMapping(value = "relation/addDrugs")
    public Response addPrescriptionDrugs(PrescriptionDrugs prescriptionDrugs) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionDrugs.getDrugsId()!=null) {
            params.put("drugsId",prescriptionDrugs.getDrugsId());
        }
        if(prescriptionDrugs.getPrescriptionId()!=null) {
            params.put("prescriptionId",prescriptionDrugs.getPrescriptionId());
        }
        if(prescriptionDrugs.getSingleDose()!=null) {
            params.put("singleDose",prescriptionDrugs.getSingleDose());
        }
        if(prescriptionDrugs.getUsage()!=null) {
            params.put("usage",prescriptionDrugs.getUsage());
        }
        if(prescriptionDrugs.getFrequency()!=null) {
            params.put("frequency",prescriptionDrugs.getFrequency());
        }
        if(prescriptionDrugs.getDays()!=null) {
            params.put("days",prescriptionDrugs.getDays());
        }
        if(prescriptionDrugs.getPrice()!=null) {
            params.put("price",prescriptionDrugs.getPrice());
        }
        if(prescriptionDrugs.getTotal()!=null) {
            params.put("total",prescriptionDrugs.getTotal());
        }
        log.debug("params:{}", params);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addDrugs"+ params);
    }
    //处方保存接口
    @ApiOperation(value = "处方疾病保存接口api,添加处方信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "医生id",name = "doctorId", required = true),
            @ApiImplicitParam(value = "患者id",name = "patientId", required = true),
            @ApiImplicitParam(value = "疾病id",name = "sicknessId", required = true),
            @ApiImplicitParam(value = "接诊类型,1初诊,2复诊",name = "receptionType", required = true),
            @ApiImplicitParam(value = "创建时间",name = "createDate", required = true)
    })
    @GetMapping(value = "relation/addPrescription")
    public Response addPrescription(Prescription prescription) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescription.getDoctorId()!=null) {
            params.put("doctorId",prescription.getDoctorId());
        }
        if(prescription.getPatientId()!=null) {
            params.put("patientId",prescription.getPatientId());
        }
        if(prescription.getSicknessId()!=null) {
            params.put("sicknessId",prescription.getSicknessId());
        }
        if(prescription.getReceptionType()!=null) {
            params.put("receptionType",prescription.getReceptionType());
        }
        if(prescription.getCreateDate()!=null) {
            params.put("createDate",prescription.getCreateDate());
        }
        log.debug("params:{}", params);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addPrescription"+ params);
    }
}
