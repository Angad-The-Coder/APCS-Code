import java.util.*;

public class HorseBarn {
  private Horse[] spaces;

  public HorseBarn() {
    this(10);
  }

  public HorseBarn(int x) {
    this.spaces = new Horse[x];// initializes the array of Horse to have x slots
  }

  /**
   * Given a possible index within spaces, ind, checkBadIndex determines whether or 
   * not that index is within the bounds of valid indices one could use to access 
   * elements in spaces and, if it isn't, it throws an IndexOutOfBoundsException 
   * stating the value of the invalid index and then the length of spaces, which 
   * would help the user by showing them why the index was invalid.
   * 
   * @param ind a possible index within spaces that must be checked for validity 
   */
  public void checkBadIndex(int ind) {
    if (ind < 0 || ind >= this.spaces.length)
      throw new IndexOutOfBoundsException("Bad index: " + ind + " length: " + this.spaces.length);
  }

  public Horse setHorse(int ind, Horse h) {
    checkBadIndex(ind);
    Horse old = this.spaces[ind];
    this.spaces[ind] = h;
    return old;
  }

  public Horse getHorse(int x) {
    checkBadIndex(x);
    return this.spaces[x];
  }

  /**
   * Returns the index of the space that contains the horse with the specified
   * name. Precondition: No two horses in the barn have the same name.
   * 
   * @param name the name of the horse to find
   * @return the index of the space containing the horse with the specified name;
   *         -1 if no horse with the specified name is in the barn.
   */
  public int findHorseSpace(String name) {
    for (int i = 0; i < this.spaces.length; i++) {
      if (this.spaces[i] != null && this.spaces[i].getName().equals(name)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Consolidates the barn by moving horses so that the horses are in adjacent
   * spaces, starting at index 0, with no empty space between any two horses.
   * Postcondition: The order of the horses is the same as before the
   * consolidation.
   */
  public void consolidate() {
    int consolidatedHorses = 0;
    for (int i = 0; i < this.spaces.length; i++) {
      if (this.spaces[i] != null) {
        if (i != consolidatedHorses) {
          this.spaces[consolidatedHorses] = this.spaces[i];
          this.spaces[i] = null;
        }
        consolidatedHorses++;
      }
    }
  }

  /**
   * Adds the specified Horse at the empty location closest to the end
   * 
   * @param The Horse to be added at an empty location
   * @return true if there was an empty spot and h was added, false otherwise.
   */
  public boolean addAtEnd(Horse h) {
    for (int i = this.spaces.length - 1; i >= 0; i--) {
      if (this.spaces[i] == null) {
        this.spaces[i] = h;
        return true;
      }
    }
    return false;
  }

  /**
   * removes an array of the Horse Objects in spaces whose birth happened before
   * the specified Date. If no Horses were born before the Date, then null is
   * returned. The returned array should be just large enough to hold the removed
   * Horses Here is a blurb from the Date class compareTo method returns 0 if the
   * argument Date is equal to this Date; a value less than 0 if this Date is
   * before the Date argument; and a value greater than 0 if this Date is after
   * the Date argument.
   */
  public Horse[] removeOlderThan(Date d) {
    // The length of oldHorses is intentionally set to be an overestimate:
    Horse[] oldHorses = new Horse[this.spaces.length];
    int oldHorseCount = 0;

    // Fill up the oldHorses with array, starting from 0 and incrementing by
    // 1 each time:
    for (int i = 0; i < this.spaces.length; i++) {
      if (spaces[i] != null && spaces[i].getBirth().compareTo(d) < 0) {
        oldHorses[oldHorseCount] = spaces[i];
        oldHorseCount++;
      }
    }
    
    // If no older horses were found, return null:
    if (oldHorseCount == 0) {
      return null;
    }

    // finalOldHorses will be the same as oldHorses, just excluding the extra
    // nulls added at oldHorses's construction.
    Horse[] finalOldHorses = new Horse[oldHorseCount];
    for (int i = 0; i < oldHorseCount; i++) {
      finalOldHorses[i] = oldHorses[i];
    }
    return finalOldHorses;
  }

  public String toString() {
    String ret = "I'm a HorseBarn!\n";
    for (Horse h : spaces)
      ret += h + "\n";
    return ret;
  }
}