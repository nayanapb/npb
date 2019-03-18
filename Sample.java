import java.util.*;
class Sample
{
public static void main(String args[])
{
int i;
int[] ones= new int[10];
Arrays.fill(ones,1);
Arrays.parallelPrefix(ones, (a,b) -> a*b);
for(i=0;i<10;i++)
System.out.println(""+ones[i]);
}
}

