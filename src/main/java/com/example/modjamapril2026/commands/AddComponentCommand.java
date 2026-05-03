package com.example.modjamapril2026.commands;

import com.example.modjamapril2026.components.VillagerComponent;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.vector.Vector3d;
import com.hypixel.hytale.math.vector.Vector3f;
import com.hypixel.hytale.math.vector.Vector3i;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.modules.entity.component.TransformComponent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.npc.INonPlayerCharacter;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.npc.NPCPlugin;
import it.unimi.dsi.fastutil.Pair;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.joml.Vector3fc;

import java.awt.*;

/**
 * AddComponentCommand - Command collection for /.
 * <p>
 * Usage:
 * - / help - Show available commands
 */
public class AddComponentCommand extends AbstractPlayerCommand {

    public AddComponentCommand() {
        super("spawnVillager", "Spawn Villager");
    }

    @Override
    protected boolean canGeneratePermission() {
        return false; // No permission required for base command
    }


    @Override
    protected void execute(@NonNullDecl CommandContext context, @NonNullDecl Store<EntityStore> store, @NonNullDecl Ref<EntityStore> ref, @NonNullDecl PlayerRef playerRef, @NonNullDecl World world) {
        TransformComponent transform = store.getComponent(ref, TransformComponent.getComponentType());
        if (transform == null) {
            context.sendMessage(Message.raw("Could not resolve player position.").color(Color.RED));
            return;
        }

        Vector3d position = new Vector3d(transform.getPosition());
        Vector3f rotation = new Vector3f(0,0,0);
        position.add(0, 0, 2);

        Pair<Ref<EntityStore>, INonPlayerCharacter> result = NPCPlugin.get().spawnNPC(store, "Civilian_Klops_Gentleman", "Gerald",
                position, rotation);
        if (result != null) {
            // Successfully spawned®
            Ref<EntityStore> npcRef = result.first();
            // Retrieve the NPC interface if needed for further interaction
            INonPlayerCharacter npc = result.second();

            setupNPC(npcRef, store);

            VillagerComponent villager = store.getComponent(npcRef, VillagerComponent.getComponentType());
            if (villager != null) {
                context.sendMessage(Message.raw("✓ Villager spawned: " + villager.getName()).color(Color.GREEN));
            } else {
                context.sendMessage(Message.raw("✗ Component failed to attach!").color(Color.RED));
            }
        }
    }

    private void setupNPC(Ref<EntityStore> ref, Store<EntityStore> store) {
        VillagerComponent villager = new VillagerComponent("Gerald", Vector3i.ZERO);

       store.addComponent(ref, VillagerComponent.getComponentType(), villager);

    }
}
