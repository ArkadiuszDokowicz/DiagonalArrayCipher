package Application.Controllers;

import Application.CipherService.CipherImpl;
import Application.Model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;

@Controller
@RequestMapping("/encryptor")
public class EncryptorController{

    Logger logger = LoggerFactory.getLogger(EncryptorController.class);

    @Autowired
    CipherImpl cipher;

    @GetMapping()
    public String getEncryptorPage(Model model){
        return "EncryptorPage";
    }

    @PostMapping(value = "/encrypt")
    public String encryptMessage(@RequestParam(value="text",required = true) String text,Model model) {
        Message message = new Message(text);
        if (message.getText().length() > 0 ) {
            logger.info("EncryptMessage method call with params :" + text + "");
            Message encryptedMessage = cipher.encrypt(message);
            model.addAttribute("text", encryptedMessage.getText());
            return "EncryptedMessagePage";
        } else {
            return "EncryptorPage";
        }
    }
}