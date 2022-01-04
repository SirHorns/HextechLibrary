package hextechlibrary.objects.lol.itemjson.item.basic;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "FlatHPPoolMod",
        "rFlatHPModPerLevel",
        "FlatMPPoolMod",
        "rFlatMPModPerLevel",
        "PercentHPPoolMod",
        "PercentMPPoolMod",
        "FlatHPRegenMod",
        "rFlatHPRegenModPerLevel",
        "PercentHPRegenMod",
        "FlatMPRegenMod",
        "rFlatMPRegenModPerLevel",
        "PercentMPRegenMod",
        "FlatArmorMod",
        "rFlatArmorModPerLevel",
        "PercentArmorMod",
        "rFlatArmorPenetrationMod",
        "rFlatArmorPenetrationModPerLevel",
        "rPercentArmorPenetrationMod",
        "rPercentArmorPenetrationModPerLevel",
        "FlatPhysicalDamageMod",
        "rFlatPhysicalDamageModPerLevel",
        "PercentPhysicalDamageMod",
        "FlatMagicDamageMod",
        "rFlatMagicDamageModPerLevel",
        "PercentMagicDamageMod",
        "FlatMovementSpeedMod",
        "rFlatMovementSpeedModPerLevel",
        "PercentMovementSpeedMod",
        "rPercentMovementSpeedModPerLevel",
        "FlatAttackSpeedMod",
        "PercentAttackSpeedMod",
        "rPercentAttackSpeedModPerLevel",
        "rFlatDodgeMod",
        "rFlatDodgeModPerLevel",
        "PercentDodgeMod",
        "FlatCritChanceMod",
        "rFlatCritChanceModPerLevel",
        "PercentCritChanceMod",
        "FlatCritDamageMod",
        "rFlatCritDamageModPerLevel",
        "PercentCritDamageMod",
        "FlatBlockMod",
        "PercentBlockMod",
        "FlatSpellBlockMod",
        "rFlatSpellBlockModPerLevel",
        "PercentSpellBlockMod",
        "FlatEXPBonus",
        "PercentEXPBonus",
        "rPercentCooldownMod",
        "rPercentCooldownModPerLevel",
        "rFlatTimeDeadMod",
        "rFlatTimeDeadModPerLevel",
        "rPercentTimeDeadMod",
        "rPercentTimeDeadModPerLevel",
        "rFlatGoldPer10Mod",
        "rFlatMagicPenetrationMod",
        "rFlatMagicPenetrationModPerLevel",
        "rPercentMagicPenetrationMod",
        "rPercentMagicPenetrationModPerLevel",
        "FlatEnergyRegenMod",
        "rFlatEnergyRegenModPerLevel",
        "FlatEnergyPoolMod",
        "rFlatEnergyModPerLevel",
        "PercentLifeStealMod",
        "PercentSpellVampMod"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = Stats.Builder.class)
public class Stats {

