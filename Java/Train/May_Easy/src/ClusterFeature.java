import java.util.Scanner;

public class ClusterFeature {
	public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();
        int[] x=new int[p+1];
        int[] y=new int[p+1];
        for(int i=1;i<=p;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }
        while(q-->0){
        int x1=sc.nextInt();
        int x2=sc.nextInt();
        int y1=sc.nextInt();
        int y2=sc.nextInt();
        int count=0;
        double x0=0,y0=0;
        for(int i=1;i<=p;i++){
            
            
            if(x[i]>=x1 && x[i]<=x2 && y[i]>=y1 && y[i]<=y2 ){
                x0+=x[i];
                y0+=y[i];
                count++;
            }
            
        }
        if(count>0){
                x0=x0/count;
                y0=y0/count;
            }
        int r2=0;
        int d2=0;
        
        for(int i=1;i<=p;i++){
            if(x[i]>=x1 && x[i]<=x2 && y[i]>=y1 && y[i]<=y2 ){
                r2+=(x[i]-x0)*(x[i]-x0)+(y[i]-y0)*(y[i]-y0);
                for(int j=1;j<=p;j++){
                    if(x[j]>=x1 && x[j]<=x2 && y[j]>=y1 && y[j]<=y2 && i!=j){
                        d2+=(x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]);
//                        System.out.println("i:: "+i+" j::: "+j+" x[i]:: "+x[i]+" y[i]:: "+y[i]+" x[j]:: "+x[j]+" y[j]:: "+y[j]+" d2:: "+d2);
                    }
                }
            }
            
            
        }
        if(count>0){
                r2=r2*count;
                if(count==1){
                    d2=0;
                }
            }
        else{
            r2=0;
            d2=0;
        }
//        System.out.println("x0:: "+x0+" y0:: "+y0+" r2:: "+r2+" d2:: "+d2+" count::: "+count);
        double result=count*x0+count*y0+r2+d2;
        System.out.println((int)result);
            
        }

    
	}
}
