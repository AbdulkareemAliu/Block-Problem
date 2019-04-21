import java.util.ArrayList;
import java.util.HashMap;



class Box{
	public int position;
	public int origin;
	public ArrayList<Box> onTop;

	public Box(int origin){
		this.position = origin;
		this.onTop = null;
		this.origin = origin;
	}

	public ArrayList<Box> getWhatsOnTop() {
		return this.onTop;

	}

	public boolean isBoxOnTop() {
		return this.getWhatsOnTop() != null;
	}
	public int getPosition(){
		return this.position;
	}
	public void moveToOrigin(ArrayList<Box> boxes){
		for (Box b: boxes ) {
			this.position = this.origin;
		}
			
	}
	

}




public class Block{

	private int noOfBoxes;
	
	private HashMap<Integer, ArrayList<Box>> block;

	public Block(int size){
		block = new HashMap<>();
		for (int j=0; j<size ;++j ) {
			this.block.put(new Integer(j), new ArrayList(new Box(j)));

		}

	}
	public void moveToOrigin(ArrayList<Box> boxes){
		for (Box b: boxes ) {
			block.put (b.origin, b);
		}
		
	}
	

	public void moveOver(Box a, Box b) { 
	
		// returns boxes on initial box to initial positions
		
		if (a.isBoxOnTop()){
			moveToOrigin(a.onTop);
		}
		// moves a box over the stack of another
		
		block.add(a.position, b);
		

	}
	public void moveOnto(Box a, Box b) { 
		// moves a box over another
		// if (a.isBoxOnTop()){
		// 	moveToOrigin(a.onTop);
		// }
		// if (b.isBoxOnTop()){
		// 	moveToOrigin(b.onTop);
		}
		// returns box on both boxes to initial position

	// public void pileOnto(Block b) { 
	// 	// moves all boxes on a certain position to another position
	// 	// all boxes on the 2nd position are moved to their initial position
	// 	// boxes retain their order in place

	// }
	// public void pileOver(Block b) { 
	// 	// piles boxes over another pile

	// }

	// public String toString(){
	// 	String str = "";

	// 	for (this.block.keys() box : this.block) {
	// 		str += "" + box + ": " + box.position + "\n";
	// 	}
	// 	return str;
	// }

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		Block b = new Block(size);
		System.out.println(b);

	}
}
