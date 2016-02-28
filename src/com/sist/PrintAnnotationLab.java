package com.sist;

import java.lang.reflect.Method;

/**
 * Created by hojin on 16. 2. 28.
 */
public class PrintAnnotationLab {
    public static void main(String[] args){
        //MethodsUseAnnotation 클래스로부터 메서드 정보를 얻음.
        Method[] methods=MethodsUseAnnotation.class.getDeclaredMethods();

        //Method 객체를 하나씩 처리함.
        for(Method method : methods){
            //PrintAnnotation이 적용되었는지 확인.
            if(method.isAnnotationPresent(PrintAnnotation.class)){
                //PrintAnnotation 객체 얻기
                PrintAnnotation printAnnotation=method.getAnnotation(PrintAnnotation.class);

                //메소드 이름 出力
                System.out.println("[" +method.getName()+ "]");
                //구분선 出力
                for(int i=0; i<printAnnotation.number(); i++){
                    System.out.print(printAnnotation.value());
                }
                System.out.println();

                try{
                    method.invoke(new MethodsUseAnnotation());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}


























