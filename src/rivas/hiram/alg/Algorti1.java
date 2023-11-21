package rivas.hiram.alg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Algorti1{
    public static void main(String[] args) {
        //System.out.println("Hellow Wld! "+recursionejem(4));
        /*int arr[] = { 12, 11, 13, 5, 6, 7 };
        for(int j:arr){
          System.out.println(j);
          }
        System.out.println("Array sorteado");
        //MergeSort(arr,0,arr.length);
        //quickSort(arr,0,arr.length-1);
        countingSort(arr, 5,13);
        for (int i : arr) {
            System.out.println(i);
        
        }*/

        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(200);
        int[] arreglo = new int[200];
        //Integer[] arreglo = new Integer[100];
        for(int i =0 ; i<200;i++){
            arreglo[i] = rand.nextInt(200);
        }
        for(int x: arreglo){
            System.out.print(" "+x);
        }
        System.out.println();
        System.out.println(arreglo.length);
        /*countig sort*/
        //List<Integer> ordenado = countingSort(Arrays.asList(arreglo));
        /*radix*/
        int[] ordenado = radixSort(arreglo);
        System.out.println("Ordenado");
        System.out.println(Arrays.toString(ordenado));
        for(int i: ordenado){
            System.out.print(i +" ");
        }
        System.out.println();
        System.out.println(ordenado.length);
    }
    /*Ejemplo arreglo={5,2,9,-2} 
     * MergeSort(arreglo,0,4)
     * 4<2 false
     * Recursive
     * MergeSort(arreglo,0,2)
     * MergeSort(arreglo,2,4)
    */
    public static void MergeSort(int[] arr,int indini,int indfin){
        //saber si el arreglo pasado es de 1 elemento
        if(indfin-indini < 2)//indfin-indini
            return;
        //sacar punto medio
        int mid= (indini + indfin) / 2;
        //left array
        MergeSort(arr,indini,mid);
        //right array
        MergeSort(arr,mid,indfin);

        //Merge
        Mergee(arr, indini, mid, indfin);
    

    }

    public static void Mergee(int[] arr,int indini, int mid, int indfin){
        /*como los arrglos ya vienen ordenados
         * si el elemnto de la izquierda es menor que el elemnto de la derecha significa
         * que ya estan ordenas y no se tiene que ordenar ejem 12345
         * mid es primer elemento de right array y mid -1 es el ultimo elemnt de left array
        */
        if(arr[mid-1] <= arr[mid]){ return;}
        int i = indini;
        int j = mid;
        int tempindex = 0;
        int[] temparray = new int[indfin-indini];
        //for(int i =0; i < arr.length;i++){if () {}}
        //recorrer arreglo hasta que uno de los 2 se no tenga mas iteraciones
        //en ese caso cualquiera de los arreglos izquierda o derecha faltara
        //agregarlo al areglo temporal por lo que se debe de agregar el restante
        while(i < mid && j<indfin){
            temparray[tempindex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            //                              = porque es stable y preservar duplicate order
        }
        //manejar el restante que se tiene que agregar contemplando ambos casos si es
        //de left o right array y copiar al temp array
        //ussar System.arrayCopy()
        //para insertar si tiene residuo left array, todos del left array completar la 
        //iteracion, el llamado no altera el copy array
        System.arraycopy(arr,i,arr,indini+tempindex,mid-i);
        System.arraycopy(temparray,0,arr,indini,tempindex);
        //el while termina el loop cuando cualquiera de los 2 i o j terminen de recorrer
        //recordar mid es el ultimo index de left array y indfin es el ultimo indice de right todos
        //exclusivos ultimo indice. Al terminar
        //por eso en caso de que todavia falten recorrer el otr array se debe de 
        //agregar, si es del lado de la izquierda se debe de añadir al arrey temporal pero si
        //es right array solo se pega lo remediado a la derecha y son mayores porque ya estan 
        //ordenados y no afecta la pocision que estaba antes de ser dividido
        //ejemplo {32, 34}, {33,36}
        //        {32, 33, 34, 36} como esta a la derecha 36 no cambia de pocision a como estaba
        //antes de ser llamado por eso no es necesario si es right agregarlo al temp array
        //pero si del lado izquierdo si cambia de pocision a como estaba antes por eso
        // si se tiene que aagregar al temp array
        

    }
    public static void quickSort(int[] arr, int init, int finn){
      if(finn - init < 2){
        return;
      }
      int pivotindex = quickPartition(arr, init, finn);
      quickSort(arr, init, pivotindex-1);
      quickSort(arr, pivotindex +1, finn);
    }
    public static int quickPartition(int[] arr, int inicial, int finalll){
      //version en el que pivot siempre es el ultimo indice
      int pivot = arr[finalll];
      int i = inicial-1;
      for(int j = inicial;finalll >= j ;j++){
        if(arr[j]<pivot){
          i++;
          int tempswampij = arr[i];
          arr[i] =arr[j];
          arr[j] = tempswampij;
          
        }
        
        }
        //i++ es la pocision que debe de estar el pivot despues de recorrer
        //el arreglo
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[finalll]= temp;
        return i;
      }
    public static int[] countingSortRadix09(int[] arr,int lenarr){
        /*(solo numero 0 o positivo)0 a k(mayor numero del arreglo)
        * n(minimo elemento)*/
        int [] dist = new int[10];
        for(int i: arr){
            dist[(i / lenarr) % 10]++;
        }
        for(int j=1;j < 10;j++ ){
            dist[j]= dist[j-1]+dist[j];
        }
        int[] listsort = new int[arr.length];
        for(int j = arr.length - 1; j >= 0; j--){
            int numval = arr[j];
            //System.out.println(numval);
            int index =dist[(numval / lenarr) % 10];
            index--;
            listsort[index]= numval;
            dist[(numval / lenarr) % 10]= index;
        }
        return listsort;
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] arrdist = new int[100];
        //Arrays.fill(arrdist,new Integer(0));
        for(int i = 0; i<arr.size(); i++){
            arrdist[arr.get(i)]++;
        }
        for(int t: arrdist){
            System.out.print(" "+t);
        }
        for(int j=1;j <= arrdist.length-1; j++){
            //System.out.println(j);
            arrdist[j]= arrdist[j-1]+arrdist[j];
        }
        Integer[] listsort = new Integer[arr.size()];
        for(int j = arr.size() - 1; j >= 0; j--){
            int numval = arr.get(j);
            //System.out.println(numval);
            int index =arrdist[numval];
            index--;
            listsort[index]= numval;
            arrdist[numval]= index;
        }
        List<Integer> list = Arrays.asList(listsort);
        return list;

    }

    public static void countSort(List<List<String>> arr) {
        //actualizar - first half
        for(int i = 0 ; i<arr.size();i++){
            if(i<arr.size()/2) {
                arr.get(i).set(1, "-");
            }
        }
        //Integer.valueOf()
        //conteo de dist
        int[] dist = new int[100];
        for(int i = 0; i<arr.size(); i++){
            dist[Integer.valueOf(arr.get(i).get(0))]++;
        }
        // arreglo de dist nums
        for(int j=1;j <= dist.length-1; j++){
            //System.out.println(j);
            dist[j]= dist[j-1]+dist[j];
        }
        //recorrer arrreglo
        String[] listsort = new String[arr.size()];
        for(int j = arr.size() - 1; j >= 0; j--){
            int numval = Integer.valueOf(arr.get(j).get(0));
            //System.out.println(numval);
            int index =dist[numval];
            index--;
            listsort[index]= arr.get(j).get(1);
            dist[numval]= index;
        }
        StringBuilder sb = new StringBuilder();
        for(int y=0; y<listsort.length; y++){
            sb.append(listsort[y]).append(" ");
        }
        System.out.print(sb.toString());
    }

    public static int[] radixSort(int[] arr){
        //buscar max para saber el width
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        /* iteraciones
        *1 iteracion se empieza con 1
        * 2 iteracion exp se actualiza en 10 y si numero mayor tiene 2 digitos solo se ejecuta hasta aqui
        * n iteraciones hasta que al hacer la division de mayor a 1 ejemplo cuando numero mayor sea 1300 se para al
        * { 12, 11, 13, 5, 1300, 7 };
        * 1300/ 1000=1.3 true cotinua when 1300/ 10000= 0.13*/


        for(int i= 1; max/i>0; i *= 10){
            System.arraycopy(countingSortRadix09(arr,i),0,arr,0,arr.length);
        }

        return arr;
    }
    
    //stack caso 3
    //recursionejem(0) pop->1
    //recursionejem(1) 1 * 1->1
    //recursionejem(2) 2 * 1->2 
    //recursionejem(3) 3 * 2->6
    public static int recursionejem(int fact){
        if(fact == 0)
            return 1;
        else
            return fact* recursionejem(fact-1);
    }
}