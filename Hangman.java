import java.io.IOException;
import java.util.*;
public class Hangman
{
	public static void main(String ...arg)
	{
		char re='y';
		while(re=='y')
		{
		String words[]={"apple","watermelon","pineapple","banana","grapes","mango","strawberry","papaya","avocado","orange","peach"};
		Random r=new Random();
		int randomnum=r.nextInt(words.length);
		int len=words[randomnum].length();
		Scanner sc=new Scanner(System.in);
		StringBuffer g_word=new StringBuffer(words[randomnum]);
		StringBuffer m_word=new StringBuffer("_"); 
		for(int i=0;i<len-1;i++)
		{
			m_word.append("_");
		}
		System.out.println("Can You Guess The Fruit Names!!!!");
		System.out.println(m_word);
		System.out.println("Hint: try letter 'a' First. And of "+ len + " letters");
		int n=3;
		System.out.println("you have "+n+" chances");
		while(n!=0)
		{			
			System.out.print("Guess a character:");
		    String ch=sc.nextLine();
			if(g_word.indexOf(ch)==-1)
			{
				n--;
				
			}
		    for(int j=0;j<len;j++)
		    {
			    if(ch.charAt(0)==g_word.charAt(j))
			    {
			       m_word.setCharAt(j,ch.charAt(0));
			    }
			
		    }
			cls();
			System.out.println("you have "+n+" chances left");
			System.out.println(m_word);
			if(m_word.indexOf("_")==-1)
		    {
				cls();
				System.out.println(m_word);
			   System.out.println("You won!!!");
			   break;
		    }
	    }
		if(m_word.indexOf("_")>0)
		{
			System.out.println("you lost!!!");
		}
		System.out.print("Press 'y' to play again:");
		re=sc.nextLine().charAt(0);
		}
		
	}
	public static void cls()
			{
				try{
					new  ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
				}catch(Exception E)
				{
					System.out.println(E);
				}
			}
}