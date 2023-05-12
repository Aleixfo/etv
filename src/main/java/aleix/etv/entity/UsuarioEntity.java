package aleix.etv.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Data
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido1", nullable = false)
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "id_poblacion")
    private int idPoblacion;

    @Column(name = "num_reservas")
    private int numReservas = 0;

    @Column(name = "num_comentarios")
    private int numComentarios = 0;

    @Column(name = "total_gastado")
    private BigDecimal totalGastado = BigDecimal.ZERO;

    @Column(name = "valoracion_dueño")
    private BigDecimal valoracionDueño = BigDecimal.ZERO;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "num_identificacion")
    private String numIdentificacion;

    //@Column(name = "tipo_identificacion")
    //private TipoIdentificacionEnum tipoIdentificacion;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "verificado")
    private boolean verificado = false;

    // Getters and Setters (Omitted for brevity)
}

