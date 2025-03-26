package org.quarks.learn.designPattern.structural;

import java.util.HashMap;
import java.util.Map;

interface Character {
    void display(int fontSize);  // Display the character with a specific font size
}

class ConcreteCharacter implements Character {
    private char symbol;  // Shared state

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void display(int fontSize) {
        System.out.println("Displaying character: " + symbol + " with font size: " + fontSize);
    }
}


class CharacterFactory {
    private static Map<Character, Character> characterMap = new HashMap<>();

    public static Character getCharacter(char symbol) {
        Character character = characterMap.get(symbol);

        if (character == null) {
            character = new ConcreteCharacter(symbol);
            characterMap.put(character, character);
            System.out.println("Creating new character: " + symbol);
        }

        return character;
    }
}


public class FlyweightPatternExample {
    public static void main(String[] args) {
        // Client code that uses the Flyweight pattern
        Character characterA1 = CharacterFactory.getCharacter('A');
        characterA1.display(12);  // Display 'A' with font size 12

        Character characterB1 = CharacterFactory.getCharacter('B');
        characterB1.display(14);  // Display 'B' with font size 14

        // Reusing the same 'A' object
        Character characterA2 = CharacterFactory.getCharacter('A');
        characterA2.display(16);  // Display 'A' with font size 16

        // Reusing the same 'B' object
        Character characterB2 = CharacterFactory.getCharacter('B');
        characterB2.display(18);  // Display 'B' with font size 18

        // No new objects will be created for 'A' or 'B'
    }
}

