package com.example.modjamapril2026.components;

import com.example.modjamapril2026.villager.JobType;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.codec.codecs.EnumCodec;
import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class JobComponent implements Component<EntityStore> {

    private static ComponentType<EntityStore, JobComponent> TYPE;

    public static void setComponentType(ComponentType<EntityStore, JobComponent> componentType) {
        TYPE = componentType;
    }

    public static ComponentType<EntityStore, JobComponent> getComponentType() {
        return TYPE;
    }

    public static final EnumCodec<JobType> JobTypeCodec = new EnumCodec<>(JobType.class);

    public static final BuilderCodec<JobComponent> CODEC = BuilderCodec
            .builder(JobComponent.class, JobComponent::new)
            .append(
                    new KeyedCodec<>("JobTitle", JobTypeCodec),
                    (component, value) -> component.job = value,
                    component -> component.job
            ).add()
            .build();

    private JobType job;

    public JobComponent() {}

    public JobComponent(final JobType job) {
        this.job = job;
    }

    @NonNullDecl
    @Override
    public JobComponent clone() {
        return new JobComponent(this.job);
    }

    @Override
    public String toString() {
        return "JobComponent{jobName=" + job.name() + "}";
    }
}
