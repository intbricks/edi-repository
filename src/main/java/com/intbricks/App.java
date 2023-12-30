package com.intbricks;

import com.walmartlabs.x12.exceptions.X12ParserException;
import com.walmartlabs.x12.standard.StandardX12Document;
import com.walmartlabs.x12.standard.StandardX12Parser;


class App {

    public static void main(String[] args) {

        String ediMessage = "ST*852*0001~XQ*H*20200601**INVRPT001*00~N9*HPI*NPI SELLER IDENTIFIER~PER*BL*HARRY SMITH*TE*800-555-1200*EM* HSMITH@PHARMACY.COM~LIN*0001*ND*55111-0124-05~CTP**RTL*12.57~ ZA*OH*500*EA~SDQ*EA*XX*NPI PHARMACY ID1*115*NPI PHARMACY ID2*120*NPI PHARMACY ID3*265~ZA*TS*1500*EA~SDQ*EA*XX*NPI PHARMACY ID1*1000*NPI PHARMACY ID2*120*NPI PHARMACY ID3*380~ CTT*1~SE*12*0001~";

        try {
            StandardX12Parser x12Parser = new StandardX12Parser();
            StandardX12Document x12Document = x12Parser.parse(new String(ediMessage));
        } catch (X12ParserException e) {
            e.printStackTrace();
        }
    }
}


