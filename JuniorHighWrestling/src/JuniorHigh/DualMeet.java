package JuniorHigh;

import java.util.*;



/*
 *  This is a class to hold dual meets.
 *  Notice that it extends Event.  An event is 
 *  a class that holds the things that are common to both a
 *  Dual Meet and a Tournament.
 */
class DualMeet extends Event {
	
	private static int DUAL_SIZE = 14;
	private List<String> weights = new ArrayList<String> ();
	
	private String opponent;
	/*
	 * This Hashtable is key'd on Weight.
	 */
	private Hashtable<String,Bout>  theDual = new Hashtable<String,Bout>();
	
	public List<String> getWeights() { return weights; }

	public boolean isADualMeet() { return true; }
	public boolean isATournament() { return false; }
	
	DualMeet() {
		
		weights.add("70");weights.add("75");weights.add("80");weights.add("85");weights.add("90");
		weights.add("95");weights.add("100");weights.add("106");weights.add("112");weights.add("118");
		weights.add("124");weights.add("130");weights.add("140");weights.add("150");weights.add("175");
		weights.add("240");
	
//		weights.add("106");weights.add("113");weights.add("120");weights.add("126");weights.add("132");
//		weights.add("138");weights.add("145");weights.add("152");weights.add("160");weights.add("170");
//		weights.add("182");weights.add("195");weights.add("220");weights.add("285");
	}
	public String getOpponent() { return opponent; }
	
	public void setOpponent( String opp ) {
		opponent = opp;
	}
   
    public Hashtable<String,Bout> getBouts() {
		return theDual;
	}
	public String toString() {
		return getMainTeam() + ":" + getOpponent() + ":" + getEventDate();
	}
	public void addBout(Bout b) {
		theDual.put(b.getWeight(),b);
	}
	public Bout getBout(String w) {
		return theDual.get(w);
	}
	public boolean doesBoutExist(String w) {
	    return theDual.contains(w);
	}
	public boolean isFullDual() {
		if ( theDual.size() != DUAL_SIZE ) {
			return false;
		}
		
		
		Set<String> keys = theDual.keySet();
		
		for (String key: keys ) {
			weights.remove(key);
		}
		if ( weights.size() > 0 ) {
			return false;
		}
		return true;
	}
}
