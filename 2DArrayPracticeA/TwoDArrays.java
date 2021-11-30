public class TwoDArrays{
	public static void main(String[] args){
        System.out.println("--- Practice1 ---");
		String[][]Practice1 = new String[][]
			{{"Cat ", "Bird ", "Turtle "},
			{"Frog ", "Pig ", "Dog "}};

		//Let's print out how many rows we have
        System.out.println("# of Rows: " + Practice1.length);


		//Let's print out how many columns we have
        System.out.println("# of Columns: " + Practice1[0].length);

		//Let's build a new int array
		int[][]Practice2 = new int[2][6];

		//Let's fill this array with specific values
		Practice2[0][0] = 11;
		Practice2[0][1] = 12;
		Practice2[0][2] = 13;
		Practice2[0][3] = 14;
		Practice2[0][4] = 15;
		Practice2[0][5] = 16;
		Practice2[1][0] = 21;
		Practice2[1][1] = 22;
		Practice2[1][2] = 23;
		Practice2[1][3] = 24;
		Practice2[1][4] = 25;
		Practice2[1][5] = 26;

        System.out.println("\n--- Practice2 ---");
		//Let's print out the contents of our String array
        for (int r = 0; r < Practice2.length; r++) {
            for (int c = 0; c < Practice2[r].length; c++) {
                System.out.print(Practice2[r][c] + " ");
            }
            System.out.println();
        }


		//This will call the method below
        System.out.println("\n--- intBuilder ---");
		intBuilder(Practice2);



	}
	//Write a method that takes in an empty array and fills it with random integers between 1 and 10. Print the result as a rectangular grid.
	public static int[][] intBuilder(int[][] a)
	{
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[r].length; c++) {
                a[r][c] = (int) (Math.random() * 10 + 1);
                System.out.print(a[r][c] + " ");
            }
            System.out.println();
        }
		return a;
	}
}
