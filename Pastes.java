public class Pastes {

  private Paste  paste ;
  
  public Pastes(){

  }
  
  public void setPaste(Paste paste){
  	this.paste = paste;
  }

  public Paste getPaste(){
  	return this.paste;
  }

   public String toString(){

   	StringBuffer  sb = new StringBuffer("Pastes :\n");

   	Paste[] enumPastes = Paste.values();
   	 
   	for(Paste paste: enumPastes){
   		sb.append("          ").append(paste).append("\n");
   	}

   	return sb.toString();

   }
}