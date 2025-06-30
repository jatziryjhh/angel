package utez.edu.mx.unidad3.modules.cede;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import utez.edu.mx.unidad3.modules.warehouse.Warehouse;

import java.util.List;

/*
01.-Crear los atributos propios de la entidad
02.-Crear los atributos de relación
03.-Crear los constructores
04.-Crear getters y setters
 */
@Entity
@Table(name = "cede")
public class Cede {
    //01.-
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="clave",nullable = false)
    private String clave;
    @Column(name="state",nullable = false)
    private String state;
    @Column(name="city",nullable = false)
    private String city;

    //02.-
    @OneToMany(mappedBy = "cede")
    @JsonIgnore
    private List<Warehouse> warehouses;

    //03.-
    public Cede() {
    }

    //04.-
    public Cede(Long id, String clave, String state, String city, List<Warehouse> warehouses) {
        this.id = id;
        this.clave = clave;
        this.state = state;
        this.city = city;
        this.warehouses = warehouses;
    }

    //Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
