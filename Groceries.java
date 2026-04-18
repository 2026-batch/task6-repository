public class Groceries{
	
  private Sugars sugars;
  private Rices rices;
  private Wheats wheats;


  public void setSugars(Sugars sugars){
  	this.sugars = sugars;
  }

  public Sugars getSugars(){
  	return this.sugars;
  }

  public void setRices(Rices rices){
    this.rices = rices;
  }
  
  public Rices getRices(){
      return this.rices;
  }

  public void setWheats(Wheats wheats){
    this.wheats = wheats;
  }
  
  public Wheats getWheats(){
      return this.wheats;
  }

  public String toString(){
  	return "Groceries : \n      "+ sugars + "\n      " + rices + "\n      " + wheats;
  }
}
