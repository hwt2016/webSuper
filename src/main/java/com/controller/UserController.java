package com.controller;

import com.convert.DateConvert;
import com.em.CompanyEnum;
import com.em.GradeEnum;
import com.em.StatusEnum;
import com.entity.*;
import com.service.*;
import com.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by sa on 2017-05-26.
 * 与User相关的操作
 * 新增、更新、删除、查询
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AscriptionService ascriptionService;

    //***********************  add  *********************************************
    //管理员添加A级用户
    @RequestMapping(value ="/addOfAdmin",method = RequestMethod.GET)
    public String  userAddOfAdmin(ModelMap modelMap){
        //获取地区列表
        List<AreaDO> areaDOList= areaService.selectAll();
        //注入地区列表信息
        modelMap.addAttribute("areas",areaDOList);
        return "user/addOfAdmin";
    }


    //管理员添加A级用户(尚未校验用户是否已存在）
    @RequestMapping(value = "/addOfAdmin",method = RequestMethod.POST)
    @ResponseBody
    public String userAddOfAdmin(UserDO userDO,int area_id){
        if(userService.IfExists(userDO)){
            return "添加失败";
        }
        //根据id选取省市区
        AreaDO areaDO=areaService.selectById(area_id);
        //设置等级
        userDO.setGrade(GradeEnum.A.code());
        //设置创建时间
        userDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        userDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //设置省份
        userDO.setProvince(areaDO.getProvince());
        //设置城市
        userDO.setCity(areaDO.getCity());
        //设置区域
        userDO.setDistrict(areaDO.getDistrict());
        //设置状态
        userDO.setStatus(StatusEnum.NORMAL.code());
        userDO.setPassword(MD5Util.GetMD5Code(userDO.getPassword()));
        userService.insert(userDO);
        return "添加成功";
    }

    //后台专线人员添加新用户
    @RequestMapping(value = "/addOfService")
    public  String  userAddOfService(){
        return "user/addOfService";
    }

    //后台专线人员添加新用户操作
    @RequestMapping(value = "/addOfService",method = RequestMethod.POST)
    @ResponseBody
    public String  userAddOfService(UserDO userDO, UserInfoDO userInfoDO,String date_birthday,String date_hiredate,String date_startofwork, HouseDO houseDO, VehicleDO vehicleDO){
        //判断用户是否已经存在
        if(userService.IfExists(userDO))
            return "false";
        //将时间字符串转换成日期类型
        Date birthday = DateConvert.strToDateLong(date_birthday);
        //将时间字符串转换成日期类型
        Date hiredate = DateConvert.strToDateLong(date_hiredate);
        //将时间字符串转换成日期类型
        Date startofwork = DateConvert.strToDateLong(date_startofwork);
        //用户表信息补全
        //设置用户生日
        userDO.setBirthday(birthday);
        //设置等级
        userDO.setGrade(GradeEnum.C.code());
        //设置状态为跟进
        userDO.setStatus(StatusEnum.FOLLOWING.code());
        //设置创建时间
        userDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        userDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //新增用户
        if(!userService.insert(userDO))
            return "新增用户信息有误";
        //根据手机号码查询用户id
        int userId = userService.selectUserByPhone(userDO).getId();
        //设置用户信息表的userId
        userInfoDO.setUserid(userId);
        //设置用户入职时间
        userInfoDO.setHiredate(hiredate);
        //设置开始工作时间
        userInfoDO.setStartofwork(startofwork);
        //设置状态为正常
        userInfoDO.setStatus(StatusEnum.NORMAL.code());
        //设置创建时间
        userInfoDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        userInfoDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //新增该用户信息
        if(!userInfoService.insert(userInfoDO))
            return "新增用户详细信息有误";
        //设置用户房屋信息表
        houseDO.setUserid(userId);
        //设置状态为正常
        houseDO.setStatus(StatusEnum.NORMAL.code());
        //设置创建时间
        houseDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        houseDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //新增用户房产信息
        if(!houseService.insert(houseDO))
            return "新增用户房产信息有误";
        //设置用户userid
        vehicleDO.setUserid(userId);
        //设置状态为正常
        vehicleDO.setStatus(StatusEnum.NORMAL.code());
        //设置创建时间
        vehicleDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        vehicleDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //新增用户车辆信息
        if(!vehicleService.insert(vehicleDO))
            return "新增车辆信息有误";
        //声明归属对象
        AscriptionDO ascriptionDO = new AscriptionDO();
        //设置上级userid
        ascriptionDO.setUpuserid(CompanyEnum.id.code());
        //设置上级等级
        ascriptionDO.setUpgrade(GradeEnum.A.code());
        //设置下级userid
        ascriptionDO.setDownuserid(userId);
        //设置下级等级
        ascriptionDO.setDowngrade(GradeEnum.C.code());
        //设置状态为正常
        ascriptionDO.setStatus(StatusEnum.NORMAL.code());
        //设置创建时间
        ascriptionDO.setCreatetime(new Date(System.currentTimeMillis()));
        //设置更新时间
        ascriptionDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //新增归属关系
        if(!ascriptionService.insert(ascriptionDO))
            return "新增归属关系有误";

        return "注册成功";
    }

    //***********************  list  *********************************************
    //A等级用户列表
    @RequestMapping(value = "/listOfA")
    public String userListOfA(ModelMap modelMap){
        //获取A等级用户列表
        List<UserDO> userDOList = userService.selectPositonOfWhich(GradeEnum.A.code());
        //注入用户信息列表
        modelMap.addAttribute("users",userDOList);
        return "user/listOfA";
    }

    //展示用户正在跟进的列表信息
    @RequestMapping(value = "/listOfUsrInfo")
    public String listOfUsrInfo(ModelMap modelMap){
        //获取正在跟进的用户列表
        List<UserDO> userDOS = userService.selectUsersByState(StatusEnum.FOLLOWING.code());
        //注入正在跟进的用户列表
        modelMap.addAttribute("users",userDOS);
        return "user/listOfUsrInfo";
    }

    //用户个人所有信息
    //userid 表示用户表的id
    @RequestMapping(value = "/userInfoDetail")
    public String userInfoDetail(ModelMap modelMap,int userid){
        //根据用户userid提取用户
        UserDO userDO = userService.selectUserById(userid);
        //根据用户userid提取用户信息
        UserInfoDO userInfoDO = userInfoService.selectUserInfoByUserId(userid);
        //根据用户userid提取用户房屋信息列表
        List<HouseDO> houseDOS = houseService.selectHousesByUserid(userid);
        //根据用户userid提取用户车辆信息列表
        List<VehicleDO> vehicleDOS = vehicleService.selectVehiclesByUserid(userid);
        //注入信息
        modelMap.addAttribute("user",userDO);
        modelMap.addAttribute("userInfo",userInfoDO);
        modelMap.addAttribute("houses",houseDOS);
        modelMap.addAttribute("vehicles",vehicleDOS);

        return "user/perInfo/userInfoDetail";
    }
    //***********************  用户基本信息 *********************************************
    //展示用户基本信息
    //userid 表示用户表的id
    @RequestMapping(value = "/userBaseShow")
    public String userBaseShow(ModelMap modelMap,int userid){
        //根据用户id获取用户
        UserDO userDO = userService.selectUserById(userid);
        //注入用户信息
        modelMap.addAttribute("user",userDO);
        return "user/perInfo/userBaseShow";
    }

    //更新用户基本信息
    //userid 表示用户表的id
    @RequestMapping(value = "/userBaseModify")
    public String userBaseModify(ModelMap modelMap,int userid){
        //根据userid提取用户基本信息
        UserDO userDO = userService.selectUserById(userid);
        //定义一个date_birthday字符串，为了方便在页面上显示的格式为YYYY/MM/DD，进行转换一下
        String date_birthday=null;
        //将日期转换成字符串（格式为YYYY/MM/DD)
        if(userDO.getBirthday()!=null)
            date_birthday= DateConvert.dateToStr(userDO.getBirthday());
        //注入信息
        modelMap.addAttribute("user",userDO);
        modelMap.addAttribute("date_birthday",date_birthday);
        return "user/perInfo/userBaseModify";
    }

    //更新用户基本信息
    //参数说明：userDO 用户基本信息对象，oldphone旧手机号，date_birthday生日
    @RequestMapping(value = "/userBaseModify",method = RequestMethod.POST)
    @ResponseBody
    public String userBaseModify(UserDO userDO,String oldphone,String date_birthday){
        //将时间字符串转换成日期类型
        Date birthday = DateConvert.strToDate(date_birthday);
        //设置生日日期
        userDO.setBirthday(birthday);
        //设置更新时间
        userDO.setUpdatetime(new Date(System.currentTimeMillis()));
        //如果原手机号与待更新手机号不同，则判断待更新手机号是否已注册
        if(!oldphone.equals(userDO.getPhone())){
            //判断带更新手机号是否已经注册
            if(userService.IfExists(userDO))
                return "false";
        }
        //更新该用户信息
        if(userService.update(userDO))
            return "录入成功";
        else
            return "录入失败";
    }
