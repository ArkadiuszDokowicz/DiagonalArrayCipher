package Application.Controllers;

import Application.CipherService.CipherImpl;
import Application.Model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/decryptor")
public class DecryptorController {


    Logger logger = LoggerFactory.getLogger(DecryptorController.class);
    @Autowired
    CipherImpl cipher;

    @GetMapping("")
    public String getDecryptorPage(Model model){
        return "DecryptorPage";
    }

    @PostMapping("/decrypt")
    public String getDecryptedMessage(@RequestParam String text,Model model){
    Message message = new Message(text);
        logger.info("getDecryptedMessage method call with params :"+text);
    Message decryptedMessage = cipher.decrypt(message);
            model.addAttribute("text",decryptedMessage.getText());
            return "EncryptedMessagePage";
}

}