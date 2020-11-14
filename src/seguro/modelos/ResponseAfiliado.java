
package seguro.modelos;

import java.util.Date;

/**
 *
 * @author A
 */
public class ResponseAfiliado {
    private String estadoAfiliado;
    private Double montoDeducible;
    private Double montoAcumulado;
    private Double montoPendiente;

    public ResponseAfiliado() {
        
    }

    public ResponseAfiliado(String estadoAfiliado, Double montoDeducible, Double montoAcumulado, Double montoPendiente) {
        this.estadoAfiliado = estadoAfiliado;
        this.montoDeducible = montoDeducible;
        this.montoAcumulado = montoAcumulado;
        this.montoPendiente = montoPendiente;
    }

    public String getEstadoAfiliado() {
        return estadoAfiliado;
    }

    public void setEstadoAfiliado(String estadoAfiliado) {
        this.estadoAfiliado = estadoAfiliado;
    }

    public Double getMontoDeducible() {
        return montoDeducible;
    }

    public void setMontoDeducible(Double montoDeducible) {
        this.montoDeducible = montoDeducible;
    }

    public Double getMontoAcumulado() {
        return montoAcumulado;
    }

    public void setMontoAcumulado(Double montoAcumulado) {
        this.montoAcumulado = montoAcumulado;
    }

    public Double getMontoPendiente() {
        return montoPendiente;
    }

    public void setMontoPendiente(Double montoPendiente) {
        this.montoPendiente = montoPendiente;
    }

  
}
