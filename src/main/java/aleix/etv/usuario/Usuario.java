package aleix.etv.usuario;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "id_poblacion")
    private Integer idPoblacion;

    @Column(name = "num_reservas", columnDefinition = "INT DEFAULT 0")
    private Integer numReservas = 0;

    @Column(name = "num_comentarios", columnDefinition = "INT DEFAULT 0")
    private Integer numComentarios = 0;

    @Column(name = "valoracion_dueño", columnDefinition = "DECIMAL(4, 2) DEFAULT 0")
    private BigDecimal valoracionDueño = BigDecimal.ZERO;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "num_identificacion", length = 50)
    private String numIdentificacion;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "verificado", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean verificado = false;

}
