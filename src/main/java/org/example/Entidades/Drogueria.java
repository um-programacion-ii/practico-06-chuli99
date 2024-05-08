package org.example.Entidades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drogueria {
    public void procesarPedido(Pedido pedido){
        System.out.println("Pedido procesado por la Drogueria");
    }
}
