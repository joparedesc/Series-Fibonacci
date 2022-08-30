package com.series.fibonacci.service.impl;

import com.google.gson.Gson;
import com.series.fibonacci.config.ApplicationControllerConfig;
import com.series.fibonacci.model.response.CalculateFibonacciResponse;
import com.series.fibonacci.service.SaveRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
@Slf4j
@Service
@AllArgsConstructor
public class SaveRequestServiceImplementation implements SaveRequestService {

    private final ApplicationControllerConfig applicationControllerConfig;

    //crea el archivo en disco, recibe como parámetro la lista de estudiantes
    public void crearArchivo(CalculateFibonacciResponse calculateFibonacciResponse,Long valueRequest) {
        FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter("C:\\archivos\\fibonacci\\FibonacciValidRequest.txt",true);
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            Gson gson = new Gson();
            String json =gson.toJson(calculateFibonacciResponse);

            String localHost="http://localhost:8080";
            //Write request valid
            bfwriter.write(
                "------------------Request Valid: "
                    +valueRequest.toString()+
                    " (seriesLength)-----------------------"+"\n"+
                    "Host: "+ localHost+"\n"+
                    "Api: "+ applicationControllerConfig.getBasePath()+
                            applicationControllerConfig.getApiCalculateFibonacci() +"\n"+
                    "Response:" + json +
                    "\n"

            );
            bfwriter.close();
            //System.out.println("Archivo creado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
