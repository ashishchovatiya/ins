import java.util.*;
import java.math.*;

class RSA
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int p,q,n,n1,d=0,e,i,count=0,count1=0;
		System.out.println("Enter Message");
		int msg=sc.nextInt();
		double c;
		BigInteger msgback; 
		System.out.println("Enter number p");
		p=sc.nextInt();
		System.out.println("Enter number q");
		q=sc.nextInt();
		for(i=2;i<p;i++)
                {
                    if(p%i==0)
                    {
                        count++;
                    }
                }
                for(i=2;i<q;i++)
                {
                    if(q%i==0)
                    {
                        count1++;
                    }
                }
                if(count==0 && count1==0)
                {
		n=p*q;
		n1=(p-1)*(q-1);
                System.out.println("System modulus N = "+n);
		System.out.println("fie(n) = "+n1);		

		for(e=2;e<n1;e++)
		{
			if(gcd(e,n1)==1)           
			{				
				break;
			}
		}
		System.out.println("Encryption Key e = "+e);				
		for(int k=0;k<=9;k++)
		{
			int x=1+(k*n1);
			if(x%e==0)      //d is for private key exponent
			{
				d=x/e;
				break;
			}
		}
		System.out.println("Decryption Key d = "+d);		
		c=(Math.pow(msg,e))%n;
		System.out.println("Encrypted message is : -");
		System.out.println(c);
                //converting int value of n to BigInteger
		BigInteger N = BigInteger.valueOf(n);
		//converting float value of c to BigInteger
		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		msgback = (C.pow(d)).mod(N);
		System.out.println("Derypted message is : -");
		System.out.println(msgback);

	}
        
        else
        {
            System.out.println("Enter prime numbers");
        }
        }
	static int gcd(int e, int n1)
	{
		if(e==0)
			return n1;	
		else
			return gcd(n1%e,e);
	}
}