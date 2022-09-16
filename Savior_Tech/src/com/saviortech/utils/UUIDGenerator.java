/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.utils;

import java.util.UUID;

/**
 *
 * @author freec
 */
public class UUIDGenerator {

    public UUID getUuid() {
        UUID gfg = UUID.randomUUID();
        System.out.println("UUID: " + gfg);
        return gfg;
    }

}
