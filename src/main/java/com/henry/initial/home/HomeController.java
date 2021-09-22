package com.henry.initial.home;

import com.henry.initial.product.ProductVO;
import com.henry.initial.util.EmailVO;
import com.henry.initial.util.SendEmail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    HomeService homeService;

    @GetMapping("/")
    public String index(Model model) throws Exception {
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) throws Exception {
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) throws Exception {
        return "contact";
    }

    @GetMapping("/test")
    public String test(Model model) throws Exception {

        List<CategoryVO> a = homeService.getCategory();
        model.addAttribute("ctgr_list",a);
        return "test";
    }

    @PostMapping("/getCategory2")
    @ResponseBody
    public List<CategoryVO> getCategory2(Model model, CategoryVO categoryVO) throws Exception {
        return  homeService.getCategory2(categoryVO);
    }

    @GetMapping("/shop")
    public String shop(Model model) throws Exception {
        return "shop";
    }

    @GetMapping("/estimate")
    public String estimate(Model model) throws Exception {
        return "estimate";
    }

    @GetMapping("/signup")
    public String signup(Model model) throws Exception {
        return "signup";
    }

    @PostMapping("/regiEsti")
    @ResponseBody
    public void regiEsti(Model model, EstimateVO estimateVO) throws Exception {

        String e_title = "[" + estimateVO.getEstiName() + "-견적 문의] "+estimateVO.getEstiTitle();
        String e_contents = "상호 : " + estimateVO.getEstiName() + "\n"
                    + "E-mail 주소 : " + estimateVO.getEstiEmail() + "\n"
                    + "전화번호 : " + estimateVO.getEstiTel() + "\n"
                    + "문의 내용 : \n " + estimateVO.getEstiContent() + "\n\nFrom Homepage";
        SendEmail sendEmail = new SendEmail();
        sendEmail.send(e_title, e_contents);

        homeService.regiEsti(estimateVO);
    }

    @PostMapping("/modiEsti")
    @ResponseBody
    public void modiEsti(Model model, EstimateVO estimateVO) throws Exception {

        String e_title = "[" + estimateVO.getEstiName() + "-견적 문의] "+estimateVO.getEstiTitle();
        String e_contents = "상호 : " + estimateVO.getEstiName() + "\n"
                + "E-mail 주소 : " + estimateVO.getEstiEmail() + "\n"
                + "전화번호 : " + estimateVO.getEstiTel() + "\n"
                + "문의 내용 : \n " + estimateVO.getEstiContent() + "\n\nFrom Homepage";
        SendEmail sendEmail = new SendEmail();
        sendEmail.send(e_title, e_contents);

        homeService.modiEsti(estimateVO);
    }

    @PostMapping("/getEsti")
    @ResponseBody
    public List<EstimateVO> getEsti(Model model) throws Exception {
        List<EstimateVO> list = homeService.getEsti();

        return list;
    }

    @PostMapping("/showContents")
    @ResponseBody
    public EstimateVO showContents(Model model, EstimateVO estimateVO) throws Exception {
        EstimateVO vo = homeService.showContents(estimateVO);
        if(estimateVO.getEstiPassword().equals("seoilco")){
            vo.setEstiPassword("pass");
        }
        return vo;
    }

    @PostMapping("/sendEmail")
    @ResponseBody
    public void sendEmail(Model model, EmailVO emailVO) throws Exception {
        String e_title = "[" + emailVO.getEmailName() + "] "+emailVO.getEmailTitle();
        String e_contents = "상호 : " + emailVO.getEmailName() + "\n"
                + "E-mail 주소 : " + emailVO.getEmailEmail() + "\n"
                + "문의 내용 : \n " + emailVO.getEmailContent() + "\n\nFrom Homepage";
        SendEmail sendEmail = new SendEmail();
        sendEmail.send(e_title, e_contents);
    }

}
