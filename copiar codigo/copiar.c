
#include <stdio.h>
#include <stdlib.h>

int  temp1, temp2, temp3, temp4;
char valor1 [20];
char valor2 [20];
char valor3 [20];
char valor4 [20];

void ingresar_valor1 (){
  int j = 0;
  for(j=19;j>0;j--)
  { 
    valor1[j]=temp1%2;
    temp1=temp1/2;
  }
}



void ingresar_valor2 (){
  int j = 0;
  for(j=19;j>0;j--)
  { 
    valor2[j]=temp2%2;
    temp2=temp2/2;
  }
  
}
      
void ingresar_valor3 (){
  int j = 0;
  for(j=19;j>0;j--)
  { 
    valor3[j]=temp3%2;
    temp3=temp3/2;
  }
  
}
      
void ingresar_valor4 (){
  int j = 0;
  for(j=19;j>0;j--)
  { 
    valor4[j]=temp4%2;
    temp4=temp4/2;
  }
  
}


      

int main()
{
      int i=0, j=0, x, multi = 2;
      int tamano = 512*512;
      

      char XOR0[] = "01001100000000001111000000000000";
      char XOR1[] = "01001100000100011111000000000000";
      char XOR2[] = "01001100001000101111000000000000";
      char XOR3[] = "01001100001100111111000000000000";
      char Suma[] = "00011101101110110000000000100000";
      char Comp[] = "11111100000010111100000000000000";
      char move[] = "11011101100000000000000000000001";
      
      char carg0[] = "01111110000000000000000000000000";
      char carg1[] = "01111110000100000000000000000000";
      char carg2[] = "01111110001000000000000000000000";
      char carg3[] = "01111110001100000000000000000000";


      char guar0[] = "01011110000000000000000000000000";
      char guar1[] = "01011110000100000000000000000000";
      char guar2[] = "01011110001000000000000000000000";
      char guar3[] = "01011110001100000000000000000000";


      FILE *archivo;
      archivo = fopen ( "memoriaInstr.txt", "a" );        
      if (archivo==NULL) {fputs ("File error",stderr); exit (1);}
      //fclose ( fp );

      //char buffer[100] = "\n\nEsto es un texto dentro del fichero.";

      //fputs( buffer, archivo );
      //
      //printf("el valor es: %s", carg0);
      for (i = 24; i < tamano; i = i + 32)
      { 
        //printf("valor de i: %d\n",i);

        temp1 = i;
        temp2 = i + 8;
        temp3 = i + 16;
        temp4 = i + 24;
        ingresar_valor1 ();
        ingresar_valor2 ();
        ingresar_valor3 ();
        ingresar_valor4 ();
        
        for (j = 0; j < 32; ++j)
        {
          if(j>=12){

            carg0[j] = valor1[j-12]+'0';
            carg1[j] = valor2[j-12]+'0';
            carg2[j] = valor3[j-12]+'0';
            carg3[j] = valor4[j-12]+'0';

            guar0[j] = valor1[j-12]+'0';
            guar1[j] = valor2[j-12]+'0';
            guar2[j] = valor3[j-12]+'0';
            guar3[j] = valor4[j-12]+'0';
          }
        }


    /*printf("el carg0 es: %s\n", carg0);
      printf("el carg1 es: %s\n", carg1);
      printf("el carg2 es: %s\n", carg2);
      printf("el carg3 es: %s\n", carg3);
      printf("+++++++++++++++++++++++++++++++++++++++++++++\n");
      printf("el guar0 es: %s\n", guar0);
      printf("el guar1 es: %s\n", guar1);
      printf("el guar2 es: %s\n", guar2);
      printf("el guar3 es: %s\n", guar3);*/
     

    fputs( "\n", archivo );
    fputs( "\n", archivo );
    fputs( carg0, archivo );
    fputs( "\n", archivo );
    fputs( carg1, archivo );
    fputs( "\n", archivo );
    fputs( carg2, archivo );
    fputs( "\n", archivo );
    fputs( carg3, archivo );
    fputs( "\n", archivo );

    fputs( XOR0, archivo );
    fputs( "\n", archivo );
    fputs( XOR1, archivo );
    fputs( "\n", archivo );
    fputs( XOR2, archivo );
    fputs( "\n", archivo );
    fputs( XOR3, archivo );
    fputs( "\n", archivo );
     
    //fputs( Suma, archivo );
    //fputs( "\n", archivo );
     
    fputs( guar0, archivo );
    fputs( "\n", archivo );
    fputs( guar1, archivo );
    fputs( "\n", archivo );
    fputs( guar2, archivo );
    fputs( "\n", archivo );
    fputs( guar3, archivo );
    fputs( "\n", archivo );

    //fputs( Comp, archivo );
    //fputs( "\n", archivo );
    

    
    //printf("\n");
      
    //printf("****************************************************\n");

    }

    fputs( move, archivo );
    fputs( "\n", archivo );

    fclose ( archivo );

  return 0;
}