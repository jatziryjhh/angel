package utez.edu.mx.unidad3.modules.warehouse;

import jakarta.persistence.*;
import utez.edu.mx.unidad3.modules.cede.Cede;
import utez.edu.mx.unidad3.modules.client.Client;

/*
01.-Crear los atributos propios de la entidad
02.-Crear los atributos de relación
03.-Crear los constructores
04.-Crear getters y setters
 */
@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="clave",nullable = false)
    private String clave;
    @Column(name="status",nullable = false)
    private String status;
    @Column(name="sell_price",nullable = false)
    private Double sellPrice;
    @Column(name="rent_price",nullable = false)
    private Double rentPrice;

    //02.-
    @ManyToOne
    @JoinColumn(name = "id_cede", nullable = false)
    private Cede cede;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    //03.-
    public Warehouse() {
    }

    //04.-
    public Warehouse(Long id, String clave, String status, Double sellPrice, Double rentPrice, Cede cede, Client client) {
        this.id = id;
        this.clave = clave;
        this.status = status;
        this.sellPrice = sellPrice;
        this.rentPrice = rentPrice;
        this.cede = cede;
        this.client = client;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Cede getCede() {
        return cede;
    }

    public void setCede(Cede cede) {
        this.cede = cede;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
