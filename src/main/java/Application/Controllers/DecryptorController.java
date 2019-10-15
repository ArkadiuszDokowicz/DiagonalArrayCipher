package Application.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/decryptor")
public class DecryptorController {

    @GetMapping("")
    public String getDecryptorPage(Model model){
        return "DecryptorPage";
    }

    @RequestMapping("/decrypt")
    public String getDecryptedMessage() {
        return "decryptor";
    }

}