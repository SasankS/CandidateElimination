import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CandidateElimination{
	public static void main(String args[]){
		int n;
		int m;
		Scanner s= new Scanner(System.in);
		n=s.nextInt();
		m=s.nextInt();
		//System.out.println(n+m);
		s.nextLine();
		String attributes[][]=new String[m][];
		String specific[]=new String[m];
		List<String[]> generic=new ArrayList<String[]>();
		String temp1=new String();
		for(int i=0;i<m;i++){
			attributes[i]=s.nextLine().split(" ");
			specific[i]="0";
			temp1+="? ";
		}
		generic.add(temp1.split(" "));
		int k = 0;
		for(int i=0;i<n;i++){
			String a[]=s.nextLine().split(" ");
			if(a[m-1].equalsIgnoreCase(attributes[m-1][1])){
				for(int j=0;j<m;j++){
					if(specific[j].equals("0")){
						specific[j]=a[j];
					}
					else{
						if(!specific[j].equals(a[j])){
							specific[j]="?";
						}
					}
				}
				int e;
				for(int d=0;d<generic.size();){
					for(e=0;e<m-1;e++){
						if(!generic.get(d)[e].equals("?")){
							if(!generic.get(d)[e].equals(a[e])){
								generic.remove(d);
								break;
							}
						}
					}
					if(e==m-1){
						d++;
					}
				}
				continue;
			}
			else{
				int size=generic.size();
				List<String[]> temp=new ArrayList<String[]>();
				for(k=0;k<size;k++){
					for(int t=0;t<m-1;t++){
						if(!(generic.get(k)[t].equalsIgnoreCase(a[t]))){
							if(!specific[t].equalsIgnoreCase(a[t])){

								if((!specific[t].equalsIgnoreCase(generic.get(k)[t]))&& !specific[t].equalsIgnoreCase("?") || t==(m-2)){
									String temp2=new String();
									for(int l=0;l<m-1;l++){
										if(l!=t){
											temp2+=generic.get(k)[l]+" ";
										}
										else{
											temp2+=specific[l]+" ";
										}
									}
									temp.add(temp2.split(" "));
								}

							}

						}
					}
				}
				generic.clear();
				for(int f=0;f<temp.size();f++){
					generic.add(temp.get(f));
				}
			}
		}
		int h=0,z=0;
		int g=0,c=0,w=0;
		for(c=0;c<generic.size();){
			w=1;
			for(g=c+1;g<generic.size();){
				h=0;z=0;
				for(int b=0;b<m-1;b++){
					String s1=generic.get(c)[b];
					String s2=generic.get(g)[b];
					if(!s1.equalsIgnoreCase(s2)){
						if(s1.equalsIgnoreCase("?") && !s2.equalsIgnoreCase("?")){
							h++;
						}
						else 
							if(!s1.equalsIgnoreCase("?") && s2.equalsIgnoreCase("?")){
								z++;
							}
					}
				}
				if(h>0 && z==0){
					generic.remove(g);
					if(g==generic.size()){
						w=0;
					}
				}
				else if(z>0 && h==0){
					generic.remove(c);
					if(g==generic.size()){
						w=0;
					}
				}
				else{
					g++;
				}
			}
			if(w==1 && g==generic.size()){
				c++;
			}
		}
		int count2=0;
		System.out.print("S: <");
		for(int i=0;i<m-1;i++){
			if(i!=m-2)
				System.out.print(specific[i]+",");
			else
				System.out.print(specific[i]);
			if(specific[i].equalsIgnoreCase("?")){
				count2++;
			}
		}
		System.out.print(">");
		System.out.println();
		System.out.print("G: ");
		int count10=0;
		if(generic.size()==0){
			for(k=0;k<m-1;k++){
				if(specific[k].equalsIgnoreCase("?")){
					count10++;
				}
				else{
					break;	
				}
			}
			if(count10!=m-1){
				System.out.print("<");
				for(int i=0;i<m-1;i++){
					if(i!=m-2)
						System.out.print(specific[i]+",");
					else
						System.out.print(specific[i]);
					if(specific[i].equalsIgnoreCase("?")){
						count2++;
					}
				}
				System.out.print(">");
				System.out.println();
				System.out.println("Version Space(excluding S and G): NULL");
			System.exit(0);
			}
			else{
			System.out.print("No Target Concept Found");
			System.exit(0);
			}
		}
		for(g=0;g<generic.size();g++){
			System.out.print("<");
			for(int y=0;y<m-1;y++){
				if(y!=m-2)
					System.out.print(generic.get(g)[y]+",");
				else
					System.out.print(generic.get(g)[y]);
			}
			System.out.print(">");
			System.out.print("   ");
		}
		System.out.println();
		s.close();
		List<Integer> xy=new ArrayList<Integer>();
		List<String[]> temp4=new ArrayList<String[]>();
		int count1=0,count4=0,count5=0;
		for(k=0;k<generic.size();k++){
			count5=0;
			for(int ij=0;ij<m-1;ij++){
				if(generic.get(k)[ij].equalsIgnoreCase("?")){
					count5++;
				}
			}
			xy.add(count5);
		}
		int max=xy.get(0);
		for(k=1;k<xy.size();k++){
			if(xy.get(k)>max){
				max=xy.get(k);
			}
		}
		max=max-count2-1;
		int temp6=0;
		System.out.println("Version Space(Excluding S and G): ");
		if(generic.size()==1){
			for(k=0;k<m-1;k++){
				if(!generic.get(0)[k].equalsIgnoreCase(specific[k])){
					temp6=1;
					break;
				}
			}
			if(temp6==0){
				System.out.print("NULL");
				System.exit(0);
			}
		}
		while(max>0){
			temp4.clear();
			xy.clear();
			for(int q=0;q<generic.size();q++){
				for(int r=0;r<m-1;r++){
					if((!specific[r].equalsIgnoreCase(generic.get(q)[r]) && generic.get(q)[r].equalsIgnoreCase("?"))){
						String temp5=new String();
						count1=0;
						for(int v=0;v<m-1;v++){
							if(v!=r){
								temp5+=generic.get(q)[v]+" ";
								if(generic.get(q)[v].equalsIgnoreCase("?")){
									count1++;
								}
							}
							else{
								temp5+=specific[v]+" ";
								if(specific[v].equalsIgnoreCase("?")){
									count1++;
								}
							}
						}

						xy.add(count1);	
						temp4.add(temp5.split(" "));
					}
				}
			}
						for(int ab=0;ab<xy.size();){
							if(xy.get(ab)==count2){
								temp4.remove(ab);
								xy.remove(ab);
								continue;
							}
							ab++;
						}
			int tt=0;
			for(k=0;k<temp4.size();){
				for(tt=k+1;tt<temp4.size();){
					count4=0;
					for(int tt2=0;tt2<m-1;tt2++){
						if(temp4.get(k)[tt2].equalsIgnoreCase(temp4.get(tt)[tt2])){
							count4++;
						}
					}
					if(count4==m-1){
						temp4.remove(tt);
						//System.out.println(k+" "+tt);
						continue;
					}
					tt++;
				}
				if(tt==temp4.size()){

					k++;
				}
			}
			generic.clear();
			for(k=0;k<temp4.size();k++){
				generic.add(temp4.get(k));
			}
			for(int u=0;u<temp4.size();u++){
				System.out.print("<");
				for(int o=0;o<m-1;o++){
					if(o!=m-2)
					System.out.print(temp4.get(u)[o]+",");
					else
						System.out.print(temp4.get(u)[o]+">");
				}
				System.out.println();
			}
			//generic=temp4;
			max--;
		}

	}
}