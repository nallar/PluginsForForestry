package net.minecraft.src.denoflionsx.items;

import java.util.HashMap;
import net.minecraft.src.denoflionsx.denLib.Colors;
import net.minecraft.src.denoflionsx.plugins.Forestry.Modules.newFuels.customFuel;

public class PfFContainer extends multiItem {

    private boolean multiPass = true;
    private HashMap<Integer, Integer> renderColors = new HashMap();

    public PfFContainer(int par1, String name) {
        super(par1, name);
    }

    public void addRenderColor(int dmg, int color) {
        renderColors.put(dmg, color);
    }

    public void setAllRenderColor(int color) {
        for (int i = 0; i != customFuel.numOfContainers; i++) {
            if (i == 0) {
                renderColors.put(i, Colors.Values.WHITE.getColor());
            } else {
                renderColors.put(i, color);
            }
        }
    }

    @Override
    public int getColorFromDamage(int par1, int par2) {
        if (par2 > 0) {
            return this.renderColors.get(par1);
        } else {
            return Colors.Values.WHITE.getColor();
        }
    }

    @Override
    public int getIconFromDamageForRenderPass(int par1, int par2) {
        if (par2 > 0) {
            return super.getIconFromDamageForRenderPass(par1, par2) + 1;
        }
        return super.getIconFromDamageForRenderPass(par1, par2);
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return this.multiPass;
    }
}