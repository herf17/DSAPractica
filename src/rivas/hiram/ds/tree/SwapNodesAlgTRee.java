package rivas.hiram.ds.tree;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void bfs(List<Integer> lista, Node node){

    }
    public static void swap(){

    }
    public static void NodetoList(Node nodo,List<Integer> iter){
        if(nodo ==null){
            return;
        }
        if(nodo.left != null){
            NodetoList(nodo.left,iter);
        }
        iter.add(nodo.data);
        if(nodo.right != null){
            NodetoList(nodo.right,iter);
        }

    }

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        // Write your code here
        Queue<Node> cola = new LinkedList<>();
        /*Segun problema root siempre es 1*/
        List<List<Integer>> resultado = new ArrayList<>();

        /*Crear tree segun */

        /*Recorrer queries*/
        for(Integer i : queries){
            List<Integer> queryiter = new ArrayList<>();
            NodetoList(resultado,);
            resultado.add(queryiter);
        }
        return resultado;
    }

}

public class SwapNodesAlgTRee {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/vyper/IdeaProjects/DSAPracticas/resources/tree/SwapNodesAlgTree/input/input00.txt"));
        FileWriter file = new FileWriter("ABC.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(file);

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

