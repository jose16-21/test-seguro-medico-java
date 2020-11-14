
package seguro.modelos;

import java.util.Date;

/**
 *
 * @author A
 */
public class ResponseProveedor {
    private int nitProveedor;
    private Long codigoPaciente;
    private Date fechaNacimiento;
    private Date fechaCobertura;
    private Date fechaConsulta;
    private String respuestaServicio;

    public ResponseProveedor() {
        
    }

   public ResponseProveedor(int nitProveedor, Long codigoPaciente, Date fechaNacimiento, Date fechaCobertura, Date fechaConsulta, String respuestaServicio) {
        this.nitProveedor = nitProveedor;
        this.codigoPaciente = codigoPaciente;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCobertura = fechaCobertura;
        this.fechaConsulta = fechaConsulta;
        this.respuestaServicio = respuestaServicio;
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

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getRespuestaServicio() {
        return respuestaServicio;
    }

    public void setRespuestaServicio(String respuestaServicio) {
        this.respuestaServicio = respuestaServicio;
    }

  

   
    
}
