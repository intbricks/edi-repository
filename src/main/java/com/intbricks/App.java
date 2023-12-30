package com.intbricks;

import com.imsweb.x12.Loop;
import com.imsweb.x12.Separators;
import com.imsweb.x12.reader.X12Reader;
import com.walmartlabs.x12.exceptions.X12ParserException;
import com.walmartlabs.x12.standard.StandardX12Document;
import com.walmartlabs.x12.standard.StandardX12Parser;
import com.walmartlabs.x12.standard.X12Group;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;


class App {

    public static void main(String[] args) throws IOException {

        String s1 = "ISA*01*0000000000*01*0000000000*ZZ*ABCDEFGHIJKLMNO*ZZ*123456789012345*101127*1719*U*00400*000000049*0*P*>~GS*SH*4405197800*999999999*20111206*1045*00*X*004060~ST*AAA*0001~TEST*1~SE*1*0001~ST*BBB*0002~TEST*2~SE*1*0002~ST*YYZ*0099~TEST*99~SE*1*0099~GE*1*00~GS*SH*4405197800*999999999*20111206*1045*99*X*004060~ST*AAA*0003~TEST*3~SE*1*0003~GE*1*99~IEA*2*000000049~                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ";

        String s2 =
                "ISA*01*0000000000*01*0000000000*ZZ*ABCDEFGHIJKLMNO*ZZ*123456789012345*101127*1719*U*00400*000000049*0*P*>\n" +
                "GS*SH*4405197800*999999999*20111206*1045*00*X*004060\n" +
                "ST*AAA*0001\n" +
                "TEST*1\n" +
                "SE*1*0001\n" +
                "ST*BBB*0002\n" +
                "TEST*2\n" +
                "SE*1*0002\n" +
                "ST*YYZ*0099\n" +
                "RUSH*99\n" +
                "HL*1**P\n" +
                "PARENT*99\n" +
                "HL*2*1*C\n" +
                "CHILD*1\n" +
                "HL*3*1*C\n" +
                "CHILD*2\n" +
                "SE*1*0099\n" +
                "GE*1*00\n" +
                "GS*SH*4405197800*999999999*20111206*1045*99*X*004060\n" +
                "ST*AAA*0003\n" +
                "TEST*3\n" +
                "SE*1*0003\n" +
                "GE*1*99\n" +
                "IEA*2*000000049";

        gozer(s1);
        gozer(s2);
        x12parser(s1);
        x12parser(s2);

    }

    public static void gozer(String ediMessage) {
        try {
            StandardX12Parser x12Parser = new StandardX12Parser();
            StandardX12Document x12Document = x12Parser.parse(new String(ediMessage));

            List<X12Group> groups = x12Document.getGroups();

            System.out.println(groups.size());


        } catch (X12ParserException e) {
            e.printStackTrace();
        }
    }

    public static void x12parser(String ediMessage) throws IOException {
        X12Reader reader = new X12Reader(X12Reader.FileType.ANSI837_5010_X222, new ByteArrayInputStream(ediMessage.getBytes()));

        List<String> errors = reader.getErrors();
        System.out.printf("errors: %d\n", errors.size());

        List<Loop> loops = reader.getLoops();
        System.out.printf("loops: %d\n", loops.size());

        Separators separators = reader.getSeparators();
        System.out.println(separators);


    }
}


