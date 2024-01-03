package org.example.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.creature.Creature;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
public abstract class Location {
    private final String id;

    public Location(String id) {
        this.id = id;
    }

}
