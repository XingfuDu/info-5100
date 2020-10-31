public class Pet {
    
    private String name;
    private String ownerName;
    private String color;
    protected int sex;
    final int MALE = 1;
    final int FEMALE = 2;
    final int SPAYED = 3;
    final int NEUTERED = 4;
     
    public Pet(String name, String ownerName, String color) {
	this.name = name;
	this.ownerName = ownerName;
	this.color = color;
    }
    
    public String getPetName() {
	return name;
    }
    
    public String getOwnerName() {
	return ownerName;
    }

    public String getColor() {
	return color;
    }

    public void setSex(int sexid) {
	sex = sexid;
    }

    public String getSex() {
        switch(sex) {
	case MALE:
	    return "Male";
	case FEMALE:
	    return "Female";
	case SPAYED:
	    return "Spayed";
	case NEUTERED:
	    return "Neutered";
	}
	return null;
    }

    @Override
    public String toString() {
	String text = getPetName() + " owned by " + getOwnerName();
	text += "\n" + "Color: " + getColor();
	text += "\n" + "Sex: " + getSex();
	return text;
    }
}