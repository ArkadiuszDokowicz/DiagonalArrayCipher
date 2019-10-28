package Application.Controllers;

import Application.BBS.ServiceBBS;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bbsGenerator")
public class bbsGeneratorController {


    Logger logger = LoggerFactory.getLogger(bbsGeneratorController.class);
    @Autowired
    ServiceBBS serviceBBS;

    @GetMapping("")
    public String getBBSGenPage(Model model){
        return "BBSGenPage";
    }

    @PostMapping("/generate")
    public String getDecryptedMessage(Model model){
        //logger.info(String.valueOf(serviceBBS.generate20kBitesAsBitSet()));
        model.addAttribute("text",serviceBBS.generate20kBitesAsStringBuilder());

        return "GeneratedByBBS";
    }

}