/** Emanuel lopez
 * 			importar un documento de texto que contenga [], {} y ().
 * 			agrupar el simbolo con su respetivo par, es imprimir un SI y un NO si contiene impares o en mal ordenados
 * 			se usara un arreglo como pila, el simpolo que abre se agregara en el arreglo y el simbolo que cierre eliminara su par que abre...
 */
package ee_t02_pilas01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class pilas01
{
    public  char arra[];
    public char c;
    public boolean sts=true;
    public void pila(String cadena)								// se ingrasa una cadena de simpolos
    { try{
        int x=0;
        int t=0;
        arra=new char[cadena.length()];								//tamaño de arreglo
      while(x<=cadena.length()-1){
       c=cadena.charAt(x);											// separar la cadena ingresada
        if(c=='{' || c=='(' || c=='['){ arra[t]=c;					// se incerta en el arreglo
        	t++;
          }else if(c=='}' || c==')' || c==']'){  char a=0;			// buscar su par en tope del arreglo
         switch(c){
              case ']':
                 a='[';   break;
              case ')':
                 a='(';  break;
              case '}':
                 a='{';   break; 
        }   t--;
        if(t>=0&& a==arra[t] ){ 									
        arra[t]=0;													// eliminar su par en el arreglo
        }else{sts=false;}
        }else if(x==cadena.length()){								// recorrer el arreglo para deteminar que `no haya ningun simpolo impar
		for(int i=0;i<=cadena.length();i++){
		if(arra[i]!=0){sts=false;}
	  }
	}else{System.out.println("subdesbordamiento "+c);}				//error de desbordamiento 
   x++; 
 }
      if(sts==true){System.out.println("SI");}else{ System.out.println("NO");}  ///imprimir el resultado
  } catch(Exception e){System.out.println("No existe ");}
}
public static void main(String []args) throws IOException{					////////--->MENU PRINCIPAL  
         int tamaño=0;
          FileReader Ar =new FileReader("Dts.txt");							//AGREGAR EL NOMBRE DE ARCHIVO.(Dts.txt)
          String cadena=null;												
          BufferedReader s =new BufferedReader(Ar);
          while ((cadena=s.readLine())!=null){       						//leer los datos que contine el archivo
          if(tamaño==0){                   									//se toma el primer dato para el tamaño de arreglo
          tamaño=Integer.parseInt(cadena);									//convertir de String a entero para el numero de elemntoe
          System.out.println(" "+tamaño+" pilas");  }
          else{		
          pilas01 p=new pilas01();
          p.pila(cadena);													// Ingresar cada cadena en el parametro de pila
        }
      }
	}
}