package denoflionsx;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import denoflionsx.Proxy.Proxy;
import denoflionsx.core.core;

@Mod(modid = "mod_PluginsforForestry", name = "Plugins for Forestry", version = "1.3 Beta", dependencies = "required-after:Forestry")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class PluginsforForestry {

    /*
     * This program is free software. It comes without any warranty, to the
     * extent permitted by applicable law. You can redistribute it and/or modify
     * it under the terms of the Do What The Fuck You Want To Public License,
     * Version 2, as published by Sam Hocevar. See
     * http://sam.zoy.org/wtfpl/COPYING for more details.
     */
    public static final String texture = "/denoflionsx/spritesheet.png";
    @SidedProxy(clientSide = "denoflionsx.Proxy.ProxyClient", serverSide = "denoflionsx.Proxy.ProxyServer")
    public static Proxy proxy;

    @PreInit
    public void preLoad(FMLPreInitializationEvent event) {
        core.PfFCore.PreLoad();
    }

    @Init
    public void load(FMLInitializationEvent event) {
        core.PfFCore.runCoreFunctions();
        core.PfFCore.setupUniversalItems();
    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent evt) {
        core.registerEarlyPlugins();
        core.registerSpecial();
    }
}