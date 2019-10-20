package Application.CipherService;

import Application.Model.Message;

public interface CipherInterface {

    Message decrypt(Message message);

    Message encrypt(Message message);
}
