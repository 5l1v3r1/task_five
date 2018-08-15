package com.fuwei.controller;


import com.fuwei.api.ChackSMS;
import com.fuwei.api.QIniuUpload;
import com.fuwei.api.SendMail;
import com.fuwei.des.CharacterUtils;
import com.fuwei.des.DesUtil;
import com.fuwei.pojo.Student;
import com.fuwei.pojo.User;
import com.fuwei.service.StudentService;
import com.fuwei.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    //加密和解密的参数和编码设置



    private static final Charset CHARSET = Charset.forName("gb2312");

    /**
     * 主页
     * @return
     */
    @RequestMapping("/")
    public String logins() {
        return "redirect:/index";
    }

    @RequestMapping(value="/index",method= RequestMethod.GET)
    public ModelAndView listCategory(){

        ModelAndView mav = new ModelAndView();
        //List<Student> cs= studentService.list();
        List<Student> cs1= studentService.list1();
        int count= studentService.count(1);
        int count2= studentService.count(2);
        // 放入转发参数
        mav.addObject("cs", cs1);
        mav.addObject("cs1", count);
        mav.addObject("cs2", count2);
        // 放入jsp路径

        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        System.out.println("--------------+++++++++--------------");
        return "/login";
    }


   // @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @RequestMapping(value = "/u/Login", method = RequestMethod.POST)
    //@ResponseBody
    public String Login(HttpServletRequest request, HttpServletResponse response, @Param("name") String name, @Param("pwd") String pwd, User user, String Pwd1, String salt, Model model) throws Exception {
        System.out.println("----------------------------");

        //ModelAndView mav = new ModelAndView();
        User loginResult = userService.login(name);
        System.out.println(name);
        try {
            //解密
            Pwd1 = DesUtil.decrypt(loginResult.getDespwd(), CHARSET, loginResult.getSalt());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (loginResult != null && Pwd1.equals(pwd) && loginResult.getName().equals(name)) {
            //保存到cookies
            Cookie cookie=new Cookie("pwd", URLEncoder.encode(Pwd1, "UTF-8"));
            Cookie cookie1=new Cookie("name",URLEncoder.encode(name, "UTF-8"));
            //对cookies进行设置
            cookie.setMaxAge(60);
            cookie1.setMaxAge(60);
            cookie.setPath("/");
            cookie1.setPath("/");
            //添加到请求
            response.addCookie(cookie);
            response.addCookie(cookie1);
            //mav.addObject("welcome", "学员:    "+name+"     欢迎来到修真院学习☺");
            //mav.setViewName("redirect:/index");
            //return mav;//一个登陆成功的页面 "redirect:/login";
            return "redirect:/index";
        } else {
            //mav.addObject("error", "用户名或者密码不正确☹");
            //mav.setViewName("/login");
            //return mav;
            return "/login";
        }
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/register";
    }

    /*@Path("/register")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})*/
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    //ModelAndView可以换成String 但是没有传值功能
    @ResponseBody
    public ModelAndView Register(@Param("name") String name, @Param("pwd") String pwd, @Param("userIphone") String userIphone,@Param("code") String code,@Param("email") String email,@Param("code_email") String code_email,User user, Model model,HttpServletRequest httpServletRequest) throws Exception {
        String Name= URLDecoder.decode(name,"utf-8");
        User loginResult = userService.login(Name);
        System.out.println(this.getClass().getName()+"   =======================");
        if (!name.equals("") && !pwd.equals("")) {


                    if (loginResult != null && loginResult.getName().equals(Name)) {
                        ModelAndView mav = new ModelAndView();
                        mav.addObject("exist", "此用户已存在☹");
                        mav.setViewName("/register");
                        return mav;
                    } else {
                        //获取session里面verify的值
                        HttpSession session=httpServletRequest.getSession();
                        String verifying= (String) session.getAttribute("verify");
                        String salt_phone= (String) session.getAttribute("salt_phone");
                        String emailcodeing= (String) session.getAttribute("emailcodeing");
                        String salt_email= (String) session.getAttribute("salt_email");

                        System.out.println(verifying+"++++++++++");
                        //验证码解密
                        String phonecode= DesUtil.decrypt(verifying, CHARSET, salt_phone);
                        String emailcode= DesUtil.decrypt(emailcodeing, CHARSET, salt_email);
                        System.out.println("----------------------------" + salt_phone);

                        if (phonecode.equals(code)&&emailcode.equals(code_email)) {

                            String salt = CharacterUtils.getRandomString2(8);//随机数

                            ModelAndView mav = new ModelAndView();
                            //加密
                            System.out.println(pwd);
                            String Pwd = DesUtil.encrypt(pwd, CHARSET, salt);
                            String phone = DesUtil.encrypt(userIphone, CHARSET, salt);
                            String phone_code = DesUtil.encrypt(phonecode, CHARSET, salt);
                            String email_num = DesUtil.encrypt(email, CHARSET, salt);
                            String email_code = DesUtil.encrypt(code_email, CHARSET, salt);
                            System.out.println(Pwd);
                            user.setName(Name);
                            user.setPwd(pwd);
                            user.setSalt(salt);
                            user.setDespwd(Pwd);
                            user.setPhone(phone);
                            user.setPhone_code(phone_code);
                            user.setEmail(email_num);
                            user.setEmail_code(email_code);
                            userService.register(user);
                            mav.addObject("error", "注册成功");
                            mav.setViewName("/login");
                            return mav;
                        }else{
                            ModelAndView mav = new ModelAndView();
                            mav.addObject("exist", "验证码错误☹");
                            mav.setViewName("/register");
                            return mav;
                        }
                    }
                }else{
                ModelAndView mav = new ModelAndView();
                mav.addObject("exist", "请填写用户名&&密码☹");
                mav.setViewName("/register");
                return mav;
                }

        }
    /**
     * 验证手机号码，11位数字，1开通，第二位数必须是3456789这些数字之一 *
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
             Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
           // Pattern regex = Pattern.compile("^1[345789]\\d{9}$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;

        }
        return flag;
    }

        //获取短信验证码
    @RequestMapping(value = "/send",method=RequestMethod.POST)
    @ResponseBody
    public Boolean send(String phone,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws Exception{
        System.out.println(phone);
        String salt_phone = CharacterUtils.getRandomString2(8);//随机数
        if(!"".equals(phone)&&phone.length()==11&&checkMobileNumber(phone)){
            String verify="";
            int verify1= (int) (Math.random()*9000+1000);
            verify= String.format("%s%s", verify, verify1);
            System.out.println(verify);
           boolean flag= ChackSMS.good(phone,verify); //返回给注册页面的flag
            //验证码加密
            String verifying = DesUtil.encrypt(verify, CHARSET, salt_phone);
           HttpSession session=httpServletRequest.getSession();//将verify添加到session里面
            session.setAttribute("verify",verifying);
            session.setAttribute("salt_phone",salt_phone);
            System.out.println("good");
            return flag; //return 返回的是一个jsp页面
        }else{
            System.out.println("bad");
            return false;
        }

    }
    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */

    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
     //email测试
    /*@RequestMapping(value = "/email", method = RequestMethod.GET)
    public String email() {
        return "/email";
    }*/

    //获取email验证码
    @RequestMapping(value = "/email",method=RequestMethod.POST)
    @ResponseBody
    public Boolean email(String email,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws Exception{
        System.out.println(email);
        String salt_email = CharacterUtils.getRandomString2(8);//随机数

        if(!"".equals(email)&&checkEmail(email)){
            String emailcode="";
            int emailcode1= (int) (Math.random()*9000+1000);
            emailcode= String.format("%s%s", emailcode, emailcode1);
            System.out.println(emailcode);
            boolean flag= false; //返回给注册页面的flag
            try {
                flag = SendMail.send_template(email,emailcode);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            //emailcode加密
            String emailcodeing = DesUtil.encrypt(emailcode, CHARSET, salt_email);
            HttpSession session=httpServletRequest.getSession();//将verify添加到session里面
            session.setAttribute("emailcodeing",emailcodeing);
            session.setAttribute("salt_email",salt_email);
            System.out.println("good");
            return flag; //return 返回的是一个jsp页面
        }else{
            System.out.println("bad");
            return false;
        }

    }
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "/upload";
    }

    //判断上传问文件类型
    private boolean checkSuffix(String imgPath) {
        Boolean flag =false;
        //图片格式
        String[] FILETYPES = new String[]{
                ".jpg", ".bmp", ".jpeg", ".png", ".gif",
                ".JPG", ".BMP", ".JPEG", ".PNG", ".GIF"
        };
        if(!StringUtils.isBlank(imgPath)){
            for (int i = 0; i < FILETYPES.length; i++) {
                String fileType = FILETYPES[i];
                if (imgPath.endsWith(fileType)) {
                    flag = true;
                    break;
                }
            }
        }

        return flag;
    }
    //文件上传
    @RequestMapping(value = "/upload",method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView upload(HttpServletRequest request, MultipartFile  file)throws Exception {
        if (checkSuffix(file.getOriginalFilename())) {
            QIniuUpload qIniuUpload = new QIniuUpload();
            String head = qIniuUpload.uploadImg2QiNiu(file);
            System.out.println(head);
            User user = new User(head, 45);
            userService.upload(user);
            System.out.println("gooood");
            ModelAndView mav = new ModelAndView();
            mav.addObject("upload", head+"");
            mav.setViewName("/upload");
            return mav;
        }else{
            System.out.println("baaaad");ModelAndView mav = new ModelAndView();
            mav.addObject("upload1", "图片有误!!!");
            mav.setViewName("/upload");
            return mav;
        }
    }
}
