public class StockData{
	
  private Cosmotics cosmotics;


  public StockData(Cosmotics cosmotics){
  	this.cosmotics  =  cosmotics;
  }


  public Cosmotics getCosmotics(){
  	return this.cosmotics;
  }

  // grocessories

  // vegitables


  public String toString(){
  	return "StockData : \n "+cosmotics;
  }

}


