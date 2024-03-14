public class Random {

    public static int random(int start , int end )
    {
        int count ;
        count = (int)(Math.random()*(end - start) + start) ;
        return count;
    }
}
