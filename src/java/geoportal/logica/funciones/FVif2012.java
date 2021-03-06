/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoportal.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import geoportal.logica.clases.Vif2012;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oscunach
 */
public class FVif2012 {
    public static ArrayList<Vif2012> llenarDatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        Vif2012 datos = null;
        try {
            while (rs.next()) {
                datos = new Vif2012(rs.getDate("pfecha_denuncia"),
                        rs.getString("pdenunciante"),
                        rs.getString("pvictima"),
                        rs.getString("psexo_victima"),
                        rs.getString("pdireccion_victima"),
                        rs.getDouble("px"),
                        rs.getDouble("py"),
                        rs.getString("pcircuito"),
                        rs.getString("pcodigo_circuito"),
                        rs.getString("psubcircuito"),
                        rs.getString("pcodigo_subcircuito"),
                        rs.getString("pdomiciliado_victima"),
                        rs.getInt("pedad_victima"),
                        rs.getString("pestado_civil_victima"),
                        rs.getString("pnivel_de_instruccion_victima"),
                        rs.getString("pocupacion"),
                        rs.getString("pagresor"),
                        rs.getString("psexo_agresor"),
                        rs.getString("pdireccion_agresor"),
                        rs.getString("pedad_agresor"),
                        rs.getString("pdomiciliado_agresor"),
                        rs.getString("pestado_civil_agresor"),
                        rs.getString("pnivel_de_instruccion_agresor"),
                        rs.getString("pocupacion_agresor"),
                        rs.getString("pparentesco_victima_agresor"),
                        rs.getString("pnumero_hijos_comun"),
                        rs.getString("plugar_agresion"),
                        rs.getString("ptipo_de_violencia"),
                        rs.getDate("pfecha_agresion"),
                        rs.getString("phora_de_agresion"),
                        rs.getString("pmedidas_de_amparo"),
                        rs.getString("psentencia"),
                        rs.getString("papelacion"),
                        rs.getString("pboletas_anteriores"),
                        rs.getString("pobservaciones"),
                        rs.getString("pboletas_de_remision"),
                        rs.getInt("pid")
                );
                lst.add(datos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatos() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    /*
     funciones de las victimas
     */
    public static ArrayList<Vif2012> ObtenerDatosVictima() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_busqueda_victima()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    /*
     funciones circuitos
     */
    public static ArrayList<Vif2012> ObtenerDatosCircuito() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_busqueda_circuito()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    /*
     funciones circuitos
     */
    public static ArrayList<Vif2012> ObtenerDatosSubcircuito() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_busqueda_subcircuito()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosDadoCircuito(String circuito) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * geoportal.f_select_Vif_2012_dado_circuito(?)";
            lstP.add(new Parametro(1, circuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosDadoSubcircuito(String subcircuito) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_subcircuito(?)";
            lstP.add(new Parametro(1, subcircuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosDadoCircuitoSexo(String circuito, String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_vif_2010_2_dado_circuito_sexo(?,?)";
            lstP.add(new Parametro(1, sexo));
            lstP.add(new Parametro(2, circuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosDadoCircuitoSexoVictima(String circuito, String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_circuito_sexo_victima(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosDadoSubCircuitoSexoVictima(String sexo, String subcircuito) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_subcircuito_sexo_victima(?,?)";
            lstP.add(new Parametro(1, sexo));
            lstP.add(new Parametro(2, subcircuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    public static ArrayList<Vif2012> ObtenerDatosDadoCodigoSubCircuitoSexoVictima(String sexo, String subcircuito) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_subcircuito_sexo_victima2(?,?)";
            lstP.add(new Parametro(1, sexo));
            lstP.add(new Parametro(2, subcircuito));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosDadoTipoViolenciaSexoVictima(String sexo, String violencia) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * geoportal.f_select_Vif_2012_dado_violencia_sexo_victima(?,?)";
            lstP.add(new Parametro(1, sexo));
            lstP.add(new Parametro(2, violencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosDadoTipoViolencia(String violencia) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_tipo_violencia(?)";
            lstP.add(new Parametro(1, violencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosTipoViolencia() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_tipo_violencia()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosEnero() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_enero()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosFebrero() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_febrero()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosMarzo() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_marzo()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosAbril() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_abril()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosMayo() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_mayo()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosJunio() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_junio()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosJulio() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_julio()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosAgosto() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_agosto()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSeptiembre() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_septiembre()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosOctubre() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_octubre()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosNoviembre() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_noviembre()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosDiciembre() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            String sql = "select * from geoportal.f_select_Vif_2012_diciembre()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaEnero(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_enero(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaFebrero(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_febrero(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaMarzo(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_marzo(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaAbril(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_abril(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaMayo(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_mayo(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaJunio(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_junio(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaJulio(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_julio(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaAgosto(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_agosto(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaSeptiembre(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_septiembre(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaOctubre(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_octubre(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaNoviembre(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_noviembre(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaDiciembre(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_diciembre(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaEdad1(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_rango1(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaEdad2(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_rango2(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaEdad3(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_rango3(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaEdad4(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_rango4(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaEdad5(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_rango5(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaEdad6(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_rango6(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Vif2012> ObtenerDatosSexoVictimaEdad7(String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_sexo_victima_rango7(?)";
            lstP.add(new Parametro(1, sexo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Vif2012> ObtenerDatosDadoCircuitoTipoViolencia(String circuito, String violencia) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_circuito_violencia(?,?)";
            lstP.add(new Parametro(1, circuito));
            lstP.add(new Parametro(2, violencia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    public static ArrayList<Vif2012> ObtenerDatosParentesco() throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_parentesco()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    
    public static ArrayList<Vif2012> ObtenerDatosDadoParentesco(String parentesco) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_parentesco(?)";
            lstP.add(new Parametro(1, parentesco));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    

    public static ArrayList<Vif2012> ObtenerDatosDiaDenuncia(int dia) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_busqueda_dia_agresion(?)";
            lstP.add(new Parametro(1, dia));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    public static ArrayList<Vif2012> ObtenerDatosDiaDenunciaSexoVictima(int dia,String sexo) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from geoportal.f_select_Vif_2012_dado_dia_agresion_sexo_victima(?,?)";
            lstP.add(new Parametro(1, dia));            
            lstP.add(new Parametro(2, sexo));   
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Vif2012> ObtenerDatosDadoDiaAgresion(int dia) throws Exception {
        ArrayList<Vif2012> lst = new ArrayList<Vif2012>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * geoportal.f_select_Vif_2012_dado_dia_agresion(?)";
            lstP.add(new Parametro(1, dia));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDatos(rs);
            rs = null;
        } catch (Exception e) {
        }
        return lst;
    }
    

    
    
}
