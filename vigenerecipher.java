import java.io.*;


public class vigenerecipher
{
public String encrypt(String keyword, String line) //Encryption Method with input as KEY and PLAIN-TEXT
{
String result="";
int offset;
int j=0,shift;
for(int i=0;i<line.length();i++)
{
if(line.charAt(i)>='a'&&line.charAt(i)<='z') // For Lower Case
{
shift=((int)keyword.charAt(j))-97;
j++;
j%=keyword.length();
offset=((int)(line.charAt(i)))-97;
offset=(offset+shift)%26;
result+=(char)(offset+97);
}
else if(line.charAt(i)>='A'&&line.charAt(i)<='Z') //For Upper Case
{
shift=((int)keyword.charAt(j))-65;
j++;
j%=keyword.length();
offset=((int)(line.charAt(i)))-65;
offset=(offset+shift)%26;
result+=(char)(offset+65);
}
else
result=result+line.charAt(i);
}
return result;
}

public String decrypt(String keyword, String line) //Decryption Method with input as Cipher-Text and Key
{
String result="";
int offset;
int j=0,shift;
for(int i=0;i<line.length();i++)
{
if(line.charAt(i)>='a'&&line.charAt(i)<='z') //For Lower Case
{
if(line.charAt(i)!=' ')
{
shift=((int)keyword.charAt(j))-97;
j++;
j%=keyword.length();
offset=((int)(line.charAt(i)))-97;
offset=(offset-shift)%26;
if(offset<0)
offset+=26;
result+=(char)(offset+97);
}
}
else if(line.charAt(i)>='A'&&line.charAt(i)<='Z') //For Upper Case
{ 
if(line.charAt(i)!=' ')
{
shift=((int)keyword.charAt(j))-65;
j++;
j%=keyword.length();
offset=((int)(line.charAt(i)))-65;
offset=(offset-shift)%26;
if(offset<0)
offset+=26;
result+=(char)(offset+65);
}
}
else
result=result+line.charAt(i);
}
return result;
}

public static void main(String args[])throws IOException //Main Method 
{
vigenerecipher obj=new vigenerecipher();
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
int choice;
System.out.println("");
System.out.println("Menu:\n1: Encryption\n2: Decryption");
choice=Integer.parseInt(in.readLine());
System.out.println("");
System.out.println("Enter the keyword: ");
String keyword=in.readLine();
System.out.println("");
System.out.println("Enter the Plain-Text: ");
String line=in.readLine();
System.out.println("");
System.out.println("Result:");

switch(choice)
{
case 1:	{
		System.out.println("");
		System.out.println(obj.encrypt(keyword,line));
		}
break;
case 2: {
		System.out.println("");
		System.out.println(obj.decrypt(keyword,line));
		}
break;
default:
		{
		System.out.println("");
		System.out.println("Invalid input!");
		}
break;
}
}
}