    @JsonProperty("FlatHPPoolMod")
    private final int flatHPPoolMod;
    @JsonProperty("rFlatHPModPerLevel")
    private final int rFlatHPModPerLevel;
    @JsonProperty("FlatMPPoolMod")
    private final int flatMPPoolMod;
    @JsonProperty("rFlatMPModPerLevel")
    private final int rFlatMPModPerLevel;
    @JsonProperty("PercentHPPoolMod")
    private final int percentHPPoolMod;
    @JsonProperty("PercentMPPoolMod")
    private final int percentMPPoolMod;
    @JsonProperty("FlatHPRegenMod")
    private final int flatHPRegenMod;
    @JsonProperty("rFlatHPRegenModPerLevel")
    private final int rFlatHPRegenModPerLevel;
    @JsonProperty("PercentHPRegenMod")
    private final int percentHPRegenMod;
    @JsonProperty("FlatMPRegenMod")
    private final int flatMPRegenMod;
    @JsonProperty("rFlatMPRegenModPerLevel")
    private final int rFlatMPRegenModPerLevel;
    @JsonProperty("PercentMPRegenMod")
    private final int percentMPRegenMod;
    @JsonProperty("FlatArmorMod")
    private final int flatArmorMod;
    @JsonProperty("rFlatArmorModPerLevel")
    private final int rFlatArmorModPerLevel;
    @JsonProperty("PercentArmorMod")
    private final int percentArmorMod;
    @JsonProperty("rFlatArmorPenetrationMod")
    private final int rFlatArmorPenetrationMod;
    @JsonProperty("rFlatArmorPenetrationModPerLevel")
    private final int rFlatArmorPenetrationModPerLevel;
    @JsonProperty("rPercentArmorPenetrationMod")
    private final int rPercentArmorPenetrationMod;
    @JsonProperty("rPercentArmorPenetrationModPerLevel")
    private final int rPercentArmorPenetrationModPerLevel;
    @JsonProperty("FlatPhysicalDamageMod")
    private final int flatPhysicalDamageMod;
    @JsonProperty("rFlatPhysicalDamageModPerLevel")
    private final int rFlatPhysicalDamageModPerLevel;
    @JsonProperty("PercentPhysicalDamageMod")
    private final int percentPhysicalDamageMod;
    @JsonProperty("FlatMagicDamageMod")
    private final int flatMagicDamageMod;
    @JsonProperty("rFlatMagicDamageModPerLevel")
    private final int rFlatMagicDamageModPerLevel;
    @JsonProperty("PercentMagicDamageMod")
    private final int percentMagicDamageMod;
    @JsonProperty("FlatMovementSpeedMod")
    private final int flatMovementSpeedMod;
    @JsonProperty("rFlatMovementSpeedModPerLevel")
    private final int rFlatMovementSpeedModPerLevel;
    @JsonProperty("PercentMovementSpeedMod")
    private final int percentMovementSpeedMod;
    @JsonProperty("rPercentMovementSpeedModPerLevel")
    private final int rPercentMovementSpeedModPerLevel;
    @JsonProperty("FlatAttackSpeedMod")
    private final int flatAttackSpeedMod;
    @JsonProperty("PercentAttackSpeedMod")
    private final int percentAttackSpeedMod;
    @JsonProperty("rPercentAttackSpeedModPerLevel")
    private final int rPercentAttackSpeedModPerLevel;
    @JsonProperty("rFlatDodgeMod")
    private final int rFlatDodgeMod;
    @JsonProperty("rFlatDodgeModPerLevel")
    private final int rFlatDodgeModPerLevel;
    @JsonProperty("PercentDodgeMod")
    private final int percentDodgeMod;
    @JsonProperty("FlatCritChanceMod")
    private final int flatCritChanceMod;
    @JsonProperty("rFlatCritChanceModPerLevel")
    private final int rFlatCritChanceModPerLevel;
    @JsonProperty("PercentCritChanceMod")
    private final int percentCritChanceMod;
    @JsonProperty("FlatCritDamageMod")
    private final int flatCritDamageMod;
    @JsonProperty("rFlatCritDamageModPerLevel")
    private final int rFlatCritDamageModPerLevel;
    @JsonProperty("PercentCritDamageMod")
    private final int percentCritDamageMod;
    @JsonProperty("FlatBlockMod")
    private final int flatBlockMod;
    @JsonProperty("PercentBlockMod")
    private final int percentBlockMod;
    @JsonProperty("FlatSpellBlockMod")
    private final int flatSpellBlockMod;
    @JsonProperty("rFlatSpellBlockModPerLevel")
    private final int rFlatSpellBlockModPerLevel;
    @JsonProperty("PercentSpellBlockMod")
    private final int percentSpellBlockMod;
    @JsonProperty("FlatEXPBonus")
    private final int flatEXPBonus;
    @JsonProperty("PercentEXPBonus")
    private final int percentEXPBonus;
    @JsonProperty("rPercentCooldownMod")
    private final int rPercentCooldownMod;
    @JsonProperty("rPercentCooldownModPerLevel")
    private final int rPercentCooldownModPerLevel;
    @JsonProperty("rFlatTimeDeadMod")
    private final int rFlatTimeDeadMod;
    @JsonProperty("rFlatTimeDeadModPerLevel")
    private final int rFlatTimeDeadModPerLevel;
    @JsonProperty("rPercentTimeDeadMod")
    private final int rPercentTimeDeadMod;
    @JsonProperty("rPercentTimeDeadModPerLevel")
    private final int rPercentTimeDeadModPerLevel;
    @JsonProperty("rFlatGoldPer10Mod")
    private final int rFlatGoldPer10Mod;
    @JsonProperty("rFlatMagicPenetrationMod")
    private final int rFlatMagicPenetrationMod;
    @JsonProperty("rFlatMagicPenetrationModPerLevel")
    private final int rFlatMagicPenetrationModPerLevel;
    @JsonProperty("rPercentMagicPenetrationMod")
    private final int rPercentMagicPenetrationMod;
    @JsonProperty("rPercentMagicPenetrationModPerLevel")
    private final int rPercentMagicPenetrationModPerLevel;
    @JsonProperty("FlatEnergyRegenMod")
    private final int flatEnergyRegenMod;
    @JsonProperty("rFlatEnergyRegenModPerLevel")
    private final int rFlatEnergyRegenModPerLevel;
    @JsonProperty("FlatEnergyPoolMod")
    private final int flatEnergyPoolMod;
    @JsonProperty("rFlatEnergyModPerLevel")
    private final int rFlatEnergyModPerLevel;
    @JsonProperty("PercentLifeStealMod")
    private final int percentLifeStealMod;
    @JsonProperty("PercentSpellVampMod")
    private final int percentSpellVampMod;

