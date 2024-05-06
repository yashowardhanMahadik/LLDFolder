public class TokenBucket {
    private int no_of_tokens;
    private int requestCount;
    private int rateLimiterWindowSize;
    private long startRefillTime;
    private long endRefillTime;

    public TokenBucket(int no_of_tokens, int requestCount, int rateLimiterWindowSize) {
        this.no_of_tokens = no_of_tokens;
        this.requestCount = requestCount;
        this.rateLimiterWindowSize = rateLimiterWindowSize;
        this.refill();
    }

    public boolean tryConsume(){
        refill();
        if(this.no_of_tokens > 0){
            this.no_of_tokens--;
            return true;
        }
        else
            return false;
    }

    public void refill() {
        if(System.currentTimeMillis() > this.startRefillTime){
            this.endRefillTime = System.currentTimeMillis();
            this.startRefillTime = this.endRefillTime + this.rateLimiterWindowSize * RateLimiterContants.MULTIPLIER;
        }
    }
}
