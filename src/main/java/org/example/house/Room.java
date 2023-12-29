package org.example.house;

import lombok.AllArgsConstructor;
import org.example.device.Device;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Room {

    private String name;
    private List<Device> devices = new ArrayList<>();

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }


}