    public Stats(Builder builder) {
        this.flatHPPoolMod = builder.flatHPPoolMod;
        this.rFlatHPModPerLevel = builder.rFlatHPModPerLevel;
        this.flatMPPoolMod = builder.flatMPPoolMod;
        this.rFlatMPModPerLevel = builder.rFlatMPModPerLevel;
        this.percentHPPoolMod = builder.percentHPPoolMod;
        this.percentMPPoolMod = builder.percentMPPoolMod;
        this.flatHPRegenMod = builder.flatHPRegenMod;
        this.rFlatHPRegenModPerLevel = builder.rFlatHPRegenModPerLevel;
        this.percentHPRegenMod = builder.percentHPRegenMod;
        this.flatMPRegenMod = builder.flatMPRegenMod;
        this.rFlatMPRegenModPerLevel = builder.rFlatMPRegenModPerLevel;
        this.percentMPRegenMod = builder.percentMPRegenMod;
        this.flatArmorMod = builder.flatArmorMod;
        this.rFlatArmorModPerLevel = builder.rFlatArmorModPerLevel;
        this.percentArmorMod = builder.percentArmorMod;
        this.rFlatArmorPenetrationMod = builder.rFlatArmorPenetrationMod;
        this.rFlatArmorPenetrationModPerLevel = builder.rFlatArmorPenetrationModPerLevel;
        this.rPercentArmorPenetrationMod = builder.rPercentArmorPenetrationMod;
        this.rPercentArmorPenetrationModPerLevel = builder.rPercentArmorPenetrationModPerLevel;
        this.flatPhysicalDamageMod = builder.flatPhysicalDamageMod;
        this.rFlatPhysicalDamageModPerLevel = builder.rFlatPhysicalDamageModPerLevel;
        this.percentPhysicalDamageMod = builder.percentPhysicalDamageMod;
        this.flatMagicDamageMod = builder.flatMagicDamageMod;
        this.rFlatMagicDamageModPerLevel = builder.rFlatMagicDamageModPerLevel;
        this.percentMagicDamageMod = builder.percentMagicDamageMod;
        this.flatMovementSpeedMod = builder.flatMovementSpeedMod;
        this.rFlatMovementSpeedModPerLevel = builder.rFlatMovementSpeedModPerLevel;
        this.percentMovementSpeedMod = builder.percentMovementSpeedMod;
        this.rPercentMovementSpeedModPerLevel = builder.rPercentMovementSpeedModPerLevel;
        this.flatAttackSpeedMod = builder.flatAttackSpeedMod;
        this.percentAttackSpeedMod = builder.percentAttackSpeedMod;
        this.rPercentAttackSpeedModPerLevel = builder.rPercentAttackSpeedModPerLevel;
        this.rFlatDodgeMod = builder.rFlatDodgeMod;
        this.rFlatDodgeModPerLevel = builder.rFlatDodgeModPerLevel;
        this.percentDodgeMod = builder.percentDodgeMod;
        this.flatCritChanceMod = builder.flatCritChanceMod;
        this.rFlatCritChanceModPerLevel = builder.rFlatCritChanceModPerLevel;
        this.percentCritChanceMod = builder.percentCritChanceMod;
        this.flatCritDamageMod = builder.flatCritDamageMod;
        this.rFlatCritDamageModPerLevel = builder.rFlatCritDamageModPerLevel;
        this.percentCritDamageMod = builder.percentCritDamageMod;
        this.flatBlockMod = builder.flatBlockMod;
        this.percentBlockMod = builder.percentBlockMod;
        this.flatSpellBlockMod = builder.flatSpellBlockMod;
        this.rFlatSpellBlockModPerLevel = builder.rFlatSpellBlockModPerLevel;
        this.percentSpellBlockMod = builder.percentSpellBlockMod;
        this.flatEXPBonus = builder.flatEXPBonus;
        this.percentEXPBonus = builder.percentEXPBonus;
        this.rPercentCooldownMod = builder.rPercentCooldownMod;
        this.rPercentCooldownModPerLevel = builder.rPercentCooldownModPerLevel;
        this.rFlatTimeDeadMod = builder.rFlatTimeDeadMod;
        this.rFlatTimeDeadModPerLevel = builder.rFlatTimeDeadModPerLevel;
        this.rPercentTimeDeadMod = builder.rPercentTimeDeadMod;
        this.rPercentTimeDeadModPerLevel = builder.rPercentTimeDeadModPerLevel;
        this.rFlatGoldPer10Mod = builder.rFlatGoldPer10Mod;
        this.rFlatMagicPenetrationMod = builder.rFlatMagicPenetrationMod;
        this.rFlatMagicPenetrationModPerLevel = builder.rFlatMagicPenetrationModPerLevel;
        this.rPercentMagicPenetrationMod = builder.rPercentMagicPenetrationMod;
        this.rPercentMagicPenetrationModPerLevel = builder.rPercentMagicPenetrationModPerLevel;
        this.flatEnergyRegenMod = builder.flatEnergyRegenMod;
        this.rFlatEnergyRegenModPerLevel = builder.rFlatEnergyRegenModPerLevel;
        this.flatEnergyPoolMod = builder.flatEnergyPoolMod;
        this.rFlatEnergyModPerLevel = builder.rFlatEnergyModPerLevel;
        this.percentLifeStealMod = builder.percentLifeStealMod;
        this.percentSpellVampMod = builder.percentSpellVampMod;
    }

