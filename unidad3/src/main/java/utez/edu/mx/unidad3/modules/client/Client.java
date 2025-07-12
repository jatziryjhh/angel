package utez.edu.mx.unidad3.modules.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.jspecify.annotations.NonNull;
import utez.edu.mx.unidad3.modules.warehouse.Warehouse;

import java.util.List;

/*
01.-Crear los atributos propios de la entidad
02.-Crear los atributos de relación
03.-Crear los constructores
04.-Crear getters y setters
 */
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ][\\sa-zA-ZáéíóúÁÉÍÓÚñÑ]{2,}$",message = "Solamente se aceptan letras")
    @NotNull(message = "Favor de ingresar los datos")
    @NotBlank(message = "Favor de no dejar los datos en blanco")
    @Column(name = "name",nullable = false)
    private String name;

    @Size(min=10,max=10,message = "Debe ser de al menos 10 digitos")
    @Pattern(regexp = "^\\d+$",message = "Solamente se aceptan numeros")
    @NotNull(message = "Favor de ingresar los datos")
    @NotBlank(message = "Favor de no dejar los datos en blanco")
    @Column(name="phone",nullable = false)
    private String phone;
    @Email(message = "Favor de colocar un correo valido")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]{2,}(\\.[a-zA-Z0-9._-]{2,}){1,2}$",message = "Favor de colocar un correo valido")
    @NotNull(message = "Favor de ingresar los datos")
    @NotBlank(message = "Favor de no dejar los datos en blanco")
    @Column(name = "email",nullable = false)
    private String email;
    //02.-
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Warehouse> warehouses;

    //03.-
    public Client() {
    }

    //04.-
    public Client(Long id, String name, String phone, String email, List<Warehouse> warehouses) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.warehouses = warehouses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
