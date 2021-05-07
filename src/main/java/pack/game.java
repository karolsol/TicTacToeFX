package pack;


public class game{
    private int g=0; //variable to count occupied areas
    private String[][] tab = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "},
    };

    public boolean isEmpty(int x, int y){
        boolean value=false;
        if (tab[x][y].equals(" ")){
            if(!win("X")||!win("O")){
                value = true;
            }
        }
        return value;
    }
    public void play(int x, int y, String c){
            tab[x][y] = c;
            g++;
    }
    private boolean checker(String b){
        boolean value = false;
        for (int i = 0; i < 3; i++){
            if (tab[0][i].equals(b) && tab[1][i].equals(b) && tab[2][i].equals(b)||
                tab[i][0].equals(b) && tab[i][1].equals(b) && tab[i][2].equals(b)){
                    value = true;
                    break;
            }
        }
        return value;
    }
    public boolean win(String a){
        boolean value = false;
        if(checker(a)){
            value=true;
        }else if(!tab[1][1].equals("c")){
            if(tab[1][1].equals(a)){
                String b = tab[1][1];
                if (tab[0][0].equals(b) && tab[2][2].equals(b) || tab[0][2].equals(b) && tab[2][0].equals(b)){
                    value = true;
                }
            }
        }
        return value;
    }
    public boolean draw(){
        boolean value = false;
        if (g == 9){
            value = true;
        }
        return value;
    }
    public void clear(){
        g=0;
        for(int i=0;i<3;i++){
            for(int b=0;b<3;b++){
                tab[i][b]=" ";
            }
        }
    }
}

