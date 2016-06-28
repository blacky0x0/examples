package hello;

import redis.clients.jedis.Jedis;

public class JedisExample {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.clientList();
        jedis.set("mine", "101");
        //jedis.set("foo", "bar");
        String value = jedis.get("mine");
        System.out.println(value);
    }
}
