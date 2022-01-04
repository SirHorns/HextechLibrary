package hextechlibrary.objects.lol.itemjson.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.objects.lol.itemjson.item.data.ItemData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@JsonDeserialize(builder = ItemsData.Builder.class)
public class ItemsData {
    private final List<ItemData> itemDataList;

    public ItemsData(Builder builder) {
        this.itemDataList = builder.itemData;
    }

    public List<ItemData> getItemDataList() {
        return itemDataList;
    }

    public ItemData getItemByID(int id){
        for(ItemData data : this.itemDataList){
            if(data.getId() == id){
                return data;
            }
        }
        return  null;
    }

    public ItemData getItemByName(String name){
        String searchLower = name.toLowerCase();

        for(ItemData data : this.itemDataList){
            if(data.getName().toLowerCase(Locale.ROOT).equals(searchLower)){
                return data;
            }
        }
        return null;
    }

    /*
    Physical Offense
    - attack damage
    - armor penetration

    Magical Offense
    - ability power
    - magic penetration

    Misc Stats
    - attack speed
    - critical strike chance
    - life steal
    - ability haste
    - mana
    - mana regeneration
    - heal and shield power
    - omnivamp

    Defense
    - health
    - health regeneration
    - armor
    - magic resistance
     */

    public List<ItemData> getItemsByBoots(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Boots");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
    }
    /**
     *
     * @return
     */
     public List<ItemData> getItemsByManaRegen(){
     List<ItemData> itemList = new ArrayList<>();
     for(ItemData data : this.itemDataList){
     boolean flag = data.getTags().contains("ManaRegen");
     if(flag){
     itemList.add(data);
     }
     }
     return itemList;
     }
     /**
     *
     * @return
     */
    public List<ItemData> getItemsByHealthRegen(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("HealthRegen");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByHealth(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Health");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByCriticalStrike(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("CriticalStrike");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsBySpellDamage(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("SpellDamage");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByMana(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Mana");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByArmor(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Armor");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsBySpellBlock(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("SpellBlock");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByLifeSteal(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("LifeSteal");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsBySpellVamp(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("pellVamp");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByJungle(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Jungle");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByDamage(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Damage");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByLane(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Lane");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByAttackSpeed(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("AttackSpeed");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByOnHit(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("OnHit");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByConsumable(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Consumable");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByActive(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Active");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByStealth(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Stealth");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByVision(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Vision");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByCooldownReduction(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("CooldownReduction");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByNonbootsMovement(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("NonbootsMovement");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByAbilityHaste(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("AbilityHaste");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByTenacity(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Tenacity");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByMagicPenetration(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("MagicPenetration");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByArmorPenetration(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("ArmorPenetration");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByAura(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Aura");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsBySlow(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Slow");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByTrinket(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("Trinket");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}
    /**
     *
     * @return
     */
    public List<ItemData> getItemsByGoldPer(){
        List<ItemData> itemList = new ArrayList<>();
        for(ItemData data : this.itemDataList){
            boolean flag = data.getTags().contains("ItemsByGoldPer");
            if(flag){
                itemList.add(data);
            }
        }
        return itemList;
}


    @JsonPOJOBuilder
    public static class Builder{
        private List<ItemData> itemData;

        public Builder withItemDataList(List<ItemData> itemData){
            this.itemData = itemData;
            return this;
        }

        public ItemsData build(){
            ItemsData itemsData = new ItemsData(this);
            //TODO: validate JSOn to Data object.
            return itemsData;
        }
    }
}
