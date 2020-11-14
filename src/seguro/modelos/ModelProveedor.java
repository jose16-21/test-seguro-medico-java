
package seguro.modelos;

import java.util.Date;

/**
 *
 * @author A
 */
public class ModelProveedor {
    private int nitProveedor;
    private Long codigoPaciente;
    private Date fechaNacimiento;
    private Date fechaCobertura;

    public ModelProveedor() {
        
    }

    public ModelProveedor(int nitProveedor, Long codigoPaciente, Date fechaNacimiento, Date fechaCobertura) {
        this.nitProveedor = nitProveedor;
        this.codigoPaciente = codigoPaciente;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCobertura = fechaCobertura;
    }
      

    public int getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(int nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public Long getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Long codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaCobertura() {
        return fechaCobertura;
    }

    public void setFechaCobertura(Date fechaCobertura) {
        this.fechaCobertura = fechaCobertura;
    }


    
    
}
