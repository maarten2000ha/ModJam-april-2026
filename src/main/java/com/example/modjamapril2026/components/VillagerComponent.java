package com.example.modjamapril2026.components;

import com.example.modjamapril2026.villager.JobType;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.EnumCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class VillagerComponent implements Component<EntityStore> {

    private static ComponentType<EntityStore, VillagerComponent> TYPE;

    public static void setComponentType(ComponentType<EntityStore, VillagerComponent> componentType) {
        TYPE = componentType;
    }

    public static ComponentType<EntityStore, VillagerComponent> getComponentType() {
        return TYPE;
    }

    public static final BuilderCodec<VillagerComponent> CODEC = BuilderCodec
            .builder(VillagerComponent.class, VillagerComponent::new)
            .append(
                    new KeyedCodec<>("Name", Codec.STRING),
                    (component, value) -> component.name = value,
                    component -> component.name
            ).add()
            .build();

    private String name;

    public VillagerComponent() {
        this.name = "";
    }

    public VillagerComponent(String name) {
        this.name = name;
    }

    @NullableDecl
    @Override
    public Component<EntityStore> clone() {
        return new VillagerComponent(this.name);
    }
}
