package Application.CipherService;


import Application.Model.Key;
import Application.Model.Message;
import Application.Model.PositionXY;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
@Component
public class CipherImpl implements  CipherInterface{
    private final String key="acbedfgihj";
    @Override
    public Message decrypt(Message message) {
        int arrayHeight= (int) Math.ceil((double)message.getText().length()/(double)key.length());
        ArrayList<ArrayList<Character>> tabulatedMessage=createTable(message,key);
        String decryptedMssg=(getDecryptedText(tabulatedMessage,arrayHeight,key,message));
        decryptedMssg=removeX(decryptedMssg);
        return(new Message(decryptedMssg));
    }


    @Override
    public Message encrypt(Message message) {
        int arrayHeight= (int) Math.ceil((double)message.getText().length()/(double)key.length());
        ArrayList<ArrayList<Character>> tabulatedMessage=createTable(message,key);
        String encryptedMssg=(getEncryptedText(tabulatedMessage,arrayHeight,key));
        return(new Message(encryptedMssg));
    }
    private ArrayList<ArrayList<Character>> createTable(Message message, String key){
        int arrayWidth=key.length();
        int arrayHeight= (int) Math.ceil((double)message.getText().length()/(double)key.length());
        char[] toEncrypt=message.getText().toCharArray();
        int characterCounter = toEncrypt.length;
        ArrayList<ArrayList<Character>> toReturn = new ArrayList<>();
        //CreateAndFillTable
        ArrayList<Character> wiersz= new ArrayList<>();
        for(int x=0;x<arrayWidth;x++){
            wiersz.add('X');
        }
        for(int i=0;i<arrayHeight;i++){
            toReturn.add(new ArrayList<>(wiersz));
        }
        int characterIterator =0;
        for(int i=0;i<arrayHeight;i++){
            for(int y=0;y<arrayWidth;y++){
                if(characterCounter!=0){
                    toReturn.get(i).set(y, toEncrypt[characterIterator]);
                    characterCounter--;
                    characterIterator++;
                }
            }
        }
        return toReturn;
    }

    private String getEncryptedText(ArrayList<ArrayList<Character>> table, int arrayHeight, String key){
        Key orderedKey= new Key(key);
        StringBuilder toReturn= new StringBuilder();
        for(int i=0;i<orderedKey.getKeyOrdered().size();i++){
            int startedValue=orderedKey.getKeyOrdered().get(i).getOrder();
            for(int x=0;x<arrayHeight;x++){
                if(x==0){
                    toReturn.append(table.get(x).get(startedValue));
                }else{
                    if(startedValue-1==-1){startedValue=orderedKey.getKeyOrdered().size();}
                    startedValue-=1;
                    toReturn.append(table.get(x).get(startedValue));
                }
            }
        }
        return toReturn.toString();
    }

    private String getDecryptedText(ArrayList<ArrayList<Character>> tabulatedMessage, int arrayHeight, String key, Message message) {
        Key orderedKey = new Key(key);
        ArrayList<PositionXY> writeOrder = new ArrayList<>();
        for (int i = 0; i < orderedKey.getKeyOrdered().size(); i++) {
            int startedValue = orderedKey.getKeyOrdered().get(i).getOrder();
            for (int x = 0; x < arrayHeight; x++) {
                if (x == 0) {
                    writeOrder.add(new PositionXY(x, startedValue));
                } else {
                    if (startedValue - 1 == -1) {
                        startedValue = orderedKey.getKeyOrdered().size();
                    }
                    startedValue -= 1;
                    writeOrder.add(new PositionXY(x, startedValue));
                }
            }
        }
        char[] characters = message.getText().toCharArray();
        Collections.reverse(writeOrder);
        for (int i = 0; i < characters.length; i++) {
            tabulatedMessage.get(writeOrder.get(i).getPositionX()).set(writeOrder.get(i).getPositionY(), characters[characters.length - 1 - i]);
        }
        StringBuilder decrypted= new StringBuilder();
        for(ArrayList<Character> arrayList:tabulatedMessage){
            for(Character character:arrayList){
                decrypted.append(character);
            }
        }
        return decrypted.toString();
    }

    private String removeX(String text){
        char[] chars=text.toCharArray();
        while(chars[chars.length-1]=='X'){
            text = removeLast(text);
            chars=text.toCharArray();
        }
        return text;
    }
    public String removeLast(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'X') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
