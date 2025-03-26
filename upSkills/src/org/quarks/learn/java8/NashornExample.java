package org.quarks.learn.java8;

import javax.script.*;

public class NashornExample {
    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        String script = "var greeting = 'Hello, Java 8!'; greeting;";
        Object result = engine.eval(script);
        System.out.println(result);
    }
}

