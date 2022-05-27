package unifacisa.arq.software.config;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import unifacisa.arq.software.model.Task;

import java.util.List;

@Slf4j
public class TaskCacheListener implements CacheEventListener<String, List<Task>>  {

    /*Para registrar um ouvinte - evento*/
    @Override
    public void onEvent(CacheEvent<? extends String, ? extends List<Task>> cacheEvent) {
        log.info("Event '{}' fired for key '{}' with value {}", cacheEvent.getType(), cacheEvent.getKey(), cacheEvent.getNewValue());
    }
}
