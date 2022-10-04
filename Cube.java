import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;


public class Cube {
  public String[][] cube = {
    {
    "r","r","r",
    "r","r","r",
    "r","r","r"
    },
    {
    "b","b","b",
    "b","b","b",
    "b","b","b"
    },
    {
    "o","o","o",
    "o","o","o",
    "o","o","o"
    },
    {
    "g","g","g",
    "g","g","g",
    "g","g","g"
    },
    {
    "y","y","y",
    "y","y","y",
    "y","y","y"
    },

    {
    "w","w","w",
    "w","w","w",
    "w","w","w"
    }
  };
	public static void main(final String[] args)
  throws IOException
  {
  
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Cube rubikscube = new Cube();
    
      boolean argsCheck =false;

      if ( args.length> 0) {
        argsCheck = true;
      }

      boolean proceed = true;

      while (proceed) {
        String input;
        int argsRunIndex = 0;

        ArrayList solve = new ArrayList<>();

        if (!argsCheck) {
          input = reader.readLine();
        }
        else {
          if (argsRunIndex == args.length) {
            argsCheck = false;
            input = "s";
          }else {
            input = args[argsRunIndex];
            argsRunIndex++;
            solve.add(input);
          }
        }

        switch (input) {
          case "u":
          rubikscube.turnedface(4, "c");
          rubikscube.showCube();
          break;
          case "d":
          rubikscube.turnedface(5, "c");
          rubikscube.showCube();
          break;
          case "r":
          rubikscube.turnedface(0, "c");
          rubikscube.showCube();
          break;
          case "l":
          rubikscube.turnedface(2, "c");
          rubikscube.showCube();
          break;
          case "f":
          rubikscube.turnedface(1, "c");
          rubikscube.showCube();
          break;
          case "b":
          rubikscube.turnedface(3, "c");
          rubikscube.showCube();
          break;

          case "u'":
          rubikscube.turnedface(4, "cc");
          rubikscube.showCube();
          break;
          case "d'":
          rubikscube.turnedface(5, "cc");
          rubikscube.showCube();
          break;
          case "r'":
          rubikscube.turnedface(0, "cc");
          rubikscube.showCube();
          break;
          case "l'":
          rubikscube.turnedface(2, "cc");
          rubikscube.showCube();
          break;
          case "f'":
          rubikscube.turnedface(1, "cc");
          rubikscube.showCube();
          break;
          case "b'":
          rubikscube.turnedface(3, "cc");
          rubikscube.showCube();
          break;

          case "s":
            while (solve != null) {
              int i = 0;
             switch (solve.get(solve.size()-i-1)) {
              case "u":
              rubikscube.turnedface(4, "c");
              rubikscube.showCube();
              break;
              case "d":
              rubikscube.turnedface(5, "c");
              rubikscube.showCube();
              break;
              case "r":
              rubikscube.turnedface(0, "c");
              rubikscube.showCube();
              break;
              case "l":
              rubikscube.turnedface(2, "c");
              rubikscube.showCube();
              break;
              case "f":
              rubikscube.turnedface(1, "c");
              rubikscube.showCube();
              break;
              case "b":
              rubikscube.turnedface(3, "c");
              rubikscube.showCube();
              break;
    
              case "u'":
              rubikscube.turnedface(4, "cc");
              rubikscube.showCube();
              break;
              case "d'":
              rubikscube.turnedface(5, "cc");
              rubikscube.showCube();
              break;
              case "r'":
              rubikscube.turnedface(0, "cc");
              rubikscube.showCube();
              break;
              case "l'":
              rubikscube.turnedface(2, "cc");
              rubikscube.showCube();
              break;
              case "f'":
              rubikscube.turnedface(1, "cc");
              rubikscube.showCube();
              break;
              case "b'":
              rubikscube.turnedface(3, "cc");
              rubikscube.showCube();
              break;
            }
            solve.remove(solve.size()-i-1);
            i++;
          }
          break;
          case "q":
          proceed = false;
          break;

        }
      }




      

    };

