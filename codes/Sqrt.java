public class Sqrt {
    // y = x^2 - n
    // first guess a x_0
    // tangential equation l_0: f(x) = f(x_0) + f'(x_0)(x - x_0)
    // let f(x) = 0, to get the intersection of l_0 and x axis
    // x = -f(x_0)/f'(x_0) + x_0 = -(x_0^2 - n)/(2*x_0) + x_0 = x_0/2 + n/2*x_0
    public int mySqrt(int x) {
        double res,last;
        if(x==0)return 0;
        res = 1;
        last = 0;
        while(res!=last){
            last = res;
            res = (res + x/res)/2;
        }
        return (int)res;
    }
}