    public int getFlatHPPoolMod() {
        return flatHPPoolMod;
    }

    public int getrFlatHPModPerLevel() {
        return rFlatHPModPerLevel;
    }

    public int getFlatMPPoolMod() {
        return flatMPPoolMod;
    }

    public int getrFlatMPModPerLevel() {
        return rFlatMPModPerLevel;
    }

    public int getPercentHPPoolMod() {
        return percentHPPoolMod;
    }

    public int getPercentMPPoolMod() {
        return percentMPPoolMod;
    }

    public int getFlatHPRegenMod() {
        return flatHPRegenMod;
    }

    public int getrFlatHPRegenModPerLevel() {
        return rFlatHPRegenModPerLevel;
    }

    public int getPercentHPRegenMod() {
        return percentHPRegenMod;
    }

    public int getFlatMPRegenMod() {
        return flatMPRegenMod;
    }

    public int getrFlatMPRegenModPerLevel() {
        return rFlatMPRegenModPerLevel;
    }

    public int getPercentMPRegenMod() {
        return percentMPRegenMod;
    }

    public int getFlatArmorMod() {
        return flatArmorMod;
    }

    public int getrFlatArmorModPerLevel() {
        return rFlatArmorModPerLevel;
    }

    public int getPercentArmorMod() {
        return percentArmorMod;
    }

    public int getrFlatArmorPenetrationMod() {
        return rFlatArmorPenetrationMod;
    }

    public int getrFlatArmorPenetrationModPerLevel() {
        return rFlatArmorPenetrationModPerLevel;
    }

    public int getrPercentArmorPenetrationMod() {
        return rPercentArmorPenetrationMod;
    }

    public int getrPercentArmorPenetrationModPerLevel() {
        return rPercentArmorPenetrationModPerLevel;
    }

    public int getFlatPhysicalDamageMod() {
        return flatPhysicalDamageMod;
    }

    public int getrFlatPhysicalDamageModPerLevel() {
        return rFlatPhysicalDamageModPerLevel;
    }

    public int getPercentPhysicalDamageMod() {
        return percentPhysicalDamageMod;
    }

    public int getFlatMagicDamageMod() {
        return flatMagicDamageMod;
    }

    public int getrFlatMagicDamageModPerLevel() {
        return rFlatMagicDamageModPerLevel;
    }

    public int getPercentMagicDamageMod() {
        return percentMagicDamageMod;
    }

    public int getFlatMovementSpeedMod() {
        return flatMovementSpeedMod;
    }

    public int getrFlatMovementSpeedModPerLevel() {
        return rFlatMovementSpeedModPerLevel;
    }

    public int getPercentMovementSpeedMod() {
        return percentMovementSpeedMod;
    }

    public int getrPercentMovementSpeedModPerLevel() {
        return rPercentMovementSpeedModPerLevel;
    }

    public int getFlatAttackSpeedMod() {
        return flatAttackSpeedMod;
    }

    public int getPercentAttackSpeedMod() {
        return percentAttackSpeedMod;
    }

    public int getrPercentAttackSpeedModPerLevel() {
        return rPercentAttackSpeedModPerLevel;
    }

    public int getrFlatDodgeMod() {
        return rFlatDodgeMod;
    }

    public int getrFlatDodgeModPerLevel() {
        return rFlatDodgeModPerLevel;
    }

