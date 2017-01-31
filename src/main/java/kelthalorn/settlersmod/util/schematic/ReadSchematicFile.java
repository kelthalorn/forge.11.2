package kelthalorn.settlersmod.util.schematic;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import org.jnbt.*;

public class ReadSchematicFile
{

    public ReadSchematicFile() {

    }

    private static Tag getChildTag(Map<String, Tag> items, String key, Class<? extends Tag> expected) {
        Tag tag = items.get(key);
        return tag;
    }

    public void readFile(InputStream in) {
        try{

            NBTInputStream nbt = new NBTInputStream(in);
            CompoundTag backuptag = (CompoundTag) nbt.readTag();
            Map<String, Tag> tagCollection = backuptag.getValue();

            short width = (Short)getChildTag(tagCollection, "Width", ShortTag.class).getValue();
            short height = (Short) getChildTag(tagCollection, "Height", ShortTag.class).getValue();
            short length = (Short) getChildTag(tagCollection, "Length", ShortTag.class).getValue();

            byte[] blocks = (byte[]) getChildTag(tagCollection, "Blocks", ByteArrayTag.class).getValue();
            byte[] data = (byte[]) getChildTag(tagCollection, "Data", ByteArrayTag.class).getValue();

            List entities = (List) getChildTag(tagCollection, "Entities", ListTag.class).getValue();
            List tileentities = (List) getChildTag(tagCollection, "TileEntities", ListTag.class).getValue();
            nbt.close();
            in.close();
            System.out.println(entities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean generateStructure(World world, BlockPos pos) {

        WorldServer worldServer = (WorldServer)world;
        MinecraftServer minecraftServer = world.getMinecraftServer();
        TemplateManager templateManager = worldServer.getStructureTemplateManager();
        Template template = templateManager.get(minecraftServer, new ResourceLocation("settlersmod", "schematic/test.schematic"));

        if(template == null)
        {
            return false;
        }

        template.addBlocksToWorld(world, pos, new PlacementSettings());

        return true;
    }
}
