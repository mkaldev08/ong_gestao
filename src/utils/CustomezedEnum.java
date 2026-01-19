/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author manuelkalueka
 */
public enum CustomezedEnum {

    ATIVO("ATIVO"),
    ENCERRADO("ENCERRADO");
    private final String status;

    CustomezedEnum(String status
    ) {
        this.status = status;
    }

    public String getStatusType() {
        return status;
    }
}