    public int getPercentDodgeMod() {
        return percentDodgeMod;
    }

    public int getFlatCritChanceMod() {
        return flatCritChanceMod;
    }

    public int getrFlatCritChanceModPerLevel() {
        return rFlatCritChanceModPerLevel;
    }

    public int getPercentCritChanceMod() {
        return percentCritChanceMod;
    }

    public int getFlatCritDamageMod() {
        return flatCritDamageMod;
    }

    public int getrFlatCritDamageModPerLevel() {
        return rFlatCritDamageModPerLevel;
    }

    public int getPercentCritDamageMod() {
        return percentCritDamageMod;
    }

    public int getFlatBlockMod() {
        return flatBlockMod;
    }

    public int getPercentBlockMod() {
        return percentBlockMod;
    }

    public int getFlatSpellBlockMod() {
        return flatSpellBlockMod;
    }

    public int getrFlatSpellBlockModPerLevel() {
        return rFlatSpellBlockModPerLevel;
    }

    public int getPercentSpellBlockMod() {
        return percentSpellBlockMod;
    }

    public int getFlatEXPBonus() {
        return flatEXPBonus;
    }

    public int getPercentEXPBonus() {
        return percentEXPBonus;
    }

    public int getrPercentCooldownMod() {
        return rPercentCooldownMod;
    }

    public int getrPercentCooldownModPerLevel() {
        return rPercentCooldownModPerLevel;
    }

    public int getrFlatTimeDeadMod() {
        return rFlatTimeDeadMod;
    }

    public int getrFlatTimeDeadModPerLevel() {
        return rFlatTimeDeadModPerLevel;
    }

    public int getrPercentTimeDeadMod() {
        return rPercentTimeDeadMod;
    }

    public int getrPercentTimeDeadModPerLevel() {
        return rPercentTimeDeadModPerLevel;
    }

    public int getrFlatGoldPer10Mod() {
        return rFlatGoldPer10Mod;
    }

    public int getrFlatMagicPenetrationMod() {
        return rFlatMagicPenetrationMod;
    }

    public int getrFlatMagicPenetrationModPerLevel() {
        return rFlatMagicPenetrationModPerLevel;
    }

    public int getrPercentMagicPenetrationMod() {
        return rPercentMagicPenetrationMod;
    }

    public int getrPercentMagicPenetrationModPerLevel() {
        return rPercentMagicPenetrationModPerLevel;
    }

    public int getFlatEnergyRegenMod() {
        return flatEnergyRegenMod;
    }

    public int getrFlatEnergyRegenModPerLevel() {
        return rFlatEnergyRegenModPerLevel;
    }

    public int getFlatEnergyPoolMod() {
        return flatEnergyPoolMod;
    }

    public int getrFlatEnergyModPerLevel() {
        return rFlatEnergyModPerLevel;
    }

    public int getPercentLifeStealMod() {
        return percentLifeStealMod;
    }

    public int getPercentSpellVampMod() {
        return percentSpellVampMod;
    }

