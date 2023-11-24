package rivas.hiram.ds.heaps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HeapMinImpl {
    int MAX_size = 100000;
    int[] valores = new int[MAX_size + 1];

    int tamano= 0;

    public void swap(int indx1, int indx2){
        int temp = valores[indx1];
        valores[indx1] = valores[indx2];
        valores[indx2] =temp;
    }

    public void add(int val){
        valores[tamano] = val;
        tamano++;
        hepifyup();
    }

    public void borrar(int val){
        int j = IntStream.range(0, valores.length)
                .filter(i -> valores[i] == val)
                .findFirst()
                .orElse(-1);
        if (j == -1) {
            throw new RuntimeException("Error: Not found");
        }
        tamano--;
        valores[j] = valores[tamano];
        hepifydown(j);
    }

    public int poll(){
        int val = valores[0];
        tamano--;
        valores[0] = valores[tamano];
        hepifydown(0);
        return val;
    }

    public void hepifyup(){
        int indc =tamano-1;
        while ( hasParent(indc) && valores[indc]< valores[getParent(indc)]){
            swap(indc, getParent(indc));
            indc= getParent(indc);
        }
    }
    public void hepifydown(int indx){
        while(hasleftchild(indx)){
            int pequenoleftright = getleftChild(indx);
            if (hasrigthchild(indx) && getRightChild(indx)<getleftChild(indx)){
                pequenoleftright = getRightChild(indx);
            }
            if(valores[indx] < valores[pequenoleftright]){
                break;
            }else{
                swap(indx,pequenoleftright);
            }
            indx=pequenoleftright;
        }
    }
    public boolean isFull(){
        return true;
    }
    public boolean hasleftchild(int indx){
        return getleftChild(indx)<tamano;
    }
    public boolean hasrigthchild(int indx){
        return getRightChild(indx)<tamano;
    }
    public int getleftChild(int indx){
        return (indx*2)+1;
    }
    public int getRightChild(int indx){
        return (indx*2)+2;
    }
    public int getParent(int index){
        /*Formula devolver parent index debe ser floor java automatico lo hace*/
        return (index-1)/2;
    }

    public boolean hasParent(int indx){
        int parent =getParent(indx);
        return parent >= 0;
    }

    public int peek(){
        if (isEmpty())
            throw new RuntimeException("Error: Heap is empty");

        return valores[0];
    }

    public boolean isEmpty() {
        return tamano <= 0;
    }

    public static void main(String[] args){
        HeapMinImpl heapMin = new HeapMinImpl();
        try(BufferedReader buff = new BufferedReader(new FileReader("/home/vyper/IdeaProjects/DSAPracticas/resources/heap/heapminimpl/input/input10.txt"));){
            String line = buff.readLine();
            //System.out.println(line+" QTY");
            int qnt =Integer.parseInt(line);
            line = buff.readLine();
            while (line != null){
                /*for (int i = 0 ; i< qnt; i++){
                }*/
                if(line.split(" ").length>1){
                    int opert=Integer.parseInt(line.split(" ")[0]);
                    //System.out.println("OPR: "+opert);
                    int value=Integer.parseInt(line.split(" ")[1]);
                    //System.out.println("VALU: "+value);
                    if (opert == 1){
                        heapMin.add(value);
                    }else{
                        heapMin.borrar(value);
                    }
                }else{
                    System.out.println(heapMin.peek());
                }

                //System.out.println(line);
                line = buff.readLine();
            }
        }
        catch (IOException ioe){

        }
        //System.out.println(Arrays.toString(heapMin.valores));

    }
}
