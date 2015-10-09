/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.util.Calendar;
import java.util.Comparator;

/**
 *
 * @author cromero
 */
public class TimeIgnoringComparator implements Comparator<Calendar> {
  @Override
  public int compare(Calendar c1, Calendar c2) {
    if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR)) 
        return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
    if (c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)) 
        return c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
    return c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH);
  }
}
