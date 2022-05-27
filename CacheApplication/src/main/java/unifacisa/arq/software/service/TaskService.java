package unifacisa.arq.software.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import unifacisa.arq.software.model.Task;

import java.util.List;

@Service
public class TaskService {

    Logger log = LoggerFactory.getLogger(TaskService.class);

    /*@Cacheable faz duas coisas:
        1. armazena o valor de retorno dentro do cache,
        2. retorna um valor em cache se estiver presente.*/

/*ainda não estamos armazenando em cache. Ao fazer a chamada algumas vezes, irá aparecer “Retrieving tasks” em cada chamada*/
//    public List<Task> findAll(boolean noCache) {
//        log.info("Retrieving tasks");
//        return List.of(new Task(1L, "My first task", true),
//                new Task(2L, "My second task", false));
//    }


/* armazenar em cache. Ao reexecutar várias vezes, verá que a mensagem “Retrieving tasks” aparece apenas uma vez.
Configuramos para 1 minuto de armazenamento.. e tentar novamente, o cache expirará e a mensagem aparecerá novamente.
Adicionando condicional para ignorar e buscar o valor em tempo real -> Se  passar true o cache será ignorado e será chamada novamente / false = usa o cache*/
//    @Cacheable(value = "tasks", condition = "!#noCache")
//    public List<Task> findAll(boolean noCache) {
//        log.info("Retrieving tasks");
//        return List.of(new Task(1L, "My first task", true),
//                new Task(2L, "My second task", false));
//    }

    /*Chaves personalizadas -> noCache é uma chave personalizada = cte. Ou seja, usa !#noCachepara inverter o valor booleano.
    key = posso passar um parâmetro ou apenas alterar a condição pra se fazer uma chamada*/
    @Cacheable(value = "tasks", condition = "!#noCache", key = "'ALL'")
    public List<Task> findAll(boolean noCache) {
        log.info("Retrieving tasks");
        return List.of(new Task(1L, "My first task", true),
                new Task(2L, "My second task", false));
    }

    /*No put, ela sempre será executada*/
    @CachePut (value = "id")
    public Task update(long id) {
        log.info("Updating task cache");
        return new Task(3L, "my third and NEW task", true);
    }

    /*para remover imediatamente qualquer valor armazenado em cache. usada para excluir um único valor armazenado em cache ou excluir todas as entradas em um cache.*/
    @CacheEvict(value = "tasks", allEntries = true)
    public void clearCache() {
        log.info("Cleared task cache");
    }

}
