public class Cosmotics{
	
  private Soaps soaps;
  private Pastes pastes;


  public void setSoaps(Soaps soaps){
  	this.soaps = soaps;
  }


  public Soaps getSoaps(){
  	return this.soaps;
  }

  public void setPastes(Pastes pastes){
    this.pastes = pastes;
  }
  
  public Pastes getPastes(){
      return this.pastes;
  }


  public String toString(){
  	return "Cosmotics : \n      "+soaps +  "\n      " + pastes;
  }
}