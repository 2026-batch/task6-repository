public enum Wheat{
	 SHARBATI(100),LOKWAN(200);

	 private int quantity;

	 Wheat(int quantity){
	 	this.quantity = quantity;
	 }

	 public int getQuantity(){
	 	return this.quantity;
	 }

	  public void setQuantity(int quantity){
	 	  this.quantity = quantity;
	 }

	 public String toString(){
	 	return String.format("%-10s : %d ",name(),quantity);
	 }

}
