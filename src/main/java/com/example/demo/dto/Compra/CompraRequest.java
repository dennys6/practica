
package com.example.demo.dto.Compra;

import com.example.demo.dto.DetalleCompra.DetalleCompraRequest;
import com.example.demo.entity.Proveedor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

public class CompraRequest {
    
    @NotNull(message="Proveedor no válido")
    private Proveedor proveedor;
    
    @NotEmpty(message="Detalle no válido")
    @Valid
    private List<DetalleCompraRequest> detalle;

    public CompraRequest() {
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<DetalleCompraRequest> getDetalle() {
        return detalle;
    }
    
}

