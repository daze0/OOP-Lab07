/**
 * 
 */
package it.unibo.oop.lab.enum2;

/**
 * Represents an enumeration for declaring sports.
 * 
 * 1) You must add a field keeping track of the number of members each team is
 * composed of (1 for individual sports)
 * 
 * 2) A second field will keep track of the name of the sport.
 * 
 * 3) A third field, of type Place, will allow to define if the sport is
 * practiced indoor or outdoor
 * 
 */
public enum Sport {

    /*
     * 
     * Declare the following sports:
     * 
     * - basket
     * 
     * - volley
     * 
     * - tennis
     * 
     * - bike
     * 
     * - F1
     * 
     * - motogp
     * 
     * - soccer
     * 
     */
	BASKET(Place.INDOOR, 5, "basket"), 
	VOLLEY(Place.INDOOR, 6, "volley"), 
	TENNIS(Place.OUTDOOR, 1, "tennis"), 
	BIKE(Place.OUTDOOR, 1, "bike"), 
	F1(Place.OUTDOOR, 1, "formula one"), 
	MOTOGP(Place.OUTDOOR, 1, "motoGP"), 
	SOCCER(Place.OUTDOOR, 11, "soccer");

	//In order to avoid magic numbers later on
	private static final int INDIVIDUAL_TEAM = 1;
    /*
     * [FIELDS]
     * 
     * Declare required fields
     */
	private final int teamMembers;
	private final String sportName;
	private final Place place;

    /**
     * 
     * [CONSTRUCTOR]
     * 
     * @param place
     * 			can be {@link Place#INDOOR} or {@link Place#OUTDOOR} 
     * 			depending from where the sport is practiced
     * 
     * @param noTeamMembers
     * 			describes the number of {@link #teamMembers} required for each sport
     * 
     * @param actualName
     * 			is the String representing the {@link #sportName}
     * 
     */
	private Sport(final Place place, final int noTeamMembers, final String actualName) {
		this.place = place;
		this.teamMembers = noTeamMembers;
		this.sportName = actualName;
	}

	/**
	 * @return true if called on individual sports,
	 * 		   false otherwise
	 */
	public boolean isIndividualSport() {
		return this.teamMembers == INDIVIDUAL_TEAM;
	}
	
	/**
	 * @return true if called on indoor sports,
	 * 		   false otherwise
	 */
	public boolean isIndoorSport() {
		return this.getPlace() == Place.INDOOR;
	}
	
	/**
	 * @return the place {@link Place#INDOOR} or {@link Place#OUTDOOR}
	 * 			where the sports is practiced
	 */
	public Place getPlace() {
		return this.place;
	}
	
	/**
	 * @return String representation of a Sport
	 */
	public String toString() {
		return this.sportName + "[TEAM MEMBERS: " + this.teamMembers + "]"
				+ "[" + this.place + "]";
	}
}
