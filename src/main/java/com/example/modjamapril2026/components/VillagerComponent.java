package com.example.modjamapril2026.components;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.math.vector.Vector3i;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class VillagerComponent implements Component<EntityStore> {

    private String name;
    private Vector3i homeBed;

    public VillagerComponent() {
        this.name = "William";
    }

    public VillagerComponent(String name, Vector3i homeBed) {
        this.name = name;
        this.homeBed = homeBed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector3i getHomeBed() {
        return homeBed;
    }

    public void setHomeBed(Vector3i homeBed) {
        this.homeBed = homeBed;
    }

    @NullableDecl
    @Override
    public Component<EntityStore> clone() {
        return new VillagerComponent(this.name, this.homeBed);
    }

    private static ComponentType<EntityStore, VillagerComponent> TYPE;

    public static void setComponentType(ComponentType<EntityStore, VillagerComponent> componentType) {
        TYPE = componentType;
    }

    public static ComponentType<EntityStore, VillagerComponent> getComponentType() {
        return TYPE;
    }

    public static final BuilderCodec<VillagerComponent> CODEC = BuilderCodec.builder(VillagerComponent.class, VillagerComponent::new)
            .append(
                    new KeyedCodec<>("Name", Codec.STRING),
                    (component, value) -> component.name = value,
                    component -> component.name
            ).add().append(new KeyedCodec<>("HomeBed", Vector3i.CODEC), (component, value) -> component.homeBed = value, villagerComponent -> villagerComponent.homeBed).add().build();
}
