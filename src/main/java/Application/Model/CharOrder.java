package Application.Model;

import java.util.ArrayList;
import java.util.Collections;

public class CharOrder implements Comparable<CharOrder>{
    private char character;
    private int order;

    public CharOrder(char character, int order) {
        this.character = character;
        this.order = order;
    }

    public char getCharacter() {
        return character;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "CharOrder{" +
                "character=" + character +
                ", order=" + order +
                '}';
    }

    @Override
    public int compareTo(CharOrder compareCharOrder) {
        return Character.compare(this.character, compareCharOrder.character);
    }
}