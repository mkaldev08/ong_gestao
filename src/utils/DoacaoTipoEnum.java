/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author manuelkalueka
 */
public enum DoacaoTipoEnum {
    MONETARIA("MONETARIA"),
    BEM("BEM");

    private final String tipo;

    DoacaoTipoEnum(String tipo
    ) {
        this.tipo = tipo;
    }

    public String getTypeE() {
        return tipo;
    }
}
