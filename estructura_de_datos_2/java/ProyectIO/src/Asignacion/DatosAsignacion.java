/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignacion;

/**
 *
 * @author 57300
 */
public class DatosAsignacion {
   private String costo;
    private boolean rayado;
    private boolean dobleRayado;
    private boolean asignado;
    private boolean colorea;
    
    public DatosAsignacion(final String costo) {
        this.costo = costo;
        this.rayado = false;
        this.dobleRayado = false;
        this.asignado = false;
        this.colorea = false;
    }
    
    public String getCosto() {
        return this.costo;
    }
    
    public void setCosto(final String costo) {
        this.costo = costo;
    }
    
    public boolean isRayado() {
        return this.rayado;
    }
    
    public void setRayado(final boolean rayado) {
        this.rayado = rayado;
    }
    
    public boolean isDobleRayado() {
        return this.dobleRayado;
    }
    
    public void setDobleRayado(final boolean dobleRayado) {
        this.dobleRayado = dobleRayado;
    }
    
    public boolean isAsignado() {
        return this.asignado;
    }
    
    public void setAsignado(final boolean asignado) {
        this.asignado = asignado;
    }
    
    public boolean isColorea() {
        return this.colorea;
    }
    
    public void setColorea(final boolean colorea) {
        this.colorea = colorea;
    }
}
