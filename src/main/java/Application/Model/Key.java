package Application.Model;

import java.util.ArrayList;
import java.util.Collections;

public class Key {
    private ArrayList<CharOrder> keyOrdered = new ArrayList<>();

    public Key(String key) {
        int i=0;
        for(char ch : key.toCharArray()){
            keyOrdered.add(new CharOrder(ch,i));
            i++;
        }
        this.setOrder();
    }

    public ArrayList<CharOrder> getKeyOrdered() {
        return keyOrdered;
    }

    private void setOrder(){
        Collections.sort(keyOrdered);
    }

    @Override
    public String toString() {
        return "Key{" +
                "keyOrdered=" + keyOrdered +
                '}';
    }
}
