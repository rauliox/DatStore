package com.util;

import com.dto.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import model.dao.impl.DaoFactory;

public class Logger {
    public static void log(Exception e)
    {
        try{
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            Log log = new Log();
            log.setTipo("Exception");
            log.setMensaje(e.getMessage());
            log.setDetalles(sw.toString());

            DaoFactory.getInstancia().getDaoLog().logIns(log);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
