package practicos.Practico9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class ColeccionesJava {
    public static void ejecutar() {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        LinkedHashMap<String, TreeMap<String, Integer>> linkedHashMap = new LinkedHashMap<>();

        // Ejemplo de uso en cada colección
        arrayList.add("Elemento ArrayList");
        linkedList.add("Elemento LinkedList");
        hashMap.put("clave", 1);
        treeMap.put("clave", 1);
        linkedHashMap.put("linkedClave", treeMap);

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("HashMap: " + hashMap);
        System.out.println("TreeMap: " + treeMap);
        System.out.println("LinkedHashMap: " + linkedHashMap);
    }
}
