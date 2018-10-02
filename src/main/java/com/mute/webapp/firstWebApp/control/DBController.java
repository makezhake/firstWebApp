package com.mute.webapp.firstWebApp.control;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mute.webapp.firstWebApp.db.TestEntity;
import com.mute.webapp.firstWebApp.db.TestEntityRepository;

@Controller
public class DBController {
	@Autowired
	private TestEntityRepository repo;
	
	@GetMapping("/db")
    public String greeting(@RequestParam(name="a", required=false, defaultValue="本群主") String nameA,Model model)throws Exception {
     //   model.addAttribute("name", Math.random()+nameA+" "+nameB);
        String name = "";
        TestEntity bo = new TestEntity();
        bo.setUUID(UUID.randomUUID().toString());
        Date time = new Date();
        bo.setName(nameA);
        repo.save(bo);
        Iterable<TestEntity> list = repo.findAll();
        StringBuffer result = new StringBuffer();
        for(TestEntity i:list) {
        	result.append(i.getUUID()+"  "+i.getName());
        	result.append("<BR/>");
        }
        name = result.toString();
        model.addAttribute("name", name);
        return "db";
    }

}
