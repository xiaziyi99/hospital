package hospital.masterdata.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hospital.common.response.Response;
import hospital.common.response.ResponseEnum;
import hospital.masterdata.entity.PrescriptionModel;
import hospital.masterdata.service.PrescriptionModelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Api
@RestController
@RequestMapping("/api/prescriptionModel")
public class PrescriptionModelController {
    @Autowired
    private PrescriptionModelService prescriptionModelService;
    @GetMapping("")
    public Response findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<PrescriptionModel> list = prescriptionModelService.findAll();
        PageInfo<PrescriptionModel> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
    @RequestMapping(value = "/findBy",method = {RequestMethod.GET,RequestMethod.POST})
    public Response findBy(Integer pageNum, Integer pageSize,String modelName, String modelPower, String prescriptionType) {
        PageHelper.startPage(pageNum,pageSize);
        List<PrescriptionModel> list = prescriptionModelService.findAllBy(modelName, modelPower,prescriptionType);
        PageInfo<PrescriptionModel> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
}