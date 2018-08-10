package com.example.demo.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    //默认使用JdkSerializationRedisSerializer序列化
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;




    /**
     * 指定缓存失效时间
     * redis对应命令：expire key seconds   seconds表示过期时间，单位为秒
     * @param key   键
     * @param time  时间（秒）
     * @return
     */
    public boolean expire(String key,long time)  {
        try {
            if (time > 0) {
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取过期时间
     * redis对应命令：  ttl key  返回键的剩余时间，单位是秒，当键不存在时返回-2 当键没有设置过期时间（及永久存在），返回-1  ppl命令功能相同，单位为毫秒
     * @param key  key键不能为空
     * @return  时间（秒） 返回0代表为永久有效
     */
    public  long getExpire(String key) {
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断key值是否存在
     * redis对应命令：exists key   若key存在返回整数1，否则返回0
     * @param key  key键
     * @return  true 存在 false不存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * redis对应命令：del key [key ...]     删除一个或多个键，返回值是删除的键的个数
     * @param key  key 可以传一个或多个
     */
    public void del(String ... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /*********************************************String************************/
    /**
     * 普通缓存获取
     * redis对应命令： get key      取值
     * @param key
     * @return
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * redis对应命令：set key value	赋值
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key , Object value) {
        try{
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     * redis对应命令：set key value	赋值    expire key seconds   expire命令返回1表示设置成功，返回0则表示键不存在或设置失败。
     * @param key
     * @param value  时间（秒） time要大于0 如果time小于等于0 将设置无限期
     * @param time
     * @return
     */
    public boolean set(String key,Object value,long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else {
                set(key,value);
            }
            return  true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * redis对应命令：incrby key increment  增加指定的整数
     * 注意：使用该方法必须确认通过StringRedisSerializer进行序列化
     * @param key
     * @param delta
     * @return
     */
    public long incr(String key,long delta) {

        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }

        return stringRedisTemplate.opsForValue().increment(key,delta);

    }

    /**
     * 递减
     * redis对应命令：decr key increment	减少指定的整数
     *              incrby key increment  增加指定的整数（整数为负值）
     * 注意：使用该方法必须确认通过StringRedisSerializer进行序列化
     * @param key
     * @param delta   要减少几（小于0）
     * @return
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return stringRedisTemplate.opsForValue().increment(key,-delta);
    }

    /*******************************Map****************************/
    /**
     * HashGet
     * redis对应命令：hget key field	获取字段值
     * @param key
     * @param item
     * @return
     */
    public  Object hget(String key,String item) {
        return redisTemplate.opsForHash().get(key,item);
    }

    /**
     * 获取hashKey对应的所有键值
     * redis对应命令：hgetall key 	获取键中所有字段和字段值
     * @param key
     * @return
     */
    public Map<Object,Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * redis对应命令：hmset key field value [field value …]	同时设置多个字段值
     * @param key
     * @param map
     * @return
     */
    public boolean hmset(String key,Map<String,Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key,map);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * HashSet 并设置时间
     * redis对应命令：hmset key field value [field value …]	同时设置多个字段值
     *              expire key seconds   expire命令返回1表示设置成功，返回0则表示键不存在或设置失败。
     * @param key 键
     * @param map 对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String,Object> map, long time){
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if(time>0){
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * redis对应命令：hset key field value	字段赋值
     * @param key 键
     * @param item 项
     * @param value 值
     * @return true 成功 false失败
     */
    public boolean hset(String key,String item,Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     * redis对应命令：hset key field value	字段赋值
     *              expire key seconds   expire命令返回1表示设置成功，返回0则表示键不存在或设置失败。
     * @param key 键
     * @param item 项
     * @param value 值
     * @param time 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hset(String key,String item,Object value,long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if(time>0){
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除hash表中的值
     * redis对应命令：hdel key field [field…]	删除一个或多个字段，返回值是被删除的字段个数
     * @param key 键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hdel(String key, Object... item){
        redisTemplate.opsForHash().delete(key,item);
    }

    /**
     * 判断hash表中是否有该项的值
     * redis对应命令：hexists key field	判断字段是否存在
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item){
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回
     * redis对应命令：hincrby key field increment	增加数字
     * @param key 键
     * @param item 项
     * @param by 要增加几(大于0)
     * @return
     */
    public double hincr(String key, String item,double by){
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash递减
     * redis对应命令：hincrby key field increment	增加数字
     * @param key 键
     * @param item 项
     * @param by 要减少记(小于0)
     * @return
     */
    public double hdecr(String key, String item,double by){
        return redisTemplate.opsForHash().increment(key, item,-by);
    }

    //============================set=============================
    /**
     * 根据key获取Set中的所有值
     * redis对应命令：smembers key 	获取集合中所有元素
     * @param key 键
     * @return
     */
    public Set<Object> sGet(String key){
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     * redis对应命令： sismember key member	判断元素是否在集合中，存在返回1,值或键值不存在返回0
     * @param key 键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean sHasKey(String key,Object value){
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将数据放入set缓存
     * redis对应命令：sadd key member [member …]	向集合中添加一个或多个元素，若键不存在自动创建，已存在忽略，返回加入成功的元素数量（忽略元素不计在内）
     * @param key 键
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSet(String key, Object...values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 将set数据放入缓存
     * redis对应命令：sadd key member [member …]	向集合中添加一个或多个元素，若键不存在自动创建，已存在忽略，返回加入成功的元素数量（忽略元素不计在内）
     *              expire key seconds   expire命令返回1表示设置成功，返回0则表示键不存在或设置失败。
     * @param key 键
     * @param time 时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    public long sSetAndTime(String key,long time,Object...values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);

            if(time>0) expire(key, time);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取set缓存的长度
     * redis对应命令：scard key	获取集合中元素个数
     * @param key 键
     * @return
     */
    public long sGetSetSize(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 移除值为value的
     * redis对应命令：srem key member [member …]	从集合中删除一个或多个元素，返回删除成功的个数
     * @param key 键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    public long setRemove(String key, Object ...values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //===============================list=================================
    /**
     * 获取list缓存的内容
     * redis对应命令：lrange key start stop   获取列表片段
     * @param key 键
     * @param start 开始
     * @param end 结束  0 到 -1代表所有值
     * @return
     */
    public List<Object> lGet(String key, long start, long end){
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     * redis对应命令：llen key 	获取列表中元素的个数
     * @param key 键
     * @return
     */
    public long lGetListSize(String key){
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     * redis对应命令：lindex key index	返回指定索引的元素，索引从0开始
     * @param key 键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lGetIndex(String key,long index){
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将list放入缓存
     * redis对应命令： rpush key value [value …]	向列表右端添加元素，返回添加元素后列表的长度
     * @param key 键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     * redis对应命令： rpush key value [value …]	向列表右端添加元素，返回添加元素后列表的长度
     *               expire key seconds   expire命令返回1表示设置成功，返回0则表示键不存在或设置失败。
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    public boolean lSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     * redis对应命令：rpush key value [value …]	向列表右端添加元素，返回添加元素后列表的长度
     * @param key 键
     * @param value 值
     * @return
     */
    public boolean lSet(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     * redis对应命令：rpush key value [value …]	向列表右端添加元素，返回添加元素后列表的长度
     *              expire key seconds   expire命令返回1表示设置成功，返回0则表示键不存在或设置失败。
     * @param key 键
     * @param value 值
     * @param time 时间(秒)
     * @return
     */
    public boolean lSet(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     * redis对应命令：lset key index value	将索引为index的元素赋值为value
     * @param key 键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean lUpdateIndex(String key, long index,Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除N个值为value
     * redis对应命令：lrem key count value	"删除列表中指定的值，lrem会删除列表中前count个值为value的元素，返回值是实际删除的元素个数。
                                根据count值的不同，lrem命令的执行方式会略有差异：
                                    （1）当count>0时，lrem命令会从列表左边开始删除前count个值为value的元素
                                    （2）当count<0时，lrem命令会从列表右边开始删除前|count|个值为value的元素
                                    （3）当count=0时，lrem命令会删除所有值为value的元素"
     * @param key 键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long lRemove(String key,long count,Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }





}