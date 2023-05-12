package aleix.etv.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Usuario {

    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String contraseña;
    private Long idPoblacion;
    private int numReservas;
    private int numComentarios;
    private BigDecimal totalGastado;
    private BigDecimal valoracionDueño;
    private String telefono;
    private String descripcion;
    private String numIdentificacion;
    //private TipoIdentificacionEnum tipoIdentificacion;
    private LocalDate fechaRegistro;
    private boolean verificado;

}
