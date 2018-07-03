/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.converters;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 7ec
 */
@FacesConverter("mobileDateConverter")
public class DateConverter implements Converter {

    private static final DateFormat FORMATADOR
            = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            if (value == null || value.equals("")) {
                return null;
            }
            long tempo = dateFormat.parse(value).getTime();
            return new Date(tempo);
        } catch (ParseException ex) {
            Logger.getLogger(DateConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return  FORMATADOR.format((Timestamp) value);
    }

}