    public void turnedface(int index, String direction){
      edgedface eface = new edgedface(index);

      String[][] copy = new String [6][9];

      for (int i=0; i<6; i++) {
        for (int j=0; j<9; j++) {
          copy[i][j] = cube[i][j];
        }
      }

      switch(direction) {
        case "c":
        cube[eface.currentface][0] = copy [eface.currentface][2];
        cube[eface.currentface][1] = copy [eface.currentface][5];
        cube[eface.currentface][2] = copy [eface.currentface][8];
        cube[eface.currentface][3] = copy [eface.currentface][1];
        cube[eface.currentface][5] = copy [eface.currentface][7];
        cube[eface.currentface][6] = copy [eface.currentface][0];
        cube[eface.currentface][7] = copy [eface.currentface][3];
        cube[eface.currentface][8] = copy [eface.currentface][6];

        //edge 1 change
        cube[eface.edge1[0]][eface.edge1[1]] = copy[eface.edge4[0]][eface.edge4[1]];
        cube[eface.edge1[0]][eface.edge1[2]] = copy[eface.edge4[0]][eface.edge4[2]];
        cube[eface.edge1[0]][eface.edge1[3]] = copy[eface.edge4[0]][eface.edge4[3]];

        //edge 2 change
        cube[eface.edge2[0]][eface.edge2[1]] = copy[eface.edge1[0]][eface.edge1[1]];
        cube[eface.edge2[0]][eface.edge2[2]] = copy[eface.edge1[0]][eface.edge1[2]];
        cube[eface.edge2[0]][eface.edge2[3]] = copy[eface.edge1[0]][eface.edge1[3]];

        //edge 3 change
        cube[eface.edge3[0]][eface.edge3[1]] = copy[eface.edge2[0]][eface.edge2[1]];
        cube[eface.edge3[0]][eface.edge3[2]] = copy[eface.edge2[0]][eface.edge2[2]];
        cube[eface.edge3[0]][eface.edge3[3]] = copy[eface.edge2[0]][eface.edge2[3]];

        //edge 4 change
        cube[eface.edge4[0]][eface.edge4[1]] = copy[eface.edge3[0]][eface.edge3[1]];
        cube[eface.edge4[0]][eface.edge4[2]] = copy[eface.edge3[0]][eface.edge3[2]];
        cube[eface.edge4[0]][eface.edge4[3]] = copy[eface.edge3[0]][eface.edge3[3]];

        break;
        case "cc":
        cube[eface.currentface][0] = copy [eface.currentface][6];
        cube[eface.currentface][1] = copy [eface.currentface][3];
        cube[eface.currentface][2] = copy [eface.currentface][0];
        cube[eface.currentface][3] = copy [eface.currentface][7];
        cube[eface.currentface][5] = copy [eface.currentface][1];
        cube[eface.currentface][6] = copy [eface.currentface][8];
        cube[eface.currentface][7] = copy [eface.currentface][5];
        cube[eface.currentface][8] = copy [eface.currentface][2];

        //edge 1 change
        cube[eface.edge1[0]][eface.edge1[1]] = copy[eface.edge2[0]][eface.edge2[1]];
        cube[eface.edge1[0]][eface.edge1[2]] = copy[eface.edge2[0]][eface.edge2[2]];
        cube[eface.edge1[0]][eface.edge1[3]] = copy[eface.edge2[0]][eface.edge2[3]];

        //edge 2 change
        cube[eface.edge2[0]][eface.edge2[1]] = copy[eface.edge3[0]][eface.edge3[1]];
        cube[eface.edge2[0]][eface.edge2[2]] = copy[eface.edge3[0]][eface.edge3[2]];
        cube[eface.edge2[0]][eface.edge2[3]] = copy[eface.edge3[0]][eface.edge3[3]];

        //edge 3 change
        cube[eface.edge3[0]][eface.edge3[1]] = copy[eface.edge4[0]][eface.edge4[1]];
        cube[eface.edge3[0]][eface.edge3[2]] = copy[eface.edge4[0]][eface.edge4[2]];
        cube[eface.edge3[0]][eface.edge3[3]] = copy[eface.edge4[0]][eface.edge4[3]];

        //edge 4 change
        cube[eface.edge4[0]][eface.edge4[1]] = copy[eface.edge1[0]][eface.edge1[1]];
        cube[eface.edge4[0]][eface.edge4[2]] = copy[eface.edge1[0]][eface.edge1[2]];
        cube[eface.edge4[0]][eface.edge4[3]] = copy[eface.edge1[0]][eface.edge1[3]];

        break;
      }

    }


class edgedface{
  public int currentface;  //these are the edges of the face we are working on
  int[] edge1 = new int[4]; // where edge1[0] is the face and edge1[1] would be the very first square on that face and so on
  int[] edge2 = new int[4];
  int[] edge3 = new int[4];
  int[] edge4 = new int[4];

