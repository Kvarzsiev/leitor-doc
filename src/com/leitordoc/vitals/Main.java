package com.leitordoc.vitals;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import com.leitordoc.controllers.BoletoToJsonController;
import com.leitordoc.controllers.IrToJsonController;
import com.leitordoc.views.*;

public class Main {

	public static void main(String[] args) throws ParseException {

                                      // Pdf input                               
//		BoletoToJsonController.convert("C:\\Users\\Usuario\\Desktop\\boleto.pdf");
//		IrToJsonController.convert("C:\\Users\\Usuario\\Desktop\\dir1.pdf");
		IrToJsonController.convert("C:\\Users\\Usuario\\Desktop\\dirMae.pdf");
	}
}