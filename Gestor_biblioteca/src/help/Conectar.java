
package help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conectar {
    private final String cadena;
    private final String usuario;
    private final String password;
    public Conectar(String cadena, String usuario, String password) {
        this.cadena=cadena;
        this.password=password;
        this.usuario=usuario;
    }
    
    public Connection getConexion (){
        Connection con = null;
        try{
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection(this.cadena,this.usuario,this.password);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
        }
        return con;
    }
}
