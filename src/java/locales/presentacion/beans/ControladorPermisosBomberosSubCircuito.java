/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locales.presentacion.beans;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import locales.logica.clases.Locales;
import locales.logica.funciones.FLocales;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import recursos.Util;

/**
 *
 * @author oscunach
 */
@ManagedBean
@RequestScoped
public class ControladorPermisosBomberosSubCircuito {

    /**
     * Creates a new instance of ControladorPermisosBomberosSubCircuitos
     */
    private CartesianChartModel lineLocalesSubCircuitos;
    private ArrayList<Locales> lstLocales;
    private ArrayList<Locales> lstLocalesDadoSubCircuito;
    private ArrayList<Locales> lstLocalesSubCircuito;
    private ArrayList<Locales> lstLocalesDadoSubCircuitoSi;
    private ArrayList<Locales> lstLocalesDadoSubCircuitoNo;
    private ArrayList<Locales> lstLocalesDadoSubCircuitoNoPresenta;

    public CartesianChartModel getLineLocalesSubCircuitos() {
        return lineLocalesSubCircuitos;
    }

    public void setLineLocalesSubCircuitos(CartesianChartModel lineLocalesSubCircuitos) {
        this.lineLocalesSubCircuitos = lineLocalesSubCircuitos;
    }

    public ArrayList<Locales> getLstLocales() {
        return lstLocales;
    }

    public void setLstLocales(ArrayList<Locales> lstLocales) {
        this.lstLocales = lstLocales;
    }

    public ArrayList<Locales> getLstLocalesDadoSubCircuito() {
        return lstLocalesDadoSubCircuito;
    }

    public void setLstLocalesDadoSubCircuito(ArrayList<Locales> lstLocalesDadoSubCircuito) {
        this.lstLocalesDadoSubCircuito = lstLocalesDadoSubCircuito;
    }

    public ArrayList<Locales> getLstLocalesSubCircuito() {
        return lstLocalesSubCircuito;
    }

    public void setLstLocalesSubCircuito(ArrayList<Locales> lstLocalesSubCircuito) {
        this.lstLocalesSubCircuito = lstLocalesSubCircuito;
    }

    public ArrayList<Locales> getLstLocalesDadoSubCircuitoSi() {
        return lstLocalesDadoSubCircuitoSi;
    }

    public void setLstLocalesDadoSubCircuitoSi(ArrayList<Locales> lstLocalesDadoSubCircuitoSi) {
        this.lstLocalesDadoSubCircuitoSi = lstLocalesDadoSubCircuitoSi;
    }

    public ArrayList<Locales> getLstLocalesDadoSubCircuitoNo() {
        return lstLocalesDadoSubCircuitoNo;
    }

    public void setLstLocalesDadoSubCircuitoNo(ArrayList<Locales> lstLocalesDadoSubCircuitoNo) {
        this.lstLocalesDadoSubCircuitoNo = lstLocalesDadoSubCircuitoNo;
    }

    public ArrayList<Locales> getLstLocalesDadoSubCircuitoNoPrsenta() {
        return lstLocalesDadoSubCircuitoNoPresenta;
    }

    public void setLstLocalesDadoSubCircuitoNoPrsenta(ArrayList<Locales> lstLocalesDadoSubCircuitoNoPrsenta) {
        this.lstLocalesDadoSubCircuitoNoPresenta = lstLocalesDadoSubCircuitoNoPrsenta;
    }

    @PostConstruct
    public void init() {
        graficar();
    }

    public void graficar() {
        this.lineLocalesSubCircuitos = graficaSubCircuitos();

    }

    private void reinit() {
        this.init();
    }

    public ControladorPermisosBomberosSubCircuito() {
        this.reinit();
    }
    
 private CartesianChartModel graficaSubCircuitos() {
        CartesianChartModel model = new CartesianChartModel();
        try {

            lstLocalesSubCircuito = FLocales.ObtenerDatosSubCircuito();
            ChartSeries Si = new ChartSeries();
            Si.setLabel("Si");
            for (Locales lstLocalesSubCircuito1 : lstLocalesSubCircuito) {
                lstLocalesDadoSubCircuitoSi = FLocales.ObtenerDatosDadoPermisoBomberosSubcircuito("Si", lstLocalesSubCircuito1.getSubcircuito());
                Si.set(lstLocalesSubCircuito1.getSubcircuito(), lstLocalesDadoSubCircuitoSi.size());
            }

            ChartSeries No = new ChartSeries();
            No.setLabel("No");
            for (Locales lstLocalesSubCircuito1 : lstLocalesSubCircuito) {
                lstLocalesDadoSubCircuitoNo = FLocales.ObtenerDatosDadoPermisoBomberosSubcircuito("No", lstLocalesSubCircuito1.getSubcircuito());
                No.set(lstLocalesSubCircuito1.getSubcircuito(), lstLocalesDadoSubCircuitoNo.size());
            }

            ChartSeries NoPresenta = new ChartSeries();
            NoPresenta.setLabel("No Presenta");
            for (Locales lstLocalesSubCircuito1 : lstLocalesSubCircuito) {
                lstLocalesDadoSubCircuitoNoPresenta = FLocales.ObtenerDatosDadoPermisoBomberosSubcircuito("No Presenta", lstLocalesSubCircuito1.getSubcircuito());
                NoPresenta.set(lstLocalesSubCircuito1.getSubcircuito(), lstLocalesDadoSubCircuitoNoPresenta.size());
            }

            model.addSeries(Si);
            model.addSeries(No);
            model.addSeries(NoPresenta);

        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
        return model;

    }

}
