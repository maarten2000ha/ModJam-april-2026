rootProject.name = "mod-jam-april-2026"
plugins {
    id("dev.scaffoldit") version "0.2.+"
}
hytale {
    manifest {
        Group = "com.example"
        Name = "modjamapril2026"
        Main = "com.example.modjamapril2026.modjamapril2026Plugin"
        IncludesAssetPack = true
        Dependencies = mapOf(
            "Hytale:NPC" to "*"
        )
    }
}