public class Wheats{

  private Wheat wheat;
  
  public Wheats(){

  }
  
  public void setWheat(Wheat wheat){
  	this.wheat = wheat;
  }

  public Wheat getWheat(){
  	return this.wheat;
  }

   public String toString(){

   	StringBuffer  sb = new StringBuffer("Wheats :\n");

   	Wheat[] enumWheats = Wheat.values();
   	 
   	for(Wheat wheat: enumWheats){
   		sb.append("          ").append(wheat).append("\n");
   	}

   	return sb.toString();

   }
}
