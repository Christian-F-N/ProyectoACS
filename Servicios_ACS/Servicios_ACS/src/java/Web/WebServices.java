/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Controllers.Funciones;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author HP
 */
@WebService(serviceName = "WebServices")
public class WebServices {

    Funciones user = new Funciones();

    @WebMethod(operationName = "Login")
    public String Login(@WebParam(name = "cedula") String cedula, @WebParam(name = "contrase") String contrase) {
        return user.login(cedula, contrase) ;
    }

}
