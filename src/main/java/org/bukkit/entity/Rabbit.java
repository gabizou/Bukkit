package org.bukkit.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Rabbit.
 */
public interface Rabbit extends Animals
{

    /**
     * Gets the type of rabbit.
     *
     * @return The type of rabbit
     */
    public RabbitType getRabbitType();

    /**
     * Sets the type of rabbit.
     *
     * @param type The type of rabbit
     */
    public void setRabbitType(RabbitType type);

    /*
    * Represents the various different Rabbit types.
    */
    public enum RabbitType
    {
        BROWN(0),
        WHITE(1),
        BLACK(2),
        BLACK_AND_WHITE(3),
        GOLD(4),
        SALT_PEPPER(5),
        KILLER(99);

        private static final Map<Integer, RabbitType> types = new HashMap<Integer, RabbitType>(values().length);
        private final int id;

        static
        {
            for (RabbitType type : values())
            {
                types.put(type.id, type);
            }
        }

        private RabbitType(int id)
        {
            this.id = id;
        }

        /**
         * Gets the ID of this rabbit type.
         *
         * @return Rabbit type ID
         * @deprecated Magic value
         */
        @Deprecated
        public int getId()
        {
            return id;
        }

        /**
         * Gets a rabbit type by its ID.
         *
         * @param id ID of the rabbit type to get.
         * @return Resulting rabbit type, or null if not found.
         * @deprecated Magic value
         */
        @Deprecated
        public static RabbitType getType(int id)
        {
            return types.get(id);
        }
    }
}
