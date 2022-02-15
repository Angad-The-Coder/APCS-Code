# Solitaire

## Class Ideas
- [ ] `Card` class
  - Instance Variables:
    - `rank` - int: from `1` (Ace) to `13` (King)
    - `suit` - int: { `0`: clubs, `1`: spades, `2`: hearts, `3`: diamonds }
    - `isShowing` - boolean: `true` if card is showing value, `false` if it is flipped over
  - Methods:
    - getters for all instance variables
    - `getColor` method: returns `"B"` (spades or clubs) or `"R"` (diamonds or hearts)
    - `flip` method to invert `isShowing`