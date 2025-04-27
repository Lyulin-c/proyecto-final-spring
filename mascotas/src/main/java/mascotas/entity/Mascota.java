package mascotas.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNac;
    private String raza;
    private Double peso;
    private Boolean tieneChip;
    private String urlFoto;

    @ManyToOne
    private Propietario propietario;
}

