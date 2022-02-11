package hextechlibrary;
/**
 * Created by Siddharth on 2/19/18.
 * This class is implemented based on Token bucket algorithm
 */
public class DualLeakyBucket {

    private final long capacity;

    //private long windowTimeInSeconds;

    //Timings work in seconds.
    long lastRefillTimeStampSeconds;
    long lastRefillTimeStampMinutes;

    long refillCountPerSecond;
    long refillCountPerMinute;

    long availableTokens;

    public DualLeakyBucket(long capacity, long windowTimeInSeconds,long windowTimeInMinutes){
        this.capacity = capacity;
        //this.windowTimeInSeconds = windowTimeInSeconds;
        lastRefillTimeStampSeconds = System.currentTimeMillis();
        lastRefillTimeStampMinutes = System.currentTimeMillis();

        refillCountPerSecond = capacity / windowTimeInSeconds;
        refillCountPerMinute = capacity / (windowTimeInMinutes * 60);

        availableTokens = 0;
    }

    public long getAvailableTokens(){
        return this.availableTokens;
    }

    public boolean tryConsume(){
        refill();

        if(availableTokens > 0)
        {
            --availableTokens;
            return true;
        }
        else
        {
            return false;
        }
    }

    private void refill(){
        long now = System.currentTimeMillis();

        //

        if(now > lastRefillTimeStampMinutes){
            long elapsedTime2 = now - lastRefillTimeStampMinutes;
            //refill tokens for this duration
            long tokensToBeAdded = (elapsedTime2/1000) * refillCountPerMinute;
            if(tokensToBeAdded > 0) {
                availableTokens = Math.min(capacity, availableTokens + tokensToBeAdded);
                lastRefillTimeStampSeconds = now;
            }
        }


        if(now > lastRefillTimeStampSeconds)
        {
            long elapsedTime = now - lastRefillTimeStampSeconds;
            //refill tokens for this duration
            long tokensToBeAdded = (elapsedTime/1000) * refillCountPerSecond;
            if(tokensToBeAdded > 0) {
                availableTokens = Math.min(capacity, availableTokens + tokensToBeAdded);
                lastRefillTimeStampSeconds = now;
            }
        }
    }
}