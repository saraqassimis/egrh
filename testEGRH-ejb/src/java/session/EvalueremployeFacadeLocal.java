/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import bean.Evalueremploye;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sara
 */
@Local
public interface EvalueremployeFacadeLocal {

    void create(Evalueremploye evalueremploye);

    void edit(Evalueremploye evalueremploye);

    void remove(Evalueremploye evalueremploye);

    Evalueremploye find(Object id);

    List<Evalueremploye> findAll();

    List<Evalueremploye> findRange(int[] range);

    int count();
    
}
