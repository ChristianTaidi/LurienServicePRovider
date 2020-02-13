package com.christian.lurien.demo.controller.impl;

import com.christian.lurien.demo.controller.RegisterRequestController;
import com.christian.lurien.demo.service.RegisterService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Controller
public class RegisterRequestControllerImpl implements RegisterRequestController {


    @Autowired
    private RegisterService registerService;

    @GetMapping("/assert")
    @Override
    public ModelAndView getAssert(String userIdentifier, Model model){
        System.out.println(registerService.getClass());
        ModelAndView mav = new ModelAndView("index");
        //ToDo call the assert service in order to deploy a new smart contract, get the contract address, and return it as qr code
        String contractAddress = this.registerService.register();
        QRCodeWriter qrWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrWriter.encode(contractAddress, BarcodeFormat.QR_CODE,500,500);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();

            MatrixToImageWriter.writeToStream(bitMatrix,"PNG",bytes);
            mav.addObject("qrcode", "data:image/png;base64,"+new String(Base64.getEncoder().encode(bytes.toByteArray())));
            return mav;
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return mav;
        }
    }
}
