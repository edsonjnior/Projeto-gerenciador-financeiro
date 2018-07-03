package br.com.juniordev.gerfina.converters;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Altieres de Matos
 */
@FacesConverter(value = "bigDecimal")
public class BigDecimalConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || "".equals(string)) {
            return BigDecimal.ZERO;
        }
        //10,00 ~> 10.00 --- 1.000,00 ~> 1000.00
        String valor = string.replace(".", "").replace(",", ".");
        return new BigDecimal(valor);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o instanceof BigDecimal) {
            BigDecimal bd = (BigDecimal) o;
            //10.00 ~> 10,00 --- 1000.00 ~> 1.000,00
            return new DecimalFormat("#,##0.00").format(bd);
        }
        return "";
    }

}
