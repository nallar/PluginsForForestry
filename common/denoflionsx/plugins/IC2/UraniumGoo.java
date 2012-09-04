package denoflionsx.plugins.IC2;

import denoflionsx.denLib.denLib;
import denoflionsx.items.multiItem;
import denoflionsx.plugins.Core.EnumToolTextures;

public class UraniumGoo extends multiItem{
    
    public final String Itemname = "Uranium Goo";
    public String ItemnameLowerCaseNoSpaces = denLib.toLowerCaseNoSpaces(Itemname);
    
    public UraniumGoo(int par1, String name) {
        super(par1, name);
        this.metaMap.put(Itemname,0);
        this.add(name,0,EnumToolTextures.ToolTextures.URANIUMGOO.getIndex(),Itemname,true);
    }
}