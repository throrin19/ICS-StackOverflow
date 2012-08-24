package com.throrinstudio.android.common.libs.entities;
/**
 * Classe utilisée pour les AlertDialog Menu
 * quand un item est accompagné d'un icon
 * @author WEB
 *
 */
public class Item{
    public final String text;
    public final int icon;
    public final String code;
    
    public final Object value;
    
    public Item(String text, Integer icon, String code) {
        this.text = text;
        this.icon = icon;
        this.code = code;
        value = null;
    }
    
    public Item(String text, Integer icon, String code, Object val) {
        this.text = text;
        this.icon = icon;
        this.code = code;
        value = val;
    }
    
    @Override
    public String toString() {
        return text;
    }
}