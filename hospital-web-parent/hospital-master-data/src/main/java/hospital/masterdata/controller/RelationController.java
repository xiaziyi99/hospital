package hospital.masterdata.controller;
import com.github.pagehelper.PageHelper;
import hospital.common.response.Response;
import hospital.common.response.ResponseEnum;
import hospital.masterdata.entity.Prescription;
import hospital.masterdata.entity.PrescriptionDrugs;
import hospital.masterdata.service.RelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Api
@RestController
@RequestMapping("/api/relation")
public class RelationController {
    @Autowired
    private RelationService relationService;
    //处方医嘱保存
    @RequestMapping(value = "/addDoctorAdvice",method = {RequestMethod.GET,RequestMethod.POST})
    public Response addPrescriptionDoctorAdvice(Integer prescriptionId, Integer[] adviceId) {
        int count = relationService.addPrescriptionDoctorAdvice(prescriptionId,adviceId);
        if (count>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(count);
        }
        return new Response(ResponseEnum.ERROR);
    }
    //处方疾病保存
    @RequestMapping(value = "/addSickness",method = {RequestMethod.GET,RequestMethod.POST})
    public Response addPrescriptionSickness(Integer prescriptionId, Integer[] sicknessId) {
        int count = relationService.addPrescriptionSickness(prescriptionId,sicknessId);
        if (count>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(count);
        }
        return new Response(ResponseEnum.ERROR);
    }

    //处方附加费用保存
    @RequestMapping(value = "/addSurcharge",method = {RequestMethod.GET,RequestMethod.POST})
    public Response addPrescriptionSurcharge(Integer prescriptionId, Integer[] surchargeId) {
        int count = relationService.addPrescriptionSurcharge(prescriptionId,surchargeId);
        if (count>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(count);
        }
        return new Response(ResponseEnum.ERROR);
    }

    //处方检查项目保存
    @RequestMapping(value = "/addItem",method = {RequestMethod.GET,RequestMethod.POST})
    public Response addPrescriptionItem(Integer prescriptionId, Integer[] itemId) {
        int count = relationService.addPrescriptionItem(prescriptionId,itemId);
        if (count>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(count);
        }
        return new Response(ResponseEnum.ERROR);
    }

    //处方药品保存
    @RequestMapping(value = "/addDrugs",method = {RequestMethod.GET,RequestMethod.POST})
    public Response addPrescriptionDrugs(PrescriptionDrugs prescriptionDrugs) {
        int count = relationService.addPrescriptionDrugs(prescriptionDrugs);
        if (count>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(count);
        }
        return new Response(ResponseEnum.ERROR);
    }

    //处方保存
    @RequestMapping(value = "/addPrescription",method = {RequestMethod.GET,RequestMethod.POST})
    public Response addPrescription( Prescription prescription) {
        int count = relationService.addPrescription(prescription);
        if (count>0){
            return new Response(ResponseEnum.SUCCESS).setResponseBody(count);
        }
        return new Response(ResponseEnum.ERROR);
    }
}