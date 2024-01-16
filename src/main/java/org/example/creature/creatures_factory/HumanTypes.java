package org.example.creature.creatures_factory;

import org.example.creature.CreaturesEnum;
import org.example.device.DeviceTypes;

/**
 * Subtype of creatures - Human Types
 */
public enum HumanTypes {

    ADULT(CreaturesEnum.HUMAN),
    CHILD(CreaturesEnum.HUMAN);

    private final CreaturesEnum creatureType;


    HumanTypes(CreaturesEnum creatureType) {
        this.creatureType = creatureType;
    }
}
