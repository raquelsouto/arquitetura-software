package unifacisa.arq.software.config;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

@Slf4j
public class TaskCacheListener implements CacheEventListener<Object, Object>  {

    /*Para registrar um ouvinte - evento*/
    @Override
    public void onEvent(CacheEvent cacheEvent) {
        log.info("Event '{}' fired for key '{}' with value {}", cacheEvent.getType(), cacheEvent.getKey(), cacheEvent.getNewValue());
    }
}