    @JsonPOJOBuilder
    public static class Builder{
        @JsonProperty("FlatHPPoolMod")
        private int flatHPPoolMod;
        @JsonProperty("rFlatHPModPerLevel")
        private int rFlatHPModPerLevel;
        @JsonProperty("FlatMPPoolMod")
        private int flatMPPoolMod;
        @JsonProperty("rFlatMPModPerLevel")
        private int rFlatMPModPerLevel;
        @JsonProperty("PercentHPPoolMod")
        private int percentHPPoolMod;
        @JsonProperty("PercentMPPoolMod")
        private int percentMPPoolMod;
        @JsonProperty("FlatHPRegenMod")
        private int flatHPRegenMod;
        @JsonProperty("rFlatHPRegenModPerLevel")
        private int rFlatHPRegenModPerLevel;
        @JsonProperty("PercentHPRegenMod")
        private int percentHPRegenMod;
        @JsonProperty("FlatMPRegenMod")
        private int flatMPRegenMod;
        @JsonProperty("rFlatMPRegenModPerLevel")
        private int rFlatMPRegenModPerLevel;
        @JsonProperty("PercentMPRegenMod")
        private int percentMPRegenMod;
        @JsonProperty("FlatArmorMod")
        private int flatArmorMod;
        @JsonProperty("rFlatArmorModPerLevel")
        private int rFlatArmorModPerLevel;
        @JsonProperty("PercentArmorMod")
        private int percentArmorMod;
        @JsonProperty("rFlatArmorPenetrationMod")
        private int rFlatArmorPenetrationMod;
        @JsonProperty("rFlatArmorPenetrationModPerLevel")
        private int rFlatArmorPenetrationModPerLevel;
        @JsonProperty("rPercentArmorPenetrationMod")
        private int rPercentArmorPenetrationMod;
        @JsonProperty("rPercentArmorPenetrationModPerLevel")
        private int rPercentArmorPenetrationModPerLevel;
        @JsonProperty("FlatPhysicalDamageMod")
        private int flatPhysicalDamageMod;
        @JsonProperty("rFlatPhysicalDamageModPerLevel")
        private int rFlatPhysicalDamageModPerLevel;
        @JsonProperty("PercentPhysicalDamageMod")
        private int percentPhysicalDamageMod;
        @JsonProperty("FlatMagicDamageMod")
        private int flatMagicDamageMod;
        @JsonProperty("rFlatMagicDamageModPerLevel")
        private int rFlatMagicDamageModPerLevel;
        @JsonProperty("PercentMagicDamageMod")
        private int percentMagicDamageMod;
        @JsonProperty("FlatMovementSpeedMod")
        private int flatMovementSpeedMod;
        @JsonProperty("rFlatMovementSpeedModPerLevel")
        private int rFlatMovementSpeedModPerLevel;
        @JsonProperty("PercentMovementSpeedMod")
        private int percentMovementSpeedMod;
        @JsonProperty("rPercentMovementSpeedModPerLevel")
        private int rPercentMovementSpeedModPerLevel;
        @JsonProperty("FlatAttackSpeedMod")
        private int flatAttackSpeedMod;
        @JsonProperty("PercentAttackSpeedMod")
        private int percentAttackSpeedMod;
        @JsonProperty("rPercentAttackSpeedModPerLevel")
        private int rPercentAttackSpeedModPerLevel;
        @JsonProperty("rFlatDodgeMod")
        private int rFlatDodgeMod;
        @JsonProperty("rFlatDodgeModPerLevel")
        private int rFlatDodgeModPerLevel;
        @JsonProperty("PercentDodgeMod")
        private int percentDodgeMod;
        @JsonProperty("FlatCritChanceMod")
        private int flatCritChanceMod;
        @JsonProperty("rFlatCritChanceModPerLevel")
        private int rFlatCritChanceModPerLevel;
        @JsonProperty("PercentCritChanceMod")
        private int percentCritChanceMod;
        @JsonProperty("FlatCritDamageMod")
        private int flatCritDamageMod;
        @JsonProperty("rFlatCritDamageModPerLevel")
        private int rFlatCritDamageModPerLevel;
        @JsonProperty("PercentCritDamageMod")
        private int percentCritDamageMod;
        @JsonProperty("FlatBlockMod")
        private int flatBlockMod;
        @JsonProperty("PercentBlockMod")
        private int percentBlockMod;
        @JsonProperty("FlatSpellBlockMod")
        private int flatSpellBlockMod;
        @JsonProperty("rFlatSpellBlockModPerLevel")
        private int rFlatSpellBlockModPerLevel;
        @JsonProperty("PercentSpellBlockMod")
        private int percentSpellBlockMod;
        @JsonProperty("FlatEXPBonus")
        private int flatEXPBonus;
        @JsonProperty("PercentEXPBonus")
        private int percentEXPBonus;
        @JsonProperty("rPercentCooldownMod")
        private int rPercentCooldownMod;
        @JsonProperty("rPercentCooldownModPerLevel")
        private int rPercentCooldownModPerLevel;
        @JsonProperty("rFlatTimeDeadMod")
        private int rFlatTimeDeadMod;
        @JsonProperty("rFlatTimeDeadModPerLevel")
        private int rFlatTimeDeadModPerLevel;
        @JsonProperty("rPercentTimeDeadMod")
        private int rPercentTimeDeadMod;
        @JsonProperty("rPercentTimeDeadModPerLevel")
        private int rPercentTimeDeadModPerLevel;
        @JsonProperty("rFlatGoldPer10Mod")
        private int rFlatGoldPer10Mod;
        @JsonProperty("rFlatMagicPenetrationMod")
        private int rFlatMagicPenetrationMod;
        @JsonProperty("rFlatMagicPenetrationModPerLevel")
        private int rFlatMagicPenetrationModPerLevel;
        @JsonProperty("rPercentMagicPenetrationMod")
        private int rPercentMagicPenetrationMod;
        @JsonProperty("rPercentMagicPenetrationModPerLevel")
        private int rPercentMagicPenetrationModPerLevel;
        @JsonProperty("FlatEnergyRegenMod")
        private int flatEnergyRegenMod;
        @JsonProperty("rFlatEnergyRegenModPerLevel")
        private int rFlatEnergyRegenModPerLevel;
        @JsonProperty("FlatEnergyPoolMod")
        private int flatEnergyPoolMod;
        @JsonProperty("rFlatEnergyModPerLevel")
        private int rFlatEnergyModPerLevel;
        @JsonProperty("PercentLifeStealMod")
        private int percentLifeStealMod;
        @JsonProperty("PercentSpellVampMod")
        private int percentSpellVampMod;

