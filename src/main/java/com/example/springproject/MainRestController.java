package com.example.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


import java.util.Optional;

@Controller
public class MainRestController {

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    UserdetailRepository userdetailRepository;


    @GetMapping("/")
    public String getLandingPage(){
        return "landingpage";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username")String username,@RequestParam("password")String password){
        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPassword(password);

        credentialRepository.save(credential);

        return "signup2";
    }


    @PostMapping("/login")

    public String login(@RequestParam("username")String username,@RequestParam("password")String password, HttpSession session, Model model){

        Optional<Credential> credValue=credentialRepository.findById(username);
        if(credValue.isPresent()) {
            if (credValue.get().getPassword().equals(password)) {
                session.setAttribute("username",username);
                Optional<Userdetail> useValue=userdetailRepository.findById(username);
                if(useValue.isPresent()){
                    model.addAttribute("userdetail",useValue.get());
                }
                return "dashboard";
            }
            else {
                return "landingpage";
            }
        }
        else {
            return "landingpage";
        }
    }

    @PostMapping("/signupp")
    public String signupp(@RequestParam("username")String username,@RequestParam("fname")String fname,@RequestParam("lname")String lname,@RequestParam("email")String email,@RequestParam("phone") String phone, HttpSession session){
        Userdetail userdetail = new Userdetail();
        userdetail.setUsername(username);
        userdetail.setFname(fname);
        userdetail.setLname(lname);
        userdetail.setEmail(email);
        userdetail.setPhone(phone);
        userdetailRepository.save(userdetail);
        session.setAttribute("username",username);
        session.setAttribute("fname",fname);
        session.setAttribute("lname",lname);
        session.setAttribute("email",email);
        session.setAttribute("phone",phone);
        return "welcome";
    }


    /*@GetMapping("/save")
    public String saveCredential(){
        Credential cr=new Credential();
        cr.setUsername("Tamo");
        cr.setPassword("tamo@123");
        credentialRepository.save(cr);
        return "New Credential Saved";
    }*/
}