package com.graywolf336.jail.interfaces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Chest;

import com.graywolf336.jail.beans.Prisoner;
import com.graywolf336.jail.beans.SimpleLocation;

public interface ICell {
    /** Gets the id of the cell in the database, <strong>internal usage only</strong> */
    public int getDatabaseID();

    /** Gets the name of the cell. */
    public String getName();

    /** Sets the prisoner in this cell. */
    public void setPrisoner(Prisoner prisoner);

    /** Gets the prisoner being held in this cell. */
    public Prisoner getPrisoner();

    /** Nullifies the prisoner data. */
    public void removePrisoner();

    /** Returns true if there is currently a prisoner in this cell. */
    public boolean hasPrisoner();

    /** Adds all the given signs to the cell. */
    public void addAllSigns(HashSet<SimpleLocation> signs);

    /** Adds a sign to the cell. */
    public void addSign(SimpleLocation sign);

    /** Returns all the signs for this cell. */
    public HashSet<SimpleLocation> getSigns();

    /** Checks if there are any signs for this cell. */
    public boolean hasSigns();

    /** Returns the entire list of signs in a string. */
    public String getSignString();

    /** Gets a list of all the signs which are invalid (not signs anymore). */
    public List<String> getInvalidSigns();

    /** Removes all the signs which are no longer sign blocks. */
    public List<String> cleanSigns();

    /**
     * Updates all the signs this cell has.
     *
     * @return collection of changes. The <strong>"removed"</strong> entry has all the signs which were removed. The <strong>"updated"</strong> entry has all the signs which got updated.
     */
    public HashMap<String, List<String>> updateSigns();

    /** Sets the location of where the prisoner will be teleported at when jailed here. */
    public void setTeleport(SimpleLocation location);

    /** Gets the teleport location where the prisoner will be teleported at when jailed here. */
    public Location getTeleport();

    /** Sets the location of the chest. */
    public void setChestLocation(SimpleLocation simpleLocation);

    /**
     * Gets the location of the chest, returns null if no chest is stored at this cell.
     *
     * @return The location of the chest, null if none.
     */
    public Location getChestLocation();

    /**
     * Gets the chest for this cell, returns null if there is no chest or the location we have is not a chest.
     *
     * @return The chest and its state.
     */
    public Chest getChest();

    /**
     * Checks if the chest location doesn't equal null and if it is a double chest.
     *
     * @return true if there is a chest, false if there isn't.
     */
    public boolean hasChest();

    /**
     * Sets whether this cell has been changed or not.
     *
     * @param changed true if we've changed it, mostly use if you want to force an update
     * @return the resulting change, whether it is changed or not
     */
    public boolean setChanged(boolean changed);

    /** Gets whether the Cell has changed from the last save or not. */
    public boolean hasChanged();
}
