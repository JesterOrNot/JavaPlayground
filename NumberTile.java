class NumberTile {
  
  int top, right, bottom, left;
  
  int rotateCount = 0;
  
  public NumberTile() {
    top = (int)(Math.random()*5);
    right = (int)(Math.random()*5);
    bottom = (int)(Math.random()*5);
    left = (int)(Math.random()*5);
  }
  
  public void rotate() {
    int temp = left;
    left = bottom;
    bottom = right;
    right = top;
    top = temp;
    rotateCount++;
  }

  public int getLeft() {
    return left;
  }
  
  public int getRight() {
    return right;
  }
  
}
