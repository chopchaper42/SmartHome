package org.example.creature.creatures_factory;

import org.example.creature.CreaturesEnum;


/**
 * Subtype of creatures - Animal Types
 */
public enum AnimalTypes {

    CAT(CreaturesEnum.ANIMAL);

    private final CreaturesEnum creatureType;

    AnimalTypes(CreaturesEnum creatureType) {
        this.creatureType = creatureType;
    }
}
