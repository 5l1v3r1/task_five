package com.fuwei.controller;


import com.fuwei.api.ChackSMS;
import com.fuwei.des.CharacterUtils;
import com.fuwei.des.DesUtil;
import com.fuwei.pojo.User;
import com.fuwei.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;


// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    //加密和解密的参数和编码设置


    private static final Charset CHARSET = Charset.forName("gb2312");

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        System.out.println("--------------+++++++++--------------");
        return "/login";
    }


   // @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @RequestMapping(value = "/u/Login", method = RequestMethod.POST)
    public ModelAndView Login(HttpServletRequest request, HttpServletResponse response, @Param("name") String name, @Param("pwd") String pwd, User user, String Pwd1, String salt, Model model) throws Exception {
        System.out.println("----------------------------");

        ModelAndView mav = new ModelAndView();
        User loginResult = userService.login(name);
        System.out.println(name);
        try {
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
            mav.addObject("welcome", "学员:    "+name+"     欢迎来到修真院学习☺");
            mav.setViewName("/index");
            return mav;//一个登陆成功的页面 "redirect:/login";
        } else {
            mav.addObject("error", "用户名或者密码不正确☹");
            mav.setViewName("/login");
            return mav;
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
    public ModelAndView Register(@Param("name") String name, @Param("pwd") String pwd, User user, Model model) throws Exception {
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
                        String salt = CharacterUtils.getRandomString2(8);//随机数
                        System.out.println("----------------------------" + salt);
                        ModelAndView mav = new ModelAndView();
                        //加密
                        System.out.println(pwd);
                        String Pwd = DesUtil.encrypt(pwd, CHARSET, salt);
                        System.out.println(Pwd);
                        user.setName(Name);
                        user.setPwd(pwd);
                        user.setSalt(salt);
                        user.setDespwd(Pwd);
                        userService.register(user);
                        mav.addObject("error", "注册成功");
                        mav.setViewName("/login");
                        return mav;
                    }
                }else{
                ModelAndView mav = new ModelAndView();
                mav.addObject("exist", "请填写用户名&&密码☹");
                mav.setViewName("/register");
                return mav;
                }

        }

    @RequestMapping(value = "/send",method=RequestMethod.POST)
    public String send(@Param("phone") String phone,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws Exception{
        System.out.println(phone);
        if(!"".equals(phone)&&phone.length()==11){
            int verify= (int) (Math.random()*9000+1000);
            System.out.println(verify);
            ChackSMS.good(phone,verify);


          /*  HttpSession session=httpServletRequest.getSession();
            session.setAttribute("verify",verify);*/
            System.out.println("good");
            return "success2222"; //return 返回的是一个jsp页面
        }else{
            System.out.println("bad");
            return "error1111";
        }

    }


}
