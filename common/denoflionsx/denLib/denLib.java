package denoflionsx.denLib;

import cpw.mods.fml.common.Loader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class denLib {
    
    public static boolean detect(String mod) {
        return LOADER.FML.isModLoaded(mod);
    }

    public static Item getItem(String mod, String name) {
        boolean hooked = false;
        Item temp = null;

        try {
            temp = (Item) Class.forName(mod).getField(name).get(null);
            hooked = true;
        } catch (Exception ex) {
            print("" + ex);
            hooked = false;
        } finally {
            if (hooked) {
                //print("Item " + temp.getItemName() + " hooked!");
            }
        }

        return temp;
    }

    public static ItemStack getItemStack(String mod, String name) {
        boolean hooked = false;
        ItemStack temp = null;


        try {
            temp = (ItemStack) Class.forName(mod).getField(name).get(null);
            hooked = true;
        } catch (Exception ex) {
            print("" + ex);
            hooked = false;
        } finally {
            if (hooked) {
                //print("Item " + temp.getItemName() + " hooked!");
            }

            return temp;
        }
    }

    public static Block getBlock(String mod, String name) {
        boolean hooked = false;
        Block temp = null;

        try {
            temp = (Block) Class.forName(mod).getField(name).get(null);
            hooked = true;
        } catch (Exception ex) {
            print("" + ex);
            hooked = false;
        } finally {
            if (hooked) {
                //print("Block " + temp.getBlockName() + " hooked!");
            }
        }

        return temp;
    }

    public static void print(String msg) {

        System.out.println(msg);

    }

    public static boolean convertToBoolean(String bool) {
        bool = bool.toLowerCase();
        if (bool.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    public static String toLowerCaseNoSpaces(String s) {
        return toNoSpaces(s).toLowerCase();
    }

    public static String Hash(String tag) {
        byte[] bytes = tag.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(bytes);
            String hash = "";
            for (byte b : md5) {
                hash = hash + String.valueOf(b);
            }
            hash = hash.replace("-", "");
            tag = hash;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tag;
    }

    public static String toNoSpaces(String s) {
        return s.replaceAll("\\s", "");
    }

    public static String addName(String name) {
            ModLoader.addLocalization("item." + denLib.toLowerCaseNoSpaces(name) + ".name", name);
            return "item." + denLib.toLowerCaseNoSpaces(name);
    }

    public static void classSnoop(String param1) {
        try {
            Class c = Class.forName(param1);
            print("--------------------");
            print("Class Snoop Engaged");
            print("Class: " + param1);
            print("--------------------");
            Method[] m = c.getDeclaredMethods();
            Field[] f = c.getDeclaredFields();
            print("Defined Methods");
            print("--------------------");
            for (int i = 0; i < m.length; i++) {
                print(m[i].getName());
            }
            print("--------------------");
            print("Defined Fields");
            print("--------------------");
            for (int i = 0; i < f.length; i++) {
                print(f[i].getName());
            }
            print("--------------------");
            print("End of Snoop");
            print("--------------------");
        } catch (Exception ex) {
        }

    }
    
    public static enum LOADER{
        MODLOADER("ModLoader"),
        FML("FML");
        
        private String mode;
        private LOADER(String mode){
            this.mode = mode;
        }
        
        public boolean isModLoaded(String mod){
            if (this.mode.equals("ModLoader")){
                return ModLoader.isModLoaded(mod);
            }else if (this.mode.equals("FML")){
                return Loader.isModLoaded(mod);
            }
            return false;
        }
    }
}