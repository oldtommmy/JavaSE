package com.tommychan.stringBuffer_;

public class StringBufferToString {
    public static void main(String[] args) {
        //String -> StringBuffer

        //1. By Constructor
        String s1= "abc";
        StringBuffer stringBuffer = new StringBuffer(s1);

        //2. By append
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(s1);

        //StringBuffer -> String

        //1. By StringBuffer.toString()
        StringBuffer stringBuffer2 = new StringBuffer("xyz");
        String s2 = stringBuffer2.toString();

        //2. By Constructor
        String s3 = new String(stringBuffer2);

    }
}
