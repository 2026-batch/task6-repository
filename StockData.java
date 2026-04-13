public class StockData{
	
  private Cosmotics cosmotics;

<<<<<<< HEAD
  // grocessories
  private Groceries groceries;

  // vegitables

=======
>>>>>>> origin/master

  public StockData(Cosmotics cosmotics){
  	this.cosmotics  =  cosmotics;
  }

<<<<<<< HEAD
  public StockData(Cosmotics cosmotics, Groceries groceries){
  	this.cosmotics   =  cosmotics;
  	this.groceries   =  groceries;
  }

=======
>>>>>>> origin/master

  public Cosmotics getCosmotics(){
  	return this.cosmotics;
  }

<<<<<<< HEAD
  public void setGroceries(Groceries groceries){
  	this.groceries = groceries;
  }

  public Groceries getGroceries(){
  	return this.groceries;
  }


  public String toString(){
  	return "StockData : \n "+cosmotics + "\n " + groceries;
=======
  // grocessories

  // vegitables


  public String toString(){
  	return "StockData : \n "+cosmotics;
>>>>>>> origin/master
  }

}