        Builder withFlatHPPoolMod(int flatHPPoolMod) {
            this.flatHPPoolMod = flatHPPoolMod;
            return this;
        }

        Builder withrFlatHPModPerLevel(int rFlatHPModPerLevel) {
            this.rFlatHPModPerLevel = rFlatHPModPerLevel;
            return this;
        }

        Builder withFlatMPPoolMod(int flatMPPoolMod) {
            this.flatMPPoolMod = flatMPPoolMod;
            return this;
        }

        Builder withrFlatMPModPerLevel(int rFlatMPModPerLevel) {
            this.rFlatMPModPerLevel = rFlatMPModPerLevel;
            return this;
        }

        Builder withPercentHPPoolMod(int percentHPPoolMod) {
            this.percentHPPoolMod = percentHPPoolMod;
            return this;
        }

        Builder withPercentMPPoolMod(int percentMPPoolMod) {
            this.percentMPPoolMod = percentMPPoolMod;
            return this;
        }

        Builder withFlatHPRegenMod(int flatHPRegenMod) {
            this.flatHPRegenMod = flatHPRegenMod;
            return this;
        }

        Builder withrFlatHPRegenModPerLevel(int rFlatHPRegenModPerLevel) {
            this.rFlatHPRegenModPerLevel = rFlatHPRegenModPerLevel;
            return this;
        }

        Builder withPercentHPRegenMod(int percentHPRegenMod) {
            this.percentHPRegenMod = percentHPRegenMod;
            return this;
        }

        Builder withFlatMPRegenMod(int flatMPRegenMod) {
            this.flatMPRegenMod = flatMPRegenMod;
            return this;
        }

        Builder withrFlatMPRegenModPerLevel(int rFlatMPRegenModPerLevel) {
            this.rFlatMPRegenModPerLevel = rFlatMPRegenModPerLevel;
            return this;
        }

        Builder withPercentMPRegenMod(int percentMPRegenMod) {
            this.percentMPRegenMod = percentMPRegenMod;
            return this;
        }

        Builder withFlatArmorMod(int flatArmorMod) {
            this.flatArmorMod = flatArmorMod;
            return this;
        }

        Builder withrFlatArmorModPerLevel(int rFlatArmorModPerLevel) {
            this.rFlatArmorModPerLevel = rFlatArmorModPerLevel;
            return this;
        }

        Builder withPercentArmorMod(int percentArmorMod) {
            this.percentArmorMod = percentArmorMod;
            return this;
        }

        Builder withrFlatArmorPenetrationMod(int rFlatArmorPenetrationMod) {
            this.rFlatArmorPenetrationMod = rFlatArmorPenetrationMod;
            return this;
        }

        Builder withrFlatArmorPenetrationModPerLevel(int rFlatArmorPenetrationModPerLevel) {
            this.rFlatArmorPenetrationModPerLevel = rFlatArmorPenetrationModPerLevel;
            return this;
        }

        Builder withrPercentArmorPenetrationMod(int rPercentArmorPenetrationMod) {
            this.rPercentArmorPenetrationMod = rPercentArmorPenetrationMod;
            return this;
        }

        Builder withrPercentArmorPenetrationModPerLevel(int rPercentArmorPenetrationModPerLevel) {
            this.rPercentArmorPenetrationModPerLevel = rPercentArmorPenetrationModPerLevel;
            return this;
        }

        Builder withFlatPhysicalDamageMod(int flatPhysicalDamageMod) {
            this.flatPhysicalDamageMod = flatPhysicalDamageMod;
            return this;
        }

        Builder withrFlatPhysicalDamageModPerLevel(int rFlatPhysicalDamageModPerLevel) {
            this.rFlatPhysicalDamageModPerLevel = rFlatPhysicalDamageModPerLevel;
            return this;
        }

        Builder withPercentPhysicalDamageMod(int percentPhysicalDamageMod) {
            this.percentPhysicalDamageMod = percentPhysicalDamageMod;
            return this;
        }

        Builder withFlatMagicDamageMod(int flatMagicDamageMod) {
            this.flatMagicDamageMod = flatMagicDamageMod;
            return this;
        }