  public edgedface(int face){
    currentface=face;
    
    switch(face){
      case 0:
      edge1[0]=1; //the face we are working on 0 (red) is moving edge1[0]=1 which means it will move face 1 (blue)
      edge1[1]=2;
      edge1[2]=5;
      edge1[3]=8;

      edge2[0]=4; //our face is 0 red this changes face 4 yellow
      edge2[1]=2;
      edge2[2]=5;
      edge2[3]=8;

      edge3[0]=3;
      edge3[1]=0;
      edge3[2]=3;
      edge3[3]=6;

      edge4[0]=5;
      edge4[1]=2;
      edge4[2]=5;
      edge4[3]=8;
      break;

      case 1:
      edge1[0]=0; 
      edge1[1]=2;
      edge1[2]=5;
      edge1[3]=8;

      edge2[0]=4; 
      edge2[1]=2;
      edge2[2]=5;
      edge2[3]=8;

      edge3[0]=2;
      edge3[1]=2;
      edge3[2]=5;
      edge3[3]=8;

      edge4[0]=3;
      edge4[1]=0;
      edge4[2]=3;
      edge4[3]=6;
      break;

      case 2:
      edge1[0]=3; 
      edge1[1]=2;
      edge1[2]=5;
      edge1[3]=8;

      edge2[0]=4; 
      edge2[1]=6;
      edge2[2]=7;
      edge2[3]=8;

      edge3[0]=1;
      edge3[1]=0;
      edge3[2]=3;
      edge3[3]=6;

      edge4[0]=5;
      edge4[1]=0;
      edge4[2]=1;
      edge4[3]=2;
      break;

      case 3:
      edge1[0]=0; 
      edge1[1]=2;
      edge1[2]=5;
      edge1[3]=8;

      edge2[0]=4; 
      edge2[1]=6;
      edge2[2]=7;
      edge2[3]=8;

      edge3[0]=2;
      edge3[1]=0;
      edge3[2]=3;
      edge3[3]=6;

      edge4[0]=5;
      edge4[1]=0;
      edge4[2]=1;
      edge4[3]=2;
      break;

      case 4:
      edge1[0]=2; 
      edge1[1]=6;
      edge1[2]=7;
      edge1[3]=8;

      edge2[0]=3; 
      edge2[1]=0;
      edge2[2]=3;
      edge2[3]=6;

      edge3[0]=0;
      edge3[1]=0;
      edge3[2]=1;
      edge3[3]=2;

      edge4[0]=1;
      edge4[1]=2;
      edge4[2]=5;
      edge4[3]=8;
      break;

      case 5:
      edge1[0]=3; 
      edge1[1]=2;
      edge1[2]=5;
      edge1[3]=8;

      edge2[0]=2; 
      edge2[1]=6;
      edge2[2]=7;
      edge2[3]=8;

      edge3[0]=1;
      edge3[1]=0;
      edge3[2]=3;
      edge3[3]=6;

      edge4[0]=0;
      edge4[1]=0;
      edge4[2]=1;
      edge4[3]=2;
      break;

      
    }
  }
}
  public void showCube() {
    for(int i=0; i<6; i++) {
      for(int j=0; j<9; j++) {
        if (j==3 || j==6 || j==9) {
          System.out.println ("");
        }
        System.out.print (cube [i][j]);      
      }
    }
  }

}
