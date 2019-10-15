package Application.CipherService;

import Application.Model.Message;

public interface CipherInterface {

    Message decrypt(Message message, String key);

    Message encrypt(Message message, String key);
}
