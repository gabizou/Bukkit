package org.bukkit.entity;

/**
 * Represents a Guardian.
 */
public interface Guardian extends Monster, WaterMob {

    /**
     * Gets the current type of this skeleton.
     *
     * @return Current type
     */
    public GuardianType getGuardianType();

    /**
     * Sets the new type of this skeleton.
     *
     * @param type New type
     */
    public void setGuardianType(GuardianType type);

    /*
     * Represents the various different Skeleton types.
     */
    public enum GuardianType {
        NORMAL(0),
        ELDER(1);

        private static final GuardianType[] types = new GuardianType[GuardianType.values().length];
        private final int id;

        static {
            for (GuardianType type : values()) {
                types[type.getId()] = type;
            }
        }

        private GuardianType(int id) {
            this.id = id;
        }

        /**
         * Gets the ID of this skeleton type.
         *
         * @return Skeleton type ID
         * @deprecated Magic value
         */
        @Deprecated
        public int getId() {
            return id;
        }

        /**
         * Gets a skeleton type by its ID.
         *
         * @param id ID of the skeleton type to get.
         * @return Resulting skeleton type, or null if not found.
         * @deprecated Magic value
         */
        @Deprecated
        public static GuardianType getType(int id) {
            return (id >= types.length) ? null : types[id];
        }
    }
}
