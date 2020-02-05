package com.christian.lurien.demo.controller.impl;

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
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class RegisterRequestControllerImpl {


    @Autowired
    private RegisterService registerService;

    @GetMapping("/assert")
    public ResponseEntity<byte[]> getAssert(String userIdentifier){
        System.out.println(registerService.getClass());
        //ToDo call the assert service in order to deploy a new smart contract, get the contract address, and return it as qr code
        String contractAddress = this.registerService.register();
        QRCodeWriter qrWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrWriter.encode(contractAddress, BarcodeFormat.QR_CODE,100,100);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();

            MatrixToImageWriter.writeToStream(bitMatrix,"PNG",bytes);
            return ResponseEntity.ok().body(bytes.toByteArray());
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
