package unidadesfamilia.presentacion.beans;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import unidadesfamilia.logica.clases.UnidadesFamilia;
import unidadesfamilia.logica.funciones.FUnidadesFamilia;

/**
 *
 * @author ICITS SALA5
 */
@ManagedBean
@RequestScoped
public class ControladorUnidadesFamiliaMedidasAmparo {

    private ArrayList<UnidadesFamilia> lstMedidasAmparo;
    private ArrayList<UnidadesFamilia> lstDatosDadoMedidasAmparo;
    private ArrayList<UnidadesFamilia> lstDatosDadoMedidasAmparoSM;
    private ArrayList<UnidadesFamilia> lstDatosDadoMedidasAmparoSF;
    private CartesianChartModel lineMedidasAmparo;
    private CartesianChartModel lineMedidasAmparoSexoVictima;
    private CartesianChartModel lineMedidasAmparo2015;
    private CartesianChartModel lineMedidasAmparoSexoVictima2015;
    private CartesianChartModel lineMedidasAmparo2016;
    private CartesianChartModel lineMedidasAmparoSexoVictima2016;
    private int anioSel;

    public int getAnioSel() {
        return anioSel;
    }

    public void setAnioSel(int anioSel) {
        this.anioSel = anioSel;
    }
    
    public ArrayList<UnidadesFamilia> getLstMedidasAmparo() {
        return lstMedidasAmparo;
    }

    public CartesianChartModel getLineMedidasAmparo2015() {
        return lineMedidasAmparo2015;
    }

    public void setLineMedidasAmparo2015(CartesianChartModel lineMedidasAmparo2015) {
        this.lineMedidasAmparo2015 = lineMedidasAmparo2015;
    }

    public CartesianChartModel getLineMedidasAmparoSexoVictima2015() {
        return lineMedidasAmparoSexoVictima2015;
    }

    public void setLineMedidasAmparoSexoVictima2015(CartesianChartModel lineMedidasAmparoSexoVictima2015) {
        this.lineMedidasAmparoSexoVictima2015 = lineMedidasAmparoSexoVictima2015;
    }

    public CartesianChartModel getLineMedidasAmparo2016() {
        return lineMedidasAmparo2016;
    }

    public void setLineMedidasAmparo2016(CartesianChartModel lineMedidasAmparo2016) {
        this.lineMedidasAmparo2016 = lineMedidasAmparo2016;
    }

    public CartesianChartModel getLineMedidasAmparoSexoVictima2016() {
        return lineMedidasAmparoSexoVictima2016;
    }

    public void setLineMedidasAmparoSexoVictima2016(CartesianChartModel lineMedidasAmparoSexoVictima2016) {
        this.lineMedidasAmparoSexoVictima2016 = lineMedidasAmparoSexoVictima2016;
    }
    
    
    
    public void setLstMedidasAmparo(ArrayList<UnidadesFamilia> lstMedidasAmparo) {
        this.lstMedidasAmparo = lstMedidasAmparo;
    }

    public ArrayList<UnidadesFamilia> getLstDatosDadoMedidasAmparo() {
        return lstDatosDadoMedidasAmparo;
    }

    public void setLstDatosDadoMedidasAmparo(ArrayList<UnidadesFamilia> lstDatosDadoMedidasAmparo) {
        this.lstDatosDadoMedidasAmparo = lstDatosDadoMedidasAmparo;
    }

    public ArrayList<UnidadesFamilia> getLstDatosDadoMedidasAmparoSM() {
        return lstDatosDadoMedidasAmparoSM;
    }

    public void setLstDatosDadoMedidasAmparoSM(ArrayList<UnidadesFamilia> lstDatosDadoMedidasAmparoSM) {
        this.lstDatosDadoMedidasAmparoSM = lstDatosDadoMedidasAmparoSM;
    }

    public ArrayList<UnidadesFamilia> getLstDatosDadoMedidasAmparoSF() {
        return lstDatosDadoMedidasAmparoSF;
    }

    public void setLstDatosDadoMedidasAmparoSF(ArrayList<UnidadesFamilia> lstDatosDadoMedidasAmparoSF) {
        this.lstDatosDadoMedidasAmparoSF = lstDatosDadoMedidasAmparoSF;
    }

    public CartesianChartModel getLineMedidasAmparo() {
        return lineMedidasAmparo;
    }

    public void setLineMedidasAmparo(CartesianChartModel lineMedidasAmparo) {
        this.lineMedidasAmparo = lineMedidasAmparo;
    }

    public CartesianChartModel getLineMedidasAmparoSexoVictima() {
        return lineMedidasAmparoSexoVictima;
    }

    public void setLineMedidasAmparoSexoVictima(CartesianChartModel lineMedidasAmparoSexoVictima) {
        this.lineMedidasAmparoSexoVictima = lineMedidasAmparoSexoVictima;
    }

    @PostConstruct
   public void init() {
        this.lineMedidasAmparo = graficaMedidasAmparo(anioSel);
        this.lineMedidasAmparoSexoVictima = graficaMedidasAmparoSexoVictima(anioSel);
        
    }
    
    private void reinit(){
    this.init();
    }
    
    public ControladorUnidadesFamiliaMedidasAmparo() {
        this.reinit();
    }

    private CartesianChartModel graficaMedidasAmparo(int anio) {
        CartesianChartModel model = new CartesianChartModel();
        try {
            lstMedidasAmparo = FUnidadesFamilia.obtenerDatosMedidasAmparo(anioSel);
            ChartSeries medidas_amparo = new ChartSeries();
            
            medidas_amparo.setLabel("Medidas Amparo");
            for (int i = 0; i < lstMedidasAmparo.size(); i++) {
                lstDatosDadoMedidasAmparo = FUnidadesFamilia.obtenerDatosDadoMedidasAmparoDadoAnio(anio, lstMedidasAmparo.get(i).getMedidas_de_amparo());
                medidas_amparo.set(lstMedidasAmparo.get(i).getMedidas_de_amparo(), lstDatosDadoMedidasAmparo.size());
            }
            model.addSeries(medidas_amparo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
    private CartesianChartModel graficaMedidasAmparoSexoVictima(int anio){
    CartesianChartModel model = new CartesianChartModel();
        try {
            lstMedidasAmparo = FUnidadesFamilia.obtenerDatosMedidasAmparo(anioSel);
            ChartSeries femenino = new ChartSeries();
            femenino.setLabel("femenino");
            for (int i = 0; i < lstMedidasAmparo.size(); i++) {
                lstDatosDadoMedidasAmparoSF = FUnidadesFamilia.ObtenerDatosDadoAnioMedidasAmparoSexoVictima(anio, lstMedidasAmparo.get(i).getMedidas_de_amparo(), "F");
                femenino.set(lstMedidasAmparo.get(i).getMedidas_de_amparo(), lstDatosDadoMedidasAmparoSF.size());
            }
            ChartSeries masculino = new ChartSeries();
            masculino.setLabel("masculino");
            for (int i = 0; i < lstMedidasAmparo.size(); i++) {
                lstDatosDadoMedidasAmparoSM = FUnidadesFamilia.ObtenerDatosDadoAnioMedidasAmparoSexoVictima(anio, lstMedidasAmparo.get(i).getMedidas_de_amparo(), "M");
                masculino.set(lstMedidasAmparo.get(i).getMedidas_de_amparo(), lstDatosDadoMedidasAmparoSM.size());
            }

            model.addSeries(femenino);
            model.addSeries(masculino);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
    
    
    
}
