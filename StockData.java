public class StockData{
	
  private Cosmotics cosmotics;

  // grocessories
  private Groceries groceries;

  // vegitables


  public StockData(Cosmotics cosmotics){
  	this.cosmotics  =  cosmotics;
  }

  public StockData(Cosmotics cosmotics, Groceries groceries){
  	this.cosmotics   =  cosmotics;
  	this.groceries   =  groceries;
  }


  public Cosmotics getCosmotics(){
  	return this.cosmotics;
  }

  public void setGroceries(Groceries groceries){
  	this.groceries = groceries;
  }

  public Groceries getGroceries(){
  	return this.groceries;
  }


  public String toString(){
  	return "StockData : \n "+cosmotics + "\n " + groceries;
  }

}


