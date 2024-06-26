package org.example.Entidades;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private Integer id;
    private List<Medicamento> medicamentos;
    private boolean estado;
}
