package package1;

public class Solution {
	private int id_solution, id_bulletin;
	private String description;
	

	public int getId_bulletin() {
		return id_bulletin;
	}
	public void setId_bulletin(int id_bulletin) {
		this.id_bulletin = id_bulletin;
	}
	public int getId_solution() {
		return id_solution;
	}
	public void setId_solution(int id_solution) {
		this.id_solution = id_solution;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription (String description) {
		this.description = description;
	}
	public Solution(int id_solution, int id_bulletin, String description) {
		super();
		this.id_bulletin = id_bulletin;
		this.id_solution = id_solution;
		this.description = description;
	}
	public Solution() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
