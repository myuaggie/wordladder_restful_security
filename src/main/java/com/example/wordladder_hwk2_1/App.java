package com.example.wordladder_hwk2_1;

import java.io.*;
import java.util.*;


//import com.leafive.test.maven5.App;

public class App {
	private Queue<Stack<String>> candidate;
	private Set<String> smallDict;
	private boolean flag;
	private String res="";
	private String word1;
	private String word2;
	private String dict;
	
	public App(String dict,String word1,String word2){
		this.dict=dict;
		this.word1=word1;
		this.word2=word2;
		this.flag=false;
	}
	public String getRes(){
		// TODO Auto-generated method stub
		Set<String> dict= new HashSet<String>();
		//String word1,word2;
		//int tryWord;
		//System.out.print("Dictionary file name? ");
		//BufferedReader br = new BufferedReader(new 
               // InputStreamReader(System.in));
		//String fileName=br.readLine();
		//System.out.println(fileName);
		//get the dictionary file
		
		//String fileName=this.getClass().getResource("/").getPath().toString();
		/*File file = new File(fileName+"res/"+this.dict);
		if (!file.exists()) {
			res=this.dict+" no existence.";
			return res;
			//fileName=br.readLine();
			//file=new File(fileName);
		}*/
		ClassLoader cl = this.getClass().getClassLoader();
		InputStream inputStream;
		//FileInputStream inputStream=null;
		inputStream =cl.getResourceAsStream("res/"+this.dict);
		if (inputStream==null){
			res=this.dict+" no existence.";
			return res;
		}
		BufferedReader brDict = new BufferedReader(new InputStreamReader(inputStream));
        String dictLine="";
		try {
			dictLine = brDict.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        while (dictLine != null) {
        		//System.out.println(dictLine);
        		dict.add(dictLine);
        		try {
					dictLine=brDict.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
        try {
			brDict.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //get the words in dictionary
        
        
        //while (true) {
	      //  System.out.print("Word #1 (or Enter to quit): ");
	        //tryWord=br.read();
	        //System.out.println(tryWord);
	        //if (tryWord==10) {break;}
	       // word1=(char)tryWord+br.readLine();
	        this.word1=this.word1.toLowerCase();
	        //System.out.println(word1);
	       // System.out.print("Word #2 (or Enter to quit): ");
	       // tryWord=br.read();
	       // if (tryWord==10) {break;}
	       // word2=(char)tryWord+br.readLine();
	        this.word2=this.word2.toLowerCase();
	        //System.out.println(word2);
	        //get start word and the end word
	        
	        if (this.word1.compareTo(this.word2)==0) {
	        		res="The two words must be different.";
	        		return res;
	        }
	        else if (this.word1.length()!=this.word2.length()) {
	        		res="The two words must be the same length.";
	        		return res;
	        }
	        else if (!dict.contains(word1)||!dict.contains(word2)) {
	        		res="The two words must be found in the dictionary.";
	        		return res;
	        }
	        //check the possible error case
	        
	        this.smallDict= new HashSet<String>();
	        Iterator<String> it = dict.iterator();  
	        String fit;
	        while (it.hasNext()) {  
	        	  fit = it.next(); 
	        	  if (fit.length()==word1.length())
	        		  this.smallDict.add(fit);
	        	}
	        //filter the dictionary according to the length of word
	        
	        this.candidate=new LinkedList<Stack<String>>();
	        Stack<String> ladder=new Stack<String>();
	        ladder.add(word1);
	        this.smallDict.remove(word1);
	        this.candidate.offer(ladder);
	    
	        this.findNeighbor(word2);
	        while (!this.candidate.isEmpty() && !this.flag) {
	        		this.findNeighbor(word2);
	        }
	        if (this.flag) {
	        		ladder=this.getTail();
	        		return this.printLadder(ladder,word1,word2);
	        }
	        else {
	        		res="No word ladder found from "+word2+" back to "+word1+".";
	        		return res;
	        }
	        
	        
	       // wl.candidate.clear();
	       // wl.smallDict.clear();
	       // wl.flag=false;
	        //clear the container
     //   }
       // System.out.println("Have a nice day.");
	}
	
	
	
	public void findNeighbor(String target) {
		//find the suitable words
		Stack<String> temp=this.candidate.poll();
		Stack<String> t;
		String word=temp.peek();
		String cddWord;
		String part1="",part2="";
		for (int j='a';j<='z';j++) {
			cddWord=(char)j+word.substring(1);
			if (this.smallDict.contains(cddWord)) {
				//System.out.println(cddWord);
				temp.push(cddWord);
				t=copyStack(temp);
				this.candidate.offer(t);
				temp.pop();
				this.smallDict.remove(cddWord);
				if (cddWord.compareTo(target)==0) {
					this.flag=true;
					return ;
				}
			}
		}
		for (int i=0;i<word.length()-2;i++) {
			for (int j='a';j<='z';j++) {
				part1=word.substring(0, 1+i);
				part2=word.substring(2+i,word.length());
				cddWord=part1+(char) j+part2;
				if (this.smallDict.contains(cddWord)) {
					//System.out.println(cddWord);
					temp.push(cddWord);
					t=copyStack(temp);
					this.candidate.offer(t);
					temp.pop();
					this.smallDict.remove(cddWord);
					if (cddWord.compareTo(target)==0) {
						this.flag=true;
						return;
					}
				}
			}
		}
		for (int j='a';j<='z';j++) {
			cddWord=word.substring(0,word.length()-1)+(char)j;
			if (this.smallDict.contains(cddWord)) {
				//System.out.println(cddWord);
				temp.push(cddWord);
				t=copyStack(temp);
				this.candidate.offer(t);
				temp.pop();
				this.smallDict.remove(cddWord);
				if (cddWord.compareTo(target)==0) {
					this.flag=true;
					return ;
				}
			}
		}
		
		
	}
	
	public Stack<String> getTail(){
	Stack<String> stk=null;
	while (!this.candidate.isEmpty()) {
	stk=this.candidate.poll();
	}
	return stk;
	}
	
	public String printLadder(Stack<String> stk,String str1,String str2) {
		//print the wordladder
		res+="A ladder from "+str2+" back to "+str1+":";
		while (!stk.empty()) {
			res+=stk.pop()+" ";
		}
		res+="\n";
		return res;
	}
	
	public Stack<String> copyStack(Stack<String> stk){
		Stack<String> s=new Stack<String>();
		Stack<String> q=new Stack<String>();
		while (!stk.empty()) {
			q.push(stk.pop());
		}
		while (!q.isEmpty()) {
			stk.push(q.peek());
			s.push(q.pop());
		}
		return s;
}
}