        Builder withrFlatMagicDamageModPerLevel(int rFlatMagicDamageModPerLevel) {
            this.rFlatMagicDamageModPerLevel = rFlatMagicDamageModPerLevel;
            return this;
        }

        Builder withPercentMagicDamageMod(int percentMagicDamageMod) {
            this.percentMagicDamageMod = percentMagicDamageMod;
            return this;
        }

        Builder withFlatMovementSpeedMod(int flatMovementSpeedMod) {
            this.flatMovementSpeedMod = flatMovementSpeedMod;
            return this;
        }

        Builder withrFlatMovementSpeedModPerLevel(int rFlatMovementSpeedModPerLevel) {
            this.rFlatMovementSpeedModPerLevel = rFlatMovementSpeedModPerLevel;
            return this;
        }

        Builder withPercentMovementSpeedMod(int percentMovementSpeedMod) {
            this.percentMovementSpeedMod = percentMovementSpeedMod;
            return this;
        }

        Builder withrPercentMovementSpeedModPerLevel(int rPercentMovementSpeedModPerLevel) {
            this.rPercentMovementSpeedModPerLevel = rPercentMovementSpeedModPerLevel;
            return this;
        }

        Builder withFlatAttackSpeedMod(int flatAttackSpeedMod) {
            this.flatAttackSpeedMod = flatAttackSpeedMod;
            return this;
        }

        Builder withPercentAttackSpeedMod(int percentAttackSpeedMod) {
            this.percentAttackSpeedMod = percentAttackSpeedMod;
            return this;
        }

        Builder withrPercentAttackSpeedModPerLevel(int rPercentAttackSpeedModPerLevel) {
            this.rPercentAttackSpeedModPerLevel = rPercentAttackSpeedModPerLevel;
            return this;
        }

        Builder withrFlatDodgeMod(int rFlatDodgeMod) {
            this.rFlatDodgeMod = rFlatDodgeMod;
            return this;
        }

        Builder withrFlatDodgeModPerLevel(int rFlatDodgeModPerLevel) {
            this.rFlatDodgeModPerLevel = rFlatDodgeModPerLevel;
            return this;
        }

        Builder withPercentDodgeMod(int percentDodgeMod) {
            this.percentDodgeMod = percentDodgeMod;
            return this;
        }

        Builder withFlatCritChanceMod(int flatCritChanceMod) {
            this.flatCritChanceMod = flatCritChanceMod;
            return this;
        }

        Builder withrFlatCritChanceModPerLevel(int rFlatCritChanceModPerLevel) {
            this.rFlatCritChanceModPerLevel = rFlatCritChanceModPerLevel;
            return this;
        }

        Builder withPercentCritChanceMod(int percentCritChanceMod) {
            this.percentCritChanceMod = percentCritChanceMod;
            return this;
        }

        Builder withFlatCritDamageMod(int flatCritDamageMod) {
            this.flatCritDamageMod = flatCritDamageMod;
            return this;
        }

        Builder withrFlatCritDamageModPerLevel(int rFlatCritDamageModPerLevel) {
            this.rFlatCritDamageModPerLevel = rFlatCritDamageModPerLevel;
            return this;
        }

        Builder withPercentCritDamageMod(int percentCritDamageMod) {
            this.percentCritDamageMod = percentCritDamageMod;
            return this;
        }

        Builder withFlatBlockMod(int flatBlockMod) {
            this.flatBlockMod = flatBlockMod;
            return this;
        }

        Builder withPercentBlockMod(int percentBlockMod) {
            this.percentBlockMod = percentBlockMod;
            return this;
        }

        Builder withFlatSpellBlockMod(int flatSpellBlockMod) {
            this.flatSpellBlockMod = flatSpellBlockMod;
            return this;
        }

        Builder withrFlatSpellBlockModPerLevel(int rFlatSpellBlockModPerLevel) {
            this.rFlatSpellBlockModPerLevel = rFlatSpellBlockModPerLevel;
            return this;
        }

        Builder withPercentSpellBlockMod(int percentSpellBlockMod) {
            this.percentSpellBlockMod = percentSpellBlockMod;
            return this;
        }

        Builder withFlatEXPBonus(int flatEXPBonus) {
            this.flatEXPBonus = flatEXPBonus;
            return this;
        }

        Builder withPercentEXPBonus(int percentEXPBonus) {
            this.percentEXPBonus = percentEXPBonus;
            return this;
        }

        Builder withrPercentCooldownMod(int rPercentCooldownMod) {
            this.rPercentCooldownMod = rPercentCooldownMod;
            return this;
        }

        public Stats build(){
            Stats stats = new Stats(this);
            //TODO: Validate JSON to Object.
            return stats;
        }
    }
}