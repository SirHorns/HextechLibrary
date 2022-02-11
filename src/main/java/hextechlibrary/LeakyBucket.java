package hextechlibrary;
/**
 * Created by Siddharth on 2/19/18.
 * This class is implemented based on Token bucket algorithm
 */
public class LeakyBucket {

    private final long capacity;

    //private long windowTimeInSeconds;

    long lastRefillTimeStamp;

    long refillCountPerSecond;

    long availableTokens;

    public LeakyBucket(long capacity, long windowTimeInSeconds){
        this.capacity = capacity;
        //this.windowTimeInSeconds = windowTimeInSeconds;
        lastRefillTimeStamp = System.currentTimeMillis();
        refillCountPerSecond = capacity / windowTimeInSeconds;
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
        if(now > lastRefillTimeStamp)
        {
            long elapsedTime = now - lastRefillTimeStamp;
            //refill tokens for this duration
            long tokensToBeAdded = (elapsedTime/1000) * refillCountPerSecond;
            if(tokensToBeAdded > 0) {
                availableTokens = Math.min(capacity, availableTokens + tokensToBeAdded);
                lastRefillTimeStamp = now;
            }
        }
    }
}