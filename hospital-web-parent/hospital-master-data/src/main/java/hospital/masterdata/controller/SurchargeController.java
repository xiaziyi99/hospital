package hospital.masterdata.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hospital.common.response.Response;
import hospital.common.response.ResponseEnum;
import hospital.masterdata.entity.Surcharge;
import hospital.masterdata.service.SurchargeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Api
@RestController
@RequestMapping("/api/surcharge")
public class SurchargeController {
    @Autowired
    private SurchargeService surchargeService;
    @GetMapping("")
    public Response findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Surcharge> list = surchargeService.findAll();
        PageInfo<Surcharge> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
    @RequestMapping(value = "/findBy",method = {RequestMethod.GET,RequestMethod.POST})
    public Response findBy(Integer pageNum, Integer pageSize,String surchargeName, String surchargeType) {
        PageHelper.startPage(pageNum,pageSize);
        List<Surcharge> list = surchargeService.findAllBy(surchargeName,surchargeType);
        PageInfo<Surcharge> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getList().size());
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
//    @RequestMapping(value = "/add",method = {RequestMethod.GET,RequestMethod.POST})
//    public Response add(Integer pageNum, Integer pageSize,Surcharge surcharge) {
//        PageHelper.startPage(pageNum,pageSize);
//        int count = surchargeService.addSurcharge(surcharge);
//        return new Response(ResponseEnum.SUCCESS).setResponseBody(surcharge);
//    }
}