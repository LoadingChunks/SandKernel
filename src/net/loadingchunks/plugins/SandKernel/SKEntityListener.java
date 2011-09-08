
package net.loadingchunks.plugins.SandKernel;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

/**
 * Sample block listener
 * @author Dinnerbone
 */
public class SKEntityListener<SandKernel> extends EntityListener {
    private final SandKernel plugin;

    public SKEntityListener(final SandKernel plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEntityDamage(EntityDamageEvent event) {
    	if(!(event.getEntity() instanceof Block))
    		return;
    	
    	Block block = (Block)event.getEntity();
    	
    	if(event.getCause() == EntityDamageEvent.DamageCause.LAVA && block.getType() == Material.SAND)
    	{
    		block.setType(Material.GLASS);
    		event.setCancelled(true);
    	}
    	
    	if(block.getType() == Material.GLASS)
    		event.setCancelled(true);
    }
}
