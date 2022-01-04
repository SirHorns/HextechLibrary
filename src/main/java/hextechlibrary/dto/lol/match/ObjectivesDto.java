package hextechlibrary.dto.lol.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import hextechlibrary.dto.lol.match.objectives.*;

//TODO: Convert to Builder Pattern
public class ObjectivesDto {
    Baron baron;
    Champion champion;
    Dragon dragon;
    Inhibitor inhibitor;
    RiftHerald riftHerald;
    Tower tower;

    public ObjectivesDto(
            @JsonProperty("baron") Baron baron
            ,@JsonProperty("champion") Champion champion
            ,@JsonProperty("dragon") Dragon dragon
            ,@JsonProperty("inhibitor") Inhibitor inhibitor
            ,@JsonProperty("riftHerald") RiftHerald riftHerald
            ,@JsonProperty("tower") Tower tower) {
        this.baron = baron;
        this.champion = champion;
        this.dragon = dragon;
        this.inhibitor = inhibitor;
        this.riftHerald = riftHerald;
        this.tower = tower;
    }

    public Baron getBaron() {
        return baron;
    }

    public void setBaron(Baron baron) {
        this.baron = baron;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public Inhibitor getInhibitor() {
        return inhibitor;
    }

    public void setInhibitor(Inhibitor inhibitor) {
        this.inhibitor = inhibitor;
    }

    public RiftHerald getRiftHerald() {
        return riftHerald;
    }

    public void setRiftHerald(RiftHerald riftHerald) {
        this.riftHerald = riftHerald;
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }
}
