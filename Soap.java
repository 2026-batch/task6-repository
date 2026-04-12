public enum Soap{
	 LUX(100),SANTOOR(200);

	 private int quantity;

	 Soap(int quantity){
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