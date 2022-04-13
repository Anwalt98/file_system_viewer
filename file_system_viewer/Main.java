package file_system_viewer;

import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
	static ArrayList<String> withArrow;
	static String insert;
	static ArrayList<String> al;
	static String iterable; 
	static boolean exit = true;
	
	static int arrowMarker = 0 ;
	
	

	static boolean left;
	static boolean right;
	

	public static void main(String[] args) {
		 Path root = getFilesRootDirectory();
	     al = createList(root);
	     ArrayList<String> withArrow = setArrow(al);
	     show(withArrow);
	     
	     changeArrowPlace(al);
	     
	     
	    

     }
	
	
	
	public static Path getFilesRootDirectory() {		
		String s = Paths.get("").toAbsolutePath().toString();
		Path root = (Path.of(s).getRoot());
		return root;	
	}
	
	public static ArrayList<String> createList(Path path) {
		File dir;
	
		ArrayList<String> strings = new ArrayList<>();
		String rootInString = path.toString();
		dir = new File(rootInString);
		for (File items : dir.listFiles()) {
			strings.add("  " + items.toString());
			
		}
return strings;	
}
	
	
	
	public static ArrayList<String> setArrow (ArrayList<String> strings) {
		StringBuilder sb;
		ArrayList<String> stringsCopy = new ArrayList<>();
		for (int i = 0; i < strings.size(); i++) {
			stringsCopy.add(strings.get(i));
		}
		iterable = new StringBuilder(strings.get(arrowMarker)).delete(0, 2).toString();
		sb = new StringBuilder(stringsCopy.get(arrowMarker));	
		sb.setCharAt(1,'\u003e');
		sb.setCharAt(0,'\u003d');
		stringsCopy.set(arrowMarker,sb.toString());
		return stringsCopy;
		
		
	}
	
	public static void show(ArrayList<String> strings) {
		for (var items : strings) {
			System.out.println(items);
		}
	}
	
	public static void changeArrowPlace(ArrayList<String> al) {
	Scanner	sc = new Scanner(System.in);
	while (exit) {
	String inserted = sc.nextLine();
		
	if (inserted.equals("w")) {
		
		arrowMarker --;
		if (arrowMarker == -1) {
			arrowMarker = al.size() - 1;}
		withArrow = setArrow(al);
		
		show(withArrow);
		}
	
		if (inserted.equals("s")) {
			
		
		arrowMarker ++;
		if (arrowMarker == al.size()) {
			arrowMarker = 0;}
		withArrow = setArrow(al);
	
		show(withArrow);
		}
		
		if (inserted.equals("d")) {
			arrowMarker = 0;
			al = createList(currentPath());
		     ArrayList<String> withArrow = setArrow(al);
		     show(withArrow);
			
		}
	    if (inserted.equals("a")) {
	    	arrowMarker = 0;
	    	al = createList(previousDirectory(currentPath()));
	    	ArrayList<String> withArrow = setArrow(al);
		     show(withArrow);
		}
		if (inserted.equals("exit")) {
		exit = false;
		 	}
		}
	}
	
	 
	public static Path currentPath() {
		StringBuilder sb = new StringBuilder();
		char[] f = iterable.toCharArray();
			
			for (int i = 0; i < f.length; i++){
				
				sb.append(f[i]);
				if (f[i] == '\\') {
					sb.append ("\\");
				}
			}
				String g = sb.toString();
				
			Path path = Path.of(g); 
			return path;
			}
	
	public static Path previousDirectory(Path path) {

		Path parentPath = path.getParent().getParent();
		
		return parentPath;
	}
	
	
	
}


	
	


	
	


		
		
				
		
		
		

