
package seguro.modelos;

import java.util.Date;

/**
 *
 * @author A
 */
public class ModelAfiliado {
    private Long codigoPaciente;
    private Date fechaNacimiento;

    public ModelAfiliado() {
        
    }

    public ModelAfiliado(int nitProveedor, Long codigoPaciente, Date fechaNacimiento, int fechaCobertura) {
       
        this.codigoPaciente = codigoPaciente;
        this.fechaNacimiento = fechaNacimiento;
       
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


    
}
