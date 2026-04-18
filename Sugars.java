public class Sugars{

  private Sugar sugar;
  
  public Sugars(){

  }
  
  public void setSugar(Sugar sugar){
  	this.sugar = sugar;
  }

  public Sugar getSugar(){
  	return this.sugar;
  }

   public String toString() {
   	StringBuffer  sb = new StringBuffer("Sugars :\n");

   	Sugar[] enumSugars = Sugar.values();
   	 
   	for(Sugar sugar: enumSugars){
   		sb.append("          ").append(sugar).append("\n");
   	}

   	return sb.toString();
   }
}
