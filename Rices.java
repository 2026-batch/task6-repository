public class Rices{

  private Rice rice;
  
  public Rices(){

  }
  
  public void setRice(Rice rice){
  	this.rice = rice;
  }

  public Rice getRice(){
  	return this.rice;
  }

   public String toString(){

   	StringBuffer  sb = new StringBuffer("Rices :\n");

   	Rice[] enumRices = Rice.values();
   	 
   	for(Rice rice: enumRices){
   		sb.append("          ").append(rice).append("\n");
   	}

   	return sb.toString();

   }
}
