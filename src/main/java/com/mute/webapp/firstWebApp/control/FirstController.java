package com.mute.webapp.firstWebApp.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mute.webapp.firstWebApp.forfun.fighter.MainTester;

@Controller
public class FirstController {
	
    @GetMapping("/fighter")
    public String greeting(@RequestParam(name="a", required=false, defaultValue="本群主") String nameA, @RequestParam(name="b", required=false, defaultValue="特朗普") String nameB,Model model)throws Exception {
     //   model.addAttribute("name", Math.random()+nameA+" "+nameB);
        String name = MainTester.testFight(nameA,nameB);
        model.addAttribute("name", name);
        return "fighter";
    }
    
    
    
    

}
