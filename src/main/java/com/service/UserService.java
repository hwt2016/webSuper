package com.service;

import com.em.GradeEnum;
import com.em.StatusEnum;
import com.entity.AscriptionDO;
import com.entity.UserDO;
import com.entity.UserDOExample;
import com.entity.UserIncomeDO;
import com.mapper.UserDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by hwt on 2017/5/25.
 * 与User相关的操作
 */
@Service
public class UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private AscriptionService ascriptionService;

    @Autowired
    private UserIncomeService userIncomeService;
    //======     insert  插入操作=================================================================================================
    //插入一个用户
    public boolean insert(UserDO userDO){
        userDO.setCreatetime(new Date(System.currentTimeMillis()));
        userDO.setUpdatetime(new Date(System.currentTimeMillis()));
        userDOMapper.insert(userDO);
        return true;
    }


    //======     select  提取操作=================================================================================================

    //根据用户状态生成用户列表
    public List<UserDO> selectUsersByState(String state){
        UserDOExample userDOExample = new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andStatusEqualTo(state);
        List<UserDO> userDOList = userDOMapper.selectByExample(userDOExample);

        return userDOList;

    }

    //选取某个等级的所有用户
    public List<UserDO> selectPositonOfWhich(String grade){
        UserDOExample userDOExample= new UserDOExample();
        userDOExample.setOrderByClause("id ASC");
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        criteria.andGradeEqualTo(grade);
        List<UserDO> userDOList=userDOMapper.selectByExample(userDOExample);

        return userDOList;
    }

    //根据手机号判断用户是否存在
    public boolean IfExists(UserDO userDO){
        UserDOExample userDOExample= new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andPhoneEqualTo(userDO.getPhone());
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        if(userDOS.size()!=0)
            return true;
        else
            return false;
    }

    //根据手机号判断用户是否存在
    public boolean IfExistsByPhone(String phone){
        UserDOExample userDOExample= new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        if(userDOS.size()!=0)
            return true;
        else
            return false;
    }

    //根据userid判断用户是否存在
    public boolean IfExistsByUserId(int userid){
        UserDOExample userDOExample= new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andIdEqualTo(userid);
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        if(userDOS.size()!=0)
            return true;
        else
            return false;
    }


    //根据手机号提取用户信息
    public UserDO selectUserByPhone(UserDO userDO){
        UserDOExample userDOExample= new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andPhoneEqualTo(userDO.getPhone());
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        if(userDOS.size()!=0)
            return userDOS.get(0);
        else
            return null;
    }

    //根据手机号提取用户信息
    public UserDO selectUserByPhoneNum(String phone){
        UserDOExample userDOExample= new UserDOExample();
        UserDOExample.Criteria criteria = userDOExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        criteria.andStatusNotEqualTo(StatusEnum.DELETED.code());
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        if(userDOS.size()!=0)
            return userDOS.get(0);
        else
            return null;
    }

    //根据id选取用户
    public UserDO selectUserById(int userid){
        UserDO userDO = userDOMapper.selectByPrimaryKey(userid);
        return  userDO;
    }


    //======     delete  删除操作=================================================================================================
    public boolean delete(UserDO userDO){
        if(this.IfExistsByUserId(userDO.getId()))
            userDOMapper.deleteByPrimaryKey(userDO.getId());
        else
            return false;
        return true;
    }
    //======     update  更新操作=================================================================================================

    //根据主键更新用户基本信息
    public boolean update(UserDO userDO){
        try {
            userDO.setUpdatetime(new Date(System.currentTimeMillis()));
            userDOMapper.updateByPrimaryKeySelective(userDO);//更新userDO中属性不为null的字段
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //根据主键更新用户基本信息
    public boolean updateByPhone(UserDO userDO){
        try {
            userDO.setUpdatetime(new Date(System.currentTimeMillis()));
            UserDOExample userDOExample = new UserDOExample();
            UserDOExample.Criteria criteria = userDOExample.createCriteria();
            criteria.andPhoneEqualTo(userDO.getPhone());
            userDOMapper.updateByExampleSelective(userDO,userDOExample);//更新userDO中属性不为null的字段
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @param phone
     * @param password
     * @param recommendPhone
     * @return  1:注册成功  0：注册异常（可能是推荐人手机号被篡改） 4：数据库异常  2：用户已注册
     */
    @Transactional
    public String userInitByInvite(String phone,String password,String recommendPhone){
        try{
            UserDO userRecommend =new UserDO();
            userRecommend.setPhone(recommendPhone);
            if(this.IfExists(userRecommend)){
                UserDO userDO=new UserDO();
                userDO.setPhone(phone);
                userDO.setPassword(password);
                userDO.setStatus("正常");
                userDO.setGrade(GradeEnum.C.code());
                if(this.IfExists(userDO))
                    return "2";//新用户已注册
//                //生成二维码，并上传到阿里OSS上
//                try {
//                    //上传到OSS地址
//                    String key="user/"+userDO.getPhone()+"/qrcode.png";
//                    //生成二维码本地路径
//                    String qrcodePath= Constant.USER_LOCAL_DIR+userDO.getPhone()+".png";
//                    //生成二维码
//                    ZxingUtil.createQRCode(Constant.INVITE+userDO.getPhone(), new File(qrcodePath));
//                    //上传到OSS
//                    PostObject ossPostObject = new PostObject();
//                    ossPostObject.post(key,qrcodePath);
//                    //更新新用户的邀请链接
//                    userDO.setInvitelink(Constant.HOST_USER+userDO.getPhone()+"/qrcode.png");
//                } catch (WriterException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                if(this.insert(userDO)){

                    userDO=this.selectUserByPhoneNum(userDO.getPhone());
                    userRecommend=this.selectUserByPhone(userRecommend);

                    System.out.println("新用户id="+userDO.getId()+"推荐人id:"+userRecommend.getId());
                    //初始化该用户的收入表
                    UserIncomeDO userIncomeDO = new UserIncomeDO();
                    userIncomeDO.setUserid(userDO.getId());
                    userIncomeDO.setStatus("正常");
                    userIncomeDO.setIncome(0.0);
                    userIncomeDO.setUpincome(0.0);
                    userIncomeService.insert(userIncomeDO);
                    //如果推荐人的等级为C
                    if(userRecommend.getGrade().equals(GradeEnum.C.code())){
                        //提取推荐人（M)归属关系信息
                        AscriptionDO ascriptionDO =ascriptionService.selectBydownGradeUserId(userRecommend.getId());
                        //定义一个上级变量
                        UserDO upGradeUser = new UserDO();
                        //若果有上级则提取用户（M)的上级用户信息（N)
                        if(ascriptionDO!=null){
                            upGradeUser = this.selectUserById(ascriptionDO.getUpuserid());
                            //设置归属关系
                            AscriptionDO ascriptionDONew=new AscriptionDO();
                            //设置新用户上级id
                            ascriptionDONew.setUpuserid(upGradeUser.getId());
                            //设置新用户id
                            ascriptionDONew.setDownuserid(userDO.getId());
                            //设置新用户上级等级
                            ascriptionDONew.setUpgrade(upGradeUser.getGrade());
                            //设置新用户等级
                            ascriptionDONew.setDowngrade(GradeEnum.C.code());
                            ascriptionDONew.setStatus("正常");
                            ascriptionService.insert(ascriptionDONew);
                        }
                    }
                    else {
                        AscriptionDO ascriptionDONew=new AscriptionDO();
                        ascriptionDONew.setUpuserid(userRecommend.getId());
                        ascriptionDONew.setDownuserid(userDO.getId());
                        ascriptionDONew.setUpgrade(userRecommend.getGrade());
                        ascriptionDONew.setDowngrade(GradeEnum.C.code());
                        ascriptionDONew.setStatus("正常");
                        ascriptionService.insert(ascriptionDONew);
                    }
                    return "1";//注册成功
                }

            }
            return "0";
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }


    }


    /**
     *
     * @param phone
     * @param password
     * @param recommendPhone
     * @return  1:注册成功  0：注册异常（可能是推荐人手机号被篡改） 4：数据库异常  2：用户已注册
     */
    @Transactional
    public String userInitBByInvite(String phone,String password,String recommendPhone){
        try{
            UserDO userRecommend =new UserDO();
            userRecommend.setPhone(recommendPhone);
            if(this.IfExists(userRecommend)){
                UserDO userDO=new UserDO();
                userDO.setPhone(phone);
                userDO.setPassword(password);
                userDO.setStatus("正常");
                userDO.setGrade(GradeEnum.B.code());
                if(this.IfExists(userDO))
                    return "2";//新用户已注册
//                //生成二维码，并上传到阿里OSS上
//                try {
//                    //上传到OSS地址
//                    String key="user/"+userDO.getPhone()+"/qrcode.png";
//                    //生成二维码本地路径
//                    String qrcodePath= Constant.USER_LOCAL_DIR+userDO.getPhone()+".png";
//                    //生成二维码
//                    ZxingUtil.createQRCode(Constant.INVITE+userDO.getPhone(), new File(qrcodePath));
//                    //上传到OSS
//                    PostObject ossPostObject = new PostObject();
//                    ossPostObject.post(key,qrcodePath);
//                    //更新新用户的邀请链接
//                    userDO.setInvitelink(Constant.HOST_USER+userDO.getPhone()+"/qrcode.png");
//                } catch (WriterException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                if(this.insert(userDO)){

                    userDO=this.selectUserByPhoneNum(userDO.getPhone());
                    userRecommend=this.selectUserByPhone(userRecommend);

                    System.out.println("新用户id="+userDO.getId()+"推荐人id:"+userRecommend.getId());
                    //初始化该用户的收入表
                    UserIncomeDO userIncomeDO = new UserIncomeDO();
                    userIncomeDO.setUserid(userDO.getId());
                    userIncomeDO.setStatus("正常");
                    userIncomeDO.setIncome(0.0);
                    userIncomeDO.setUpincome(0.0);
                    userIncomeService.insert(userIncomeDO);
                    //如果推荐人的等级为B
                    if(userRecommend.getGrade().equals(GradeEnum.B.code())){
                        //提取推荐人（M)归属关系信息
                        AscriptionDO ascriptionDO =ascriptionService.selectBydownGradeUserId(userRecommend.getId());
                        //定义一个上级变量
                        UserDO upGradeUser = new UserDO();
                        //若果有上级则提取用户（M)的上级用户信息（N)
                        if(ascriptionDO!=null){
                            upGradeUser = this.selectUserById(ascriptionDO.getUpuserid());
                            //设置归属关系
                            AscriptionDO ascriptionDONew=new AscriptionDO();
                            //设置新用户上级id
                            ascriptionDONew.setUpuserid(upGradeUser.getId());
                            //设置新用户id
                            ascriptionDONew.setDownuserid(userDO.getId());
                            //设置新用户上级等级
                            ascriptionDONew.setUpgrade(upGradeUser.getGrade());
                            //设置新用户等级
                            ascriptionDONew.setDowngrade(GradeEnum.B.code());
                            ascriptionDONew.setStatus("正常");
                            ascriptionService.insert(ascriptionDONew);
                        }
                    }
                    else {
                        AscriptionDO ascriptionDONew=new AscriptionDO();
                        ascriptionDONew.setUpuserid(userRecommend.getId());
                        ascriptionDONew.setDownuserid(userDO.getId());
                        ascriptionDONew.setUpgrade(userRecommend.getGrade());
                        ascriptionDONew.setDowngrade(GradeEnum.B.code());
                        ascriptionDONew.setStatus("正常");
                        ascriptionService.insert(ascriptionDONew);
                    }
                    return "1";//注册成功
                }

            }
            return "0";
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }


    }

    /**
     *
     * @param phone
     * @param password
     * @return 1:注册成功  0：注册异常（可能是推荐人手机号被篡改） 4：数据库异常  2：用户已注册
     */
    @Transactional
    public String userInsertByApp(String phone ,String password){
        try {
            UserDO userDO=new UserDO();
            userDO.setPhone(phone);
            userDO.setPassword(password);
            userDO.setStatus("正常");
            userDO.setGrade(GradeEnum.C.code());
            if(this.IfExists(userDO))
                return "2";//新用户已注册
//            //生成二维码，并上传到阿里OSS上
//            try {
//                //上传到OSS地址
//                String key="user/"+userDO.getPhone()+"/qrcode.png";
//                //生成二维码本地路径
//                String qrcodePath= Constant.USER_LOCAL_DIR+userDO.getPhone()+".png";
//                //生成二维码
//                ZxingUtil.createQRCode(Constant.INVITE+userDO.getPhone(), new File(qrcodePath));
//                //上传到OSS
//                PostObject ossPostObject = new PostObject();
//                ossPostObject.post(key,qrcodePath);
//                //更新新用户的邀请链接
//                userDO.setInvitelink(Constant.HOST_USER+userDO.getPhone()+"/qrcode.png");
//            } catch (WriterException e) {
//                e.printStackTrace();
//                return "0";
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "0";
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "0";
//            }
            if(this.insert(userDO)) {

                userDO = this.selectUserByPhoneNum(userDO.getPhone());
                //初始化该用户的收入表
                UserIncomeDO userIncomeDO = new UserIncomeDO();
                userIncomeDO.setUserid(userDO.getId());
                userIncomeDO.setStatus("正常");
                userIncomeDO.setIncome(0.0);
                userIncomeDO.setUpincome(0.0);
                userIncomeService.insert(userIncomeDO);

                AscriptionDO ascriptionDONew = new AscriptionDO();
                ascriptionDONew.setUpuserid(0);
                ascriptionDONew.setDownuserid(userDO.getId());
                ascriptionDONew.setUpgrade(GradeEnum.A.code());
                ascriptionDONew.setDowngrade(GradeEnum.C.code());
                ascriptionDONew.setStatus("正常");
                ascriptionService.insert(ascriptionDONew);
                return "1";//注册成功
            }
            else
                return "0";
        }catch (Exception e){
            e.printStackTrace();
            return "4";
        }

    }

}
