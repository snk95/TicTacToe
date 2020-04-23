package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0-X
    // 1-O
    // 2-null state
    boolean gameActive=true;
    int activePlayer =0;
    int [] gameState ={2,2,2,2,2,2,2,2,2};
    int [][] winPositions={{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};

    public void playerTap(View view){
        ImageView img= (ImageView) view;
        int tappedImage= Integer.parseInt((String) img.getTag());

        if(!gameActive){
            gameReset(view);
        }

        if(gameState[tappedImage] ==2){
            gameState[tappedImage] = activePlayer ;
            img.setTranslationX(-1000f);

            if(activePlayer==0){
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                TextView status= findViewById(R.id.status);
                status.setText("O's turn.. Tap to play");
            }
            else {
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                TextView status= findViewById(R.id.status);
                status.setText("X's turn.. Tap to play");
            }
            img.animate().translationXBy(1000f).setDuration(300);
        }

        for (int [] winposition:winPositions){
            if(gameState[winposition[0]]==gameState[winposition[1]] && gameState[winposition[1]]==gameState[winposition[2]]
            && gameState[winposition[0]]!=2) {
                //somebody won the game
                String winner;
                gameActive = false;
                if(gameState[winposition[0]]==0) {
                    winner="X has won the game" ;
                }
                else {
                    winner="O has won the game" ;
                }
                TextView status= findViewById(R.id.status);
                status.setText(winner);
            }
        }

    }

    public void gameReset(View view){
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
       ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
