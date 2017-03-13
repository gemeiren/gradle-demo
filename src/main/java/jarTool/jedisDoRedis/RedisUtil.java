package jarTool.jedisDoRedis;
/** 
 * @Description: http://www.cnblogs.com/liuling/p/2014-4-19-04.html#3390792
 * http://www.cnblogs.com/liuling/p/2014-4-20-01.html
 * @date 2016年3月29日  上午10:17:23
 */
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description 缓存测试
 * VSCM_REDIS_IP=10.199.169.237
 * VSCM_REDIS_PORT=6379
 * @date 2016年3月29日  上午10:40:20
 */
public final class RedisUtil {
    
    //Redis服务器IP
    private static String ADDR = "10.199.169.237";
    
    //Redis的端口号
    private static int PORT = 6379;
    
    //访问密码
    //private static String AUTH = "admin";
    
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;
    
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;
    
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;
    
    private static int TIMEOUT = 10000;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;
    
    /**
     * 初始化Redis连接池
     */
    static {
        try {
        	System.out.println("初始化Redis连接池begin");
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);//, AUTH
            System.out.println("初始化Redis连接池over");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
        	System.out.println("获取Jedis实例begin");
            if (jedisPool != null) {
            	System.out.println("获取Jedis实例-jedisPool不为空");
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
    	System.out.println("释放jedis资源-begin");
        if (jedis != null) {
        	System.out.println("释放jedis资源-jedis不为空");
            jedisPool.returnResource(jedis);
        }
    }
}