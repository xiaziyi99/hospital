package hospital.masterdata.controller;
import com.github.pagehelper.PageHelper;
import hospital.common.response.Response;
import hospital.common.response.ResponseEnum;
import hospital.masterdata.service.RelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Api
@RestController
@RequestMapping("/api/doctorAdvice")
public class RelationController {
    @Autowired
    private RelationService relationService;
    //处方医嘱保存
    @RequestMapping(value = "/findBy",method = {RequestMethod.GET,RequestMethod.POST})
    public Response addPrescriptionDoctorAdvice(Integer pageNum, Integer pageSize, Integer prescriptionId, Integer[] adviceId) {
        PageHelper.startPage(pageNum,pageSize);
        int count = relationService.addPrescriptionDoctorAdvice(prescriptionId,adviceId);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(count);
    }
}