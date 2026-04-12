import java.util.List;


public class Customer{
	
	private Long identity;

	private String name;

	private int age;

	private String gender;

	private List<Item> items;


	public Customer(){

	}

	public Customer(Long identity,String name,int age,String gender,Item item){
		this.identity = identity;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.items = items;
	}

	public void setIdentity(Long identity){
		 this.identity = identity;
	}

	public Long getIdentity(){
		return this.identity;
	}


	public void setName(String name){
		 this.name = name;
	}

	public String getName(){
		return this.name;
	}


	public void setAge(int age){
		 this.age = age;
	}

	public int getAge(){
		return this.age;
	}


	public void setGender(String gender){
		 this.gender = gender;
	}

	public String getGender(){
		return this.gender;
	}

	public void setItems(List<Item> items){
		 this.items = items;
	}

	public List<Item> getItems(){
		return this.items;
	}

}