//    //***********************  用户详细信息 *********************************************
//
//    //更新用户详细信息
//    @RequestMapping(value = "/userInfoModify")
//    public String userInfoModify(ModelMap modelMap,int userInfoId){
//        UserInfoDO userInfoDO = userInfoService.selectUserInfoById(userInfoId);//根据userInfoId提取用户详细信息
//        String date_startofwork=null,date_hiredate=null;
//        if(userInfoDO.getStartofwork()!=null)
//            date_startofwork= DateConvert.dateToStr(userInfoDO.getStartofwork());//将日期转换成字符串
//        if(userInfoDO.getHiredate()!=null)
//            date_hiredate= DateConvert.dateToStr(userInfoDO.getHiredate());//将日期转换成字符串
//        modelMap.addAttribute("userinfo",userInfoDO);
//        modelMap.addAttribute("date_startofwork",date_startofwork);
//        modelMap.addAttribute("date_hiredate",date_hiredate);
//        return "user/perInfo/userInfoModify";
//    }
//
//    //更新用户详细信息
//    @RequestMapping(value = "/userInfoModify",method =RequestMethod.POST)
//    @ResponseBody
//    public String userInfoModify(UserInfoDO userInfoDO,String date_startofwork,String date_hiredate){
//        Date startofwork = DateConvert.strToDate(date_startofwork);//将时间字符串转换成日期类型
//        Date hiredate = DateConvert.strToDate(date_hiredate);//将时间字符串转换成日期类型
//        userInfoDO.setStartofwork(startofwork);//设置开始工作时间
//        userInfoDO.setHiredate(hiredate);//设置入职时间
//        userInfoDO.setUpdatetime(new Date(System.currentTimeMillis()));//设置更新时间
//        if(userInfoService.update(userInfoDO))
//            return "true";
//        else
//            return "录入失败";
//    }
//
//
//    //***********************  用户房屋信息 *********************************************
//
//    //更新房屋信息
//    @RequestMapping(value = "/userHouseModify")
//    public String userHouseModify(ModelMap modelMap,int houseid){
//        HouseDO houseDO = houseService.selectHouseById(houseid);//根据houseid提取房屋信息
//        modelMap.addAttribute("house",houseDO);
//        return "user/perInfo/userHouseModify";
//    }
//
//    //更新房屋信息
//    @RequestMapping(value = "/userHouseModify",method = RequestMethod.POST)
//    @ResponseBody
//    public String userHouseModify(HouseDO houseDO){
//        houseDO.setUpdatetime(new Date(System.currentTimeMillis()));//设置更新时间
//        if(houseService.update(houseDO))
//            return "true";
//        else
//            return "录入失败";
//    }
//
//    //根据用户id新增房产信息
//    @RequestMapping(value = "/userHouseAdd")
//    public String userHouseAdd(ModelMap modelMap,int userid){
//        modelMap.addAttribute("userid",userid);
//        return "user/perInfo/userHouseAdd";
//    }
//
//    //根据用户id新增房产信息
//    @RequestMapping(value = "/userHouseAdd",method = RequestMethod.POST)
//    @ResponseBody
//    public String userHouseAdd(HouseDO houseDO){
//        houseDO.setCreatetime(new Date(System.currentTimeMillis()));//设置创建时间
//        houseDO.setUpdatetime(new Date(System.currentTimeMillis()));//设置更新时间
//        houseDO.setStatus(StatusEnum.NORMAL.code());//设置状态为正常
//        if(houseService.insert(houseDO))
//            return "true";
//        else
//            return "新增房产失败";
//    }
//    //***********************  用户车辆信息 *********************************************
//
//    //更新车辆信息
//    @RequestMapping(value = "/userVehicleModify")
//    public String userVehicleModify(ModelMap modelMap,int vehicleid){
//        VehicleDO vehicleDO = vehicleService.selectVehicleById(vehicleid);//根据车辆id提取车辆信息
//        modelMap.addAttribute("vehicle",vehicleDO);
//        return "user/perInfo/userVehicleModify";
//    }
//
//    //更新车辆信息
//    @RequestMapping(value = "/userVehicleModify",method = RequestMethod.POST)
//    @ResponseBody
//    public String userVehicleModify(VehicleDO vehicleDO){
//        vehicleDO.setUpdatetime(new Date(System.currentTimeMillis()));
//        if(vehicleService.update(vehicleDO))
//            return "true";
//        else
//            return "录入失败";
//    }
//
//    //根据用户id新增车辆
//    @RequestMapping(value = "/userVehicleAdd")
//    public String userVehicleAdd(ModelMap modelMap,int userid){
//        modelMap.addAttribute("userid",userid);
//        return "user/perInfo/userVehicleAdd";
//
//    }
//    //根据用户id新增车辆
//    @RequestMapping(value = "/userVehicleAdd",method = RequestMethod.POST)
//    @ResponseBody
//    public String userVehicleAdd(VehicleDO vehicleDO){
//        vehicleDO.setCreatetime(new Date(System.currentTimeMillis()));//设置创建时间
//        vehicleDO.setUpdatetime(new Date(System.currentTimeMillis()));//设置更新时间
//        vehicleDO.setStatus(StatusEnum.NORMAL.code());//设置状态为正常
//        if(vehicleService.insert(vehicleDO))
//            return "true";
//        else
//            return "新增车辆失败";
//    }

    //***********************  delete  *********************************************
    //根据用户ID删除该用户信息
    //参数说明：userDO（id)
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String userDelete(UserDO userDO){
        //TODO 后期需要考虑如何删除用户 牵连的表太多
        if(userService.delete(userDO))
            return "删除成功";
        else
            return "删除失败";

    }

}
