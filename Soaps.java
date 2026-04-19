public class Soaps{

  private Soap soap;
  
  public Soaps(){

  }
  
  public void setSoap(Soap soap){
  	this.soap = soap;
  }

  public Soap getSoap(){
  	return this.soap;
  }

   public String toString(){

   	StringBuffer  sb = new StringBuffer("Soaps :\n");

   	Soap[] enumSoaps = Soap.values();
   	 
   	for(Soap soap: enumSoaps){
   		sb.append("          ").append(soap).append("\n");
   	}

   	return sb.toString();

   }
}