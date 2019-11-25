package com.example.work11.fanshe;

import java.lang.reflect.Method;

/**
 * Created by anchaoguang on 2019-10-23.
 */
public class CommunicateReflectively {
    public static void perform(Object speaker){
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method[] an = spkr.getMethods();
                an.toString();



                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            }catch (Exception e){
                System.out.println(speaker + " can not speak");
            }
            try {
             Method sit = spkr.getMethod("sit");
             sit.invoke(speaker);
            }catch (Exception e){
                System.out.println(speaker + " can not sit");
            }
        }catch (Exception e){
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}
